package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

public interface PointArrayProperty extends GeometryArrayProperty<Point> {
	public List<Point> getPoint();
	public boolean isSetPoint();
	
	public void addPoint(Point point);
	public void setPoint(List<Point> point);
	public void unsetPoint();
	public boolean unsetPoint(Point point);
}
