package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class StartPrefixMapping extends SAXEvent {
	private String prefix;
	private String uri;

	private StartPrefixMapping() {
		super(EventType.START_PREFIX_MAPPING);
	}
	
	public StartPrefixMapping(String prefix, String uri) {
		this();
		this.prefix = prefix;
		this.uri = uri;
	}

	@Override
	public StartPrefixMapping shallowCopy() {
		StartPrefixMapping startPrefixMapping = new StartPrefixMapping();
		startPrefixMapping.prefix = prefix;
		startPrefixMapping.uri = uri;
		
		return startPrefixMapping;
	}

	@Override
	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.startPrefixMapping(prefix, uri);
	}
	
	@Override
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
