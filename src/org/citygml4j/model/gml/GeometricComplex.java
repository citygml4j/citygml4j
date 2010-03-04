package org.citygml4j.model.gml;

import java.util.List;

public interface GeometricComplex extends AbstractGeometry {
	public List<GeometricPrimitiveProperty> getElement();
	public boolean isSetElement();
	
	public void addElement(GeometricPrimitiveProperty element);
	public void setElement(List<GeometricPrimitiveProperty> element);
	public void unsetElement();
	public boolean unsetElement(GeometricPrimitiveProperty element);
}
