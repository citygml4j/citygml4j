package org.citygml4j.model.citygml.cityobjectgroup;

import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.feature.FeatureProperty;

public interface CityObjectGroupParent extends CityObjectGroupModuleComponent, FeatureProperty<AbstractCityObject> {
	public AbstractCityObject getCityObject();
	public boolean isSetCityObject();
	
	public void setCityObject(AbstractCityObject cityObject);
	public void unsetCityObject();
}
