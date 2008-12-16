package org.citygml4j.model.xal;

public interface PostBoxNumberExtension extends XALBase {
	public String getContent();
	public String getNumberExtensionSeparator();
	public boolean isSetContent();
	public boolean isSetNumberExtensionSeparator();
	
	public void setContent(String content);
	public void setNumberExtensionSeparator(String numberExtensionSeparator);
	public void unsetContent();
	public void unsetNumberExtensionSeparator();
}
