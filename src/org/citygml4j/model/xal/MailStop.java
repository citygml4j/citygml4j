package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface MailStop extends XAL, Child, Copyable {
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
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
