package org.citygml4j.model.citygml.transportation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface Road extends TransportationComplex {
	public List<ADEComponent> getGenericApplicationPropertyOfRoad();
	public boolean isSetGenericApplicationPropertyOfRoad();
	
	public void addGenericApplicationPropertyOfRoad(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfRoad(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfRoad();
	public boolean unsetGenericApplicationPropertyOfRoad(ADEComponent adeObject);
}
