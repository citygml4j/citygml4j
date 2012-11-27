/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.util.xml.saxevents;

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
