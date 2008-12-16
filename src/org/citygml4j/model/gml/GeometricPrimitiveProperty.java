package org.citygml4j.model.gml;

public interface GeometricPrimitiveProperty extends GMLBase, AssociationAttributeGroup {
	public AbstractGeometricPrimitive getGeometricPrimitive();
	public boolean isSetGeometricPrimitive();
	
	public void setGeometricPrimitive(AbstractGeometricPrimitive abstractGeometricPrimitive);
	public void unsetGeometricPrimitive();
}
