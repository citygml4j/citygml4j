package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface MultiPolygonProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public MultiPolygon getMultiPolygon();
	public boolean isSetMultiPolygon();
	
	public void setMultiPolygon(MultiPolygon multiPolygon);
	public void unsetMultiPolygon();
}
