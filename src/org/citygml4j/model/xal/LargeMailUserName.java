package org.citygml4j.model.xal;

public interface LargeMailUserName extends XALBase {
	public String getContent();
	public String getType();
	public String getCode();
	public boolean isSetContent();
	public boolean isSetType();
	public boolean isSetCode();

	public void setContent(String content);
	public void setType(String type);
	public void setCode(String code);
	public void unsetContent();
	public void unsetType();
	public void unsetCode();
}
