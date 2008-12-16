package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface Site extends CityObject {
	public List<ADEComponent> getGenericApplicationPropertyOfSite();
	public boolean isSetGenericApplicationPropertyOfSite();
	
	public void addGenericApplicationPropertyOfSite(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfSite(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfSite();
}
