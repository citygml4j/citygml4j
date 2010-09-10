package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;

public interface AbstractCurveSegment extends GML, Associable, Child, Copyable {
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
