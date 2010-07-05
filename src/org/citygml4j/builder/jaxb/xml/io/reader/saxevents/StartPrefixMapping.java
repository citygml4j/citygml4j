package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class StartPrefixMapping extends SAXEvent {
	private final String prefix;
	private final String uri;

	public StartPrefixMapping(String prefix, String uri) {
		super(EventType.START_PREFIX_MAPPING);
		this.prefix = prefix;
		this.uri = uri;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.startPrefixMapping(prefix, uri);
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

	public String getPrefix() {
		return prefix;
	}

	public String getUri() {
		return uri;
	}

}
