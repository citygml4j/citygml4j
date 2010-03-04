package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class IgnorableWhitespace implements SAXEvent {
	private final char[] ch;

	public IgnorableWhitespace(char[] ch, int start, int length) {
		// make a copy of the char array ch.
		// we do not want to have a reference to potentially large arrays

		this.ch = new char[length];
		System.arraycopy(ch, start, this.ch, 0, length);
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.ignorableWhitespace(ch, 0, ch.length);
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

	public char[] getCh() {
		return ch;
	}

}
