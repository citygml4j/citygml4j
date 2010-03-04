package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface ThoroughfareNumber extends XAL, GrPostal, Child, Copyable {
	public String getContent();
	public String getNumberType();
	public String getType();
	public String getIndicator();
	public String getIndicatorOccurrence();
	public String getNumberOccurrence();
	public boolean isSetContent();
	public boolean isSetNumberType();
	public boolean isSetType();
	public boolean isSetIndicator();
	public boolean isSetIndicatorOccurrence();
	public boolean isSetNumberOccurrence();
	
	public void setContent(String content);
	public void setNumberType(String numberType);
	public void setType(String type);
	public void setIndicator(String indicator);
	public void setIndicatorOccurrence(String indicatorOccurrence);
	public void setNumberOccurrence(String numberOccurrence);
	public void unsetContent();
	public void unsetNumberType();
	public void unsetType();
	public void unsetIndicator();
	public void unsetIndicatorOccurrence();
	public void unsetNumberOccurrence();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
