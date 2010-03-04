package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.LocatorImpl;

public final class StartElement implements SAXEvent, Locatable {
	private final String uri;
	private final String localName;
	private final String qName;
	private final Attributes atts;
	private Location location;

	public StartElement(String uri, String localName, String qName, Attributes atts, Location location) {
		this.uri = uri;
		this.localName = localName;
		this.qName = qName;
		this.atts = new AttributesImpl(atts);
		this.location = location;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.startElement(uri, localName, qName, atts);
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

	public Attributes getAtts() {
		return atts;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
