/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
package org.citygml4j.builder.jaxb.xml.io.reader;

import java.net.URI;
import java.util.List;
import java.util.Set;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.xml.validation.ValidationSchemaHandler;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.SAXException;

public abstract class AbstractJAXBReader implements CityGMLReader {
	final XMLStreamReader reader;

	JAXBInputFactory factory;
	SchemaHandler schemaHandler;
	JAXBUnmarshaller jaxbUnmarshaller;
	XMLElementChecker elementChecker;

	boolean useValidation;
	boolean failOnMissingADESchema;
	ValidationSchemaHandler validationSchemaHandler;
	ValidationEventHandler validationEventHandler;
	CityGMLInputFilter filter;

	boolean parseSchema;
	URI baseURI;

	@SuppressWarnings("unchecked")
	public AbstractJAXBReader(XMLStreamReader reader, JAXBInputFactory factory, URI baseURI) throws CityGMLReadException {
		this.reader = reader;
		this.factory = factory;
		this.baseURI = baseURI;

		parseSchema = (Boolean)factory.getProperty(CityGMLInputFactory.PARSE_SCHEMA);
		useValidation = (Boolean)factory.getProperty(CityGMLInputFactory.USE_VALIDATION);

		schemaHandler = factory.getSchemaHandler();
		jaxbUnmarshaller = factory.builder.createJAXBUnmarshaller(schemaHandler);
		jaxbUnmarshaller.setThrowMissingADESchema((Boolean)factory.getProperty(CityGMLInputFactory.FAIL_ON_MISSING_ADE_SCHEMA));

		elementChecker = new XMLElementChecker(schemaHandler, 
				(FeatureReadMode)factory.getProperty(CityGMLInputFactory.FEATURE_READ_MODE),
				(Boolean)factory.getProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE),
				parseSchema,
				(Set<Class<? extends CityGML>>)factory.getProperty(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING),
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

			if (reader != null)
				reader.close();
		} catch (XMLStreamException e) {
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
