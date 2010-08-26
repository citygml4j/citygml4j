package org.citygml4j.model.xal;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface PostBoxNumberPrefix extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getNumberPrefixSeparator();
	public boolean isSetContent();
	public boolean isSetNumberPrefixSeparator();
	
	public void setContent(String content);
	public void setNumberPrefixSeparator(String numberPrefixSeparator);
	public void unsetContent();
	public void unsetNumberPrefixSeparator();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
