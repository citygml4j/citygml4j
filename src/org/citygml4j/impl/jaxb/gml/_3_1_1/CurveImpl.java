package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.CurveType;
import org.citygml4j.model.gml.AbstractCurveSegment;
import org.citygml4j.model.gml.Curve;
import org.citygml4j.model.gml.CurveSegmentArrayProperty;
import org.citygml4j.model.gml.GMLClass;

public class CurveImpl extends AbstractCurveImpl implements Curve {
	private CurveType curveType;
	
	public CurveImpl() {
		this(new CurveType());
	}
	
	public CurveImpl(CurveType curveType) {
		super(curveType);
		this.curveType = curveType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.CURVE;
	}

	@Override
	public CurveType getJAXBObject() {
		return curveType;
	}

	@Override
	public CurveSegmentArrayProperty getSegments() {
		if (curveType.isSetSegments())
			return new CurveSegmentArrayPropertyImpl(curveType.getSegments());
		
		return null;
	}

	@Override
	public void setSegments(CurveSegmentArrayProperty segments) {
		curveType.setSegments(((CurveSegmentArrayPropertyImpl)segments).getJAXBObject());
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (getSegments() != null) {
			CurveSegmentArrayProperty arrayProperty = getSegments();
			
			if (arrayProperty.isSetCurveSegment())
				for (AbstractCurveSegment curveSegment : arrayProperty.getCurveSegment())
					curveSegment.calcBoundingBox(min, max);
		}
	}

	@Override
	public boolean isSetSegments() {
		return curveType.isSetSegments();
	}

	@Override
	public void unsetSegments() {
		curveType.setSegments(null);
	}

}
