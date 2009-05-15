package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.math.BigInteger;

import org.citygml4j.jaxb.gml._3_1_1.AbstractCurveSegmentType;
import org.citygml4j.model.gml.AbstractCurveSegment;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractCurveSegmentImpl extends GMLBaseImpl implements AbstractCurveSegment {
	private AbstractCurveSegmentType abstractCurveSegmentType;
	
	public AbstractCurveSegmentImpl(AbstractCurveSegmentType abstractCurveSegmentType) {
		this.abstractCurveSegmentType = abstractCurveSegmentType;
	}
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTCURVESEGMENT;
	}

	@Override
	public AbstractCurveSegmentType getJAXBObject() {
		return abstractCurveSegmentType;
	}

	public Integer getNumDerivativeInterior() {
		if (abstractCurveSegmentType.isSetNumDerivativeInterior())
			return abstractCurveSegmentType.getNumDerivativeInterior().intValue();
		
		return null;
	}

	public Integer getNumDerivativesAtEnd() {
		if (abstractCurveSegmentType.isSetNumDerivativesAtEnd())
			return abstractCurveSegmentType.getNumDerivativesAtEnd().intValue();
		
		return null;
	}

	public Integer getNumDerivativesAtStart() {
		if (abstractCurveSegmentType.isSetNumDerivativesAtStart())
			return abstractCurveSegmentType.getNumDerivativesAtStart().intValue();
		
		return null;
	}

	public void setNumDerivativeInterior(Integer value) {
		abstractCurveSegmentType.setNumDerivativeInterior(new BigInteger(String.valueOf(value)));
	}

	public void setNumDerivativesAtEnd(Integer value) {
		abstractCurveSegmentType.setNumDerivativesAtEnd(new BigInteger(String.valueOf(value)));
	}

	public void setNumDerivativesAtStart(Integer value) {
		abstractCurveSegmentType.setNumDerivativesAtStart(new BigInteger(String.valueOf(value)));
	}

	public boolean isSetNumDerivativeInterior() {
		return abstractCurveSegmentType.isSetNumDerivativeInterior();
	}

	public boolean isSetNumDerivativesAtEnd() {
		return abstractCurveSegmentType.isSetNumDerivativesAtEnd();
	}

	public boolean isSetNumDerivativesAtStart() {
		return abstractCurveSegmentType.isSetNumDerivativesAtStart();
	}

	public void unsetNumDerivativeInterior() {
		abstractCurveSegmentType.setNumDerivativeInterior(null);
	}

	public void unsetNumDerivativesAtEnd() {
		abstractCurveSegmentType.setNumDerivativesAtEnd(null);
	}

	public void unsetNumDerivativesAtStart() {
		abstractCurveSegmentType.setNumDerivativesAtStart(null);
	}

}
