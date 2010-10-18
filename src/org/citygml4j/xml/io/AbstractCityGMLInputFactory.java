/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.xml.io;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.stream.XMLInputFactory;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public abstract class AbstractCityGMLInputFactory implements CityGMLInputFactory {
	protected SchemaHandler schemaHandler;
	protected XMLInputFactory xmlInputFactory;
	protected GMLIdManager gmlIdManager;
	protected ValidationEventHandler validationEventHandler;

	protected FeatureReadMode featureReadMode;
	protected Set<Class<? extends CityGML>> excludes;
	protected boolean keepInlineAppearance;
	protected boolean parseSchema;
	protected boolean useValidation;

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
		keepInlineAppearance = true;
		parseSchema = true;
		useValidation = false;
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
		
		return false;
	}
	
}
