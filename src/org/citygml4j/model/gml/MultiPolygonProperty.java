package org.citygml4j.model.gml;

public interface MultiPolygonProperty extends GMLBase,	AssociationAttributeGroup {
	public MultiPolygon getMultiPolygon();
	public boolean isSetMultiPolygon();
	
	public void setMultiPolygon(MultiPolygon multiPolygon);
	public void unsetMultiPolygon();
}
