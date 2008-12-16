package org.citygml4j.model.gml;

public interface PointProperty extends GMLBase, AssociationAttributeGroup {
	public Point getPoint();
	public boolean isSetPoint();
	
	public void setPoint(Point point);
	public void unsetPoint();
}
