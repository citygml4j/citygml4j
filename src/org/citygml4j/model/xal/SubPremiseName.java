package org.citygml4j.model.xal;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface SubPremiseName extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getType();
	public String getTypeOccurrence();
	public boolean isSetContent();
	public boolean isSetType();
	public boolean isSetTypeOccurrence();
	
	public void setContent(String content);
	public void setType(String type);
	public void setTypeOccurrence(String typeOccurrence);
	public void unsetContent();
	public void unsetType();
	public void unsetTypeOccurrence();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
