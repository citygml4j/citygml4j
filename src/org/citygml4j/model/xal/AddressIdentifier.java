package org.citygml4j.model.xal;

public interface AddressIdentifier extends XALBase, GrPostal {
	public String getContent();
	public String getIdentifierType();
	public String getType();
	public boolean isSetContent();
	public boolean isSetIdentifierType();
	public boolean isSetType();
	
	public void setContent(String content);
	public void setIdentifierType(String identifierType);
	public void setType(String type);
	public void unsetContent();
	public void unsetIdentifierType();
	public void unsetType();
}
