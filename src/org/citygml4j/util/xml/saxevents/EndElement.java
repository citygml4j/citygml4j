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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.util.xml.saxevents;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class EndElement extends SAXEvent {
	private StartElement startElement;
	private Location location;

	private EndElement() {
		super(EventType.END_ELEMENT);
	}

	public EndElement(StartElement startElement, Location location) {
		this();
		this.startElement = startElement;
		this.location = location;
	}

	@Override
	public EndElement shallowCopy() {
		EndElement endElement = new EndElement();
		endElement.startElement = startElement;
		endElement.location = location;

		return endElement;
	}

	@Override
	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.endElement(startElement.getURI(), startElement.getLocalName(), startElement.getQName());
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
		return startElement.getURI();
	}

	public String getLocalName() {
		return startElement.getLocalName();
	}
	
	public String getQName() {
		return startElement.getQName();
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
