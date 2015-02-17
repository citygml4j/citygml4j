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
package org.citygml4j.model.module.citygml;

import java.util.HashMap;
import java.util.HashSet;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.module.AbstractModule;
import org.citygml4j.model.module.Module;

public abstract class AbstractCityGMLModule extends AbstractModule implements CityGMLModule {
	HashMap<String, Class<? extends CityGML>> elementMap;
	HashSet<String> propertySet;
	
	public AbstractCityGMLModule (
			CityGMLModuleType type, 
			CityGMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);
	}
	
	@Override
	public CityGMLModuleType getType() {
		return (CityGMLModuleType)super.getType();
	}

	@Override
	public CityGMLModuleVersion getVersion() {
		return (CityGMLModuleVersion)super.getVersion();
	}

	public boolean hasFeatureElement(String localName) {
		return elementMap != null ? elementMap.containsKey(localName) : false;
	}

	public boolean hasFeaturePropertyElement(String localName) {
		return propertySet != null ? propertySet.contains(localName) : false;
	}

	public Class<? extends CityGML> getFeatureElementClass(String elementName) {
		return elementMap != null ? elementMap.get(elementName) : null;
	}

}
