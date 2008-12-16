package org.citygml4j.model.xal;

import java.util.List;

public interface Firm extends XALBase {
	public List<AddressLine> getAddressLine();
	public List<FirmName> getFirmName();
	public List<Department> getDepartment();
	public MailStop getMailStop();
	public PostalCode getPostalCode();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetFirmName();
	public boolean isSetDepartment();
	public boolean isSetMailStop();
	public boolean isSetPostalCode();
	public boolean isSetType();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void addFirmName(FirmName firmName);
	public void setFirmName(List<FirmName> firmName);
	public void addDepartment(Department department);
	public void setDepartment(List<Department> department);
	public void setMailStop(MailStop mailStop);
	public void setPostalCode(PostalCode postalCode);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetFirmName();
	public boolean unsetFirmName(FirmName firmName);
	public void unsetDepartment();
	public boolean unsetDepartment(Department department);
	public void unsetMailStop();
	public void unsetPostalCode();
	public void unsetType();
}
