package org.citygml4j.model.gml.geometry.complexes;

import java.util.List;

import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;

public interface GeometricComplex extends AbstractGeometry {
	public List<GeometricPrimitiveProperty> getElement();
	public boolean isSetElement();
	
	public void addElement(GeometricPrimitiveProperty element);
	public void setElement(List<GeometricPrimitiveProperty> element);
	public void unsetElement();
	public boolean unsetElement(GeometricPrimitiveProperty element);
}
