package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface PremiseNumberPrefix extends XAL, GrPostal, Child, Copyable {
	public String getValue();
	public String getNumberPrefixSeparator();
	public String getType();
	public boolean isSetValue();
	public boolean isSetNumberPrefixSeparator();
	public boolean isSetType();
	
	public void setValue(String value);
	public void setNumberPrefixSeparator(String numberPrefixSeparator);
	public void setType(String type);
	public void unsetValue();
	public void unsetNumberPrefixSeparator();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
