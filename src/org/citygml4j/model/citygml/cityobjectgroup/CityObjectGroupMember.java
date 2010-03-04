package org.citygml4j.model.citygml.cityobjectgroup;

import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.gml.Association;

public interface CityObjectGroupMember extends CityObjectGroupModuleComponent, Association<CityObject> {
	public CityObject getCityObject();
	public String getGroupRole();
	public boolean isSetCityObject();
	public boolean isSetGroupRole();

	public void setCityObject(CityObject cityObject);
	public void setGroupRole(String groupRole);
	public void unsetCityObject();
	public void unsetGroupRole();
}
