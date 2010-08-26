package org.citygml4j.model.xal;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

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
	public <T> T visit(XALFunctor<T> visitor);
}
