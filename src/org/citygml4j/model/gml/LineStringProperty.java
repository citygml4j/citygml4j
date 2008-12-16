package org.citygml4j.model.gml;

public interface LineStringProperty extends GMLBase, AssociationAttributeGroup {
	public LineString getLineString();
	public boolean isSetLineString();
	
	public void setLineString(LineString lineString);
	public void unsetLineString();
}
