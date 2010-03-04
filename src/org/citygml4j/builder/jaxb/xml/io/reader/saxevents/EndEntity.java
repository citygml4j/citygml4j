package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.LocatorImpl;

public final class EndEntity implements SAXEvent, Locatable {
	private final String name;
	private Location location;
	
	public EndEntity(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		if (contentHandler instanceof LexicalHandler)
			((LexicalHandler)contentHandler).endEntity(name);
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

	public String getName() {
		return name;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

}
