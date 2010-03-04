package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class SkippedEntity implements SAXEvent {
	private final String name;

	public SkippedEntity(String name) {
		this.name = name;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.skippedEntity(name);
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

	public String getName() {
		return name;
	}

}
