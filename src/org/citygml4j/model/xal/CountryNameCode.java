package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface CountryNameCode extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getScheme();
	public boolean isSetContent();
	public boolean isSetScheme();
	
	public void setContent(String content);
	public void setScheme(String scheme);
	public void unsetContent();
	public void unsetScheme();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
