package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface CeilingSurface extends BoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfCeilingSurface();
	public boolean isSetGenericApplicationPropertyOfCeilingSurface();
	
	public void addGenericApplicationPropertyOfCeilingSurface(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfCeilingSurface(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfCeilingSurface();
	public boolean unsetGenericApplicationPropertyOfCeilingSurface(ADEComponent adeObject);
}
