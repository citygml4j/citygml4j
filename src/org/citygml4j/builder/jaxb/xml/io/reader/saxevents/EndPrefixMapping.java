package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class EndPrefixMapping extends SAXEvent {
	private String prefix;
	
	private EndPrefixMapping() {
		super(EventType.END_PREFIX_MAPPING);
	}
	
	public EndPrefixMapping(String prefix) {
		this();
		this.prefix = prefix;
	}

	@Override
	public EndPrefixMapping shallowCopy() {
		EndPrefixMapping endPrefixMapping = new EndPrefixMapping();
		endPrefixMapping.prefix = prefix;
		
		return endPrefixMapping;
	}

	@Override
	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.endPrefixMapping(prefix);
	}
	
	@Override
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		send(contentHandler);
	}

	public String getPrefix() {
		return prefix;
	}

}
