package org.citygml4j.model.xal;

public interface PostBoxNumberPrefix extends XALBase, GrPostal {
	public String getContent();
	public String getNumberPrefixSeparator();
	public boolean isSetContent();
	public boolean isSetNumberPrefixSeparator();
	
	public void setContent(String content);
	public void setNumberPrefixSeparator(String numberPrefixSeparator);
	public void unsetContent();
	public void unsetNumberPrefixSeparator();
}
