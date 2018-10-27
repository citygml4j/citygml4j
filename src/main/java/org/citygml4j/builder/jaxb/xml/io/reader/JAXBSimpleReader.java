/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObject;
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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXResult;
import java.io.InputStream;
import java.net.URI;
import java.util.NoSuchElementException;

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

					elementInfo = elementChecker.getElementInfo(reader.getName());
					if (elementInfo != null && elementInfo.isFeature()) {

						if (!isFilteredReader() || filter.accept(reader.getName())) {
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
		} catch (MissingADESchemaException e) {
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
					if (citygml instanceof AbstractFeature)
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
				next = new XMLChunkImpl(this, null);
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
