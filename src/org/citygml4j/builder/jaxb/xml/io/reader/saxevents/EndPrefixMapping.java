package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class EndPrefixMapping implements SAXEvent {
	private final String prefix;

	public EndPrefixMapping(String prefix) {
		this.prefix = prefix;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.endPrefixMapping(prefix);
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

	public String getPrefix() {
		return prefix;
	}

}
