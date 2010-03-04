package org.citygml4j.builder.jaxb.xml.io.reader;

import java.util.NoSuchElementException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.xml.validation.ValidationSchemaHandler;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.SAXException;

public class JAXBSimpleReader implements CityGMLReader {
	private XMLStreamReader reader;	
	private JAXBInputFactory factory;	
	private SchemaHandler schemaHandler;
	private JAXBUnmarshaller jaxbUnmarshaller;
	private XMLUtil util;

	private CityGML tmp;
	private boolean parseSchema;

	private boolean useValidation;
	private ValidationSchemaHandler validationSchemaHandler;
	private ValidationEventHandler validationEventHandler;

	public JAXBSimpleReader(XMLStreamReader reader, JAXBInputFactory factory) throws CityGMLReadException {
		this.reader = reader;
		this.factory = factory;

		parseSchema = (Boolean)factory.getProperty(CityGMLInputFactory.PARSE_SCHEMA);
		util = XMLUtil.getInstance();

		schemaHandler = factory.getSchemaHandler();
		useValidation = (Boolean)factory.getProperty(CityGMLInputFactory.USE_VALIDATION);

		jaxbUnmarshaller = factory.builder.createJAXBUnmarshaller(schemaHandler);
		jaxbUnmarshaller.setParseSchema(parseSchema);

		if (useValidation) {
			validationSchemaHandler = new ValidationSchemaHandler(schemaHandler);
			validationEventHandler = factory.getValidationEventHandler();
		}
	}

	public void close() throws CityGMLReadException {
		try {
			schemaHandler = null;
			factory = null;
			jaxbUnmarshaller = null;
			util = null;
			tmp = null;

			validationSchemaHandler = null;
			validationEventHandler = null;	

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
					if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {

						// keep track of schema documents
						if (parseSchema) {
							for (int i = 0; i < reader.getAttributeCount(); i++) {
								if (reader.getAttributeLocalName(i).equals("schemaLocation"))
									schemaHandler.parseSchema(reader.getAttributeValue(i));
								else if (reader.getAttributeLocalName(i).equals("noNamespaceSchemaLocation"))
									schemaHandler.parseSchema("", reader.getAttributeValue(i));
							}
						}

						if (util.isCityGMLElement(reader.getName()) &&
								util.isCityGMLFeature(reader.getLocalName(), reader.getNamespaceURI())) {
							Unmarshaller unmarshaller = factory.builder.getJAXBContext().createUnmarshaller();

							// validate input
							if (useValidation) {
								unmarshaller.setSchema(validationSchemaHandler.getSchema());
								if (validationEventHandler != null)
									unmarshaller.setEventHandler(validationEventHandler);
							}							

							// unmarshal input
							Object result = unmarshaller.unmarshal(reader);

							// release memory
							unmarshaller = null;

							if (result instanceof JAXBElement<?>) {
								Object citygml = jaxbUnmarshaller.unmarshal((JAXBElement<?>)result);
								if (citygml instanceof CityGML && citygml instanceof AbstractFeature) {
									next = (CityGML)citygml;
									break;
								}
							}
						}
					}

					reader.next();
				}
			} catch (XMLStreamException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (JAXBException e) {
				throw new CityGMLReadException("Caused by: ", e);
			} catch (SAXException e) {
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

	public boolean isSetParentInfo() {
		return false;
	}

	public ParentInfo getParentInfo() {
		return null;
	}

}
