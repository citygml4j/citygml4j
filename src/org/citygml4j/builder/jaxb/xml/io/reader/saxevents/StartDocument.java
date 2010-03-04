package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class StartDocument implements SAXEvent {
	public static final StartDocument SINGLETON = new StartDocument();

	private StartDocument() {
		// just to thwart instantiation
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.startDocument();
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

}
