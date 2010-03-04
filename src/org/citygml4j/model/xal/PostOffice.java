package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface PostOffice extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<PostOfficeName> getPostOfficeName();
	public PostOfficeNumber getPostOfficeNumber();
	public PostalRoute getPostalRoute();
	public PostBox getPostBox();
	public PostalCode getPostalCode();
	public String getType();
	public String getIndicator();
	public boolean isSetAddressLine();
	public boolean isSetPostOfficeName();
	public boolean isSetPostOfficeNumber();
	public boolean isSetPostalRoute();
	public boolean isSetPostBox();
	public boolean isSetPostalCode();
	public boolean isSetType();
	public boolean isSetIndicator();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addPostOfficeName(PostOfficeName postOfficeName);
	public void setPostOfficeName(List<PostOfficeName> postOfficeName);
	public void setPostOfficeNumber(PostOfficeNumber postOfficeNumber);
	public void setPostalRoute(PostalRoute postalRoute);
	public void setPostBox(PostBox postBox);
	public void setPostalCode(PostalCode postalCode);
	public void setType(String type);
	public void setIndicator(String indicator);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetPostOfficeName();
	public boolean unsetPostOfficeName(PostOfficeName postOfficeName);
	public void unsetPostOfficeNumber();
	public void unsetPostalRoute();
	public void unsetPostBox();
	public void unsetPostalCode();
	public void unsetType();
	public void unsetIndicator();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
