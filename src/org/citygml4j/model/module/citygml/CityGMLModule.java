package org.citygml4j.model.module.citygml;

import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.module.Module;

public interface CityGMLModule extends Module {
	public CityGMLModuleType getType();
	public CityGMLModuleVersion getVersion();
	
	public boolean hasFeatureElement(String localName);
	public boolean hasFeaturePropertyElement(String localName);
	public Class<? extends CityGML> getFeatureElementClass(String elementName);
}
