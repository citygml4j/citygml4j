package org.citygml4j.model.xal;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface LargeMailUserIdentifier extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getType();
	public String getIndicator();
	public boolean isSetContent();
	public boolean isSetType();
	public boolean isSetIndicator();

	public void setContent(String content);
	public void setType(String type);
	public void setIndicator(String indicator);
	public void unsetContent();
	public void unsetType();
	public void unsetIndicator();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
