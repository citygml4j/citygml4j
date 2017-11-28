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
package org.citygml4j.builder.jaxb.xml.io.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.CityGMLBuilderException;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.util.internal.xml.SystemIDResolver;
import org.citygml4j.xml.io.AbstractCityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.schema.SchemaHandler;

public class JAXBInputFactory extends AbstractCityGMLInputFactory {
	CityGMLBuilder builder;

	public JAXBInputFactory(CityGMLBuilder builder, SchemaHandler schemaHandler) {
		super(schemaHandler);
		this.builder = builder;
	}
	
	public JAXBInputFactory(CityGMLBuilder builder) throws CityGMLBuilderException {
		this(builder, builder.getDefaultSchemaHandler());
	}

	public CityGMLReader createCityGMLReader(String systemId, InputStream in) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(systemId, in);
			URI baseURI = toURI(systemId != null ? SystemIDResolver.getAbsoluteURI(systemId) : null);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, in, this, baseURI);
			default:
				return new JAXBSimpleReader(streamReader, in, this, baseURI);
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}

	public CityGMLReader createCityGMLReader(String systemId, InputStream in, String encoding) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(in, encoding);
			URI baseURI = toURI(systemId != null ? SystemIDResolver.getAbsoluteURI(systemId) : null);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, in, this, baseURI);
			default:
				return new JAXBSimpleReader(streamReader, in, this, baseURI);
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}

	public CityGMLReader createCityGMLReader(File file, String encoding) throws CityGMLReadException {
		try {
			FileInputStream in = new FileInputStream(file);
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(in, encoding);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, in, this, file.toURI().normalize());
			default:
				return new JAXBSimpleReader(streamReader, in, this, file.toURI().normalize());
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		} catch (FileNotFoundException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}

	public CityGMLReader createCityGMLReader(File file) throws CityGMLReadException {
		try {
			FileInputStream in = new FileInputStream(file);
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(in);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, in, this, file.toURI().normalize());
			default:
				return new JAXBSimpleReader(streamReader, in, this, file.toURI().normalize());
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		} catch (FileNotFoundException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}

	public CityGMLReader createFilteredCityGMLReader(CityGMLReader reader, CityGMLInputFilter filter) {
		if (reader instanceof AbstractJAXBReader)
			((AbstractJAXBReader)reader).filter = filter;
		else
			throw new IllegalArgumentException("CityGML reader must be a JAXB based reader.");

		return reader;
	}

	private URI toURI(String baseURI) {
		URI uri = null;

		try {
			uri = new URI(baseURI).normalize();
		} catch (Exception e) {
			uri = URI.create("");
		}

		return uri;
	}
}
