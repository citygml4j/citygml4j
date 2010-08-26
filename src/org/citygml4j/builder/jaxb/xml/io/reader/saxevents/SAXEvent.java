package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public abstract class SAXEvent {
	private final EventType type;
	private SAXEvent next;

	public enum EventType {
		CHARACTERS,
		END_DOCUMENT,
		END_ELEMENT,
		END_PREFIX_MAPPING,
		START_DOCUMENT,
		START_ELEMENT,
		START_PREFIX_MAPPING
	}
	
	SAXEvent(EventType type) {
		this.type = type;
	}
	
	public abstract SAXEvent shallowCopy();
	public abstract void send(ContentHandler contentHandler) throws SAXException;
	public abstract void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException;

	public EventType getType() {
		return type;
	}

	public SAXEvent next() {
		return next;
	}

	public void setNext(SAXEvent next) {
		this.next = next;
	}
}
