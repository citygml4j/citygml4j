package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface MultiPolygonProperty extends GeometryProperty<MultiPolygon> {
	public MultiPolygon getMultiPolygon();
	public boolean isSetMultiPolygon();
	
	public void setMultiPolygon(MultiPolygon multiPolygon);
	public void unsetMultiPolygon();
}
