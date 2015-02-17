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
package org.citygml4j.xml.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.internal.xml.TransformerChainFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public abstract class AbstractCityGMLInputFactory implements CityGMLInputFactory {
	protected SchemaHandler schemaHandler;
	protected XMLInputFactory xmlInputFactory;
	protected GMLIdManager gmlIdManager;
	protected ValidationEventHandler validationEventHandler;
	protected TransformerChainFactory transformerChainFactory;

	protected FeatureReadMode featureReadMode;
	protected Set<Class<? extends CityGML>> excludes;
	protected List<QName> splitAtFeatureProperties;
	protected boolean keepInlineAppearance;
	protected boolean parseSchema;
	protected boolean useValidation;
	protected boolean failOnMissingADESchema;
	protected boolean supportCityGML040;

	public AbstractCityGMLInputFactory() throws CityGMLReadException {
		try {
			schemaHandler = SchemaHandler.newInstance();
			init();
		} catch (SAXException e) {
			throw new CityGMLReadException("Caused by: ", e);
		}
	}

	public AbstractCityGMLInputFactory(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
		init();
	}

	private void init() {
		xmlInputFactory = XMLInputFactory.newInstance();
		xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.TRUE);

		gmlIdManager = DefaultGMLIdManager.getInstance();
		validationEventHandler = null;
		featureReadMode = FeatureReadMode.NO_SPLIT;
		excludes = new HashSet<Class<? extends CityGML>>();
		splitAtFeatureProperties = new ArrayList<QName>();
		keepInlineAppearance = true;
		parseSchema = true;
		useValidation = false;
		failOnMissingADESchema = true;
		supportCityGML040 = false;
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
		if (name == null)
			throw new IllegalArgumentException("name may not be null.");

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

	@SuppressWarnings("unchecked")
	public void setProperty(String name, Object value) {
		if (name == null)
			throw new IllegalArgumentException("name may not be null.");

		if (name.equals(CityGMLInputFactory.FEATURE_READ_MODE)) {
			FeatureReadMode mode = FeatureReadMode.fromValue(value.toString());
			if (mode != null)
				featureReadMode = mode;

			return;
		}

		if (name.equals(CityGMLInputFactory.KEEP_INLINE_APPEARANCE)) {
			if (value instanceof Boolean)
				keepInlineAppearance = ((Boolean)value).booleanValue();

			return;		
		}

		if (name.equals(CityGMLInputFactory.PARSE_SCHEMA)) {
			if (value instanceof Boolean)
				parseSchema = ((Boolean)value).booleanValue();

			return;		
		}
		
		if (name.equals(CityGMLInputFactory.USE_VALIDATION)) {
			if (value instanceof Boolean)
				useValidation = ((Boolean)value).booleanValue();

			return;		
		}

		if (name.equals(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING)) {
			if (value instanceof Class<?>) {
				if (isSubclassOfCityGML((Class<?>)value))
					excludes.add((Class<? extends CityGML>)value);
				else
					throw new IllegalArgumentException("exclude must be of type Class<? extends CityGML>.");
				
				return;
			}

			else if (value instanceof Collection<?>) {
				for (Object o : (Collection<?>)value) {
					if (isSubclassOfCityGML((Class<?>)o))
						excludes.add((Class<? extends CityGML>)o);
					else
						throw new IllegalArgumentException("exclude must be of type Class<? extends CityGML>.");
				}
				
				return;
			}

			else if (value instanceof Class<?>[]) {
				for (Object o : (Class<?>[])value) {
					if (isSubclassOfCityGML((Class<?>)o))
						excludes.add((Class<? extends CityGML>)o);
					else
						throw new IllegalArgumentException("exclude must be of type Class<? extends CityGML>.");
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
			
			else if (value instanceof Class<?>[]) {
				for (Object o : (Class<?>[])value) {
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
				failOnMissingADESchema = ((Boolean)value).booleanValue();

			return;		
		}
		
		if (name.equals(CityGMLInputFactory.SUPPORT_CITYGML_VERSION_0_4_0)) {
			if (value instanceof Boolean)
				supportCityGML040 = ((Boolean)value).booleanValue();

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

	private boolean isSubclassOfCityGML(Class<?> a) {
		if (a == null)
			return false;
		
		if (a == CityGML.class)
			return true;
		
		for (Class<?> tmp : a.getInterfaces())
			if (isSubclassOfCityGML(tmp))
				return true;
		
		if (a.getSuperclass() != Object.class)
			return isSubclassOfCityGML(a.getSuperclass());
		
		return false;
	}
	
}
