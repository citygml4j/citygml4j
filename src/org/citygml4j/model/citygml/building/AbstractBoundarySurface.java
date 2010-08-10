package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;

public interface AbstractBoundarySurface extends BuildingModuleComponent, AbstractCityObject {
	public MultiSurfaceProperty getLod2MultiSurface();
	public MultiSurfaceProperty getLod3MultiSurface();
	public MultiSurfaceProperty getLod4MultiSurface();
	public List<OpeningProperty> getOpening();
	public List<ADEComponent> getGenericApplicationPropertyOfBoundarySurface();
	public boolean isSetLod2MultiSurface();
	public boolean isSetLod3MultiSurface();
	public boolean isSetLod4MultiSurface();
	public boolean isSetOpening();
	public boolean isSetGenericApplicationPropertyOfBoundarySurface();
	
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface);
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);
	public void setOpening(List<OpeningProperty> opening);
	public void addOpening(OpeningProperty opening);	
	public void addGenericApplicationPropertyOfBoundarySurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfBoundarySurface(List<ADEComponent> ade);
	public void unsetLod2MultiSurface();
	public void unsetLod3MultiSurface();
	public void unsetLod4MultiSurface();
	public void unsetOpening();
	public boolean unsetOpening(OpeningProperty opening);
	public void unsetGenericApplicationPropertyOfBoundarySurface();
	public boolean unsetGenericApplicationPropertyOfBoundarySurface(ADEComponent ade);
}
