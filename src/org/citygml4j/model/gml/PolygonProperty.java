package org.citygml4j.model.gml;

public interface PolygonProperty extends GMLBase, AssociationAttributeGroup {
	public Polygon getPolygon();
	public boolean isSetPolygon();
	
	public void setPolygon(Polygon polygon);
	public void unsetPolygon();
}
