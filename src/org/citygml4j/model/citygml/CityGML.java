package org.citygml4j.model.citygml;

import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.module.citygml.CityGMLModule;

public interface CityGML extends ModelObject {
	public CityGMLClass getCityGMLClass();
	public boolean isSetCityGMLModule();
	public CityGMLModule getCityGMLModule();
}
