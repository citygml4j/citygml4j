/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
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
 */
package org.citygml4j.builder.jaxb.xml.io.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.util.internal.xml.SystemIDResolver;
import org.citygml4j.xml.io.AbstractCityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.schema.SchemaHandler;

public class JAXBInputFactory extends AbstractCityGMLInputFactory {
	JAXBBuilder builder;

	public JAXBInputFactory(JAXBBuilder builder) throws CityGMLReadException {
		this.builder = builder;
	}

	public JAXBInputFactory(JAXBBuilder builder, SchemaHandler schemaHandler) {
		super(schemaHandler);
		this.builder = builder;
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
