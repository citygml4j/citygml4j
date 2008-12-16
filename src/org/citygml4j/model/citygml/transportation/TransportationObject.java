package org.citygml4j.model.citygml.transportation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;

public interface TransportationObject extends CityObject {
	public List<ADEComponent> getGenericApplicationPropertyOfTransportationObject();
	public boolean isSetGenericApplicationPropertyOfTransportationObject();
	
	public void addGenericApplicationPropertyOfTransportationObject(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfTransportationObject(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfTransportationObject();
	public boolean unsetGenericApplicationPropertyOfTransportationObject(ADEComponent adeObject);
}
