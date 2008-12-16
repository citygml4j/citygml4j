package org.citygml4j.model.xal;

import java.util.List;

public interface MailStop extends XALBase {
	public List<AddressLine> getAddressLine();
	public MailStopName getMailStopName();
	public MailStopNumber getMailStopNumber();
	public String getType();
	public boolean isSetAddressLine();
	public boolean isSetMailStopName();
	public boolean isSetMailStopNumber();
	public boolean isSetType();
	
	public void setAddressLine(List<AddressLine> addressLine);
	public void addAddressLine(AddressLine addressLine);
	public void setMailStopName(MailStopName mailStopName);
	public void setMailStopNumber(MailStopNumber mailStopNumber);
	public void setType(String type);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	public void unsetMailStopName();
	public void unsetMailStopNumber();
	public void unsetType();
}
