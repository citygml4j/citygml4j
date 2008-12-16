package org.citygml4j.model.xal;

public interface PostBoxNumberSuffix extends XALBase, GrPostal {
	public String getContent();
	public String getNumberSuffixSeparator();
	public boolean isSetContent();
	public boolean isSetNumberSuffixSeparator();
	
	public void setContent(String content);
	public void setNumberSuffixSeparator(String numberSuffixSeparator);
	public void unsetContent();
	public void unsetNumberSuffixSeparator();
}
