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
package org.citygml4j.xml.io;

import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Templates;
import java.io.File;
import java.io.InputStream;

public interface CityGMLInputFactory {
	public static final String FEATURE_READ_MODE = "org.citygml4j.featureReadMode";
	public static final String KEEP_INLINE_APPEARANCE = "org.citygml4j.keepInlineAppearance";
	public static final String PARSE_SCHEMA = "org.citygml4j.parseSchema";
	public static final String SPLIT_AT_FEATURE_PROPERTY = "org.citygml4j.splitAtFeatureProperty";
	public static final String EXCLUDE_FROM_SPLITTING = "org.citygml4j.excludeFromSplitting";
	public static final String USE_VALIDATION = "org.citygml4j.useValidation";
	public static final String FAIL_ON_MISSING_ADE_SCHEMA = "org.citygml4j.failOnMissingADESchema";
	public static final String SUPPORT_CITYGML_VERSION_0_4_0 = "org.citygml4j.supportCityGML040";
	
	public XMLInputFactory getXMLInputFactory();
	public GMLIdManager getGMLIdManager();
	public SchemaHandler getSchemaHandler();
	public ValidationEventHandler getValidationEventHandler();
	public Templates[] getTransformationTemplates();
	public Object getProperty(String name);
	public void setXMLInputFactory(XMLInputFactory xmlInputFactory);	
	public void setGMLIdManager(GMLIdManager gmlIdManager);
	public void setSchemaHandler(SchemaHandler schemaHandler);
	public void setValidationEventHandler(ValidationEventHandler validationEventHandler);
	public void setTransformationTemplates(Templates... templates) throws CityGMLWriteException;
	public void setProperty(String name, Object value);
	
	public boolean registerSchemaLocation(String namespaceURI, File schemaLocation);
	public void parseSchema(File schemaLocation) throws SAXException;
	public void parseSchema(String namespaceURI, String schemaLocation) throws SAXException;
	public void parseSchema(Element element) throws SAXException;
	
	public CityGMLReader createCityGMLReader(File file) throws CityGMLReadException;	
	public CityGMLReader createCityGMLReader(File file, String encoding) throws CityGMLReadException;
	public CityGMLReader createCityGMLReader(String systemId, InputStream in) throws CityGMLReadException;	
	public CityGMLReader createCityGMLReader(String systemId, InputStream in, String encoding) throws CityGMLReadException;

	public CityGMLReader createFilteredCityGMLReader(CityGMLReader reader, CityGMLInputFilter filter);
}
