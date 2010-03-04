package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface PostalRoute extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<PostalRouteName> getPostalRouteName();
	public PostalRouteNumber getPostalRouteNumber();
	public PostBox getPostBox();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetPostalRouteName();
	public boolean isSetPostalRouteNumber();
	public boolean isSetPostBox();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addPostalRouteName(PostalRouteName postalRouteName);
	public void setPostalRouteName(List<PostalRouteName> postalRouteName);
	public void setPostalRouteNumber(PostalRouteNumber postalRouteNumber);
	public void setPostBox(PostBox postBox);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetPostalRouteName();
	public boolean unsetPostalRouteName(PostalRouteName postalRouteName);
	public void unsetPostalRouteNumber();
	public void unsetPostBox();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
