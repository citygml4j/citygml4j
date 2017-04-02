package org.citygml4j.model.citygml;

import org.citygml4j.model.module.citygml.CityGMLModule;

public interface CityGMLModuleComponent extends CityGML {
	public CityGMLModule getCityGMLModule();
	public boolean isSetCityGMLModule();
}
