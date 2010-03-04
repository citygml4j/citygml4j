package org.citygml4j.model.citygml.cityobjectgroup;

import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.gml.Association;

public interface CityObjectGroupParent extends CityObjectGroupModuleComponent, Association<CityObject> {
	public CityObject getCityObject();
	public boolean isSetCityObject();
	
	public void setCityObject(CityObject cityObject);
	public void unsetCityObject();
}
