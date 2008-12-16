package org.citygml4j.model.xal;

public interface MailStopNumber extends XALBase, GrPostal {
	public String getContent();
	public String getNameNumberSeparator();
	public boolean isSetContent();
	public boolean isSetNameNumberSeparator();
	
	public void setContent(String content);
	public void setNameNumberSeparator(String nameNumberSeparator);
	public void unsetContent();
	public void unsetNameNumberSeparator();
}
