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
package org.citygml4j.builder.jaxb.xml.io.reader;

import java.io.InputStream;
import java.net.URI;
import java.util.NoSuchElementException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXResult;

import org.citygml4j.builder.jaxb.xml.io.reader.XMLElementChecker.ElementInfo;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.util.internal.xml.TransformerChain;
import org.citygml4j.util.xml.SAXEventBuffer;
import org.citygml4j.util.xml.StAXStream2SAX;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.citygml4j.xml.io.reader.XMLChunk;
import org.xml.sax.SAXException;

public class JAXBSimpleReader extends AbstractJAXBReader implements CityGMLReader {
	private boolean iterator;
	private ElementInfo elementInfo;

	public JAXBSimpleReader(XMLStreamReader reader, InputStream in, JAXBInputFactory factory, URI baseURI) throws CityGMLReadException {
		super(reader, in, factory, baseURI);
		jaxbUnmarshaller.setParseSchema(parseSchema);
	}

	public void close() throws CityGMLReadException {
		super.close();
		elementInfo = null;
	}

	public synchronized boolean hasNext() throws CityGMLReadException {
		iterator = false;
		elementInfo = null;

		try {
			while (reader.hasNext()) {
				if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {

					// keep track of schema documents
					if (parseSchema) {
						for (int i = 0; i < reader.getAttributeCount(); i++) {
							if (reader.getAttributeLocalName(i).equals("schemaLocation"))
								parseSchema(reader.getAttributeValue(i));
							else if (reader.getAttributeLocalName(i).equals("noNamespaceSchemaLocation"))
								schemaHandler.parseSchema("", reader.getAttributeValue(i));
						}
					}

					elementInfo = elementChecker.getCityGMLFeature(reader.getName(), isFilteredReader());
					if (elementInfo != null && elementInfo.isFeature()) {

						if (!isFilteredReader() || filter.accept(elementInfo.getType())) {
							iterator = true;
							break;
						}

						else {
							// consume events until corresponding end element								
							for (int depth = 1; depth > 0; ) {
								reader.next();

								if (reader.getEventType() == XMLStreamConstants.START_ELEMENT)
									depth++;
								else if (reader.getEventType() == XMLStreamConstants.END_ELEMENT)
									depth--;
							}
						}
					}
				}

				reader.next();
			}
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		} catch (SAXException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}

		return iterator;
	}

	public synchronized CityGML nextFeature() throws CityGMLReadException {
		CityGML next = null;

		if (iterator || hasNext()) {
			try {
				Unmarshaller unmarshaller = factory.builder.getJAXBContext().createUnmarshaller();

				// validate input
				if (useValidation) {
					unmarshaller.setSchema(validationSchemaHandler.getSchema());
					if (validationEventHandler != null)
						unmarshaller.setEventHandler(validationEventHandler);
				}							

				// unmarshal input
				Object result = null;
				
				if (transformerChainFactory == null)
					result = unmarshaller.unmarshal(reader);
				else {
					// create a unmarshaller handler and make it the target of the transformer chain
					UnmarshallerHandler handler = unmarshaller.getUnmarshallerHandler();
					TransformerChain chain = transformerChainFactory.buildChain();
					chain.tail().setResult(new SAXResult(handler));
					
					// the entire document has to be copied to a sax buffer
					SAXEventBuffer buffer = new SAXEventBuffer();
					StAXStream2SAX mapper = new StAXStream2SAX(buffer);
					
					// map all stax events to the sax buffer
					mapper.bridgeEvent(reader);
					for (int depth = 1; depth > 0; ) {
						reader.next();
						mapper.bridgeEvent(reader);

						if (reader.getEventType() == XMLStreamConstants.START_ELEMENT)
							depth++;
						else if (reader.getEventType() == XMLStreamConstants.END_ELEMENT)
							depth--;
					}

					// send the sax buffer to the first template in the chain
					chain.head().startDocument();
					buffer.send(chain.head(), true);
					chain.head().endDocument();
					
					result = handler.getResult();
				}

				// release memory
				unmarshaller = null;

				if (result instanceof JAXBElement<?>) {
					ModelObject citygml = jaxbUnmarshaller.unmarshal((JAXBElement<?>)result);
					if (citygml.getModelType() == ModelType.CITYGML && citygml instanceof AbstractFeature)
						next = (CityGML)citygml;
				}
			} catch (JAXBException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (SAXException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (MissingADESchemaException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (TransformerConfigurationException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (XMLStreamException e) {
				throw new CityGMLReadException("Caused by: ", e);
			}
		}

		if (next == null)
			throw new NoSuchElementException();
		else {
			iterator = false;
			return next;
		}	
	}

	public synchronized XMLChunk nextChunk() throws CityGMLReadException {
		XMLChunkImpl next = null;

		if (iterator || hasNext()) {
			try {
				next = new XMLChunkImpl(this, null, elementInfo != null ? elementInfo.getType() : null);
				while (reader.hasNext()) {
					next.addEvent(reader);
					if (next.isComplete())
						break;
					
					reader.next();
				}
			} catch (XMLStreamException e) {
				throw new CityGMLReadException("Caused by: ", e);
			}
		}

		if (next == null)
			throw new NoSuchElementException();
		else {
			iterator = false;
			return next;
		}
	}

	public boolean isSetParentInfo() {
		return false;
	}

	public ParentInfo getParentInfo() {
		return null;
	}

}
