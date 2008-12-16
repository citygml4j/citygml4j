package org.citygml4j.model.gml;

public interface LocationProperty extends GMLBase, AssociationAttributeGroup {
	public AbstractGeometry getGeometry();
	public Code getLocationKeyWord();
	public StringOrRef getLocationString();
	public String getNull();
	public boolean isSetGeometry();
	public boolean isSetLocationKeyWord();
	public boolean isSetLocationString();
	public boolean isSetNull();
	
	public void setGeometry(AbstractGeometry geometry);
	public void setLocationKeyWord(Code locationKeyWord);
	public void setLocationString(StringOrRef locationString);
	public void setNull(String _null);
	public void unsetGeometry();
	public void unsetLocationKeyWord();
	public void unsetLocationString();
	public void unsetNull();
}
