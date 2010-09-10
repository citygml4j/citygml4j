package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface GeometricPrimitiveProperty extends GeometryProperty<AbstractGeometricPrimitive> {
	public AbstractGeometricPrimitive getGeometricPrimitive();
	public boolean isSetGeometricPrimitive();
	
	public void setGeometricPrimitive(AbstractGeometricPrimitive abstractGeometricPrimitive);
	public void unsetGeometricPrimitive();
}
