package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface RoofSurface extends AbstractBoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfRoofSurface();
	public boolean isSetGenericApplicationPropertyOfRoofSurface();
	
	public void addGenericApplicationPropertyOfRoofSurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfRoofSurface(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfRoofSurface();
	public boolean unsetGenericApplicationPropertyOfRoofSurface(ADEComponent ade);
}
