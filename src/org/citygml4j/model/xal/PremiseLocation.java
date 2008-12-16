package org.citygml4j.model.xal;

public interface PremiseLocation extends XALBase, GrPostal {
	public String getContent();
	public boolean isSetContent();

	public void setContent(String content);
	public void unsetContent();
}
