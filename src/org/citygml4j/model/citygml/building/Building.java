package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface Building extends AbstractBuilding {
	public List<ADEComponent> getGenericApplicationPropertyOfBuilding();
	public boolean isSetGenericApplicationPropertyOfBuilding();
	
	public void addGenericApplicationPropertyOfBuilding(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfBuilding(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfBuilding();
	public boolean unsetGenericApplicationPropertyOfBuilding(ADEComponent adeObject);
}
