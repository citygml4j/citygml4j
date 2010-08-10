package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface GroundSurface extends AbstractBoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfGroundSurface();
	public boolean isSetGenericApplicationPropertyOfGroundSurface();
	
	public void addGenericApplicationPropertyOfGroundSurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfGroundSurface(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfGroundSurface();
	public boolean unsetGenericApplicationPropertyOfGroundSurface(ADEComponent ade);
}
