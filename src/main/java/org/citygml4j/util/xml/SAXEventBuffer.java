/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.XMLConstants;

public class SAXEventBuffer implements ContentHandler {
	private final String END_PREFIX_MAPPING      = "END_PREFIX_MAPPING";
	private final Byte UNDEFINED                 = 0;
	private final Byte START_DOCUMENT            = 1;
	private final Byte END_DOCUMENT              = 2;
	private final Byte START_ELEMENT             = 3;
	private final Byte END_ELEMENT               = 4;
	private final Byte QUALIFIED_END_ELEMENT     = 5;
	private final Byte CHARACTERS                = 6;
	private final Byte NAMESPACE_PREFIX_MAPPING  = 7;
	private final Byte ATTRIBUTE                 = 8;

	private ArrayBuffer<String> stringBuffer;
	private ArrayBuffer<char[]> charactersBuffer;
	private ArrayBuffer<Byte> eventBuffer;
	private ArrayBuffer<String> tmpBuffer;
	private AttributesImpl atts;
	private Byte previousElement = UNDEFINED;

	public SAXEventBuffer() {
		stringBuffer = new ArrayBuffer<String>(String.class);
		charactersBuffer = new ArrayBuffer<char[]>(char[].class);
		eventBuffer = new ArrayBuffer<Byte>(Byte.class);
	}

	public void reset() {
		stringBuffer = new ArrayBuffer<String>(String.class);
		charactersBuffer = new ArrayBuffer<char[]>(char[].class);
		eventBuffer = new ArrayBuffer<Byte>(Byte.class);
		tmpBuffer = null;
		atts = null;
		previousElement = UNDEFINED;		
	}

	public boolean isEmpty() {
		return eventBuffer.currentPtr() == 0 && eventBuffer.previousBuffer() == null;
	}

	public void removeTrailingCharacters() {
		while (eventBuffer.peek() == CHARACTERS) {
			popEvent();
			popCharacters();				
		}
	}

	public void addCharacters(char[] ch) {
		if (previousElement == START_ELEMENT) {
			pushEvent(CHARACTERS);
			pushCharacters(ch);
		}
	}

	public void addStartElement(String uri, String localName, String prefix) {
		if (previousElement == START_ELEMENT)
			removeTrailingCharacters();

		pushEvent(START_ELEMENT);
		pushString(uri);
		pushString(localName);
		pushString(prefix);

		previousElement = START_ELEMENT;
	}

	public void addEndElement() {
		if (previousElement == END_ELEMENT)
			removeTrailingCharacters();

		pushEvent(END_ELEMENT);
		previousElement = END_ELEMENT;
	}

	public void addEndElement(String uri, String localName) {
		if (previousElement == END_ELEMENT)
			removeTrailingCharacters();

		pushEvent(QUALIFIED_END_ELEMENT);
		pushString(uri);
		pushString(localName);

		previousElement = END_ELEMENT;
	}

	public void addNamespacePrefixMapping(String uri, String prefix) {
		pushEvent(NAMESPACE_PREFIX_MAPPING);
		pushString(uri);
		pushString(prefix);
	}

	public void addAttribute(String uri, String localName, String prefix, String type, String value) {
		pushEvent(ATTRIBUTE);
		pushString(uri);
		pushString(localName);
		pushString(prefix);
		pushString(type);
		pushString(value);
	}

	public void addStartDocument() {
		pushEvent(START_DOCUMENT);
	}

	public void addEndDocument() {
		pushEvent(END_DOCUMENT);
	}

	public void send(ContentHandler handler, boolean release) throws SAXException {
		if (isEmpty())
			throw new IllegalStateException("buffer is empty.");

		eventBuffer = eventBuffer.rewindToHeadBuffer();
		stringBuffer = stringBuffer.rewindToHeadBuffer();
		charactersBuffer = charactersBuffer.rewindToHeadBuffer();
		tmpBuffer = new ArrayBuffer<String>(String.class);
		atts = new AttributesImpl();

		Byte currentEvent = null;
		while (eventBuffer.peek() != null) {
			currentEvent = nextEvent(release);

			if (currentEvent == START_ELEMENT)
				sendStartElement(handler, release);
			else if (currentEvent == END_ELEMENT)
				sendEndElement(handler);
			else if (currentEvent == CHARACTERS)
				sendCharacters(handler, release);
			else if (currentEvent == NAMESPACE_PREFIX_MAPPING)
				sendStartPrefixMapping(handler, release);
			else if (currentEvent == START_DOCUMENT)
				handler.startDocument();
			else if (currentEvent == END_DOCUMENT)
				handler.endDocument();
			else if (currentEvent == QUALIFIED_END_ELEMENT)
				sendQualifiedEndElement(handler, release);
		}

		// clean up
		eventBuffer.decrementPtr();
		stringBuffer.decrementPtr();
		charactersBuffer.decrementPtr();		

		if (release)
			reset();
	}

	private void sendCharacters(ContentHandler handler, boolean release) throws SAXException {
		char[] ch = nextCharacters(release);		
		handler.characters(ch, 0, ch.length);
	}

	private void sendStartPrefixMapping(ContentHandler handler, boolean release) throws SAXException {
		String nsUri = nextString(release);
		String nsPrefix = nextString(release);
		if (nsPrefix == null)
			nsPrefix = XMLConstants.DEFAULT_NS_PREFIX;

		handler.startPrefixMapping(nsPrefix, nsUri);

		pushTmpString(nsPrefix);
		pushTmpString(END_PREFIX_MAPPING);								
	}

	private void sendStartElement(ContentHandler handler, boolean release) throws SAXException {
		String elementUri = nextString(release);
		String elementLocalName = nextString(release);
		String elementPrefix = nextString(release);
		String elementQName = (elementPrefix == null || elementPrefix.length() == 0) ? 
				elementLocalName : new StringBuffer(elementPrefix).append(':').append(elementLocalName).toString();

		if (eventBuffer.peek() == ATTRIBUTE) {
			do {
				nextEvent(release);

				String attrUri = nextString(release);
				String attrLocalName = nextString(release);
				String attrPrefix = nextString(release);
				String attrType = nextString(release);
				String attrValue = nextString(release);				
				String attrQName = (attrPrefix == null || attrPrefix.length() == 0) ? 
						attrLocalName : new StringBuffer(attrPrefix).append(':').append(attrLocalName).toString();

				if (attrUri == null)
					attrUri = "";

				atts.addAttribute(attrUri, attrLocalName, attrQName, attrType, attrValue);
			} while (eventBuffer.peek() == ATTRIBUTE);
		}

		pushTmpString(elementUri);
		pushTmpString(elementLocalName);
		pushTmpString(elementPrefix);

		handler.startElement(elementUri, elementLocalName, elementQName, atts);
		atts.clear();
	}

	private void sendEndElement(ContentHandler handler) throws SAXException {
		String elementPrefix = popTmpString();
		String elementLocalName = popTmpString();
		String elementUri = popTmpString();
		String elementQName = elementPrefix == null ? elementLocalName :
			new StringBuffer(elementPrefix).append(':').append(elementLocalName).toString();

		handler.endElement(elementUri, elementLocalName, elementQName);

		if (tmpBuffer.peek() == END_PREFIX_MAPPING) {
			do {
				popTmpString();
				String nsPrefix = popTmpString();

				handler.endPrefixMapping(nsPrefix);
			} while (tmpBuffer.peek() == END_PREFIX_MAPPING);
		}
	}

	private void sendQualifiedEndElement(ContentHandler handler, boolean release) throws SAXException {
		String elementUri = nextString(release);
		String elementLocalName = nextString(release);

		handler.endElement(elementUri, elementLocalName, elementLocalName);

		if (tmpBuffer.peek() == END_PREFIX_MAPPING) {
			do {
				popTmpString();
				String nsPrefix = popTmpString();

				handler.endPrefixMapping(nsPrefix);
			} while (tmpBuffer.peek() == END_PREFIX_MAPPING);
		}
	}

	private void pushEvent(byte event) {
		eventBuffer.push(event);
		if (eventBuffer.currentPtr() == eventBuffer.size())
			eventBuffer = eventBuffer.appendBuffer();
	}

	private void pushCharacters(char[] ch) {
		charactersBuffer.push(ch);
		if (charactersBuffer.currentPtr() == charactersBuffer.size())
			charactersBuffer = charactersBuffer.appendBuffer();
	}

	private void pushString(String s) {
		stringBuffer.push(s);
		if (stringBuffer.currentPtr() == stringBuffer.size())
			stringBuffer = stringBuffer.appendBuffer();
	}

	private void pushTmpString(String s) {
		tmpBuffer.push(s);
		if (tmpBuffer.currentPtr() == tmpBuffer.size())
			tmpBuffer = tmpBuffer.appendBuffer();
	}

	private void popEvent() {
		if (eventBuffer.currentPtr() == 0)
			eventBuffer = eventBuffer.dropBuffer();

		eventBuffer.pop();
	}

	private void popCharacters() {
		if (charactersBuffer.currentPtr() == 0)
			charactersBuffer = charactersBuffer.dropBuffer();

		charactersBuffer.pop();
	}

	private String popTmpString() {
		if (tmpBuffer.currentPtr() == 0)
			tmpBuffer = tmpBuffer.dropBuffer();

		return tmpBuffer.pop();
	}

	private Byte nextEvent(boolean release) {
		Byte event = eventBuffer.next(release);

		if (eventBuffer.currentPtr() > eventBuffer.size() && eventBuffer.nextBuffer() != null) {
			eventBuffer = eventBuffer.nextBuffer();
			if (release)
				eventBuffer.dropPreviousBuffer();
		}

		return event;
	}

	private String nextString(boolean release) {
		String s = stringBuffer.next(release);

		if (stringBuffer.currentPtr() > stringBuffer.size() && stringBuffer.nextBuffer() != null) {
			stringBuffer = stringBuffer.nextBuffer();
			if (release)
				stringBuffer.dropPreviousBuffer();
		}

		return s;
	}

	private char[] nextCharacters(boolean release) {
		char[] ch = charactersBuffer.next(release);

		if (charactersBuffer.currentPtr() > charactersBuffer.size() && charactersBuffer.nextBuffer() != null) {
			charactersBuffer = charactersBuffer.nextBuffer();
			if (release)
				charactersBuffer.dropPreviousBuffer();
		}

		return ch;
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// we do not record this event
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// we do not record this event
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		char[] tmp = new char[length];
		System.arraycopy(ch, start, tmp, 0, length);
		addCharacters(tmp);
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// we do not record this event
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// we do not record this event
	}

	@Override
	public void startDocument() throws SAXException {
		addStartDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		addStartElement(uri, localName, null);
		for (int i = 0; i < atts.getLength(); i++)
			addAttribute(atts.getURI(i), atts.getLocalName(i), null, atts.getType(i), atts.getValue(i));
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		addNamespacePrefixMapping(uri, prefix);
	}

	@Override
	public void endDocument() throws SAXException {
		addEndDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		addEndElement();
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// we do not record this event
	}

}
