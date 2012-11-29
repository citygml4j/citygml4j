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
package org.citygml4j.builder.jaxb.xml.io.reader;

import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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

import org.citygml4j.builder.jaxb.xml.io.reader.XMLElementChecker.ElementInfo;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.feature.LocationProperty;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.util.xml.SAXEventBuffer;
import org.citygml4j.util.xml.StAXStream2SAX;
import org.citygml4j.util.xml.saxevents.EndElement;
import org.citygml4j.util.xml.saxevents.SAXEvent;
import org.citygml4j.util.xml.saxevents.SAXEvent.EventType;
import org.citygml4j.util.xml.saxevents.StartElement;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.citygml4j.xml.io.reader.UnmarshalException;
import org.citygml4j.xml.io.reader.XMLChunk;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.LocatorImpl;
import org.xml.sax.helpers.NamespaceSupport;

public class XMLChunkImpl implements XMLChunk {
	private final AbstractJAXBReader jaxbReader;
	private final XMLChunkImpl parentChunk;	
	private final SAXEventBuffer buffer;
	private final StAXStream2SAX stax2sax;	

	private CityGML citygml;
	private ParentInfo featureInfo;	
	private CityGMLClass type = CityGMLClass.UNDEFINED;
	private AtomicBoolean parentInfoResolved = new AtomicBoolean(false);
	private AtomicBoolean citygmlResolved = new AtomicBoolean(false);
	private AtomicBoolean typeResolved = new AtomicBoolean(false);

	private boolean isFiltered = false;
	private int depth = 0;
	private boolean hasPassedXMLValidation = false;

	XMLChunkImpl(AbstractJAXBReader chunkReader, XMLChunkImpl parentChunk, CityGMLClass type) {
		this.jaxbReader = chunkReader;
		this.parentChunk = parentChunk;

		buffer = new SAXEventBuffer(chunkReader.useValidation);
		stax2sax = new StAXStream2SAX(buffer);
		
		if (type != null && type != CityGMLClass.UNDEFINED) {
			this.type = type;
			typeResolved.set(true);
		}
	}

	boolean isFiltered() {
		return isFiltered;
	}

	void setIsFiltered(boolean isFiltered) {
		this.isFiltered = isFiltered;
	}

	public void addEvent(XMLStreamReader reader) throws XMLStreamException {
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

	public boolean isComplete() {
		return !buffer.isEmpty() && depth == 0;
	}

	public StartElement getFirstStartElement() {
		return buffer.getFirstStartElement();
	}

	public StartElement getLastStartElement() {
		return buffer.getLastStartElement();
	}

	public StartElement getParentStartElement() {
		return buffer.getParentStartElement();
	}

	public void append(XMLChunkImpl other) {
		buffer.append(other.buffer);
	}

	public boolean isSetParentInfo() {
		return getParentInfo() != null;
	} 

	public ParentInfo getParentInfo() {
		return parentChunk != null ? parentChunk.unmarshalFeatureInfo() : null;
	}

	public boolean hasPassedXMLValidation() {
		return hasPassedXMLValidation;
	}

	public CityGMLClass getCityGMLClass() {
		if (citygmlResolved.get())
			return citygml.getCityGMLClass();

		if (typeResolved.compareAndSet(false, true)) {
			QName name = new QName(buffer.getFirstStartElement().getURI(), buffer.getFirstStartElement().getLocalName());
			ElementInfo info = null;
			
			if (jaxbReader.elementChecker.isCityGMLElement(name))
				info = jaxbReader.elementChecker.getCityGMLFeature(name, true);
			else {
				try {
					info = jaxbReader.elementChecker.getADEElementInfo(name, null, true, true);
				} catch (MissingADESchemaException e) {
					//
				}
			}
			
			if (info != null)
				type = info.getType();
		}

		return type;
	}

	public void send(ContentHandler handler) throws SAXException {
		if (!citygmlResolved.get()) {
			SAXEvent event = buffer.getFirstEvent();
			do {
				event.send(handler);
			} while ((event = event.next()) != null); 
		} else
			throw new SAXException("Unmarshalled chunks cannot be forwarded to a ContentHandler.");
	}

	private ParentInfo unmarshalFeatureInfo() {
		if (!buffer.isEmpty() && parentInfoResolved.compareAndSet(false, true)) {
			try {
				SAXEventBuffer tmp = new SAXEventBuffer();
				SAXEvent event = buffer.getFirstStartElement();
				tmp.addEvent(event.shallowCopy());

				StartElement element = null;
				boolean isParentInfoElement = false;
				int depth = 0;

				while ((event = event.next()) != null) {					
					if (event.getType() == EventType.START_ELEMENT) {
						if (depth == 0) {
							element = (StartElement)event;
							isParentInfoElement = jaxbReader.elementChecker.isParentInfoElement(
									element.getURI(), 
									element.getLocalName());
						}

						depth++;
					}

					else if (event.getType() == EventType.END_ELEMENT)
						depth--;

					if (isParentInfoElement)
						tmp.addEvent(event.shallowCopy());					
				}

				// add EndElement in case we found an unclosed StartElement
				if (isParentInfoElement) {
					tmp.addEvent(new EndElement(
							element.getURI(), 
							element.getLocalName(),
							null,
							null));
				}

				// close root element
				element = tmp.getFirstStartElement();					
				tmp.addEvent(new EndElement(
						element.getURI(), 
						element.getLocalName(),
						null,
						null));

				CityGML citygml = unmarshal(tmp, false);
				if (citygml instanceof AbstractFeature)
					featureInfo = new FeatureInfoImpl((AbstractFeature)citygml);

			} catch (UnmarshalException e) {
				//
			} catch (MissingADESchemaException e) {
				//
			}

		}

		return featureInfo;
	}

	public CityGML unmarshal() throws UnmarshalException, MissingADESchemaException {
		if (!buffer.isEmpty() && citygmlResolved.compareAndSet(false, true))
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

			UnmarshallerHandler handler = unmarshaller.getUnmarshallerHandler();
			LocatorImpl locator = new LocatorImpl();
			handler.setDocumentLocator(locator);

			// emulate start of a new document
			emulateStartDocument(handler, fakeRoot);

			// fire buffered sax events to unmarshaller
			SAXEvent event = buffer.getFirstEvent();
			do {
				try {
					event.send(handler, locator);
					buffer.removeFirstEvent();
				} catch (SAXException e) {
					buffer.clear();
					throw e;
				}
			} while ((event = event.next()) != null);

			// emulate end of a document
			emulateEndDocument(handler, fakeRoot);

			// unmarshal sax events
			Object result = handler.getResult();

			// release memory
			unmarshaller = null;
			handler = null;

			if (result instanceof JAXBElement<?>) {
				ModelObject gml = jaxbReader.jaxbUnmarshaller.unmarshal((JAXBElement<?>)result);

				if (gml.getModelType() == ModelType.CITYGML) {
					if (gml instanceof AbstractFeature)
						citygml = (CityGML)gml;
					else if (gml instanceof AppearanceProperty)
						citygml = ((AppearanceProperty)gml).getAppearance();
				} else if (gml instanceof FeatureProperty<?>)
					citygml = ((FeatureProperty<?>)gml).getGenericADEComponent();
			}

			return citygml;
		} catch (JAXBException e) {
			throw new UnmarshalException("Unmarshal exception caused by: ", e);
		} catch (SAXException e) {
			throw new UnmarshalException("Unmarshal exception caused by: ", e);
		}
	}

	@SuppressWarnings("unchecked")
	private void emulateStartDocument(UnmarshallerHandler handler, QName fakeRoot) throws SAXException {
		// fire sax events to emulate the start of a new document
		handler.startDocument();

		NamespaceSupport ns = buffer.getNamespaceSupport();
		Enumeration<String> prefixes = ns.getPrefixes();
		while (prefixes.hasMoreElements()) {
			String prefix = prefixes.nextElement();
			String uri = ns.getURI(prefix);

			handler.startPrefixMapping(prefix, uri);
		}

		String defaultURI = ns.getURI("");
		if (defaultURI != null)
			handler.startPrefixMapping("", defaultURI);

		// surround buffer events by fake root element
		if (fakeRoot != null)
			handler.startElement(fakeRoot.getNamespaceURI(), 
					fakeRoot.getLocalPart(), 
					"", 
					new AttributesImpl());
	}

	@SuppressWarnings("unchecked")
	private void emulateEndDocument(UnmarshallerHandler handler, QName fakeRoot) throws SAXException {
		// terminate fake root element
		if (fakeRoot != null)
			handler.endElement(fakeRoot.getNamespaceURI(), 
					fakeRoot.getLocalPart(), 
					"");

		// emulate the end of a document
		NamespaceSupport ns = buffer.getNamespaceSupport();
		Enumeration<String> prefixes = ns.getPrefixes();
		while (prefixes.hasMoreElements()) 
			handler.endPrefixMapping(prefixes.nextElement());

		if (ns.getURI("") != null)
			handler.endPrefixMapping("");

		handler.endDocument();
	}

	private QName getFakeRoot() {
		StartElement root = getFirstStartElement();

		if (root.getLocalName().equals("Appearance") && 
				jaxbReader.elementChecker.isCityGMLElement(root.getURI()))
			return new QName(root.getURI(), "appearanceMember");
		else if (!jaxbReader.elementChecker.isCityGMLElement(root.getURI())) 
			return new QName(GMLCoreModule.v3_1_1.getNamespaceURI(), "featureProperty");

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
