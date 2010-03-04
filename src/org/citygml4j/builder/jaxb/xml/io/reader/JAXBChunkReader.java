package org.citygml4j.builder.jaxb.xml.io.reader;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

import javax.xml.bind.JAXBException;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.xml.io.reader.XMLElementChecker.ElementInfo;
import org.citygml4j.builder.jaxb.xml.io.reader.saxevents.StartElement;
import org.citygml4j.builder.jaxb.xml.validation.ValidationSchemaHandler;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class JAXBChunkReader implements CityGMLReader {
	private final XMLStreamReader reader;

	JAXBInputFactory factory;
	SchemaHandler schemaHandler;
	JAXBUnmarshaller jaxbUnmarshaller;
	XMLUtil util;

	boolean useValidation;
	ValidationSchemaHandler validationSchemaHandler;
	ValidationEventHandler validationEventHandler;

	private CityGML tmp;
	private Stack<XMLChunk> chunks;
	private XMLChunk chunk;

	private XMLElementChecker elementChecker;
	private ElementInfo elementInfo;
	private Stack<ElementInfo> elementInfos;

	private boolean isInited = false;
	private boolean setXLink = false;
	private boolean parseSchema;

	@SuppressWarnings("unchecked")
	public JAXBChunkReader(XMLStreamReader reader, JAXBInputFactory factory) throws CityGMLReadException {
		this.reader = reader;
		this.factory = factory;

		schemaHandler = factory.getSchemaHandler();
		parseSchema = (Boolean)factory.getProperty(CityGMLInputFactory.PARSE_SCHEMA);
		useValidation = (Boolean)factory.getProperty(CityGMLInputFactory.USE_VALIDATION);

		jaxbUnmarshaller = factory.builder.createJAXBUnmarshaller(schemaHandler);
		jaxbUnmarshaller.setParseSchema(false);

		chunks = new Stack<XMLChunk>();
		util = XMLUtil.getInstance();
		elementInfos = new Stack<ElementInfo>();
		elementChecker = new XMLElementChecker(schemaHandler, 
				(FeatureReadMode)factory.getProperty(CityGMLInputFactory.FEATURE_READ_MODE),
				(Boolean)factory.getProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE),
				(Set<Class<? extends CityGML>>)factory.getProperty(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING));

		if (useValidation) {
			validationSchemaHandler = new ValidationSchemaHandler(schemaHandler);
			validationEventHandler = factory.getValidationEventHandler();
		}
	}

	public void close() throws CityGMLReadException {
		try {
			factory = null;
			schemaHandler = null;
			jaxbUnmarshaller = null;
			util = null;	

			validationSchemaHandler = null;
			validationEventHandler = null;	
			
			elementChecker = null;
			elementInfos.clear();
			elementInfo = null;

			tmp = null;
			chunks.clear();
			chunk = null;

			isInited = false;
			setXLink = false;

			if (reader != null)
				reader.close();
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
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
								schemaHandler.parseSchema(reader.getAttributeValue(i));					
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
			}
		}

		if (next == null)
			throw new NoSuchElementException();
		else {
			tmp = null;
			return next;
		}
	}	

	private CityGML unmarshalChunk() throws JAXBException, SAXException {
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
			XMLChunk previous = chunks.peek();
			StartElement propertyElement = previous.getLastStartElement();
			if (propertyElement == null)
				return;			

			StartElement feature = chunk.getFirstStartElement();
			String gmlId = null;	

			Attributes featureAtts = feature.getAtts();
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

				chunk.replaceFirstStartElement(new StartElement(
						feature.getURI(), 
						feature.getLocalName(), 
						feature.getQName(), 
						atts, 
						null));
			}

			Attributes featurePropertyAtts = propertyElement.getAtts();
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
			previous.replaceLastStartElement(new StartElement(
					propertyElement.getURI(), 
					propertyElement.getLocalName(), 
					propertyElement.getQName(), 
					atts, 
					null));
		}		
	}

	public boolean isSetParentInfo() {
		return getParentInfo() != null;
	}

	public ParentInfo getParentInfo() {
		return chunk != null ? chunk.unmarshalFeatureInfo() : null;
	}

}
