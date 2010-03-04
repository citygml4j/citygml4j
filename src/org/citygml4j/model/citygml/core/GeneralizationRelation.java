package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.Association;

public interface GeneralizationRelation extends CoreModuleComponent, Association<CityObject> {
	public CityObject getCityObject();
	public boolean isSetCityObject();
	
	public void setCityObject(CityObject cityObject);
	public void unsetCityObject();
}
