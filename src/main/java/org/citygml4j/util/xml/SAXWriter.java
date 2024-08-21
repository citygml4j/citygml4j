/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.util.xml;

import org.citygml4j.xml.CityGMLNamespaceContext;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.NamespaceSupport;
import org.xml.sax.helpers.XMLFilterImpl;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.*;
import java.util.Map.Entry;

public class SAXWriter extends XMLFilterImpl implements AutoCloseable {
	private final String OPEN_COMMENT = "<!--";
	private final String END_COMMENT = "-->";
	private final String XML_DECL_ENCODING = " encoding=";
	private final String XML_DECL_VERSION = " version=\"1.0\"";
	private final String XML_DECL_STANDALONE = " standalone=\"yes\"";
	private final String OPEN_XML_DECL = "<?xml";
	private final String CLOSE_XML_DECL = "?>";
	private final char CLOSE_START_TAG = '>';
	private final char OPEN_START_TAG = '<';
	private final String OPEN_END_TAG = "</";
	private final char CLOSE_END_TAG = '>';
	private final String OPEN_PI = "<?";
	private final String CLOSE_PI = "?>";	
	private final String CLOSE_EMPTY_ELEMENT = "/>";
	private final String SPACE = " ";
	private final String LINE_SEPARATOR = System.getProperty("line.separator");
	private final String SCHEMA_LOCATION_NS = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
	private final String SCHEMA_LOCATION = "schemaLocation";
	private final String SCHEMA_LOCATION_NS_PREFIX = "xsi";

	private Writer writer;
	private CharsetEncoder charsetEncoder;
	private String streamEncoding;

	private CityGMLNamespaceContext userDefinedNS;
	private NamespaceSupport reportedNS;
	private LocalNamespaceContext localNS;

	private boolean needNSContext = true;
	private boolean writeReportedNamespaces = false;
	private boolean escapeCharacters = true;
	private boolean writeEncoding = false;
	private boolean writeXMLDecl = true;

	private String indent;
	private String[] headerComment;
	private HashMap<String, String> schemaLocations;
	private int depth = 0;
	private int nsCounter = 1;

	private XMLContentType lastXMLContent;

	private enum XMLContentType {
		UNDEFINED,
		START_ELEMENT,
		END_ELEMENT,
		CHARACTERS,
		PI,
		COMMENT
	}

	public SAXWriter() {
		init();
	}

	public SAXWriter(StreamResult streamResult, String encoding) throws IOException {
		this();
		setOutput(streamResult, encoding);
	}

	public SAXWriter(OutputStream outputStream) throws IOException {
		this(outputStream, null);
	}

	public SAXWriter(OutputStream outputStream, String encoding) throws IOException {
		this();
		setOutput(outputStream, encoding);
	}

	public SAXWriter(Writer writer) throws IOException {
		this();
		setOutput(writer);
	}

	private void init() {
		userDefinedNS = new CityGMLNamespaceContext();
		reportedNS = new NamespaceSupport();
		localNS = new LocalNamespaceContext();

		schemaLocations = new HashMap<>();
		lastXMLContent = XMLContentType.UNDEFINED;
	}

	public void reset() {
		userDefinedNS.reset();
		reportedNS.reset();
		localNS.reset();

		streamEncoding = null;
		needNSContext = true;
		writeReportedNamespaces = false;
		escapeCharacters = true;
		writeEncoding = false;
		writeXMLDecl = true;
		indent = null;
		headerComment = null;
		schemaLocations.clear();
		depth = 0;
		nsCounter = 1;

		lastXMLContent = XMLContentType.UNDEFINED;
	}

	public void setOutput(StreamResult streamResult) throws IOException {
		setOutput(streamResult, null);
	}

	public void setOutput(StreamResult streamResult, String encoding) throws IOException {
		if (streamResult.getOutputStream() != null)
			setOutput(streamResult.getOutputStream(), encoding);
		else if (streamResult.getWriter() != null)
			setOutput(streamResult.getWriter());
		else if (streamResult.getSystemId() != null)
			setOutput(new FileOutputStream(streamResult.getSystemId()), encoding);
	}

	public void setOutput(Writer writer) {
		this.writer = writer;

		if (writer instanceof OutputStreamWriter) {
			this.writer = new BufferedWriter(writer);
			String encoding = ((OutputStreamWriter) writer).getEncoding();

			if (encoding != null) {
				Charset charset = Charset.forName(encoding);
				streamEncoding = charset.name();
				writeEncoding = true;

				if (!streamEncoding.equalsIgnoreCase("utf-8"))
					charsetEncoder = charset.newEncoder();
			}
		}
	}
	
	public void setOutput(OutputStream outputStream) throws IOException {
		setOutput(outputStream, null);
	}

	public void setOutput(OutputStream outputStream, String encoding) throws IOException {
		if (encoding == null)
			encoding = System.getProperty("file.encoding");
		
		if (encoding != null) {		
			Charset charset = Charset.forName(encoding);
			streamEncoding = charset.name();
			writeEncoding = true;
			
			writer = new BufferedWriter(new OutputStreamWriter(outputStream, encoding));

			if (!streamEncoding.equalsIgnoreCase("utf-8"))
				charsetEncoder = charset.newEncoder();			
		} 			
	}

	public Writer getOutputWriter() {
		return writer;
	}

	public void flush() throws SAXException {
		try {
			if (writer != null)
				writer.flush();
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	@Override
	public void close() throws SAXException {
		try {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			throw new SAXException(e);
		}

		writer = null;
		charsetEncoder = null;
		userDefinedNS.reset();
		reportedNS.reset();
		localNS.reset();
		headerComment = null;
		schemaLocations.clear();
	}

	public boolean isEscapeCharacters() {
		return escapeCharacters;
	}

	public void setEscapeCharacters(boolean escapeCharacters) {
		this.escapeCharacters = escapeCharacters;
	}

	public boolean isWriteReportedNamespaces() {
		return writeReportedNamespaces;
	}

	public void setWriteReportedNamespaces(boolean writeReportedNamespaces) {
		this.writeReportedNamespaces = writeReportedNamespaces;
	}

	public void setNamespaceContext(CityGMLNamespaceContext context) {
		if (context == null)
			throw new IllegalArgumentException("namespace context may not be null.");

		userDefinedNS = context;
		
		if (depth > 0) {
			Iterator<String> iter = userDefinedNS.getNamespaceURIs();
			while (iter.hasNext()) {
				String userDefinedURI = iter.next();
				localNS.declarePrefix(userDefinedNS.getPrefix(userDefinedURI), userDefinedURI);
			}
		}
	}

	public CityGMLNamespaceContext getNamespaceContext() {
		return userDefinedNS;
	}

	public void setPrefix(String prefix, String uri) {
		if (prefix == null || uri == null)
			return;

		if (depth == 0)
			userDefinedNS.setPrefix(prefix, uri);

		localNS.declarePrefix(prefix, uri);
	}

	public String getPrefix(String uri) {
		String prefix = userDefinedNS.getPrefix(uri);
		if (prefix == null)
			prefix = getReportedPrefix(uri);

		return prefix;
	}

	public String getNamespaceURI(String prefix) {
		String uri = userDefinedNS.getNamespaceURI(prefix);
		if (uri.equals(XMLConstants.NULL_NS_URI))
			uri = getReportedURI(prefix);

		return uri;
	}

	public void setDefaultNamespace(String uri) {    
		if (uri == null)
			throw new IllegalArgumentException("namespace URI may not be null.");

		if (depth == 0)
			userDefinedNS.setDefaultNamespace(uri);

		localNS.declarePrefix(XMLConstants.DEFAULT_NS_PREFIX, uri);
	}

	public String getIndentString() {
		return indent;
	}

	public void setIndentString(String indent) {
		if (indent == null)
			throw new IllegalArgumentException("indentation string may not be null.");

		this.indent = indent;
	}

	public boolean isWriteEncoding() {
		return writeEncoding;
	}

	public void setWriteEncoding(boolean writeEncoding) {
		this.writeEncoding = writeEncoding;
	}

	public boolean isWriteXMLDecl() {
		return writeXMLDecl;
	}

	public void setWriteXMLDecl(boolean writeXMLDecl) {
		this.writeXMLDecl = writeXMLDecl;
	}

	public void setHeaderComment(String... headerMessage) {
		if (headerMessage == null)
			throw new IllegalArgumentException("header comment may not be null.");

		this.headerComment = headerMessage;
	}

	public String[] getHeaderComment() {
		return headerComment;
	}

	public void unsetHeaderComment() {
		headerComment = null;
	}

	public void setSchemaLocation(String namespaceURI, String schemaLocation) {
		if (namespaceURI == null)
			throw new IllegalArgumentException("namespace URI may not be null.");

		if (schemaLocation == null || schemaLocation.trim().isEmpty())
			return;

		schemaLocations.put(namespaceURI, schemaLocation);
	}

	public String getSchemaLocation(String namespaceURI) {
		return schemaLocations.get(namespaceURI);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		try {
			if (length > 0) {
				if (lastXMLContent == XMLContentType.START_ELEMENT)
					writer.write(CLOSE_START_TAG);

				writeXMLContent(ch, start, length, escapeCharacters);
				lastXMLContent = XMLContentType.CHARACTERS;
			}
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// nothing to do
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		try {
			depth--;

			if (lastXMLContent == XMLContentType.START_ELEMENT)
				writer.write(CLOSE_EMPTY_ELEMENT);
			else {
				if (lastXMLContent == XMLContentType.END_ELEMENT)
					writeIndent();

				writer.write(OPEN_END_TAG);
				writeQName(localNS.getPrefix(uri), localName);
				writer.write(CLOSE_END_TAG);
			}

			lastXMLContent = XMLContentType.END_ELEMENT;
			localNS.popContext();
			reportedNS.popContext();
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		try {
			if (lastXMLContent != XMLContentType.END_ELEMENT) {
				if (length > 0 && lastXMLContent == XMLContentType.START_ELEMENT)
					writer.write(CLOSE_START_TAG);

				writeXMLContent(ch, start, length, escapeCharacters);
				lastXMLContent = XMLContentType.CHARACTERS;
			}
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		try {
			if (lastXMLContent == XMLContentType.START_ELEMENT) {
				writer.write(CLOSE_START_TAG);
				writeIndent();
			}

			if (target == null || data == null)
				throw new SAXException("PI target cannot be null.");

			writer.write(OPEN_PI);
			writer.write(target);
			writer.write(SPACE);
			writer.write(data);
			writer.write(CLOSE_PI);
			writeIndent();

			lastXMLContent = XMLContentType.PI;
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	@Override
	public void startDocument() throws SAXException {
		try {
			if (depth == 0) {
				if (writeXMLDecl) {
					if (streamEncoding == null && writer instanceof OutputStreamWriter) {
						streamEncoding = ((OutputStreamWriter)writer).getEncoding();
						if (streamEncoding != null)
							streamEncoding = Charset.forName(streamEncoding).name();
					}

					writer.write(OPEN_XML_DECL);
					writer.write(XML_DECL_VERSION);

					if (writeEncoding && streamEncoding != null) {
						writer.write(XML_DECL_ENCODING);
						writer.write("\"");
						writer.write(streamEncoding);
						writer.write("\"");
					}

					writer.write(XML_DECL_STANDALONE);
					writer.write(CLOSE_XML_DECL);
					writeIndent();

					lastXMLContent = XMLContentType.PI;
				}

				if (headerComment != null) {
					writeHeader(headerComment);

					lastXMLContent = XMLContentType.COMMENT;
				}
			}

		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		try {
			if (needNSContext)
				reportedNS.pushContext();

			if (depth > 0) {
				if (lastXMLContent == XMLContentType.START_ELEMENT)
					writer.write(CLOSE_START_TAG);

				writeIndent();
			} else if (depth == 0) {
				Iterator<String> iter = userDefinedNS.getNamespaceURIs();
				while (iter.hasNext()) {
					String userDefinedURI = iter.next();
					localNS.declarePrefix(userDefinedNS.getPrefix(userDefinedURI), userDefinedURI);
				}
			}

			writer.write(OPEN_START_TAG);

			boolean writeLocalNS = false;
			String prefix = localNS.getPrefix(uri);
			if (prefix == null) {
				prefix = getReportedPrefix(uri);

				if (prefix == null)
					throw new IllegalStateException("namespace URI " + uri + " is not bound to a prefix.");

				writeLocalNS = true;
			}

			writeQName(prefix, localName);

			if (depth == 0) {
				writeDeclaredNamespaces();
				writeSchemaLocations();
			}

			if (writeLocalNS) {
				localNS.declarePrefix(prefix, uri);
				writeNamespace(prefix, uri);
			}

			if (writeReportedNamespaces && depth > 0)
				writeReportedNamespaces();

			writeAttributes(atts);

			lastXMLContent = XMLContentType.START_ELEMENT;
			needNSContext = true;
			depth++;
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		if (needNSContext) {
			reportedNS.pushContext();
			needNSContext = false;
		}

		if (getReportedPrefix(uri) == null)
			reportedNS.declarePrefix(prefix, uri);
	}

	private String getReportedPrefix(String uri) {
		String prefix = reportedNS.getPrefix(uri);
		if (prefix == null && uri.equals(reportedNS.getURI(XMLConstants.DEFAULT_NS_PREFIX)))
			prefix = XMLConstants.DEFAULT_NS_PREFIX;

		return prefix;
	}

	private String getReportedURI(String prefix) {
		return reportedNS.getURI(prefix);
	}

	private void writeAttributes(Attributes atts) throws SAXException {
		try {
			String localName, uri, prefix;

			for (int i = 0; i < atts.getLength(); i++) {
				localName = atts.getLocalName(i);
				uri = atts.getURI(i);
				prefix = null;

				if (uri != null && uri.length() > 0) {
					if (uri.equals(XMLConstants.XMLNS_ATTRIBUTE_NS_URI))
						continue;
					
					prefix = localNS.getPrefix(uri);					
					if (prefix == null) {
						prefix = getReportedPrefix(uri);
						localNS.declarePrefix(prefix, uri);
						writeNamespace(prefix, uri);
					}
				}

				writer.write(SPACE);
				writeQName(prefix, localName);
				writer.write("=\"");
				writeXMLContent(atts.getValue(i), true, true);
				writer.write('"');
			}
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	private void writeQName(String prefix, String localName) throws SAXException {
		try {
			if (prefix != null && !prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
				writer.write(prefix);
				writer.write(':');
			}

			writer.write(localName);
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	private void writeDeclaredNamespaces() throws SAXException {
		Iterator<String> iter = userDefinedNS.getNamespaceURIs();

		while (iter.hasNext()) {
			String uri = iter.next();
			String prefix = userDefinedNS.getPrefix(uri);

			writeNamespace(prefix, uri);
		}
	}

	private void writeReportedNamespaces() throws SAXException {
		for (Enumeration e = reportedNS.getDeclaredPrefixes(); e.hasMoreElements(); ) {
			String reportedPrefix = e.nextElement().toString();
			String reportedUri = reportedNS.getURI(reportedPrefix);

			// skip if the namespace URI is already defined by the user
			if (userDefinedNS.getPrefix(reportedUri) != null)
				continue;

			// skip if the namespace URI is already defined locally
			if (localNS.getPrefix(reportedUri) != null)
				continue;

			// adapt prefix if it is already in use
			if (userDefinedNS.containsPrefix(reportedPrefix) || localNS.containsPrefix(reportedPrefix))
				reportedPrefix += nsCounter++;

			localNS.declarePrefix(reportedPrefix, reportedUri);
			writeNamespace(reportedPrefix, reportedUri);
		}
	}

	private void writeNamespace(String prefix, String uri) throws SAXException {
		if (prefix.equals(XMLConstants.XML_NS_PREFIX) && uri.equals(XMLConstants.XML_NS_URI))
			return;
		
		try {
			writer.write(SPACE);
			writer.write(XMLConstants.XMLNS_ATTRIBUTE);

			if (prefix.length() > 0) {
				writer.write(':');
				writer.write(prefix);
			}

			writer.write("=\"");
			writeXMLContent(uri, true, true);
			writer.write('"');
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	public void writeSchemaLocations() throws SAXException {
		if (!schemaLocations.isEmpty()) {
			try {
				String uri = SCHEMA_LOCATION_NS;			
				String prefix = localNS.getPrefix(uri);

				if (prefix == null) {
					prefix = SCHEMA_LOCATION_NS_PREFIX;
					localNS.declarePrefix(prefix, uri);
					writeNamespace(prefix, uri);
				}

				writer.write(SPACE);
				writeQName(prefix, SCHEMA_LOCATION);
				writer.write("=\"");

				Iterator<Entry<String, String>> iter = schemaLocations.entrySet().iterator();
				while (iter.hasNext()) {
					Entry<String, String> entry = iter.next();
					writeXMLContent(entry.getKey(), true, true);
					writer.write(SPACE);
					writeXMLContent(entry.getValue(), true, true);

					if (iter.hasNext())
						writer.write(SPACE);
				}

				writer.write('"');
			} catch (IOException e) {
				throw new SAXException(e);
			}
		}
	}

	public void writeHeader(String... data) throws SAXException {
		try {
			if (lastXMLContent == XMLContentType.START_ELEMENT) {
				writer.write(CLOSE_START_TAG);
				writeIndent();
			}

			if (data == null)
				throw new SAXException("comment target cannot be null.");

			for (String line : data) {
				if (line == null)
					continue;

				writer.write(OPEN_COMMENT);
				writer.write(SPACE);			
				writer.write(line);			
				writer.write(SPACE);
				writer.write(END_COMMENT);
				writeIndent();
			}

			lastXMLContent = XMLContentType.COMMENT;
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	private void writeIndent() throws SAXException {
		if (indent == null || indent.length() == 0)
			return;
		
		if (lastXMLContent == XMLContentType.CHARACTERS)
			return;

		try {
			writer.write(LINE_SEPARATOR);
			for (int i = 0; i < depth; i++)
				writer.write(indent);
		} catch (IOException e) {
			throw new SAXException(e);
		}
	}

	private void writeXMLContent(char[] content, int start, int length, boolean escapeChars) throws IOException {
		if (!escapeChars) {
			writer.write(content, start, length);
			return;
		}

		int startWritePos = start;
		final int end = start + length;

		for (int index = start; index < end; index++) {
			char ch = content[index];

			if (charsetEncoder != null && !charsetEncoder.canEncode(ch)){
				writer.write(content, startWritePos, index - startWritePos );

				writer.write("&#x");
				writer.write(Integer.toHexString(ch));
				writer.write(';');                    
				startWritePos = index + 1;
				continue;
			}

			switch (ch) {
			case '<':
				writer.write(content, startWritePos, index - startWritePos);
				writer.write("&lt;");
				startWritePos = index + 1;

				break;

			case '&':
				writer.write(content, startWritePos, index - startWritePos);
				writer.write("&amp;");
				startWritePos = index + 1;

				break;

			case '>':
				writer.write(content, startWritePos, index - startWritePos);
				writer.write("&gt;");
				startWritePos = index + 1;

				break;
			}
		}

		writer.write(content, startWritePos, end - startWritePos);
	}

	private void writeXMLContent(String content, boolean escapeChars, boolean escapeDoubleQuotes) throws IOException {
		if (!escapeChars) {
			writer.write(content);
			return;
		}

		int startWritePos = 0;
		final int end = content.length();

		for (int index = 0; index < end; index++) {
			char ch = content.charAt(index);

			if (charsetEncoder != null && !charsetEncoder.canEncode(ch)){
				writer.write(content, startWritePos, index - startWritePos );

				writer.write("&#x");
				writer.write(Integer.toHexString(ch));
				writer.write(';');                    
				startWritePos = index + 1;
				continue;
			}

			switch (ch) {
			case '<':
				writer.write(content, startWritePos, index - startWritePos);
				writer.write("&lt;");
				startWritePos = index + 1;

				break;

			case '&':
				writer.write(content, startWritePos, index - startWritePos);
				writer.write("&amp;");
				startWritePos = index + 1;

				break;

			case '>':
				writer.write(content, startWritePos, index - startWritePos);
				writer.write("&gt;");
				startWritePos = index + 1;

				break;

			case '"':
				writer.write(content, startWritePos, index - startWritePos);
				if (escapeDoubleQuotes) {
					writer.write("&quot;");
				} else {
					writer.write('"');
				}
				startWritePos = index + 1;

				break;
			}
		}

		writer.write(content, startWritePos, end - startWritePos);
	}

	private class LocalNamespaceContext {
		Deque<LocalNamespaceMap> contexts = new ArrayDeque<>();

		void pushContext() {
			if (contexts.isEmpty() || contexts.getFirst().level != depth)
				contexts.push(new LocalNamespaceMap(depth));
		}

		void popContext() {
			if (!contexts.isEmpty() && contexts.getFirst().level == depth)
				contexts.pop();
		}

		void reset() {
			contexts.clear();
		}

		void declarePrefix(String prefix, String uri) {
			pushContext();
			contexts.getFirst().namespaces.put(uri, prefix);
		}

		String getPrefix(String uri) {
			for (LocalNamespaceMap context : contexts) {
				String prefix = context.namespaces.get(uri);
				if (prefix != null) {

					// make sure the prefix has not been redefined in a more recent context
					if (context != contexts.getFirst()) {
						for (LocalNamespaceMap recent : contexts) {
							if (recent == context)
								break;

							if (recent.namespaces.values().contains(prefix))
								return null;
						}
					}

					return prefix;
				}
			}

			return null;
		}

		boolean containsPrefix(String prefix) {
			for (LocalNamespaceMap context : contexts) {
				if (context.namespaces.containsValue(prefix))
					return true;
			}

			return false;
		}
	}

	private class LocalNamespaceMap {
		private HashMap<String, String> namespaces;
		private int level;

		LocalNamespaceMap(int level) {
			this.level = level;
			namespaces = new HashMap<>();
		}		
	}
}
