package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface LargeMailUser extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public List<LargeMailUserName> getLargeMailUserName();
	public LargeMailUserIdentifier getLargeMailUserIdentifier();
	public List<BuildingName> getBuildingName();
	public Department getDepartment();
	public PostBox getPostBox();
	public Thoroughfare getThoroughfare(); 
	public PostalCode getPostalCode();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetLargeMailUserName();
	public boolean isSetLargeMailUserIdentifier();
	public boolean isSetBuildingName();
	public boolean isSetDepartment();
	public boolean isSetPostBox();
	public boolean isSetThoroughfare(); 
	public boolean isSetPostalCode();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addLargeMailUserName(LargeMailUserName largeMailUserName);
	public void setLargeMailUserName(List<LargeMailUserName> largeMailUserName);
	public void setLargeMailUserIdentifier(LargeMailUserIdentifier largeMailUserIdentifier);
	public void addBuildingName(BuildingName buildingName);
	public void setBuildingName(List<BuildingName> buildingName);
	public void setDepartment(Department department);
	public void setPostBox(PostBox postBox);
	public void setThoroughfare(Thoroughfare thoroughfare);
	public void setPostalCode(PostalCode postalCode);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetLargeMailUserName();
	public boolean unsetLargeMailUserName(LargeMailUserName largeMailUserName);
	public void unsetLargeMailUserIdentifier();
	public void unsetBuildingName();
	public boolean unsetBuildingName(BuildingName buildingName);
	public void unsetDepartment();
	public void unsetPostBox();
	public void unsetThoroughfare(); 
	public void unsetPostalCode();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
