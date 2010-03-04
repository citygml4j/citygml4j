package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface WaterGroundSurface extends WaterBoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfWaterGroundSurface();
	public boolean isSetGenericApplicationPropertyOfWaterGroundSurface();
	
	public void addGenericApplicationPropertyOfWaterGroundSurface(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfWaterGroundSurface(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfWaterGroundSurface();
	public boolean unsetGenericApplicationPropertyOfWaterGroundSurface(ADEComponent ade);
}
