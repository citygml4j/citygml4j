package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface ClosureSurface extends BoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfClosureSurface();
	public boolean isSetGenericApplicationPropertyOfClosureSurface();
	
	public void addGenericApplicationPropertyOfClosureSurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfClosureSurface(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfClosureSurface();
	public boolean unsetGenericApplicationPropertyOfClosureSurface(ADEComponent ade);
}
