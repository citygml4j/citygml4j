package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface MailStopNumber extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getNameNumberSeparator();
	public boolean isSetContent();
	public boolean isSetNameNumberSeparator();
	
	public void setContent(String content);
	public void setNameNumberSeparator(String nameNumberSeparator);
	public void unsetContent();
	public void unsetNameNumberSeparator();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
