package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface IntBuildingInstallation extends BuildingModuleComponent, AbstractCityObject {
	public String getClazz();
	public List<String> getFunction();
	public List<String> getUsage();
	public GeometryProperty<? extends AbstractGeometry> getLod4Geometry();
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
	public void setLod4Geometry(GeometryProperty<? extends AbstractGeometry> lod4Geometry);	
	public void addGenericApplicationPropertyOfIntBuildingInstallation(ADEComponent ade);
	public void setGenericApplicationPropertyOfIntBuildingInstallation(List<ADEComponent> ade);
	public void unsetClazz();
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetUsage();
	public boolean unsetUsage(String usage);
	public void unsetLod4Geometry();
	public void unsetGenericApplicationPropertyOfIntBuildingInstallation();
	public boolean unsetGenericApplicationPropertyOfIntBuildingInstallation(ADEComponent ade);
}
