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

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.xml.validation.ValidationSchemaHandler;
import org.citygml4j.util.internal.xml.TransformerChainFactory;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.SAXException;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

public abstract class AbstractJAXBReader {
	final XMLStreamReader reader;
	final InputStream in;

	JAXBInputFactory factory;
	SchemaHandler schemaHandler;
	JAXBUnmarshaller jaxbUnmarshaller;
	XMLElementChecker elementChecker;
	TransformerChainFactory transformerChainFactory;

	boolean useValidation;
	boolean failOnMissingADESchema;
	ValidationSchemaHandler validationSchemaHandler;
	ValidationEventHandler validationEventHandler;
	CityGMLInputFilter filter;

	boolean parseSchema;
	URI baseURI;

	@SuppressWarnings("unchecked")
	public AbstractJAXBReader(XMLStreamReader reader, InputStream in, JAXBInputFactory factory, URI baseURI) throws CityGMLReadException {		
		if ((Boolean)factory.getProperty(CityGMLInputFactory.SUPPORT_CITYGML_VERSION_0_4_0))
			reader = new CityGMLNamespaceMapper(reader);

		this.reader = reader;
		this.in = in;
		this.factory = factory;
		this.baseURI = baseURI;

		transformerChainFactory = factory.getTransformerChainFactory();
		parseSchema = (Boolean)factory.getProperty(CityGMLInputFactory.PARSE_SCHEMA);
		useValidation = (Boolean)factory.getProperty(CityGMLInputFactory.USE_VALIDATION);
		failOnMissingADESchema = (Boolean)factory.getProperty(CityGMLInputFactory.FAIL_ON_MISSING_ADE_SCHEMA);

		schemaHandler = factory.getSchemaHandler();
		jaxbUnmarshaller = factory.builder.createJAXBUnmarshaller(schemaHandler);
		jaxbUnmarshaller.setThrowMissingADESchema(failOnMissingADESchema);

		elementChecker = new XMLElementChecker(schemaHandler, 
				(FeatureReadMode)factory.getProperty(CityGMLInputFactory.FEATURE_READ_MODE),
				(Boolean)factory.getProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE),
				parseSchema,
				failOnMissingADESchema,
				(List<QName>)factory.getProperty(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING),
				(List<QName>)factory.getProperty(CityGMLInputFactory.SPLIT_AT_FEATURE_PROPERTY));

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
			elementChecker = null;	

			validationSchemaHandler = null;
			validationEventHandler = null;	
			filter = null;

			if (reader != null) {
				reader.close();
				in.close();
			}
		} catch (XMLStreamException | IOException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}
	
	public boolean isFilteredReader() {
		return filter != null;
	}

	public String getBaseURI() {
		return baseURI.toString();
	}
	
	void parseSchema(String schemaLocation) throws SAXException {
		String[] split = schemaLocation.trim().split("\\s+");
		if (split.length % 2 == 0)	
			for (int i = 0; i < split.length; i += 2)
				schemaHandler.parseSchema(split[i], baseURI.resolve(split[i+1]).toString());
	}

}
