package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface FloorSurface extends AbstractBoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfFloorSurface();
	public boolean isSetGenericApplicationPropertyOfFloorSurface();
	
	public void addGenericApplicationPropertyOfFloorSurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfFloorSurface(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfFloorSurface();
	public boolean unsetGenericApplicationPropertyOfFloorSurface(ADEComponent ade);
}
