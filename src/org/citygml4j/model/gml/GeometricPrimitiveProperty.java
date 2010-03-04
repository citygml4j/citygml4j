package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface GeometricPrimitiveProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public AbstractGeometricPrimitive getGeometricPrimitive();
	public boolean isSetGeometricPrimitive();
	
	public void setGeometricPrimitive(AbstractGeometricPrimitive abstractGeometricPrimitive);
	public void unsetGeometricPrimitive();
}
