/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.xml.io;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.internal.xml.TransformerChainFactory;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.io.writer.FeatureWriteMode;
import org.citygml4j.xml.schema.SchemaHandler;

public abstract class AbstractCityGMLOutputFactory implements CityGMLOutputFactory {
	protected SchemaHandler schemaHandler;	
	protected ModuleContext moduleContext;
	protected GMLIdManager gmlIdManager;
	protected ValidationEventHandler validationEventHandler;
	protected TransformerChainFactory transformerChainFactory;

	protected FeatureWriteMode featureWriteMode;
	protected Set<Class<? extends CityGML>> excludes;
	protected boolean keepInlineAppearance;
	protected boolean splitCopy;
	protected boolean useValidation;

	public AbstractCityGMLOutputFactory(ModuleContext moduleContext, SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
		this.moduleContext = moduleContext;

		gmlIdManager = DefaultGMLIdManager.getInstance();
		featureWriteMode = FeatureWriteMode.NO_SPLIT;
		excludes = new HashSet<Class<? extends CityGML>>();
		keepInlineAppearance = true;
		splitCopy = true;
	}

	public AbstractCityGMLOutputFactory(ModuleContext moduleContext) {
		this(moduleContext, null);
	}

	public AbstractCityGMLOutputFactory(SchemaHandler schemaHandler) {
		this(new ModuleContext(), schemaHandler);
	}

	public AbstractCityGMLOutputFactory() {
		this(new ModuleContext(), null);
	}

	public ModuleContext getModuleContext() {
		return moduleContext;
	}

	public SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}

	public void setSchemaHandler(SchemaHandler schemaHandler) {
		if (schemaHandler == null)
			throw new IllegalArgumentException("schema handler may not be null.");

		this.schemaHandler = schemaHandler;
	}

	public void setModuleContext(ModuleContext moduleContext) {
		if (moduleContext == null)
			throw new IllegalArgumentException("module context may not be null.");

		this.moduleContext = moduleContext;
	}

	public void setCityGMLVersion(CityGMLVersion version) {
		if (version == null)
			throw new IllegalArgumentException("CityGML version may not be null.");

		moduleContext = new ModuleContext(version);
	}

	public GMLIdManager getGMLIdManager() {
		return gmlIdManager;
	}

	public void setGMLIdManager(GMLIdManager gmlIdManager) {
		if (gmlIdManager == null)
			throw new IllegalArgumentException("gml:id manager may not be null.");

		this.gmlIdManager = gmlIdManager;
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

		if (name.equals(CityGMLOutputFactory.FEATURE_WRITE_MODE))
			return featureWriteMode;
		if (name.equals(CityGMLOutputFactory.KEEP_INLINE_APPEARANCE))
			return keepInlineAppearance;
		if (name.equals(CityGMLOutputFactory.SPLIT_COPY))
			return splitCopy;
		if (name.equals(CityGMLOutputFactory.USE_VALIDATION))
			return useValidation;
		if (name.equals(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING))
			return excludes;

		throw new IllegalArgumentException("the property '" + name + "' is not supported.");
	}

	@SuppressWarnings("unchecked")
	public void setProperty(String name, Object value) {
		if (name == null)
			throw new IllegalArgumentException("name may not be null.");

		if (name.equals(CityGMLOutputFactory.FEATURE_WRITE_MODE)) {
			FeatureWriteMode mode = FeatureWriteMode.fromValue(value.toString());
			if (mode != null)
				featureWriteMode = mode;

			return;
		}

		if (name.equals(CityGMLOutputFactory.KEEP_INLINE_APPEARANCE)) {
			if (value instanceof Boolean)
				keepInlineAppearance = ((Boolean)value).booleanValue();

			return;		
		}

		if (name.equals(CityGMLOutputFactory.SPLIT_COPY)) {
			if (value instanceof Boolean)
				splitCopy = ((Boolean)value).booleanValue();

			return;		
		}

		if (name.equals(CityGMLOutputFactory.USE_VALIDATION)) {
			if (value instanceof Boolean)
				useValidation = ((Boolean)value).booleanValue();

			return;		
		}

		if (name.equals(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING)) {
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
