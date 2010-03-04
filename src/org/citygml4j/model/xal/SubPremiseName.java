package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

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
	public <T> T visit(XALFunction<T> visitor);
}
