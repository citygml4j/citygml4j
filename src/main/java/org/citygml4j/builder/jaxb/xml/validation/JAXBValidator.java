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
package org.citygml4j.builder.jaxb.xml.validation;

import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.common.base.ModelObject;
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

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.helpers.ValidationEventImpl;
import javax.xml.bind.helpers.ValidationEventLocatorImpl;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import java.io.IOException;

public class JAXBValidator implements Validator {
	private final CityGMLBuilder builder;
	private ValidationSchemaHandler validationSchemaHandler;
	private ValidationEventHandler validationEventHandler;

	public JAXBValidator(CityGMLBuilder builder, SchemaHandler schemaHandler) {
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

			if (object instanceof ADEGenericElement)
				object = ((ADEGenericElement)object).getContent();

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

			else if (object instanceof ModelObject) {
				JAXBMarshaller marshaller = builder.createJAXBMarshaller(moduleContext);
				Object jaxb = marshaller.marshalJAXBElement((ModelObject)object);

				if (jaxb != null) {
					try {
						Marshaller m = builder.getJAXBContext().createMarshaller();
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
