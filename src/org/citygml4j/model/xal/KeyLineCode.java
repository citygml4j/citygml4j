package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface KeyLineCode extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getType();
	public boolean isSetContent();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setType(String type);
	public void unsetContent();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
