package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.FeatureProperty;

public interface CityObjectMember extends CityGMLBase, FeatureProperty {
	public CityObject getCityObject();
	public boolean isSetCityObject();
	
	public void setCityObject(CityObject cityObject);
	public void unsetCityObject();
}
