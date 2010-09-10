package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface CeilingSurface extends AbstractBoundarySurface {
	public List<ADEComponent> getGenericApplicationPropertyOfCeilingSurface();
	public boolean isSetGenericApplicationPropertyOfCeilingSurface();
	
	public void addGenericApplicationPropertyOfCeilingSurface(ADEComponent ade);
	public void setGenericApplicationPropertyOfCeilingSurface(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfCeilingSurface();
	public boolean unsetGenericApplicationPropertyOfCeilingSurface(ADEComponent ade);
}
