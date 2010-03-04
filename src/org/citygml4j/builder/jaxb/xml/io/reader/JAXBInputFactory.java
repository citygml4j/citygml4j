package org.citygml4j.builder.jaxb.xml.io.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;

import org.citygml4j.builder.jaxb.JAXBBuilder;
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
	
	public CityGMLReader createCityGMLReader(InputStream in, String encoding) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(in, encoding);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this);
			default:
				return new JAXBSimpleReader(streamReader, this);
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}
	
	public CityGMLReader createCityGMLReader(File file, String encoding) throws CityGMLReadException {
		try {
			return createCityGMLReader(new FileInputStream(file), encoding);
		} catch (FileNotFoundException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}
	
	public CityGMLReader createCityGMLReader(InputStream in) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(in);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this);
			default:
				return new JAXBSimpleReader(streamReader, this);
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}
	
	public CityGMLReader createCityGMLReader(File file) throws CityGMLReadException {
		try {
			return createCityGMLReader(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}

	public CityGMLReader createCityGMLReader(Reader reader) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(reader);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this);
			default:
				return new JAXBSimpleReader(streamReader, this);
			}	
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}

	public CityGMLReader createCityGMLReader(Source source) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(source);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this);
			default:
				return new JAXBSimpleReader(streamReader, this);
			}	
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}

	public CityGMLReader createCityGMLReader(String systemId, InputStream in) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(systemId, in);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this);
			default:
				return new JAXBSimpleReader(streamReader, this);
			}			
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}

	public CityGMLReader createCityGMLReader(String systemId, Reader reader) throws CityGMLReadException {
		try {
			XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(systemId, reader);

			switch (featureReadMode) {
			case SPLIT_PER_COLLECTION_MEMBER:
			case SPLIT_PER_FEATURE:
				return new JAXBChunkReader(streamReader, this);
			default:
				return new JAXBSimpleReader(streamReader, this);		
			} 
		} catch (XMLStreamException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}
}
