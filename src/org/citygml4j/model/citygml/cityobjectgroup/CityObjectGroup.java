package org.citygml4j.model.citygml.cityobjectgroup;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.gml.GeometryProperty;

public interface CityObjectGroup extends CityObject {
	public String getClazz();
	public List<String> getFunction();
	public List<String> getUsage();
	public List<CityObjectGroupMember> getGroupMember();
	public CityObjectGroupParent getParent();
	public GeometryProperty getGeometry();
	public List<ADEComponent> getGenericApplicationPropertyOfCityObjectGroup();
	public boolean isSetClazz();
	public boolean isSetFunction();
	public boolean isSetUsage();
	public boolean isSetGroupMember();
	public boolean isSetParent();
	public boolean isSetGeometry();
	public boolean isSetGenericApplicationPropertyOfCityObjectGroup();	
	
	public void setClazz(String clazz);
	public void setFunction(List<String> function);
	public void addFunction(String function);
	public void setUsage(List<String> usage);
	public void addUsage(String usage);
	public void setGroupMember(List<CityObjectGroupMember> groupMember);
	public void addGroupMember(CityObjectGroupMember groupMember);
	public void setParent(CityObjectGroupParent parent);
	public void setGeometry(GeometryProperty geometry);	
	public void addGenericApplicationPropertyOfCityObjectGroup(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfCityObjectGroup(List<ADEComponent> adeObject);
	public void unsetClazz();
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetUsage();
	public boolean unsetUsage(String usage);
	public void unsetGroupMember();
	public boolean unsetGroupMember(CityObjectGroupMember groupMember);
	public void unsetParent();
	public void unsetGeometry();
	public void unsetGenericApplicationPropertyOfCityObjectGroup();	
	public boolean unsetGenericApplicationPropertyOfCityObjectGroup(ADEComponent adeObject);	
}
