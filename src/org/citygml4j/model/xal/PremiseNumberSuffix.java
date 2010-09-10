package org.citygml4j.model.xal;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface PremiseNumberSuffix extends XAL, GrPostal, Child, Copyable {
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
	public <T> T visit(XALFunctor<T> visitor);
}
