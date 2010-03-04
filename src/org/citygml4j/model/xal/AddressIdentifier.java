package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface AddressIdentifier extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getIdentifierType();
	public String getType();
	public boolean isSetContent();
	public boolean isSetIdentifierType();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setIdentifierType(String identifierType);
	public void setType(String type);
	public void unsetContent();
	public void unsetIdentifierType();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
