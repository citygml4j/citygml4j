package org.citygml4j.builder.jaxb.xml.io.reader;

import java.util.ArrayList;
import java.util.Iterator;

import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.Characters;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.EndDocument;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.EndElement;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.EndPrefixMapping;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.IgnorableWhitespace;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.Location;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.ProcessingInstruction;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.SAXEvent;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.SkippedEntity;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartDocument;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartElement;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartPrefixMapping;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;
import org.xml.sax.helpers.NamespaceSupport;

public class SAXEventBuffer implements ContentHandler {
	final ArrayList<SAXEvent> saxEvents;
	final NamespaceSupport namespaces;
	final boolean trackLocation;

	private final LocatorImpl locator;

	public SAXEventBuffer() {
		this(false);
	}

	public SAXEventBuffer(boolean trackLocation) {
		this.trackLocation = trackLocation;
		saxEvents = new ArrayList<SAXEvent>();
		namespaces = new NamespaceSupport();
		locator = trackLocation ? new LocatorImpl() : null;
	}

	public void setDocumentLocator(Locator locator) {
		//
	}

	public void updateLocation(int lineNumber, int columnNumber, String systemId, String publicId) {
		locator.setLineNumber(lineNumber);
		locator.setColumnNumber(columnNumber);
		locator.setSystemId(systemId);
		locator.setPublicId(publicId);
	}

	public void skippedEntity(String name) throws SAXException {
		saxEvents.add(new SkippedEntity(name));
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		saxEvents.add(new Characters(ch, start, length, getLocation()));
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		saxEvents.add(new IgnorableWhitespace(ch, start, length));
	}

	public void processingInstruction(String target, String data) throws SAXException {
		saxEvents.add(new ProcessingInstruction(target, data, getLocation()));
	}

	public void startDocument() throws SAXException {
		saxEvents.add(StartDocument.SINGLETON);
	}

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		saxEvents.add(new StartElement(uri, localName, qName, atts, getLocation()));
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		namespaces.pushContext();
		namespaces.declarePrefix(prefix, uri);		
		saxEvents.add(new StartPrefixMapping(prefix, uri));
	}

	public void endDocument() throws SAXException {
		saxEvents.add(EndDocument.SINGLETON);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		saxEvents.add(new EndElement(uri, localName, qName, getLocation()));
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		namespaces.popContext();		
		saxEvents.add(new EndPrefixMapping(prefix));
	}

	public boolean isEmpty() {
		return saxEvents.isEmpty();
	}

	public void clear() {
		saxEvents.clear();
		namespaces.reset();
	}

	public void addEvent(SAXEvent event) {
		saxEvents.add(event);
	}

	public void append(SAXEventBuffer other) {
		saxEvents.addAll(other.saxEvents);
	}

	public Iterator<SAXEvent> iterator() {
		return saxEvents.iterator();
	}

	private Location getLocation() {
		return trackLocation ? new Location(
				locator.getLineNumber(), 
				locator.getColumnNumber(),
				locator.getSystemId(),
				locator.getPublicId()) : null;
	}
}
