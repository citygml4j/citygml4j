/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.jaxb.xml.io.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.transform.stream.StreamResult;

import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.util.xml.SAXWriter;
import org.citygml4j.xml.io.AbstractCityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.schema.SchemaHandler;

public class JAXBOutputFactory extends AbstractCityGMLOutputFactory {
	JAXBBuilder builder;
	
	public JAXBOutputFactory(JAXBBuilder builder) {
		super();
		this.builder = builder;
	}
	
	public JAXBOutputFactory(JAXBBuilder builder, ModuleContext moduleContext) {
		super(moduleContext);
		this.builder = builder;
	}
	
	public JAXBOutputFactory(JAXBBuilder builder, SchemaHandler schemaHandler) {
		super(schemaHandler);
		this.builder = builder;
	}
	
	public JAXBOutputFactory(JAXBBuilder builder, ModuleContext moduleContext, SchemaHandler schemaHandler) {
		super(moduleContext, schemaHandler);
		this.builder = builder;
	}
	
	public CityGMLWriter createCityGMLWriter(File file, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(new OutputStreamWriter(new FileOutputStream(file))), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(File file, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(new OutputStreamWriter(new FileOutputStream(file), encoding)), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(OutputStream outputStream, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(outputStream), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(OutputStream outputStream, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(outputStream, encoding), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(StreamResult streamResult, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(streamResult, encoding), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityGMLWriter createCityGMLWriter(Writer writer, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBSimpleWriter(
					new SAXWriter(writer), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}
	
	public CityGMLWriter createCityGMLWriter(File file, String encoding) throws CityGMLWriteException {
		return createCityGMLWriter(file, encoding, moduleContext);
	}

	public CityGMLWriter createCityGMLWriter(File file) throws CityGMLWriteException {
		return createCityGMLWriter(file, moduleContext);
	}
	
	public CityGMLWriter createCityGMLWriter(OutputStream outputStream, String encoding) throws CityGMLWriteException {
		return createCityGMLWriter(outputStream, encoding, moduleContext);
	}

	public CityGMLWriter createCityGMLWriter(OutputStream outputStream) throws CityGMLWriteException {
		return createCityGMLWriter(outputStream, moduleContext);
	}
	
	public CityGMLWriter createCityGMLWriter(StreamResult streamResult, String encoding) throws CityGMLWriteException {
		return createCityGMLWriter(streamResult, encoding, moduleContext);
	}
	
	public CityGMLWriter createCityGMLWriter(Writer writer) throws CityGMLWriteException {
		return createCityGMLWriter(writer, moduleContext);
	}

	public CityModelWriter createCityModelWriter(File file, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(new OutputStreamWriter(new FileOutputStream(file))), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(File file, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(new OutputStreamWriter(new FileOutputStream(file), encoding)), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(OutputStream outputStream, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(outputStream), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(OutputStream outputStream, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(outputStream, encoding), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(StreamResult streamResult, String encoding, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(streamResult, encoding), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public CityModelWriter createCityModelWriter(Writer writer, ModuleContext moduleContext) throws CityGMLWriteException {
		try {
			return new JAXBModelWriter(
					new SAXWriter(writer), 
					this, 
					moduleContext);
		} catch (FileNotFoundException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		} catch (IOException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}
	
	public CityModelWriter createCityModelWriter(File file, String encoding) throws CityGMLWriteException {
		return createCityModelWriter(file, encoding, moduleContext);
	}

	public CityModelWriter createCityModelWriter(File file) throws CityGMLWriteException {
		return createCityModelWriter(file, moduleContext);
	}
	
	public CityModelWriter createCityModelWriter(OutputStream outputStream, String encoding) throws CityGMLWriteException {
		return createCityModelWriter(outputStream, encoding, moduleContext);
	}

	public CityModelWriter createCityModelWriter(OutputStream outputStream) throws CityGMLWriteException {
		return createCityModelWriter(outputStream, moduleContext);
	}
	
	public CityModelWriter createCityModelWriter(StreamResult streamResult, String encoding) throws CityGMLWriteException {
		return createCityModelWriter(streamResult, encoding, moduleContext);
	}
	
	public CityModelWriter createCityModelWriter(Writer writer) throws CityGMLWriteException {
		return createCityModelWriter(writer, moduleContext);
	}
	
}
