package org.citygml4j.model.xal;

public interface SortingCode extends XALBase, GrPostal {
	public String getType();
	public boolean isSetType();

	public void setType(String type);
	public void unsetType();
}
