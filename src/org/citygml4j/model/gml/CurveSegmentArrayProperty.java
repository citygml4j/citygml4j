package org.citygml4j.model.gml;

import java.util.List;

public interface CurveSegmentArrayProperty extends GMLBase {
	public List<AbstractCurveSegment> getCurveSegment();
	public boolean isSetCurveSegment();
	
	public void addCurveSegment(AbstractCurveSegment curveSegment);
	public void setCurveSegment(List<AbstractCurveSegment> curveSegment);
	public void unsetCurveSegment();
	public boolean unsetCurveSegment(AbstractCurveSegment curveSegment);
}
