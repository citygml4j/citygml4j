package org.citygml4j.builder.jaxb.xml.io.reader;

import java.net.URI;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.xml.validation.ValidationSchemaHandler;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.SAXException;

public abstract class AbstractJAXBReader implements CityGMLReader {
	final XMLStreamReader reader;

	JAXBInputFactory factory;
	SchemaHandler schemaHandler;
	JAXBUnmarshaller jaxbUnmarshaller;
	XMLUtil util;
	
	boolean useValidation;
	ValidationSchemaHandler validationSchemaHandler;
	ValidationEventHandler validationEventHandler;
	
	boolean parseSchema;
	URI baseURI;
	
	public AbstractJAXBReader(XMLStreamReader reader, JAXBInputFactory factory, URI baseURI) throws CityGMLReadException {
		this.reader = reader;
		this.factory = factory;
		this.baseURI = baseURI;
		
		parseSchema = (Boolean)factory.getProperty(CityGMLInputFactory.PARSE_SCHEMA);
		useValidation = (Boolean)factory.getProperty(CityGMLInputFactory.USE_VALIDATION);

		util = XMLUtil.getInstance();
		schemaHandler = factory.getSchemaHandler();
		
		jaxbUnmarshaller = factory.builder.createJAXBUnmarshaller(schemaHandler);

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

			if (reader != null)
				reader.close();
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}
	
	void parseSchema(String schemaLocation) throws SAXException {
		String[] split = schemaLocation.trim().split("\\s+");
		if (split.length % 2 == 0)	
			for (int i = 0; i < split.length; i += 2)
				schemaHandler.parseSchema(split[i], baseURI.resolve(split[i+1]).toString());
	}

	public String getBaseURI() {
		return baseURI.toString();
	}
	
}
