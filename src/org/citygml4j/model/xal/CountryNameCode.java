package org.citygml4j.model.xal;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

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
	public <T> T visit(XALFunctor<T> visitor);
}
