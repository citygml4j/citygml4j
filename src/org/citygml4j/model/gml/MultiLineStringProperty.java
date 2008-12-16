package org.citygml4j.model.gml;

public interface MultiLineStringProperty extends GMLBase, AssociationAttributeGroup {
	public MultiLineString getMultiLineString();
	public boolean isSetMultiLineString();
	
	public void setMultiLineString(MultiLineString multiLineString);
	public void unsetMultiLineString();
}
