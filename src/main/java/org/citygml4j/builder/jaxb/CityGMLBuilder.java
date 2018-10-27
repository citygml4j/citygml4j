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
package org.citygml4j.builder.jaxb;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.xml.io.reader.JAXBInputFactory;
import org.citygml4j.builder.jaxb.xml.io.writer.JAXBOutputFactory;
import org.citygml4j.builder.jaxb.xml.validation.JAXBValidator;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.Validator;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;

public class CityGMLBuilder {
	private final JAXBContext context;
	private SchemaHandler schemaHandler;

	protected CityGMLBuilder(JAXBContext context) {
		this.context = context;
	}

	public JAXBContext getJAXBContext() {
		return context;
	}
	
	public JAXBUnmarshaller createJAXBUnmarshaller(SchemaHandler schemaHandler) {
		return new JAXBUnmarshaller(this, schemaHandler);
	}

	public JAXBUnmarshaller createJAXBUnmarshaller() throws CityGMLBuilderException {
		return createJAXBUnmarshaller(getDefaultSchemaHandler());
	}

	public JAXBMarshaller createJAXBMarshaller(ModuleContext moduleContext) {
		return new JAXBMarshaller(this, moduleContext);
	}

	public JAXBMarshaller createJAXBMarshaller(CityGMLVersion version) {
		return new JAXBMarshaller(this, new ModuleContext(version));
	}

	public JAXBMarshaller createJAXBMarshaller() {
		return createJAXBMarshaller(new ModuleContext(CityGMLVersion.DEFAULT));
	}

	public CityGMLInputFactory createCityGMLInputFactory() throws CityGMLBuilderException {
		return new JAXBInputFactory(this);
	}

	public CityGMLInputFactory createCityGMLInputFactory(SchemaHandler schemaHandler) {
		return new JAXBInputFactory(this, schemaHandler);
	}

	public CityGMLOutputFactory createCityGMLOutputFactory() {
		return new JAXBOutputFactory(this);
	}

	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext) {
		return new JAXBOutputFactory(this, moduleContext);
	}

	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext, SchemaHandler schemaHandler) {
		return new JAXBOutputFactory(this, moduleContext, schemaHandler);
	}

	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version) {
		return new JAXBOutputFactory(this, new ModuleContext(version));
	}

	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version, SchemaHandler schemaHandler) {
		return new JAXBOutputFactory(this, new ModuleContext(version), schemaHandler);
	}

	public CityGMLOutputFactory createCityGMLOutputFactory(SchemaHandler schemaHandler) {
		return new JAXBOutputFactory(this, schemaHandler);
	}

	public Validator createValidator() throws CityGMLBuilderException {
		return new JAXBValidator(this, getDefaultSchemaHandler());
	}

	public Validator createValidator(SchemaHandler schemaHandler) {
		return new JAXBValidator(this, schemaHandler);
	}

	public synchronized SchemaHandler getDefaultSchemaHandler() throws CityGMLBuilderException {
		if (schemaHandler == null) {
			try {
				schemaHandler = SchemaHandler.newInstance();
			} catch (SAXException e) {
				throw new CityGMLBuilderException("Failed to build default schema handler.", e);
			}
		}

		return schemaHandler;
	}
}
