package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.LocatorImpl;

public final class EndCDATA implements SAXEvent {
	public static final EndCDATA SINGLETON = new EndCDATA();

	private EndCDATA() {
		// just to thwart instantiation
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		if (contentHandler instanceof LexicalHandler)
			((LexicalHandler)contentHandler).endCDATA();
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

}
