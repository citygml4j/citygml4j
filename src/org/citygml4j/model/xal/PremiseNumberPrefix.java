package org.citygml4j.model.xal;

public interface PremiseNumberPrefix extends XALBase, GrPostal {
	public String getValue();
	public String getNumberPrefixSeparator();
	public String getType();
	public boolean isSetValue();
	public boolean isSetNumberPrefixSeparator();
	public boolean isSetType();
	
	public void setValue(String value);
	public void setNumberPrefixSeparator(String numberPrefixSeparator);
	public void setType(String type);
	public void unsetValue();
	public void unsetNumberPrefixSeparator();
	public void unsetType();
}
