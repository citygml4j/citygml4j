package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.LocatorImpl;

public final class StartDTD implements SAXEvent {
	private final String name;
	private final String publicId;
	private final String systemId;

	public StartDTD(String name, String publicId, String systemId) {
		this.name = name;
		this.publicId = publicId;
		this.systemId = systemId;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		if (contentHandler instanceof LexicalHandler)
			((LexicalHandler)contentHandler).startDTD(name, publicId, systemId);
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

	public String getName() {
		return name;
	}

	public String getPublicId() {
		return publicId;
	}

	public String getSystemId() {
		return systemId;
	}

}
