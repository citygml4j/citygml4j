package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface PointArrayProperty extends GML, Child, Copyable {
	public List<Point> getPoint();
	public boolean isSetPoint();
	
	public void addPoint(Point point);
	public void setPoint(List<Point> point);
	public void unsetPoint();
	public boolean unsetPoint(Point point);
}
