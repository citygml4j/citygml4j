/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2016 Claus Nagel <claus.nagel@gmail.com>
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
