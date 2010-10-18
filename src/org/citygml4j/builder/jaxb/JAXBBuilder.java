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
package org.citygml4j.builder.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.builder.jaxb.marshal.JAXBNamespacePrefixMapper;
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.builder.jaxb.xml.io.reader.JAXBInputFactory;
import org.citygml4j.builder.jaxb.xml.io.writer.JAXBOutputFactory;
import org.citygml4j.builder.jaxb.xml.validation.JAXBValidator;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.CityGMLValidateException;
import org.citygml4j.xml.validation.Validator;
import org.xml.sax.SAXException;

public class JAXBBuilder implements CityGMLBuilder {
	private final JAXBContext context;
	
	public JAXBBuilder() throws JAXBException {
		this(Thread.currentThread().getContextClassLoader());
	}
	
	public JAXBBuilder(ClassLoader classLoader) throws JAXBException {
		context = JAXBContext.newInstance(JAXBContextPath.getContextPath(), classLoader);
	}

	public JAXBContext getJAXBContext() {
		return context;
	}
	
	public JAXBUnmarshaller createJAXBUnmarshaller(SchemaHandler schemaHandler) {
		return new JAXBUnmarshaller(this, schemaHandler);
	}
	
	public JAXBUnmarshaller createJAXBUnmarshaller() throws SAXException {
		return createJAXBUnmarshaller(SchemaHandler.newInstance());
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

	public JAXBNamespacePrefixMapper createNamespacePrefixMapper() {
		return new JAXBNamespacePrefixMapper();
	}
	
	public CityGMLInputFactory createCityGMLInputFactory() throws CityGMLReadException {
		return new JAXBInputFactory(this);
	}
	
	public CityGMLInputFactory createCityGMLInputFactory(SchemaHandler schemaHandler) {
		return new JAXBInputFactory(this, schemaHandler);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory() throws CityGMLReadException {
		return new JAXBOutputFactory(this);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext) throws CityGMLReadException {
		return new JAXBOutputFactory(this, moduleContext);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(ModuleContext moduleContext, SchemaHandler schemaHandler) {
		return new JAXBOutputFactory(this, moduleContext, schemaHandler);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version) throws CityGMLReadException {
		return new JAXBOutputFactory(this, new ModuleContext(version));
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(CityGMLVersion version, SchemaHandler schemaHandler) {
		return new JAXBOutputFactory(this, new ModuleContext(version), schemaHandler);
	}
	
	public CityGMLOutputFactory createCityGMLOutputFactory(SchemaHandler schemaHandler) {
		return new JAXBOutputFactory(this, schemaHandler);
	}
	
	public Validator createValidator() throws CityGMLValidateException {
		return new JAXBValidator(this);
	}
	
	public Validator createValidator(SchemaHandler schemaHandler) {
		return new JAXBValidator(this, schemaHandler);
	}
	
}
