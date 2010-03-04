package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;

public interface WaterObject extends WaterBodyModuleComponent, CityObject {
	public List<ADEComponent> getGenericApplicationPropertyOfWaterObject();
	public boolean isSetGenericApplicationPropertyOfWaterObject();
	
	public void addGenericApplicationPropertyOfWaterObject(ADEComponent ade);
	public void setGenericApplicationPropertyOfWaterObject(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfWaterObject();
	public boolean unsetGenericApplicationPropertyOfWaterObject(ADEComponent ade);
}
