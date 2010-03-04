package org.citygml4j.model.xal;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.visitor.XALFunction;
import org.citygml4j.visitor.XALVisitor;

public interface PremiseNumberRange extends XAL, Child, Copyable {
	public PremiseNumberRangeFrom getPremiseNumberRangeFrom();
	public PremiseNumberRangeTo getPremiseNumberRangeTo();
	public String getRangeType();
	public String getIndicator();
	public String getSeparator();
	public String getType();
	public String getIndicatorOccurence();
	public String getNumberRangeOccurence();
	public boolean isSetPremiseNumberRangeFrom();
	public boolean isSetPremiseNumberRangeTo();
	public boolean isSetRangeType();
	public boolean isSetIndicator();
	public boolean isSetSeparator();
	public boolean isSetType();
	public boolean isSetIndicatorOccurence();
	public boolean isSetNumberRangeOccurence();
	
	public void setPremiseNumberRangeFrom(PremiseNumberRangeFrom premiseNumberRangeFrom);
	public void setPremiseNumberRangeTo(PremiseNumberRangeTo premiseNumberRangeTo);
	public void setRangeType(String rangeType);
	public void setIndicator(String indicator);
	public void setSeparator(String separator);
	public void setType(String type);
	public void setIndicatorOccurence(String indicatorOccurence);
	public void setNumberRangeOccurence(String numberRangeOccurence);
	public void unsetPremiseNumberRangeFrom();
	public void unsetPremiseNumberRangeTo();
	public void unsetRangeType();
	public void unsetIndicator();
	public void unsetSeparator();
	public void unsetType();
	public void unsetIndicatorOccurence();
	public void unsetNumberRangeOccurence();
	
	public void visit(XALVisitor visitor);
	public <T> T visit(XALFunction<T> visitor);
}
