package org.citygml4j.model.xal;

import java.util.List;

public interface PostalCode extends XALBase {
	public List<AddressLine> getAddressLine();
	public List<PostalCodeNumber> getPostalCodeNumber();
	public List<PostalCodeNumberExtension> getPostalCodeNumberExtension();
	public PostTown getPostTown();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetPostalCodeNumber();
	public boolean isSetPostalCodeNumberExtension();
	public boolean isSetPostTown();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addPostalCodeNumber(PostalCodeNumber postalCodeNumber);
	public void setPostalCodeNumber(List<PostalCodeNumber> postalCodeNumber);
	public void addPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension);
	public void setPostalCodeNumberExtension(List<PostalCodeNumberExtension> postalCodeNumberExtension);
	public void setPostTown(PostTown postTown);
	public void setType(String type);	
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetPostalCodeNumber();
	public boolean unsetPostalCodeNumber(PostalCodeNumber postalCodeNumber);
	public void unsetPostalCodeNumberExtension();
	public boolean unsetPostalCodeNumberExtension(PostalCodeNumberExtension postalCodeNumberExtension);
	public void unsetPostTown();
	public void unsetType();
}
