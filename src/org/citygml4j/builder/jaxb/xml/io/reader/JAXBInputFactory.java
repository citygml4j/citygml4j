package org.citygml4j.builder.jaxb.xml.io.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.internal.util.xml.SystemIDResolver;
import org.citygml4j.xml.io.AbstractCityGMLInputFactory;
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
			URI baseURI = toURI(SystemIDResolver.getAbsoluteURI(systemId));
			
			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this, baseURI);
			default:
				return new JAXBSimpleReader(streamReader, this, baseURI);
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}
	
	public CityGMLReader createCityGMLReader(String systemId, InputStream in, String encoding) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(in, encoding);
			URI baseURI = toURI(SystemIDResolver.getAbsoluteURI(systemId));

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this, baseURI);
			default:
				return new JAXBSimpleReader(streamReader, this, baseURI);
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}
	
	public CityGMLReader createCityGMLReader(File file, String encoding) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(file), encoding);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this, file.toURI().normalize());
			default:
				return new JAXBSimpleReader(streamReader, this, file.toURI().normalize());
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		} catch (FileNotFoundException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}
	
	public CityGMLReader createCityGMLReader(File file) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(file));

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this, file.toURI().normalize());
			default:
				return new JAXBSimpleReader(streamReader, this, file.toURI().normalize());
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		} catch (FileNotFoundException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
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
