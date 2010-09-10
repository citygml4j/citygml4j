package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface PolygonProperty extends GeometryProperty<Polygon> {
	public Polygon getPolygon();
	public boolean isSetPolygon();
	
	public void setPolygon(Polygon polygon);
	public void unsetPolygon();
}
