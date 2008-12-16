package org.citygml4j.model.xal;

public interface PostalCodeNumberExtension extends XALBase, GrPostal {
	public String getContent();
	public String getNumberExtensionSeparator();
	public String getType();
	public boolean isSetContent();
	public boolean isSetNumberExtensionSeparator();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setNumberExtensionSeparator(String numberExtensionSeparator);
	public void setType(String type);
	public void unsetContent();
	public void unsetNumberExtensionSeparator();
	public void unsetType();
}
