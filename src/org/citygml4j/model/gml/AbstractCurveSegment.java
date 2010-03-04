package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.geometry.BoundingBox;

public interface AbstractCurveSegment extends GML, Child, Copyable {
	public Integer getNumDerivativesAtStart();
	public Integer getNumDerivativesAtEnd();
	public Integer getNumDerivativeInterior();
	public BoundingBox calcBoundingBox();
	public boolean isSetNumDerivativesAtStart();
	public boolean isSetNumDerivativesAtEnd();
	public boolean isSetNumDerivativeInterior();
	
	public void setNumDerivativesAtStart(Integer numDerivativesAtStart);
	public void setNumDerivativesAtEnd(Integer numDerivativesAtEnd);
	public void setNumDerivativeInterior(Integer numDerivativeInterior);
	public void unsetNumDerivativesAtStart();
	public void unsetNumDerivativesAtEnd();
	public void unsetNumDerivativeInterior();
}
