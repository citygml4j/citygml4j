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

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.LocatorImpl;

public final class Characters extends SAXEvent implements Locatable {
	private char[] ch;
	private Location location;

	private Characters() {
		super(EventType.CHARACTERS);
	}

	public Characters(char[] ch, int start, int length, Location location) {
		this();

		// make a copy of the char array if necessary.
		// we do not want to have a reference to potentially large arrays
		if (start == 0 && length == ch.length)
			this.ch = ch;
		else {
			this.ch = new char[length];
			System.arraycopy(ch, start, this.ch, 0, length);
		}

		this.location = location;
	}

	@Override
	public Characters shallowCopy() {
		Characters characters = new Characters();
		characters.ch = ch;
		characters.location = location;

		return characters;
	}

	@Override
	public void send(ContentHandler contentHandler) throws SAXException {
		contentHandler.characters(ch, 0, ch.length);
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

	public String toString() {
		return new String(ch);
	}

	public void append(StringBuffer buffer) {
		buffer.append(ch);
	}

	public char[] getCh() {
		return ch;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
