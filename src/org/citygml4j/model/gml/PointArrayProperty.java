package org.citygml4j.model.gml;

import java.util.List;

public interface PointArrayProperty extends GMLBase {
	public List<Point> getPoint();
	public boolean isSetPoint();
	
	public void addPoint(Point point);
	public void setPoint(List<Point> point);
	public void unsetPoint();
	public boolean unsetPoint(Point point);
}
