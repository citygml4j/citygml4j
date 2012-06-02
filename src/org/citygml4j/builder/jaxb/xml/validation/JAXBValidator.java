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
package org.citygml4j.builder.jaxb.xml.validation;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.helpers.ValidationEventImpl;
import javax.xml.bind.helpers.ValidationEventLocatorImpl;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;

import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.JAXBNamespacePrefixMapper;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.CityGMLValidateException;
import org.citygml4j.xml.validation.Validator;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class JAXBValidator implements Validator {
	private final JAXBBuilder builder;
	private ValidationSchemaHandler validationSchemaHandler;
	private ValidationEventHandler validationEventHandler;

	public JAXBValidator(JAXBBuilder builder) throws CityGMLValidateException {
		this.builder = builder;

		try {
			validationSchemaHandler = new ValidationSchemaHandler(SchemaHandler.newInstance());
		} catch (SAXException e) {
			throw new CityGMLValidateException("Caused by: ", e);
		}		
	}

	public JAXBValidator(JAXBBuilder builder, SchemaHandler schemaHandler) {
		this.builder = builder;
		validationSchemaHandler = new ValidationSchemaHandler(schemaHandler);
	}

	public SchemaHandler getSchemaHandler() {
		return validationSchemaHandler.getSchemaHandler();
	}

	public ValidationEventHandler getValidationEventHandler() {
		return validationEventHandler;
	}

	public void setSchemaHandler(SchemaHandler schemaHandler) {
		if (schemaHandler == null)
			throw new IllegalArgumentException("schema handler may not be null.");

		validationSchemaHandler.setSchemaHandler(schemaHandler);
	}

	public void setValidationEventHandler(ValidationEventHandler validationEventHandler) {
		this.validationEventHandler = validationEventHandler;
	}

	public void validate(Object object, CityGMLVersion version) throws CityGMLValidateException {
		validate(object, new ModuleContext(version));
	}

	public void validate(Object object, ModuleContext moduleContext) throws CityGMLValidateException {
		try {
			Schema schema = validationSchemaHandler.getSchema();

			if (object instanceof ADEComponent)
				object = ((ADEComponent)object).getContent();

			if (object instanceof Element) {
				javax.xml.validation.Validator validator = schema.newValidator();
				if (validationEventHandler != null)
					validator.setErrorHandler(new ErrorHandler2ValidationEventHandler());

				try {
					validator.validate(new DOMSource((Element)object));
				} catch (IOException e) {
					throw new CityGMLValidateException("Caused by: ", e);
				}
			} 

			else {
				JAXBMarshaller marshaller = builder.createJAXBMarshaller(moduleContext);
				Object jaxb = marshaller.marshalJAXBElement(object);

				if (jaxb != null) {
					try {
						Marshaller m = builder.getJAXBContext().createMarshaller();
						m.setProperty("com.sun.xml.bind.namespacePrefixMapper", 
								new JAXBNamespacePrefixMapper(moduleContext));
						m.setSchema(schema);

						if (validationEventHandler != null)
							m.setEventHandler(validationEventHandler);

						m.marshal(jaxb, new DefaultHandler());				
					} catch (JAXBException e) {
						throw new CityGMLValidateException("Caused by: ", e);
					}
				} else 
					throw new CityGMLValidateException("failed to marshal citygml4j object to JAXB - validation aborted.");
			}

		} catch (SAXException e) {
			throw new CityGMLValidateException("Caused by: ", e);
		}
	}

	private final class ErrorHandler2ValidationEventHandler implements ErrorHandler {

		public void fatalError(SAXParseException exception) throws SAXException {
			handleValidationEvent(exception, ValidationEvent.FATAL_ERROR);
		}

		public void warning(SAXParseException exception) throws SAXException {
			handleValidationEvent(exception, ValidationEvent.WARNING);
		}

		public void error(SAXParseException exception) throws SAXException {
			handleValidationEvent(exception, ValidationEvent.ERROR);
		}

		private void handleValidationEvent(SAXParseException exception, int severity) throws SAXException {
			if (!validationEventHandler.handleEvent(
					new ValidationEventImpl(
							severity,
							exception.getMessage(),
							new ValidationEventLocatorImpl(),
							exception.getCause())))
				throw exception;
		}

	}

}
