package org.citygml4j.model.xal;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface LargeMailUserName extends XAL, Child, Copyable {
	public String getContent();
	public String getType();
	public String getCode();
	public boolean isSetContent();
	public boolean isSetType();
	public boolean isSetCode();

	public void setContent(String content);
	public void setType(String type);
	public void setCode(String code);
	public void unsetContent();
	public void unsetType();
	public void unsetCode();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
