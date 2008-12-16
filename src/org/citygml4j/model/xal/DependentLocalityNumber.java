package org.citygml4j.model.xal;

public interface DependentLocalityNumber extends XALBase, GrPostal {
	public String getContent();
	public String getNameNumberOccurrence();
	public boolean isSetContent();
	public boolean isSetNameNumberOccurrence();

	public void setContent(String content);
	public void setNameNumberOccurrence(String nameNumberOccurrence);
	public void unsetContent();
	public void unsetNameNumberOccurrence();
}
