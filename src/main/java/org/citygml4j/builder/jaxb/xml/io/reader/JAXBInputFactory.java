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

import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.builder.jaxb.CityGMLBuilderException;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.internal.xml.SystemIDResolver;
import org.citygml4j.util.internal.xml.TransformerChainFactory;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class JAXBInputFactory implements CityGMLInputFactory {
	final CityGMLBuilder builder;
	private SchemaHandler schemaHandler;
	private XMLInputFactory xmlInputFactory;
	private GMLIdManager gmlIdManager;
	private ValidationEventHandler validationEventHandler;
	private TransformerChainFactory transformerChainFactory;

	private FeatureReadMode featureReadMode;
	private List<QName> excludes;
	private List<QName> splitAtFeatureProperties;
	private boolean keepInlineAppearance;
	private boolean parseSchema;
	private boolean useValidation;
	private boolean failOnMissingADESchema;
	private boolean supportCityGML040;

	public JAXBInputFactory(CityGMLBuilder builder, SchemaHandler schemaHandler) {
		this.builder = builder;
		this.schemaHandler = schemaHandler;

		xmlInputFactory = XMLInputFactory.newInstance();
		xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.TRUE);

		gmlIdManager = DefaultGMLIdManager.getInstance();
		validationEventHandler = null;
		featureReadMode = FeatureReadMode.NO_SPLIT;
		excludes = new ArrayList<QName>();
		splitAtFeatureProperties = new ArrayList<QName>();
		keepInlineAppearance = true;
		parseSchema = true;
		useValidation = false;
		failOnMissingADESchema = true;
		supportCityGML040 = false;
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
		} catch (XMLStreamException | FileNotFoundException e) {
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
		} catch (XMLStreamException | FileNotFoundException e) {
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
	
	public XMLInputFactory getXMLInputFactory() {
		return xmlInputFactory;
	}

	public void setXMLInputFactory(XMLInputFactory xmlInputFactory) {
		if (xmlInputFactory == null)
			throw new IllegalArgumentException("xml input factory may not be null.");

		this.xmlInputFactory = xmlInputFactory;
	}

	public GMLIdManager getGMLIdManager() {
		return gmlIdManager;
	}

	public void setGMLIdManager(GMLIdManager gmlIdManager) {
		if (gmlIdManager == null)
			throw new IllegalArgumentException("gml:id manager may not be null.");

		this.gmlIdManager = gmlIdManager;
	}

	public SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}

	public void setSchemaHandler(SchemaHandler schemaHandler) {
		if (schemaHandler == null)
			throw new IllegalArgumentException("schema handler may not be null.");

		this.schemaHandler = schemaHandler;
	}

	public ValidationEventHandler getValidationEventHandler() {
		return validationEventHandler;
	}

	public void setValidationEventHandler(ValidationEventHandler validationEventHandler) {
		if (validationEventHandler == null)
			throw new IllegalArgumentException("validation event handler may not be null.");

		this.validationEventHandler = validationEventHandler;
	}
	
	public void setTransformationTemplates(Templates... transformationTemplates) throws CityGMLWriteException {
		if (transformationTemplates == null)
			throw new IllegalArgumentException("transformation templates may not be null.");

		try {
			if (transformerChainFactory == null)
				transformerChainFactory = new TransformerChainFactory(transformationTemplates);
			else
				transformerChainFactory.updateTemplates(transformationTemplates);
		} catch (TransformerConfigurationException e) {
			throw new CityGMLWriteException("Caused by: ", e);
		}
	}

	public Templates[] getTransformationTemplates() {
		return transformerChainFactory == null ? null : transformerChainFactory.getTemplates();
	}

	public TransformerChainFactory getTransformerChainFactory() {
		return transformerChainFactory;
	}

	public Object getProperty(String name) {
		Objects.requireNonNull(name, "property name may not be null.");

		if (name.equals(CityGMLInputFactory.FEATURE_READ_MODE))
			return featureReadMode;
		if (name.equals(CityGMLInputFactory.KEEP_INLINE_APPEARANCE))
			return keepInlineAppearance;
		if (name.equals(CityGMLInputFactory.PARSE_SCHEMA))
			return parseSchema;
		if (name.equals(CityGMLInputFactory.USE_VALIDATION))
			return useValidation;
		if (name.equals(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING))
			return excludes;
		if (name.equals(CityGMLInputFactory.SPLIT_AT_FEATURE_PROPERTY))
			return splitAtFeatureProperties;
		if (name.equals(CityGMLInputFactory.FAIL_ON_MISSING_ADE_SCHEMA))
			return failOnMissingADESchema;
		if (name.equals(CityGMLInputFactory.SUPPORT_CITYGML_VERSION_0_4_0))
			return supportCityGML040;

		throw new IllegalArgumentException("the property '" + name + "' is not supported.");
	}

	public void setProperty(String name, Object value) {
		Objects.requireNonNull(name, "property name may not be null.");

		if (name.equals(CityGMLInputFactory.FEATURE_READ_MODE)) {
			FeatureReadMode mode = FeatureReadMode.fromValue(value.toString());
			if (mode != null)
				featureReadMode = mode;

			return;
		}

		if (name.equals(CityGMLInputFactory.KEEP_INLINE_APPEARANCE)) {
			if (value instanceof Boolean)
				keepInlineAppearance = (Boolean) value;

			return;		
		}

		if (name.equals(CityGMLInputFactory.PARSE_SCHEMA)) {
			if (value instanceof Boolean)
				parseSchema = (Boolean) value;

			return;		
		}
		
		if (name.equals(CityGMLInputFactory.USE_VALIDATION)) {
			if (value instanceof Boolean)
				useValidation = (Boolean) value;

			return;		
		}

		if (name.equals(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING)) {
			if (value instanceof QName){
				excludes.add((QName)value);
				return;
			} 

			else if (value instanceof Collection<?>) {
				for (Object o : (Collection<?>)value) {
					if (o instanceof QName)
						excludes.add((QName)o);
					else
						throw new IllegalArgumentException("exclude must be of type java.xml.namespace.QName.");
				}
				
				return;
			}

			else if (value instanceof Object[]) {
				for (Object o : (Object[])value) {
					if (o instanceof QName)
						excludes.add((QName)o);
					else
						throw new IllegalArgumentException("exclude must be of type java.xml.namespace.QName.");
				}
				
				return;
			}
		}
		
		if (name.equals(CityGMLInputFactory.SPLIT_AT_FEATURE_PROPERTY)) {
			if (value instanceof QName) {
				splitAtFeatureProperties.add((QName)value);
				return;
			}
			
			else if (value instanceof Collection<?>) {
				for (Object o : (Collection<?>)value) {
					if (o instanceof QName)
						splitAtFeatureProperties.add((QName)o);
					else
						throw new IllegalArgumentException("feature property must be specified using java.xml.namespace.QName.");
				}
				
				return;
			}

			else if (value instanceof Object[]) {
				for (Object o : (Object[])value) {
					if (o instanceof QName)
						splitAtFeatureProperties.add((QName)o);
					else
						throw new IllegalArgumentException("feature property must be specified using java.xml.namespace.QName.");
				}
				
				return;
			}
		}
		
		if (name.equals(CityGMLInputFactory.FAIL_ON_MISSING_ADE_SCHEMA)) {
			if (value instanceof Boolean)
				failOnMissingADESchema = (Boolean) value;

			return;		
		}
		
		if (name.equals(CityGMLInputFactory.SUPPORT_CITYGML_VERSION_0_4_0)) {
			if (value instanceof Boolean)
				supportCityGML040 = (Boolean) value;

			return;		
		}

		throw new IllegalArgumentException("the key-value pair '" + name + " - " + value.getClass().getName() + "' is not supported.");
	}

	public boolean registerSchemaLocation(String namespaceURI, File schemaLocation) {
		return schemaHandler.registerSchemaLocation(namespaceURI, schemaLocation);
	}

	public void parseSchema(File schemaLocation) throws SAXException {
		schemaHandler.parseSchema(schemaLocation);
	}

	public void parseSchema(String namespaceURI, String schemaLocation) throws SAXException {
		schemaHandler.parseSchema(namespaceURI, schemaLocation);	
	}

	public void parseSchema(Element element) throws SAXException {
		schemaHandler.parseSchema(element);
	}

	private URI toURI(String baseURI) {
		URI uri;

		try {
			uri = new URI(baseURI).normalize();
		} catch (Exception e) {
			uri = URI.create("");
		}

		return uri;
	}
	
}
