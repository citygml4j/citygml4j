package org.citygml4j.model.xal;

public interface ThoroughfareNumber extends XALBase, GrPostal {
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
}
