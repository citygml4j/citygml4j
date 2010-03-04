package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

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
	public <T> T visit(XALFunction<T> visitor);
}
