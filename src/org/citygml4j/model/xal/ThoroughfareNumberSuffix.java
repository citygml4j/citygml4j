package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface ThoroughfareNumberSuffix extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getNumberSuffixSeparator();
	public String getType();
	public boolean isSetContent();
	public boolean isSetNumberSuffixSeparator();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setNumberSuffixSeparator(String numberSuffixSeparator);
	public void setType(String type);
	public void unsetContent();
	public void unsetNumberSuffixSeparator();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
