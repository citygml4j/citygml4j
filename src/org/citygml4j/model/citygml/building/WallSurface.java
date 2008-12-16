package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface WallSurface extends BoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfWallSurface();
	public boolean isSetGenericApplicationPropertyOfWallSurface();
	
	public void addGenericApplicationPropertyOfWallSurface(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfWallSurface(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfWallSurface();
	public boolean unsetGenericApplicationPropertyOfWallSurface(ADEComponent adeObject);
}
