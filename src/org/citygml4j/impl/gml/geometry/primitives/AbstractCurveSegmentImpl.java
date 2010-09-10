package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurveSegment;

public abstract class AbstractCurveSegmentImpl implements AbstractCurveSegment {
	private Integer numDerivativesAtStart;
	private Integer numDerivativesAtEnd;
	private Integer numDerivativeInterior;	
	private Object parent;

	public Integer getNumDerivativeInterior() {
		if (!isSetNumDerivativeInterior())
			return 0;
		else
			return numDerivativeInterior;
	}

	public Integer getNumDerivativesAtEnd() {
		if (!isSetNumDerivativesAtEnd())
			return 0;
		else
			return numDerivativesAtEnd;
	}

	public Integer getNumDerivativesAtStart() {
		if (!isSetNumDerivativesAtStart())
			return 0;
		else
			return numDerivativesAtStart;
	}

	public boolean isSetNumDerivativeInterior() {
		return numDerivativeInterior != null;
	}

	public boolean isSetNumDerivativesAtEnd() {
		return numDerivativesAtEnd != null;
	}

	public boolean isSetNumDerivativesAtStart() {
		return numDerivativesAtStart != null;
	}

	public void setNumDerivativeInterior(Integer numDerivativeInterior) {
		this.numDerivativeInterior = numDerivativeInterior;
	}

	public void setNumDerivativesAtEnd(Integer numDerivativesAtEnd) {
		this.numDerivativesAtEnd = numDerivativesAtEnd;
	}

	public void setNumDerivativesAtStart(Integer numDerivativesAtStart) {
		this.numDerivativesAtStart = numDerivativesAtStart;
	}

	public void unsetNumDerivativeInterior() {
		numDerivativeInterior = null;
	}

	public void unsetNumDerivativesAtEnd() {
		numDerivativesAtEnd = null;
	}

	public void unsetNumDerivativesAtStart() {
		numDerivativesAtStart = null;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractCurveSegment copy = (AbstractCurveSegment)target;

		if (isSetNumDerivativeInterior())
			copy.setNumDerivativeInterior((Integer)copyBuilder.copy(numDerivativeInterior));

		if (isSetNumDerivativesAtEnd())
			copy.setNumDerivativesAtEnd((Integer)copyBuilder.copy(numDerivativesAtEnd));

		if (isSetNumDerivativesAtStart())
			copy.setNumDerivativesAtStart((Integer)copyBuilder.copy(numDerivativesAtStart));

		copy.unsetParent();

		return copy;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

}
