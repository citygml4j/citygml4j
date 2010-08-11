package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class StartElement extends SAXEvent implements Locatable {
	private final String uri;
	private final String localName;
	private final String prefix;
	private Attributes attributes;
	private Location location;

	public StartElement(String uri, String localName, String prefix, Attributes attributes, Location location) {
		super(EventType.START_ELEMENT);
		this.uri = uri;
		this.localName = localName;
		this.attributes = attributes;
		this.location = location;

		int index = prefix.indexOf(':');
		this.prefix = index > 0 ? prefix.substring(0, index).intern() : null;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.startElement(uri, localName, prefix != null ? prefix + ':' + localName : localName, attributes);
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

	public Attributes getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
