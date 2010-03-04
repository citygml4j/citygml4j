package org.citygml4j.builder.jaxb.xml.io.reader.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class ProcessingInstruction implements SAXEvent, Locatable {
	private final String target;
	private final String data;
	private Location location;
	
	public ProcessingInstruction(String target, String data, Location location) {
		this.target = target;
		this.data = data;
		this.location = location;
	}

	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.processingInstruction(target, data);
	}
	
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		if (location != null) {
			locator.setLineNumber(location.getLineNumber());
			locator.setColumnNumber(location.getColumnNumber());
			locator.setSystemId(location.getSystemId());
			locator.setPublicId(location.getPublicId());
		}
		
		send(contentHandler);
	}

	public String getTarget() {
		return target;
	}

	public String getData() {
		return data;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

}
