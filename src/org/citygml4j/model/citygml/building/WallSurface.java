package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface WallSurface extends AbstractBoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfWallSurface();
	public boolean isSetGenericApplicationPropertyOfWallSurface();
	
	public void addGenericApplicationPropertyOfWallSurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfWallSurface(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfWallSurface();
	public boolean unsetGenericApplicationPropertyOfWallSurface(ADEComponent ade);
}
