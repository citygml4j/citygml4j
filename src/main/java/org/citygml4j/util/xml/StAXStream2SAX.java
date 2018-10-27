/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
