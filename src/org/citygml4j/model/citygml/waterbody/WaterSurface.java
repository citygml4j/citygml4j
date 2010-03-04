package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface WaterSurface extends WaterBoundarySurface {
	public String getWaterLevel();
	public List<ADEComponent> getGenericApplicationPropertyOfWaterSurface();
	public boolean isSetWaterLevel();
	public boolean isSetGenericApplicationPropertyOfWaterSurface();

	public void setWaterLevel(String waterLevel);	
	public void addGenericApplicationPropertyOfWaterSurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfWaterSurface(List<ADEComponent> ade);
	public void unsetWaterLevel();
	public void unsetGenericApplicationPropertyOfWaterSurface();
	public boolean unsetGenericApplicationPropertyOfWaterSurface(ADEComponent ade);
}
