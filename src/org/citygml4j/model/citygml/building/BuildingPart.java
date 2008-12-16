package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface BuildingPart extends AbstractBuilding {
	public List<ADEComponent> getGenericApplicationPropertyOfBuildingPart();
	public boolean isSetGenericApplicationPropertyOfBuildingPart();
	
	public void addGenericApplicationPropertyOfBuildingPart(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfBuildingPart(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfBuildingPart();
	public boolean unsetGenericApplicationPropertyOfBuildingPart(ADEComponent adeObject);
}
