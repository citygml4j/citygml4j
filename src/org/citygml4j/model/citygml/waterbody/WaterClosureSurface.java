package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface WaterClosureSurface extends AbstractWaterBoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfWaterClosureSurface();
	public boolean isSetGenericApplicationPropertyOfWaterClosureSurface();
	
	public void addGenericApplicationPropertyOfWaterClosureSurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfWaterClosureSurface(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfWaterClosureSurface();
	public boolean unsetGenericApplicationPropertyOfWaterClosureSurface(ADEComponent ade);
}
