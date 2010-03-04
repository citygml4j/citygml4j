package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.Association;

public interface AddressProperty extends CoreModuleComponent, Association<Address> {
	public Address getAddress();
	public boolean isSetAddress();
	
	public void setAddress(Address address);
	public void unsetAddress();
}
