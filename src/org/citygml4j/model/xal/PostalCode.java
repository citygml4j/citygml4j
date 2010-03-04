package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface PostalCode extends XAL, Child, Copyable {
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
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
