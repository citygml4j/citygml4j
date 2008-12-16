package org.citygml4j.model.citygml.cityobjectgroup;

import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.gml.Association;

public interface CityObjectGroupMember extends CityGMLBase, Association<CityObject> {
	public String getGroupRole();
	public boolean isSetGroupRole();
	
	public void setGroupRole(String groupRole);
	public void unsetGroupRole();
}
