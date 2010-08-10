package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;

public interface AbstractOpening extends BuildingModuleComponent, AbstractCityObject {
	public MultiSurfaceProperty getLod3MultiSurface();
	public MultiSurfaceProperty getLod4MultiSurface();
	public List<ADEComponent> getGenericApplicationPropertyOfOpening();
	public boolean isSetLod3MultiSurface();
	public boolean isSetLod4MultiSurface();
	public boolean isSetGenericApplicationPropertyOfOpening();
	
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);	
	public void addGenericApplicationPropertyOfOpening(ADEComponent ade);
	public void setGenericApplicationPropertyOfOpening(List<ADEComponent> ade);
	public void unsetLod3MultiSurface();
	public void unsetLod4MultiSurface();
	public void unsetGenericApplicationPropertyOfOpening();
	public boolean unsetGenericApplicationPropertyOfOpening(ADEComponent ade);
}
