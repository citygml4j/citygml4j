package org.citygml4j.builder.jaxb.xml.io.reader;

import java.util.Enumeration;
import java.util.Iterator;
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
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartElement;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.Code;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.LocationProperty;
import org.citygml4j.model.gml.MetaDataProperty;
import org.citygml4j.model.gml.StringOrRef;
import org.citygml4j.model.module.gml.GMLCoreModule;
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
	private AtomicBoolean infoResolved = new AtomicBoolean(false);
	private AtomicBoolean citygmlResolved = new AtomicBoolean(false);
	
	int depth = 0;

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
		for (SAXEvent event : buffer.saxEvents)
			if (event instanceof StartElement)
				return (StartElement)event;

		return null;
	}

	public boolean replaceFirstStartElement(StartElement newFirst) {
		for (int i = 0; i < buffer.saxEvents.size(); i++) {
			SAXEvent event = buffer.saxEvents.get(i);
			if (event instanceof StartElement) {				
				if (buffer.trackLocation)
					newFirst.setLocation(((StartElement)event).getLocation());
				
				buffer.saxEvents.set(i, newFirst);
				return true;
			}
		}

		return false;
	}

	public StartElement getLastStartElement() {
		for (int i = buffer.saxEvents.size() - 1; i >= 0; i--) {
			SAXEvent event = buffer.saxEvents.get(i);
			if (event instanceof StartElement)
				return (StartElement)event;
		}

		return null;
	}

	public boolean replaceLastStartElement(StartElement newLast) {
		for (int i = buffer.saxEvents.size() - 1; i >= 0; i--) {
			SAXEvent event = buffer.saxEvents.get(i);
			if (event instanceof StartElement) {				
				if (buffer.trackLocation)
					newLast.setLocation(((StartElement)event).getLocation());
				
				buffer.saxEvents.set(i, newLast);
				return true;
			}
		}

		return false;
	}

	public StartElement getParentStartElement() {
		int depth = 1;

		for (int i = buffer.saxEvents.size() - 1; i >= 0; i--) {
			SAXEvent event = buffer.saxEvents.get(i);

			if (event instanceof StartElement && --depth == 0)
				return (StartElement)event;

			if (event instanceof EndElement)
				++depth;
		}

		return null;
	}

	public void append(XMLChunk other) {
		buffer.append(other.buffer);
	}

	public ParentInfo unmarshalFeatureInfo() {
		if (!buffer.isEmpty() && infoResolved.compareAndSet(false, true)) {
			try {
				SAXEventBuffer tmp = new SAXEventBuffer();
				StartElement root = null;

				Iterator<SAXEvent> iter = buffer.iterator();
				boolean isInited = false;

				while (iter.hasNext()) {
					SAXEvent event = iter.next();

					if (!isInited) {
						tmp.addEvent(event);
						if (event instanceof StartElement) {
							root = (StartElement)event;
							isInited = true;
						}

						continue;
					}

					if (event instanceof StartElement) {
						StartElement startElement = (StartElement)event;

						if (!chunkReader.util.isGMLElement(startElement.getURI()))
							break;
						else if (chunkReader.util.isFeatureInfo(startElement.getURI(), startElement.getLocalName())) {
							tmp.addEvent(event);
							while (iter.hasNext()) {
								event = iter.next();
								tmp.addEvent(event);

								if (event instanceof EndElement) {
									EndElement endElement = (EndElement)event;
									if (endElement.getURI().equals(startElement.getURI()) &&
											endElement.getLocalName().equals(startElement.getLocalName()))
										break;
								}
							}
						}

					} else if (event instanceof EndElement) {
						EndElement endElement = (EndElement)event;

						if (chunkReader.util.isCityGMLElement(endElement.getURI()))
							break;

						if (endElement.getURI().equals(root.getURI()) &&
								endElement.getLocalName().equals(root.getLocalName()))
							break;
					}
				}

				if (root != null) {
					tmp.addEvent(new EndElement(
							root.getURI(), 
							root.getLocalName(), 
							root.getQName(),
							null));

					CityGML citygml = unmarshal(tmp, false);
					if (citygml instanceof AbstractFeature)
						featureInfo = new FeatureInfoImpl((AbstractFeature)citygml);
				} 

			} catch (JAXBException e) {
				//
			} catch (SAXException e) {
				//
			}

		}

		return featureInfo;
	}

	public CityGML unmarshal() throws JAXBException, SAXException {
		if (!buffer.isEmpty() && citygmlResolved.compareAndSet(false, true))
			citygml = unmarshal(buffer, chunkReader.useValidation);

		return citygml;
	}	

	private CityGML unmarshal(SAXEventBuffer buffer, boolean useValidation) throws JAXBException, SAXException {
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
		for (SAXEvent event : buffer.saxEvents)
			event.send(handler, locator);

		// emulate end of a document
		emulateEndDocument(handler, fakeRoot);

		// unmarshal sax events
		Object result = handler.getResult();
		
		// release memory
		unmarshaller = null;
		handler = null;
		
		if (result instanceof JAXBElement<?>) {			
			Object gml = chunkReader.jaxbUnmarshaller.unmarshal((JAXBElement<?>)result);
			
			if (gml instanceof CityGML) {
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