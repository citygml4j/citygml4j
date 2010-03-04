package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public interface SAXEvent {
	public void send(ContentHandler contentHandler) throws SAXException;
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException;
}
