package org.citygml4j.util.xml;

import javax.xml.namespace.QName;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

public class SAXFragmentWriter extends XMLFilterImpl {
	private final ContentHandler writer;
	private final QName breakElement;

	private WriteMode mode;
	private boolean shouldWrite;
	private boolean hasStartElement;

	public enum WriteMode {
		HEAD,
		TAIL
	}

	public SAXFragmentWriter(QName breakElement, ContentHandler writer, WriteMode mode) {
		this.breakElement = breakElement;
		this.writer = writer;
		this.mode = mode;

		shouldWrite = mode == WriteMode.HEAD;
	}

	public SAXFragmentWriter(QName breakElement, ContentHandler writer) {
		this(breakElement, writer, WriteMode.HEAD);
	}

	public WriteMode getWriteMode() {
		return mode;
	}

	public void setWriteMode(WriteMode mode) {
		this.mode = mode;
		shouldWrite = mode == WriteMode.HEAD;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (shouldWrite)
			writer.characters(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {
		writer.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equals(breakElement.getLocalPart()) && uri.equals(breakElement.getNamespaceURI()))
			shouldWrite = !shouldWrite;

		if (shouldWrite) {
			if (!hasStartElement && writer instanceof SAXEventBuffer) {
				((SAXEventBuffer)writer).addEndElement(uri, localName);
				return;
			}
			
			writer.endElement(uri, localName, qName);
		}
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		if (shouldWrite)
			writer.ignorableWhitespace(ch, start, length);
	}

	@Override
	public void startDocument() throws SAXException {
		if (shouldWrite)
			writer.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if (shouldWrite) {
			writer.startElement(uri, localName, qName, atts);
			hasStartElement = true;
		}
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		writer.endPrefixMapping(prefix);
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		writer.startPrefixMapping(prefix, uri);
	}

}
