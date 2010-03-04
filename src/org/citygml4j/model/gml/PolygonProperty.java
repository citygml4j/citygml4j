package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface PolygonProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public Polygon getPolygon();
	public boolean isSetPolygon();
	
	public void setPolygon(Polygon polygon);
	public void unsetPolygon();
}
