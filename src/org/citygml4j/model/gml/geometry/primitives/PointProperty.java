package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface PointProperty extends GeometryProperty<Point> {
	public Point getPoint();
	public boolean isSetPoint();
	
	public void setPoint(Point point);
	public void unsetPoint();
}
