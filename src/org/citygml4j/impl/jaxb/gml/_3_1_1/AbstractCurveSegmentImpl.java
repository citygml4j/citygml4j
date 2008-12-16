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

	@Override
	public Integer getNumDerivativeInterior() {
		if (abstractCurveSegmentType.isSetNumDerivativeInterior())
			return abstractCurveSegmentType.getNumDerivativeInterior().intValue();
		
		return null;
	}

	@Override
	public Integer getNumDerivativesAtEnd() {
		if (abstractCurveSegmentType.isSetNumDerivativesAtEnd())
			return abstractCurveSegmentType.getNumDerivativesAtEnd().intValue();
		
		return null;
	}

	@Override
	public Integer getNumDerivativesAtStart() {
		if (abstractCurveSegmentType.isSetNumDerivativesAtStart())
			return abstractCurveSegmentType.getNumDerivativesAtStart().intValue();
		
		return null;
	}

	@Override
	public void setNumDerivativeInterior(Integer value) {
		abstractCurveSegmentType.setNumDerivativeInterior(new BigInteger(String.valueOf(value)));
	}

	@Override
	public void setNumDerivativesAtEnd(Integer value) {
		abstractCurveSegmentType.setNumDerivativesAtEnd(new BigInteger(String.valueOf(value)));
	}

	@Override
	public void setNumDerivativesAtStart(Integer value) {
		abstractCurveSegmentType.setNumDerivativesAtStart(new BigInteger(String.valueOf(value)));
	}

	@Override
	public boolean isSetNumDerivativeInterior() {
		return abstractCurveSegmentType.isSetNumDerivativeInterior();
	}

	@Override
	public boolean isSetNumDerivativesAtEnd() {
		return abstractCurveSegmentType.isSetNumDerivativesAtEnd();
	}

	@Override
	public boolean isSetNumDerivativesAtStart() {
		return abstractCurveSegmentType.isSetNumDerivativesAtStart();
	}

	@Override
	public void unsetNumDerivativeInterior() {
		abstractCurveSegmentType.setNumDerivativeInterior(null);
	}

	@Override
	public void unsetNumDerivativesAtEnd() {
		abstractCurveSegmentType.setNumDerivativesAtEnd(null);
	}

	@Override
	public void unsetNumDerivativesAtStart() {
		abstractCurveSegmentType.setNumDerivativesAtStart(null);
	}

}
