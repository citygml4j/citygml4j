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
package org.citygml4j.builder.jaxb.xml.io.reader;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Stack;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.xml.io.reader.XMLElementChecker.ElementInfo;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.util.xml.saxevents.StartElement;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.XMLChunk;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.citygml4j.xml.io.reader.UnmarshalException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class JAXBChunkReader extends AbstractJAXBReader implements CityGMLReader {
	private XMLChunkImpl current;
	private XMLChunkImpl iterator;

	private Stack<XMLChunkImpl> chunks;
	private XMLChunkImpl chunk;

	private ElementInfo elementInfo;
	private Stack<ElementInfo> elementInfos;

	private boolean isInited = false;
	private boolean setXLink = false;

	public JAXBChunkReader(XMLStreamReader reader, JAXBInputFactory factory, URI baseURI) throws CityGMLReadException {
		super(reader, factory, baseURI);
		jaxbUnmarshaller.setParseSchema(false);
		chunks = new Stack<XMLChunkImpl>();
		elementInfos = new Stack<ElementInfo>();
	}

	public void close() throws CityGMLReadException {
		super.close();

		current = null;
		iterator = null;
		chunks.clear();
		chunk = null;

		elementInfos.clear();
		elementInfo = null;
	}

	public synchronized boolean hasNext() throws CityGMLReadException {
		if (iterator == null) {
			try {
				iterator = (XMLChunkImpl)nextChunk();
			} catch (NoSuchElementException e) {
				//
			}
		}

		return iterator != null;
	}

	public XMLChunk nextChunk() throws CityGMLReadException {
		if (iterator == null) {
			try {
				current = null;

				while (reader.hasNext()) {
					int event = reader.next();	

					// keep track of schema documents
					if (event == XMLStreamConstants.START_ELEMENT && parseSchema) {
						for (int i = 0; i < reader.getAttributeCount(); i++) {
							if (reader.getAttributeLocalName(i).equals("schemaLocation"))
								parseSchema(reader.getAttributeValue(i));					
							else if (reader.getAttributeLocalName(i).equals("noNamespaceSchemaLocation"))
								schemaHandler.parseSchema("", reader.getAttributeValue(i));
						}
					}

					// move to the next CityGML feature in the document
					// and create a new chunk to initiate parsing
					if (!isInited) {
						if (event != XMLStreamConstants.START_ELEMENT)
							continue;

						else {
							elementInfo = elementChecker.getCityGMLFeature(reader.getName(), isFilteredReader());

							if (elementInfo != null && elementInfo.isFeature()) {
								isInited = true;
								chunks.clear();
								chunk = new XMLChunkImpl(this, null, elementInfo.getType());

								if (isFilteredReader())
									chunk.setIsFiltered(!filter.accept(elementInfo.getType()));
							} else
								continue;
						}						
					}

					// set XLink on property element
					if (setXLink)
						setXLink();

					// check whether start element is a feature
					if (event == XMLStreamConstants.START_ELEMENT) {
						ElementInfo lastElementInfo = elementInfos.push(elementInfo);
						elementInfo = elementChecker.getElementInfo(reader.getName(), chunk, lastElementInfo, isFilteredReader());

						if (elementInfo != null && elementInfo.isFeature()) {
							chunk.skipTrailingCharacters();
							chunks.add(chunk);

							chunk = new XMLChunkImpl(this, chunks.peek(), elementInfo.getType());

							if (isFilteredReader())
								chunk.setIsFiltered(!filter.accept(elementInfo.getType()));								

							if (lastElementInfo != null)
								setXLink = lastElementInfo.hasXLink();
						}
					}

					// pop last element info
					else if (event == XMLStreamConstants.END_ELEMENT)
						elementInfo = elementInfos.pop();

					// add streaming event to the current chunk 
					chunk.addEvent(reader);

					// if the chunk is complete, return it
					if (chunk.isComplete()) {
						current = chunk;

						if (!chunks.isEmpty())
							chunk = chunks.pop();
						else {
							chunk = null;
							isInited = false;
						}

						if (!isFilteredReader() || !current.isFiltered())
							break;
						else
							current = null;
					}
				}
			} catch (XMLStreamException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (SAXException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (MissingADESchemaException e) {
				throw new CityGMLReadException("Caused by: ", e);
			}
			
			if (current == null)
				throw new NoSuchElementException();
		} else
			current = iterator;

		iterator = null;
		return current;
	}

	public CityGML nextFeature() throws CityGMLReadException {	
		CityGML cityGML = null;
		XMLChunkImpl next = (XMLChunkImpl)nextChunk();

		try {
			cityGML = next.unmarshal();
			if (cityGML == null && !chunks.isEmpty())
				chunks.peek().append(next);
		} catch (UnmarshalException e) {
			throw new CityGMLReadException("Caused by: ", e.getCause());
		} catch (MissingADESchemaException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}

		return cityGML;
	}

	private void setXLink() {
		setXLink = false;

		if (!chunks.isEmpty()) {
			StartElement propertyElement = chunks.peek().getLastStartElement();
			if (propertyElement == null)
				return;			

			StartElement feature = chunk.getFirstStartElement();
			String gmlId = null;	

			Attributes featureAtts = feature.getAttributes();
			for (int i = 0; i < featureAtts.getLength(); i++) {
				if (featureAtts.getLocalName(i).equals("id")) {
					gmlId = featureAtts.getValue(i);
					break;
				}
			}

			if (gmlId == null || gmlId.length() == 0) {
				gmlId = factory.getGMLIdManager().generateUUID();
				AttributesImpl atts = new AttributesImpl(featureAtts);
				atts.addAttribute(GMLCoreModule.v3_1_1.getNamespaceURI(), "id", "id", "CDATA", gmlId);
				feature.setAttributes(atts);
			}

			Attributes featurePropertyAtts = propertyElement.getAttributes();
			AttributesImpl atts = new AttributesImpl();
			for (int i = 0; i < featurePropertyAtts.getLength(); i++) {
				if (featurePropertyAtts.getURI(i).equals("http://www.w3.org/1999/xlink"))
					continue;

				atts.addAttribute(featurePropertyAtts.getURI(i),
						featurePropertyAtts.getLocalName(i),
						featurePropertyAtts.getQName(i),
						featurePropertyAtts.getType(i),
						featurePropertyAtts.getValue(i));						
			}

			atts.addAttribute("http://www.w3.org/1999/xlink", "href", "href", "CDATA", '#' + gmlId);
			propertyElement.setAttributes(atts);
		}		
	}

	public boolean isSetParentInfo() {
		return getParentInfo() != null;
	}

	public ParentInfo getParentInfo() {
		return current != null ? current.getParentInfo() : null;
	}

}
