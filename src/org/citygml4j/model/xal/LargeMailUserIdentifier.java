package org.citygml4j.model.xal;

public interface LargeMailUserIdentifier extends XALBase, GrPostal {
	public String getContent();
	public String getType();
	public String getIndicator();
	public boolean isSetContent();
	public boolean isSetType();
	public boolean isSetIndicator();

	public void setContent(String content);
	public void setType(String type);
	public void setIndicator(String indicator);
	public void unsetContent();
	public void unsetType();
	public void unsetIndicator();
}
