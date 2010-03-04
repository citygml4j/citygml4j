package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface PostBoxNumber extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public boolean isSetContent();

	public void setContent(String content);
	public void unsetContent();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
