package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.base.AssociationByRep;
import org.citygml4j.model.xal.AddressDetails;

public interface XalAddressProperty extends CoreModuleComponent, AssociationByRep<AddressDetails> {
	public AddressDetails getAddressDetails();
	public boolean isSetAddressDetails();
	
	public void setAddressDetails(AddressDetails addressDetails);
	public void unsetAddressDetails();
}
