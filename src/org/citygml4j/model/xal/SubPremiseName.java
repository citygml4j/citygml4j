package org.citygml4j.model.xal;

public interface SubPremiseName extends XALBase, GrPostal {
	public String getContent();
	public String getType();
	public String getTypeOccurrence();
	public boolean isSetContent();
	public boolean isSetType();
	public boolean isSetTypeOccurrence();
	
	public void setContent(String content);
	public void setType(String type);
	public void setTypeOccurrence(String typeOccurrence);
	public void unsetContent();
	public void unsetType();
	public void unsetTypeOccurrence();
}
