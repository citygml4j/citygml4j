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
package org.citygml4j.builder.jaxb.xml.io.reader;

import org.citygml4j.builder.jaxb.xml.io.reader.XMLElementChecker.ElementInfo;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.model.module.gml.XLinkModule;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.citygml4j.xml.io.reader.UnmarshalException;
import org.citygml4j.xml.io.reader.XMLChunk;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Stack;

public class JAXBChunkReader extends AbstractJAXBReader implements CityGMLReader {
	private XMLChunkImpl current;
	private XMLChunkImpl iterator;

	private Stack<XMLChunkImpl> chunks;
	private XMLChunkImpl chunk;

	private ElementInfo elementInfo;
	private Stack<ElementInfo> elementInfos;

	private boolean isInited = false;
	private boolean setXLink = false;

	public JAXBChunkReader(XMLStreamReader reader, InputStream in, JAXBInputFactory factory, URI baseURI) throws CityGMLReadException {
		super(reader, in, factory, baseURI);
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
							elementInfo = elementChecker.getElementInfo(reader.getName());

							if (elementInfo != null && elementInfo.isFeature()) {
								isInited = true;
								chunks.clear();

								chunk = new XMLChunkImpl(this, null);
								chunk.setFirstElement(reader.getName());

								if (isFilteredReader())
									chunk.setIsFiltered(!filter.accept(reader.getName()));
							} else
								continue;
						}						
					}

					// check whether start element is a feature
					if (event == XMLStreamConstants.START_ELEMENT) {
						ElementInfo lastElementInfo = elementInfos.push(elementInfo);
						elementInfo = elementChecker.getElementInfo(reader.getName(), lastElementInfo);

						if (elementInfo != null && elementInfo.isFeature()) {
							chunk.removeTrailingCharacters();
							chunks.add(chunk);

							chunk = new XMLChunkImpl(this, chunks.peek());
							chunk.setFirstElement(reader.getName());

							if (isFilteredReader())
								chunk.setIsFiltered(!filter.accept(reader.getName()));								

							if (lastElementInfo != null)
								setXLink = lastElementInfo.hasXLink();
						}
					}

					// pop last element info
					else if (event == XMLStreamConstants.END_ELEMENT)
						elementInfo = elementInfos.pop();

					// add streaming event to the current chunk 
					chunk.addEvent(reader);
					if (setXLink)
						setXLink(reader);

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
			} catch (XMLStreamException | SAXException | MissingADESchemaException e) {
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
		} catch (UnmarshalException e) {
			throw new CityGMLReadException("Caused by: ", e.getCause());
		} catch (MissingADESchemaException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}

		return cityGML;
	}
	
	private void setXLink(XMLStreamReader reader) {
		setXLink = false;
		
		// check whether the new chunk has a gml:id
		String gmlId = null;
		for (int i = 0; i < reader.getAttributeCount(); i++) {
			if (reader.getAttributeLocalName(i).equals("id")) {
				gmlId = reader.getAttributeValue(i);
				break;
			}
		}
		
		// set gml:id if not present
		if (gmlId == null) {
			gmlId = factory.getGMLIdManager().generateUUID();
			chunk.addAttribute(GMLCoreModule.v3_1_1.getNamespaceURI(), "id", "id", "CDATA", gmlId);
		}
		
		// set xlink:href property on previous chunk
		chunks.peek().addAttribute(XLinkModule.v3_1_1.getNamespaceURI(), "href", "href", "CDATA", '#' + gmlId);
	}

	public boolean isSetParentInfo() {
		return getParentInfo() != null;
	}

	public ParentInfo getParentInfo() {
		return current != null ? current.getParentInfo() : null;
	}

}
