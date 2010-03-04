package org.citygml4j.model.citygml.vegetation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;

public interface VegetationObject extends VegetationModuleComponent, CityObject {
	public List<ADEComponent> getGenericApplicationPropertyOfVegetationObject();
	public boolean isSetGenericApplicationPropertyOfVegetationObject();
	
	public void addGenericApplicationPropertyOfVegetationObject(ADEComponent ade);
	public void setGenericApplicationPropertyOfVegetationObject(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfVegetationObject();
	public boolean unsetGenericApplicationPropertyOfVegetationObject(ADEComponent ade);
}
