/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */
package org.citygml4j.util.xml.saxevents;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.LocatorImpl;

public final class StartElement extends SAXEvent implements Locatable {
	private String uri;
	private String localName;
	private String prefix;
	private Attributes attributes;
	private Location location;
	
	private StartElement() {
		super(EventType.START_ELEMENT);
	}

	public StartElement(String uri, String localName, String prefix, Attributes attributes, Location location) {
		this();
		this.uri = uri;
		this.localName = localName;
		this.attributes = new AttributesImpl(attributes);
		this.location = location;

		if (prefix != null) {
			int index = prefix.indexOf(':');
			this.prefix = index > 0 ? prefix.substring(0, index).intern() : null;
		} else
			this.prefix = prefix;
	}

	@Override
	public StartElement shallowCopy() {
		StartElement startElement = new StartElement();
		startElement.uri = uri;
		startElement.localName = localName;
		startElement.prefix = prefix;
		startElement.attributes = attributes;
		startElement.location = location;
		
		return startElement;
	}

	@Override
	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.startElement(uri, localName, prefix != null ? prefix + ':' + localName : localName, attributes);
	}

	@Override
	public void send(ContentHandler contentHandler, LocatorImpl locator) throws SAXException {
		if (location != null) {
			locator.setLineNumber(location.getLineNumber());
			locator.setColumnNumber(location.getColumnNumber());
			locator.setSystemId(location.getSystemId());
			locator.setPublicId(location.getPublicId());
		}

		send(contentHandler);
	}

	public String getURI() {
		return uri;
	}

	public String getLocalName() {
		return localName;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
