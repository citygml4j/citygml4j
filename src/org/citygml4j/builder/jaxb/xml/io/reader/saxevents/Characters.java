package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class Characters implements SAXEvent, Locatable {
	private final char[] ch;
	private Location location;
	
	public Characters(char[] ch, int start, int length, Location location) {
		// make a copy of the char array ch.
		// we do not want to have a reference to potentially large arrays

		this.ch = new char[length];
		System.arraycopy(ch, start, this.ch, 0, length);
		this.location = location;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.characters(ch, 0, ch.length);
	}

	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		if (location != null) {
			locator.setLineNumber(location.getLineNumber());
			locator.setColumnNumber(location.getColumnNumber());
			locator.setSystemId(location.getSystemId());
			locator.setPublicId(location.getPublicId());
		}
		
		send(contentHandler);
	}

	public String toString() {
		return new String(ch);
	}

	public void append(StringBuffer buffer) {
		buffer.append(ch);
	}

	public char[] getCh() {
		return ch;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
