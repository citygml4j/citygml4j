package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface Window extends Opening {
	public List<ADEComponent> getGenericApplicationPropertyOfWindow();
	public boolean isSetGenericApplicationPropertyOfWindow();
	
	public void addGenericApplicationPropertyOfWindow(ADEComponent ade);
	public void setGenericApplicationPropertyOfWindow(List<ADEComponent> ade);
	public void unsetGenericApplicationPropertyOfWindow();
	public boolean unsetGenericApplicationPropertyOfWindow(ADEComponent ade);
}
