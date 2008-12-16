package org.citygml4j.model.xal;

public interface SubPremiseNumber extends XALBase, GrPostal {
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
	public void setIndicatorOccurrence(String indicatorOccurence);
	public void setNumberTypeOccurrence(String numberTypeOccurence);
	public void setPremiseNumberSeparator(String premiseNumberSeparator);
	public void setType(String type);
	public void unsetContent();
	public void unsetIndicator();
	public void unsetIndicatorOccurrence();
	public void unsetNumberTypeOccurrence();
	public void unsetPremiseNumberSeparator();
	public void unsetType();
}
