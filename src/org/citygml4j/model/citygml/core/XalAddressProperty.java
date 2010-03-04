package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.xal.AddressDetails;

public interface XalAddressProperty extends CoreModuleComponent, Child, Copyable {
	public AddressDetails getAddressDetails();
	public boolean isSetAddressDetails();
	
	public void setAddressDetails(AddressDetails addressDetails);
	public void unsetAddressDetails();
}
