package org.citygml4j.model.citygml.cityobjectgroup;

import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.feature.FeatureProperty;

public interface CityObjectGroupMember extends CityObjectGroupModuleComponent, FeatureProperty<AbstractCityObject> {
	public AbstractCityObject getCityObject();
	public String getGroupRole();
	public boolean isSetCityObject();
	public boolean isSetGroupRole();

	public void setCityObject(AbstractCityObject cityObject);
	public void setGroupRole(String groupRole);
	public void unsetCityObject();
	public void unsetGroupRole();
}
