package org.citygml4j.model.xal;

public interface PremiseNumberSuffix extends XALBase, GrPostal {
	public String getContent();
	public String getNumberSuffixSeparator();
	public String getType();
	public boolean isSetContent();
	public boolean isSetNumberSuffixSeparator();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setNumberSuffixSeparator(String numberSuffixSeparator);
	public void setType(String type);
	public void unsetContent();
	public void unsetNumberSuffixSeparator();
	public void unsetType();
}
