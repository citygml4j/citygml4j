package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface CityObjectMember extends CoreModuleComponent, FeatureProperty<AbstractCityObject> {
	public AbstractCityObject getCityObject();
	public boolean isSetCityObject();
	
	public void setCityObject(AbstractCityObject cityObject);
	public void unsetCityObject();
}
