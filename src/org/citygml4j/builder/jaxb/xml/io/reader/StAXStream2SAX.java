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
package org.citygml4j.builder.jaxb.xml.io.reader;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class StAXStream2SAX {
	private final SAXEventBuffer buffer;

	public StAXStream2SAX(SAXEventBuffer buffer) {
		this.buffer = buffer;
	}

	public void bridgeEvent(XMLStreamReader reader) throws XMLStreamException {
		// update location	
		if (buffer.trackLocation) {
			Location location = reader.getLocation();
			buffer.updateLocation(
					location.getLineNumber(), 
					location.getColumnNumber(), 
					location.getSystemId(),
					location.getPublicId());
		}

		// convert stax to sax revent
		switch (reader.getEventType()) {
		case XMLStreamConstants.START_ELEMENT:
			handleStartElement(reader);
			break;
		case XMLStreamConstants.END_ELEMENT:
			handleEndElement(reader);
			break;
		case XMLStreamConstants.CHARACTERS:
			handleCharacters(reader);
			break;
		}
	}

	private void handleCharacters(XMLStreamReader reader) throws XMLStreamException {
		char[] buf = new char[reader.getTextLength()];
		int len, start = 0;

		do {
			len = reader.getTextCharacters(start, buf, 0, buf.length);
			start += len;			
		} while (len == buf.length);

		try {
			buffer.characters(buf, 0, len);
		} catch (SAXException e) {
			throw new XMLStreamException(e);
		}
	}

	private void handleEndElement(XMLStreamReader reader) throws XMLStreamException {
		try {
			QName name = reader.getName();
			String prefix = name.getPrefix();

			buffer.endElement(
					name.getNamespaceURI(),
					name.getLocalPart(),
					(prefix != null && prefix.length() > 0) ? prefix + ':' + name.getLocalPart() : name.getLocalPart());

			for (int i = reader.getNamespaceCount() - 1; i >= 0; i--) {
				prefix = reader.getNamespacePrefix(i);
				if (prefix == null)
					prefix = "";

				buffer.endPrefixMapping(prefix);
			}
		} catch (SAXException e) {
			throw new XMLStreamException(e);
		}
	}

	private void handleStartElement(XMLStreamReader reader) throws XMLStreamException {
		try {
			for (int i = 0; i < reader.getNamespaceCount(); i++) {
				String uri = reader.getNamespaceURI(i);
				if (uri == null)
					uri = "";

				String prefix = reader.getNamespacePrefix(i);
				if (prefix == null)
					prefix = "";

				buffer.startPrefixMapping(
						prefix,
						uri);
			}

			QName name = reader.getName();
			String prefix = reader.getPrefix();
			Attributes attrs = getAttributes(reader);

			buffer.startElement(
					name.getNamespaceURI(),
					name.getLocalPart(),
					(prefix != null && prefix.length() > 0) ? prefix + ':' + name.getLocalPart() : name.getLocalPart(),
					attrs);

		} catch (SAXException e) {
			throw new XMLStreamException(e);
		}
	}

	private Attributes getAttributes(XMLStreamReader reader) {
		AttributesImpl attrs = new AttributesImpl();

		for (int i = 0; i < reader.getNamespaceCount(); i++) {
			String uri = reader.getNamespaceURI(i);
			if (uri == null) 
				uri = "";

			String prefix = reader.getNamespacePrefix(i);
			if (prefix == null) 
				prefix = "";

			String name = XMLConstants.XMLNS_ATTRIBUTE;
			if (prefix.length() == 0)
				prefix = name;
			else
				name += ':' + prefix;

			attrs.addAttribute(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, prefix, name, "CDATA", uri);                
		}

		for (int i = 0; i < reader.getAttributeCount(); i++) {
			String uri = reader.getAttributeNamespace(i);
			if (uri == null)   
				uri = "";

			String localName = reader.getAttributeLocalName(i);
			String type = reader.getAttributeType(i);
			String value = reader.getAttributeValue(i);
			
			attrs.addAttribute(uri, localName, localName, type, value);
		}

		return attrs;
	}

}
