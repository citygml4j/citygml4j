package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface InteriorWallSurface extends BoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfInteriorWallSurface();
	public boolean isSetGenericApplicationPropertyOfInteriorWallSurface();
	
	public void addGenericApplicationPropertyOfInteriorWallSurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfInteriorWallSurface(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfInteriorWallSurface();
	public boolean unsetGenericApplicationPropertyOfInteriorWallSurface(ADEComponent ade);
}
