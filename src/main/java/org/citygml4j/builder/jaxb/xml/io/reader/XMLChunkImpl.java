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
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.feature.LocationProperty;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.util.internal.xml.TransformerChain;
import org.citygml4j.util.xml.SAXEventBuffer;
import org.citygml4j.util.xml.StAXStream2SAX;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.citygml4j.xml.io.reader.UnmarshalException;
import org.citygml4j.xml.io.reader.XMLChunk;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXResult;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class XMLChunkImpl implements XMLChunk {
	private final AbstractJAXBReader jaxbReader;
	private final XMLChunkImpl parentChunk;	
	private final SAXEventBuffer buffer;
	private final StAXStream2SAX stax2sax;	

	private CityGML citygml;
	private ParentInfo featureInfo;	
	private CityGMLClass type = CityGMLClass.UNDEFINED;
	private QName firstElement;
	private AtomicBoolean parentInfoResolved = new AtomicBoolean(false);
	private AtomicBoolean citygmlResolved = new AtomicBoolean(false);
	private AtomicBoolean typeResolved = new AtomicBoolean(false);

	private boolean isFiltered = false;
	private int depth = 0;
	private boolean hasPassedXMLValidation = false;

	XMLChunkImpl(AbstractJAXBReader chunkReader, XMLChunkImpl parentChunk) {
		this.jaxbReader = chunkReader;
		this.parentChunk = parentChunk;

		buffer = new SAXEventBuffer();
		stax2sax = new StAXStream2SAX(buffer);
	}

	@Override
	public QName getTypeName() {
		return firstElement;
	}

	@Override
	public boolean isSetParentInfo() {
		return getParentInfo() != null;
	} 

	@Override
	public ParentInfo getParentInfo() {
		return parentChunk != null ? parentChunk.unmarshalFeatureInfo() : null;
	}

	@Override
	public boolean hasPassedXMLValidation() {
		return hasPassedXMLValidation;
	}

	protected void removeTrailingCharacters() {
		buffer.removeTrailingCharacters();
	}

	protected boolean isComplete() {
		return depth == 0 && !buffer.isEmpty();
	}

	protected boolean isFiltered() {
		return isFiltered;
	}

	protected void setIsFiltered(boolean isFiltered) {
		this.isFiltered = isFiltered;
	}

	protected void setFirstElement(QName firstElement) {
		this.firstElement = firstElement;
	}

	protected void addEvent(XMLStreamReader reader) throws XMLStreamException {
		int event = reader.getEventType();

		if (buffer.isEmpty() && event != XMLStreamConstants.START_ELEMENT)
			throw new XMLStreamException("chunk expects a START_ELEMENT as first element.");
		else if (isComplete() && (event == XMLStreamConstants.START_ELEMENT || event == XMLStreamConstants.END_ELEMENT)) 
			throw new XMLStreamException("chunk does not accept further START_ELEMENT or END_ELEMENT events.");

		stax2sax.bridgeEvent(reader);

		switch (event) {
		case XMLStreamConstants.START_ELEMENT:
			depth++;
			break;
		case XMLStreamConstants.END_ELEMENT:
			depth--;
			break;
		}
	}

	protected void addAttribute(String uri, String localName, String prefix, String type, String value) {
		buffer.addAttribute(uri, localName, prefix, type, value);
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		if (citygmlResolved.get())
			return citygml.getCityGMLClass();

		if (typeResolved.compareAndSet(false, true)) {
			try {
				ElementInfo info = jaxbReader.elementChecker.getElementInfo(firstElement);
				if (info != null) {
					if (info.getFeatureClass() != null
							&& jaxbReader.elementChecker.isCityGMLElement(firstElement)
							&& CityGML.class.isAssignableFrom(info.getFeatureClass()))
						type = CityGMLClass.fromModelClass(info.getFeatureClass().asSubclass(CityGML.class));
					else
						type = CityGMLClass.ADE_COMPONENT;
				}
			} catch (MissingADESchemaException e) {
				//
			}
		}

		return type;
	}

	@Override
	public void send(ContentHandler handler, boolean release) throws SAXException {
		if (citygmlResolved.get())
			throw new IllegalStateException("Unmarshalled chunks cannot be forwarded to a ContentHandler.");

		buffer.send(handler, release);
	}

	private ParentInfo unmarshalFeatureInfo() {
		if (!buffer.isEmpty() && parentInfoResolved.compareAndSet(false, true)) {
			try {
				final SAXEventBuffer tmp = new SAXEventBuffer();

				ContentHandler handler = new ContentHandler() {
					int depth = 0;
					boolean captureElements = true;

					public void startPrefixMapping(String prefix, String uri) throws SAXException {
						tmp.startPrefixMapping(prefix, uri);
					}

					public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
						if (depth == 1)
							captureElements = jaxbReader.elementChecker.isParentInfoElement(uri, localName);

						if (captureElements)
							tmp.startElement(uri, localName, qName, atts);

						depth++;
					}

					public void endElement(String uri, String localName, String qName) throws SAXException {
						if (captureElements)
							tmp.endElement(uri, localName, qName);

						depth--;
					}

					public void characters(char[] ch, int start, int length) throws SAXException {
						if (captureElements)
							tmp.characters(ch, start, length);
					}

					public void endDocument() throws SAXException {
						tmp.addEndElement();					
						if (captureElements)
							tmp.addEndElement();						
					}

					public void startDocument() throws SAXException { }					
					public void skippedEntity(String name) throws SAXException { }
					public void setDocumentLocator(Locator locator) { }
					public void processingInstruction(String target, String data) throws SAXException { }
					public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException { }
					public void endPrefixMapping(String prefix) throws SAXException { }
				};

				buffer.send(handler, false);
				handler.endDocument();

				CityGML citygml = unmarshal(tmp, false);
				if (citygml instanceof AbstractFeature)
					featureInfo = new FeatureInfoImpl((AbstractFeature)citygml);

			} catch (UnmarshalException | MissingADESchemaException | SAXException e) {
				//
			}
		}

		return featureInfo;
	}

	@Override
	public CityGML unmarshal() throws UnmarshalException, MissingADESchemaException {
		if (citygmlResolved.compareAndSet(false, true))
			citygml = unmarshal(buffer, jaxbReader.useValidation);

		return citygml;
	}	

	private CityGML unmarshal(SAXEventBuffer buffer, boolean useValidation) throws UnmarshalException, MissingADESchemaException {
		try {
			CityGML citygml = null;		
			QName fakeRoot = getFakeRoot();

			Unmarshaller unmarshaller = jaxbReader.factory.builder.getJAXBContext().createUnmarshaller();
			if (useValidation) {
				hasPassedXMLValidation = true;
				unmarshaller.setSchema(jaxbReader.validationSchemaHandler.getSchema());

				if (jaxbReader.validationEventHandler != null) {			
					unmarshaller.setEventHandler(new ValidationEventHandler() {
						public boolean handleEvent(ValidationEvent event) {
							hasPassedXMLValidation = false;
							return jaxbReader.validationEventHandler.handleEvent(event);
						}
					});
				}
			}

			UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();			
			ContentHandler contentHandler = null;

			if (jaxbReader.transformerChainFactory == null)
				contentHandler = unmarshallerHandler;
			else {
				// apply transformation before unmarshalling
				TransformerChain chain = jaxbReader.transformerChainFactory.buildChain();
				chain.tail().setResult(new SAXResult(unmarshallerHandler));
				contentHandler = chain.head();
			}

			// emulate start of a new document
			contentHandler.startDocument();
			if (fakeRoot != null)
				contentHandler.startElement(fakeRoot.getNamespaceURI(), fakeRoot.getLocalPart(), "", new AttributesImpl());

			// fire buffered sax events to content handler		
			buffer.send(contentHandler, true);

			// emulate end of a document
			if (fakeRoot != null)
				contentHandler.endElement(fakeRoot.getNamespaceURI(), fakeRoot.getLocalPart(), "");

			contentHandler.endDocument();

			// unmarshal sax events
			Object result = unmarshallerHandler.getResult();
			unmarshaller = null;
			unmarshallerHandler = null;

			if (result instanceof JAXBElement<?>) {
				ModelObject gml = jaxbReader.jaxbUnmarshaller.unmarshal((JAXBElement<?>)result);

				if (gml instanceof AbstractFeature)
					citygml = (CityGML)gml;
				else if (gml instanceof AppearanceProperty) {
					Appearance appearance = ((AppearanceProperty)gml).getAppearance();
					appearance.unsetParent();
					citygml = appearance;
				} else if (gml instanceof FeatureProperty<?>) {
					FeatureProperty<?> property = (FeatureProperty<?>)gml;
					if (property.isSetFeature()) {
						AbstractFeature feature = property.getFeature();
						feature.unsetParent();
						citygml = (CityGML)feature;
					} else
						citygml = ((FeatureProperty<?>)gml).getGenericADEElement();
				}
			}

			return citygml;
		} catch (JAXBException | SAXException | TransformerConfigurationException e) {
			throw new UnmarshalException("Unmarshal exception caused by: ", e);
		}
	}

	private QName getFakeRoot() {
		if (!jaxbReader.elementChecker.isCityGMLElement(firstElement.getNamespaceURI())) 
			return new QName(GMLCoreModule.v3_1_1.getNamespaceURI(), "featureProperty");
		else if (firstElement.getLocalPart().equals("Appearance"))
			return new QName(firstElement.getNamespaceURI(), "appearanceMember");

		return null;
	}

	private final class FeatureInfoImpl implements ParentInfo {
		private final AbstractFeature feature;

		private FeatureInfoImpl(AbstractFeature feature) {
			this.feature = feature;
		}

		public boolean isSetId() {
			return feature.isSetId();
		}

		public String getId() {
			return feature.getId();
		}

		public boolean isSetName() {
			return feature.isSetName();
		}

		public List<Code> getName() {
			return feature.getName();
		}

		public boolean isSetDescription() {
			return feature.isSetDescription();
		}

		public StringOrRef getDescription() {
			return feature.getDescription();
		}

		public boolean isSetMetaDataProperty() {
			return feature.isSetMetaDataProperty();
		}

		public List<MetaDataProperty> getMetaDataProperty() {
			return feature.getMetaDataProperty();
		}

		public boolean isSetBoundedBy() {
			return feature.isSetBoundedBy();
		}

		public BoundingShape getBoundedBy() {
			return feature.getBoundedBy();
		}

		public boolean isSetLocation() {
			return feature.isSetLocation();
		}

		public LocationProperty getLocation() {
			return feature.getLocation();
		}

		public boolean isSetAppearance() {
			if (feature instanceof AbstractCityObject)
				return ((AbstractCityObject)feature).isSetAppearance();
			else if (feature instanceof CityModel)
				return ((CityModel)feature).isSetAppearanceMember();

			return false;
		}

		public List<? extends AppearanceProperty> getAppearance() {
			if (feature instanceof AbstractCityObject)
				return ((AbstractCityObject)feature).getAppearance();
			else if (feature instanceof CityModel)
				return ((CityModel)feature).getAppearanceMember();

			return null;
		}

		public CityGMLClass getCityGMLClass() {
			return (feature instanceof CityGML) ? ((CityGML)feature).getCityGMLClass() : CityGMLClass.UNDEFINED;
		}

		public boolean isSetParentInfo() {
			return getParentInfo() != null;
		}

		public ParentInfo getParentInfo() {
			return (parentChunk != null) ? parentChunk.unmarshalFeatureInfo() : null;
		}
	}
}
