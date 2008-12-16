package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface GroundSurface extends BoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfGroundSurface();
	public boolean isSetGenericApplicationPropertyOfGroundSurface();
	
	public void addGenericApplicationPropertyOfGroundSurface(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfGroundSurface(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfGroundSurface();
	public boolean unsetGenericApplicationPropertyOfGroundSurface(ADEComponent adeObject);
}
