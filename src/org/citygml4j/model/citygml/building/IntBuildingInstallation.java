package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.gml.GeometryProperty;

public interface IntBuildingInstallation extends CityObject {
	public String getClazz();
	public List<String> getFunction();
	public List<String> getUsage();
	public GeometryProperty getLod4Geometry();
	public List<ADEComponent> getGenericApplicationPropertyOfIntBuildingInstallation();
	public boolean isSetClazz();
	public boolean isSetFunction();
	public boolean isSetUsage();
	public boolean isSetLod4Geometry();
	public boolean isSetGenericApplicationPropertyOfIntBuildingInstallation();
	
	public void setClazz(String clazz);
	public void setFunction(List<String> function);
	public void addFunction(String function);
	public void setUsage(List<String> usage);
	public void addUsage(String usage);
	public void setLod4Geometry(GeometryProperty lod4Geometry);	
	public void addGenericApplicationPropertyOfIntBuildingInstallation(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfIntBuildingInstallation(List<ADEComponent> adeObject);
	public void unsetClazz();
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetUsage();
	public boolean unsetUsage(String usage);
	public void unsetLod4Geometry();
	public void unsetGenericApplicationPropertyOfIntBuildingInstallation();
	public boolean unsetGenericApplicationPropertyOfIntBuildingInstallation(ADEComponent adeObject);
}
