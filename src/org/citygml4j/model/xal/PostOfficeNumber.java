package org.citygml4j.model.xal;

public interface PostOfficeNumber extends XALBase, GrPostal {
	public String getContent();
	public String getIndicator();
	public String getIndicatorOccurrence();
	public boolean isSetContent();
	public boolean isSetIndicator();
	public boolean isSetIndicatorOccurrence();
	
	public void setContent(String content);
	public void setIndicator(String indicator);
	public void setIndicatorOccurrence(String indicatorOccurrence);
	public void unsetContent();
	public void unsetIndicator();
	public void unsetIndicatorOccurrence();
}
