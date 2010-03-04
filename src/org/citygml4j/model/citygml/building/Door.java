package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AddressProperty;

public interface Door extends Opening {
	public List<AddressProperty> getAddress();
	public List<ADEComponent> getGenericApplicationPropertyOfDoor();
	public boolean isSetAddress();
	public boolean isSetGenericApplicationPropertyOfDoor();
	
	public void setAddress(List<AddressProperty> address);
	public void addAddress(AddressProperty address);	
	public void addGenericApplicationPropertyOfDoor(ADEComponent ade);
	public void setGenericApplicationPropertyOfDoor(List<ADEComponent> ade);
	public void unsetAddress();
	public boolean unsetAddress(AddressProperty address);
	public void unsetGenericApplicationPropertyOfDoor();
	public boolean unsetGenericApplicationPropertyOfDoor(ADEComponent ade);
}
