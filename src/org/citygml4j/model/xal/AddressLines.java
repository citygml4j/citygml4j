package org.citygml4j.model.xal;

import java.util.List;

public interface AddressLines extends XALBase {
	public List<AddressLine> getAddressLine();
	public boolean isSetAddressLine();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
}
