package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class EndElement implements SAXEvent, Locatable {
	private final String uri;
	private final String localName;
	private final String qName;
	private Location location;

	public EndElement(String uri, String localName, String qName, Location location) {
		this.uri = uri;
		this.localName = localName;
		this.qName = qName;
		this.location = location;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.endElement(uri, localName, qName);
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

	public String getURI() {
		return uri;
	}

	public String getLocalName() {
		return localName;
	}

	public String getQName() {
		return qName;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

}
