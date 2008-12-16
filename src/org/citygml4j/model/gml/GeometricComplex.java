package org.citygml4j.model.gml;

import java.util.List;

public interface GeometricComplex extends AbstractGeometry {
	public List<GeometricPrimitiveProperty> getElement();
	public boolean isSetElement();
	
	public void addElement(GeometricPrimitiveProperty geometricPrimitiveProperty);
	public void setElement(List<GeometricPrimitiveProperty> geometricPrimitiveProperty);
	public void unsetElement();
	public boolean unsetElement(GeometricPrimitiveProperty geometricPrimitiveProperty);
}
