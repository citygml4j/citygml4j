package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface AddressProperty extends CoreModuleComponent, FeatureProperty<Address> {
	public Address getAddress();
	public boolean isSetAddress();
	
	public void setAddress(Address address);
	public void unsetAddress();
}
