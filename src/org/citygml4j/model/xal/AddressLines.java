package org.citygml4j.model.xal;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface AddressLines extends XAL, Child, Copyable {
	public List<AddressLine> getAddressLine();
	public boolean isSetAddressLine();
	
	public void addAddressLine(AddressLine addressLine);
	public void setAddressLine(List<AddressLine> addressLine);
	public void unsetAddressLine();
	public boolean unsetAddressLine(AddressLine addressLine);
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
