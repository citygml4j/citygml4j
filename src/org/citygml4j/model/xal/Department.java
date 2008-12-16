package org.citygml4j.model.xal;

import java.util.List;

public interface Department extends XALBase {
	public List<AddressLine> getAddressLine();
	public List<DepartmentName> getDepartmentName();
	public MailStop getMailStop();
	public PostalCode getPostalCode();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetDepartmentName();
	public boolean isSetMailStop();
	public boolean isSetPostalCode();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addDepartmentName(DepartmentName departmentName);
	public void setDepartmentName(List<DepartmentName> departmentName);
	public void setMailStop(MailStop mailStop);
	public void setPostalCode(PostalCode postalCode);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetDepartmentName();
	public boolean unsetDepartmentName(DepartmentName departmentName);
	public void unsetMailStop();
	public void unsetPostalCode();
	public void unsetType();
}
