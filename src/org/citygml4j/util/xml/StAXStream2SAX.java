/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
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
 */
package org.citygml4j.util.xml;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXStream2SAX {
	private final SAXEventBuffer buffer;

	public StAXStream2SAX(SAXEventBuffer buffer) {
		this.buffer = buffer;
	}

	public void bridgeEvent(XMLStreamReader reader) throws XMLStreamException {
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

		buffer.addCharacters(buf);
	}

	private void handleEndElement(XMLStreamReader reader) throws XMLStreamException {
		buffer.addEndElement();
	}

	private void handleStartElement(XMLStreamReader reader) throws XMLStreamException {
		for (int i = 0; i < reader.getNamespaceCount(); i++)
			buffer.addNamespacePrefixMapping(reader.getNamespaceURI(i), reader.getNamespacePrefix(i));

		buffer.addStartElement(reader.getNamespaceURI(), reader.getLocalName(), reader.getPrefix());

		for (int i = 0; i < reader.getAttributeCount(); i++)
			buffer.addAttribute(reader.getAttributeNamespace(i), 
					reader.getAttributeLocalName(i), 
					reader.getAttributePrefix(i),
					reader.getAttributeType(i), 
					reader.getAttributeValue(i));
	}
}
