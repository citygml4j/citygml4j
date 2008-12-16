package org.citygml4j.model.gml;

import org.citygml4j.geometry.Point;

public interface AbstractCurveSegment extends GMLBase {
	public Integer getNumDerivativesAtStart();
	public Integer getNumDerivativesAtEnd();
	public Integer getNumDerivativeInterior();
	public void calcBoundingBox(Point min, Point max);
	public boolean isSetNumDerivativesAtStart();
	public boolean isSetNumDerivativesAtEnd();
	public boolean isSetNumDerivativeInterior();
	
	public void setNumDerivativesAtStart(Integer value);
	public void setNumDerivativesAtEnd(Integer value);
	public void setNumDerivativeInterior(Integer value);
	public void unsetNumDerivativesAtStart();
	public void unsetNumDerivativesAtEnd();
	public void unsetNumDerivativeInterior();
}
