package org.citygml4j.model.xal;

public interface CountryName extends XALBase, GrPostal {
	public String getType();
	public String getContent();
	public boolean isSetContent();
	public boolean isSetType();
	
	public void setType(String type);
	public void setContent(String content);
	public void unsetContent();
	public void unsetType();
}
