package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.gml.base.ArrayAssociation;

public interface CurveSegmentArrayProperty extends ArrayAssociation<AbstractCurveSegment> {
	public List<? extends AbstractCurveSegment> getCurveSegment();
	public boolean isSetCurveSegment();
	
	public void addCurveSegment(AbstractCurveSegment curveSegment);
	public void setCurveSegment(List<? extends AbstractCurveSegment> curveSegment);
	public void unsetCurveSegment();
	public boolean unsetCurveSegment(AbstractCurveSegment curveSegment);
}
