package org.citygml4j.xml.io;

import java.io.File;
import java.io.InputStream;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.stream.XMLInputFactory;

import org.citygml4j.commons.gmlid.GMLIdManager;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public interface CityGMLInputFactory {
	public static final String FEATURE_READ_MODE = "org.citygml4j.featureReadMode";
	public static final String KEEP_INLINE_APPEARANCE = "org.citygml4j.keepInlineAppearance";
	public static final String PARSE_SCHEMA = "org.citygml4j.parseSchema";
	public static final String EXCLUDE_FROM_SPLITTING = "org.citygml4j.excludeFromSplitting";
	public static final String USE_VALIDATION = "org.citygml4j.useValidation";
	
	public XMLInputFactory getXMLInputFactory();
	public GMLIdManager getGMLIdManager();
	public SchemaHandler getSchemaHandler();
	public ValidationEventHandler getValidationEventHandler();
	public Object getProperty(String name);
	public void setXMLInputFactory(XMLInputFactory xmlInputFactory);	
	public void setGMLIdManager(GMLIdManager gmlIdManager);
	public void setSchemaHandler(SchemaHandler schemaHandler);
	public void setValidationEventHandler(ValidationEventHandler validationEventHandler);
	public void setProperty(String name, Object value);
	
	public boolean registerSchemaLocation(String namespaceURI, File schemaLocation);
	public void parseSchema(File schemaLocation) throws SAXException;
	public void parseSchema(String namespaceURI, String schemaLocation) throws SAXException;
	public void parseSchema(Element element) throws SAXException;
	
	public CityGMLReader createCityGMLReader(File file) throws CityGMLReadException;	
	public CityGMLReader createCityGMLReader(File file, String encoding) throws CityGMLReadException;
	public CityGMLReader createCityGMLReader(String systemId, InputStream in) throws CityGMLReadException;	
	public CityGMLReader createCityGMLReader(String systemId, InputStream in, String encoding) throws CityGMLReadException;
}
