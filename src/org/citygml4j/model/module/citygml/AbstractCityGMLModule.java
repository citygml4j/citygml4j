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
