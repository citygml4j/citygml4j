package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.LocatorImpl;

public final class StartCDATA implements SAXEvent {
	public static final StartCDATA SINGELTON = new StartCDATA();

	private StartCDATA() {
		// just to thwart instantiation
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		if (contentHandler instanceof LexicalHandler)
			((LexicalHandler)contentHandler).startCDATA();
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

}
