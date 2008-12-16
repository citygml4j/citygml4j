package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;

public interface WaterObject extends CityObject {
	public List<ADEComponent> getGenericApplicationPropertyOfWaterObject();
	public boolean isSetGenericApplicationPropertyOfWaterObject();
	
	public void addGenericApplicationPropertyOfWaterObject(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfWaterObject(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfWaterObject();
	public boolean unsetGenericApplicationPropertyOfWaterObject(ADEComponent adeObject);
}
