package org.citygml4j.model.xal;

public interface CountryNameCode extends XALBase, GrPostal {
	public String getContent();
	public String getScheme();
	public boolean isSetContent();
	public boolean isSetScheme();
	
	public void setContent(String content);
	public void setScheme(String scheme);
	public void unsetContent();
	public void unsetScheme();
}
