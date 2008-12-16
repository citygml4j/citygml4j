package org.citygml4j.model.xal;

public interface ThoroughfareNumberPrefix extends XALBase, GrPostal {
	public String getContent();
	public String getNumberPrefixSeparator();
	public String getType();
	public boolean isSetContent();
	public boolean isSetNumberPrefixSeparator();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setNumberPrefixSeparator(String numberPrefixSeparator);
	public void setType(String type);
	public void unsetContent();
	public void unsetNumberPrefixSeparator();
	public void unsetType();
}
