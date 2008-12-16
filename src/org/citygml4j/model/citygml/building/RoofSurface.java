package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface RoofSurface extends BoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfRoofSurface();
	public boolean isSetGenericApplicationPropertyOfRoofSurface();
	
	public void addGenericApplicationPropertyOfRoofSurface(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfRoofSurface(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfRoofSurface();
	public boolean unsetGenericApplicationPropertyOfRoofSurface(ADEComponent adeObject);
}
