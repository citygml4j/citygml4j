package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class EndDocument extends SAXEvent {

	public EndDocument() {
		super(EventType.END_DOCUMENT);
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.endDocument();
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}
	
}
