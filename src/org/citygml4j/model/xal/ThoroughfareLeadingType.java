package org.citygml4j.model.xal;

public interface ThoroughfareLeadingType extends XALBase, GrPostal {
	public String getContent();
	public String getType();
	public boolean isSetContent();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setType(String type);
	public void unsetContent();
	public void unsetType();
}
