package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface PointProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public Point getPoint();
	public boolean isSetPoint();
	
	public void setPoint(Point point);
	public void unsetPoint();
}
