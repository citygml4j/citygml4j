package org.citygml4j.model.citygml.transportation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface Railway extends TransportationComplex {
	public List<ADEComponent> getGenericApplicationPropertyOfRailway();
	public boolean isSetGenericApplicationPropertyOfRailway();
	
	public void addGenericApplicationPropertyOfRailway(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfRailway(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfRailway();
	public boolean unsetGenericApplicationPropertyOfRailway(ADEComponent adeObject);
}
