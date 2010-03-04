package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface PostBoxNumberExtension extends XAL, Child, Copyable {
	public String getContent();
	public String getNumberExtensionSeparator();
	public boolean isSetContent();
	public boolean isSetNumberExtensionSeparator();
	
	public void setContent(String content);
	public void setNumberExtensionSeparator(String numberExtensionSeparator);
	public void unsetContent();
	public void unsetNumberExtensionSeparator();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
