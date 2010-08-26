package org.citygml4j.model.xal;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;

public interface SubPremiseNumber extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getIndicator();
	public String getIndicatorOccurrence();
	public String getNumberTypeOccurrence();
	public String getPremiseNumberSeparator();
	public String getType();
	public boolean isSetContent();
	public boolean isSetIndicator();
	public boolean isSetIndicatorOccurrence();
	public boolean isSetNumberTypeOccurrence();
	public boolean isSetPremiseNumberSeparator();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setIndicator(String indicator);
	public void setIndicatorOccurrence(String indicatorOccurrence);
	public void setNumberTypeOccurrence(String numberTypeOccurrence);
	public void setPremiseNumberSeparator(String premiseNumberSeparator);
	public void setType(String type);
	public void unsetContent();
	public void unsetIndicator();
	public void unsetIndicatorOccurrence();
	public void unsetNumberTypeOccurrence();
	public void unsetPremiseNumberSeparator();
	public void unsetType();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunctor<T> visitor);
}
