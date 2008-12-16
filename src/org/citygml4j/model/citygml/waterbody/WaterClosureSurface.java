package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface WaterClosureSurface extends WaterBoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfWaterClosureSurface();
	public boolean isSetGenericApplicationPropertyOfWaterClosureSurface();
	
	public void addGenericApplicationPropertyOfWaterClosureSurface(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfWaterClosureSurface(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfWaterClosureSurface();
	public boolean unsetGenericApplicationPropertyOfWaterClosureSurface(ADEComponent adeObject);
}
