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

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.xml.io.reader.XMLElementChecker.ElementInfo;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartElement;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class JAXBChunkReader extends AbstractJAXBReader {
	private CityGML tmp;
	private Stack<XMLChunk> chunks;
	private XMLChunk chunk;

	private XMLElementChecker elementChecker;
	private ElementInfo elementInfo;
	private Stack<ElementInfo> elementInfos;

	private boolean isInited = false;
	private boolean setXLink = false;

	@SuppressWarnings("unchecked")
	public JAXBChunkReader(XMLStreamReader reader, JAXBInputFactory factory, URI baseURI) throws CityGMLReadException {
		super(reader, factory, baseURI);

		jaxbUnmarshaller.setParseSchema(false);

		chunks = new Stack<XMLChunk>();
		elementInfos = new Stack<ElementInfo>();
		elementChecker = new XMLElementChecker(schemaHandler, 
				(FeatureReadMode)factory.getProperty(CityGMLInputFactory.FEATURE_READ_MODE),
				(Boolean)factory.getProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE),
				parseSchema,
				(Set<Class<? extends CityGML>>)factory.getProperty(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING));
	}

	public void close() throws CityGMLReadException {
		super.close();

		tmp = null;
		chunks.clear();
		chunk = null;
		
		elementChecker = null;
		elementInfos.clear();
		elementInfo = null;
	}

	public boolean hasNextFeature() throws CityGMLReadException {
		if (tmp == null) {
			try {
				tmp = nextFeature();
			} catch (NoSuchElementException e) {
				//
			}
		}

		return tmp != null;
	}

	public CityGML nextFeature() throws CityGMLReadException {
		CityGML next = tmp;

		if (next == null) {
			try {				
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
						if (event != XMLStreamConstants.START_ELEMENT || 
								!util.isCityGMLElement(reader.getName()) ||
								!util.isCityGMLFeature(reader.getLocalName(), reader.getNamespaceURI()))
							continue;

						chunks.clear();
						chunk = new XMLChunk(this, null);
						isInited = true;
					}

					// set XLink on property element
					if (setXLink)
						setXLink();

					// check whether start element is a feature
					if (event == XMLStreamConstants.START_ELEMENT) {
						ElementInfo lastElementInfo = elementInfos.push(elementInfo);
						elementInfo = elementChecker.getElementInfo(reader.getName(), chunk, lastElementInfo);

						if (elementInfo != null && elementInfo.isFeature()) {						
							chunks.add(chunk);
							chunk = new XMLChunk(this, chunks.peek());

							if (lastElementInfo != null)
								setXLink = lastElementInfo.hasXLink();
						}
					}

					// pop last element info
					else if (event == XMLStreamConstants.END_ELEMENT)
						elementInfo = elementInfos.pop();

					// add streaming event to the current chunk 
					chunk.addEvent(reader);

					// if the chunk is complete, try and unmarshal it
					if (chunk.isComplete()) {
						next = unmarshalChunk();
						if (next != null)
							break;	
					}
				}
			} catch (XMLStreamException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (SAXException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (JAXBException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (MissingADESchemaException e) {
				throw new CityGMLReadException("Caused by: ", e);
			}
		}

		if (next == null)
			throw new NoSuchElementException();
		else {
			tmp = null;
			return next;
		}
	}	

	private CityGML unmarshalChunk() throws JAXBException, SAXException, MissingADESchemaException {
		CityGML next = chunk.unmarshal();

		if (!chunks.isEmpty()) {
			if (next == null)
				chunks.peek().append(chunk);

			chunk = chunks.pop();
		} else {
			chunk = null;
			isInited = false;
		}

		return next;
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
				gmlId = factory.getGMLIdManager().generateGmlId();
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
		return chunk != null ? chunk.unmarshalFeatureInfo() : null;
	}

}
