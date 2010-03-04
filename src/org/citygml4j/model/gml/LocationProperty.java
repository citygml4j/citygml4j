package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface LocationProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public AbstractGeometry getGeometry();
	public Code getLocationKeyWord();
	public StringOrRef getLocationString();
	public Null getNull();
	public boolean isSetGeometry();
	public boolean isSetLocationKeyWord();
	public boolean isSetLocationString();
	public boolean isSetNull();
	
	public void setGeometry(AbstractGeometry geometry);
	public void setLocationKeyWord(Code locationKeyWord);
	public void setLocationString(StringOrRef locationString);
	public void setNull(Null _null);
	public void unsetGeometry();
	public void unsetLocationKeyWord();
	public void unsetLocationString();
	public void unsetNull();
}
