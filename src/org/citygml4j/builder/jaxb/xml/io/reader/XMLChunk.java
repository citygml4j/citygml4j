package org.citygml4j.builder.jaxb.xml.io.reader;

import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.EndElement;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.SAXEvent;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.SAXEvent.EventType;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartElement;
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
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.LocatorImpl;

public class XMLChunk {
	private final JAXBChunkReader chunkReader;
	private final XMLChunk parentChunk;	
	private final SAXEventBuffer buffer;
	private final StAXStream2SAX stax2sax;	

	private CityGML citygml;
	private ParentInfo featureInfo;	
	private AtomicBoolean parentInfoResolved = new AtomicBoolean(false);
	private AtomicBoolean citygmlResolved = new AtomicBoolean(false);

	private int depth = 0;

	XMLChunk(JAXBChunkReader chunkReader, XMLChunk parentChunk) {
		this.chunkReader = chunkReader;
		this.parentChunk = parentChunk;

		buffer = new SAXEventBuffer(chunkReader.useValidation);
		stax2sax = new StAXStream2SAX(buffer);
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

	public void append(XMLChunk other) {
		buffer.append(other.buffer);
	}

	public ParentInfo unmarshalFeatureInfo() {
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
							isParentInfoElement = chunkReader.util.isParentInfoElement(
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

			} catch (JAXBException e) {
				//
			} catch (SAXException e) {
				//
			} catch (MissingADESchemaException e) {
				//
			}

		}

		return featureInfo;
	}

	public CityGML unmarshal() throws JAXBException, SAXException, MissingADESchemaException {
		if (!buffer.isEmpty() && citygmlResolved.compareAndSet(false, true))
			citygml = unmarshal(buffer, chunkReader.useValidation);

		return citygml;
	}	

	private CityGML unmarshal(SAXEventBuffer buffer, boolean useValidation) throws JAXBException, SAXException, MissingADESchemaException {
		CityGML citygml = null;
		QName fakeRoot = getFakeRoot();

		Unmarshaller unmarshaller = chunkReader.factory.builder.getJAXBContext().createUnmarshaller();
		if (useValidation) {
			unmarshaller.setSchema(chunkReader.validationSchemaHandler.getSchema());			
			if (chunkReader.validationEventHandler != null)
				unmarshaller.setEventHandler(chunkReader.validationEventHandler);
		}

		UnmarshallerHandler handler = unmarshaller.getUnmarshallerHandler();
		LocatorImpl locator = new LocatorImpl();
		handler.setDocumentLocator(locator);

		// emulate start of a new document
		emulateStartDocument(handler, fakeRoot);

		// fire buffered sax events to unmarshaller
		SAXEvent event = buffer.getFirstEvent();
		do {
			event.send(handler, locator);
			buffer.removeFirstEvent();
		} while ((event = event.next()) != null);

		// emulate end of a document
		emulateEndDocument(handler, fakeRoot);

		// unmarshal sax events
		Object result = handler.getResult();

		// release memory
		unmarshaller = null;
		handler = null;

		if (result instanceof JAXBElement<?>) {			
			ModelObject gml = chunkReader.jaxbUnmarshaller.unmarshal((JAXBElement<?>)result);

			if (gml.getModelType() == ModelType.CITYGML) {
				if (gml instanceof AbstractFeature)
					citygml = (CityGML)gml;
				else if (gml instanceof AppearanceProperty)
					citygml = ((AppearanceProperty)gml).getAppearance();
			} else if (gml instanceof FeatureProperty<?>)
				citygml = ((FeatureProperty<?>)gml).getGenericADEComponent();
		}

		return citygml;
	}

	@SuppressWarnings("unchecked")
	private void emulateStartDocument(UnmarshallerHandler handler, QName fakeRoot) throws SAXException {
		// fire sax events to emulate the start of a new document
		handler.startDocument();

		Enumeration<String> prefixes = buffer.namespaces.getPrefixes();
		while (prefixes.hasMoreElements()) {
			String prefix = prefixes.nextElement();
			String uri = buffer.namespaces.getURI(prefix);

			handler.startPrefixMapping(prefix, uri);
		}

		String defaultURI = buffer.namespaces.getURI("");
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
		Enumeration<String> prefixes = buffer.namespaces.getPrefixes();
		while (prefixes.hasMoreElements()) 
			handler.endPrefixMapping(prefixes.nextElement());

		if (buffer.namespaces.getURI("") != null)
			handler.endPrefixMapping("");

		handler.endDocument();
	}

	private QName getFakeRoot() {
		StartElement root = getFirstStartElement();

		if (root.getLocalName().equals("Appearance") && 
				chunkReader.util.isCityGMLElement(root.getURI()))
			return new QName(root.getURI(), "appearanceMember");
		else if (!chunkReader.util.isCityGMLElement(root.getURI())) 
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