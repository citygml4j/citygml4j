package org.citygml4j.model.xal;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface DependentLocalityNumber extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getNameNumberOccurrence();
	public boolean isSetContent();
	public boolean isSetNameNumberOccurrence();

	public void setContent(String content);
	public void setNameNumberOccurrence(String nameNumberOccurrence);
	public void unsetContent();
	public void unsetNameNumberOccurrence();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
