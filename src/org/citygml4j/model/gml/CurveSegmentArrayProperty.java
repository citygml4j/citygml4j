package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface CurveSegmentArrayProperty extends GML, Child, Copyable {
	public List<AbstractCurveSegment> getCurveSegment();
	public boolean isSetCurveSegment();
	
	public void addCurveSegment(AbstractCurveSegment curveSegment);
	public void setCurveSegment(List<AbstractCurveSegment> curveSegment);
	public void unsetCurveSegment();
	public boolean unsetCurveSegment(AbstractCurveSegment curveSegment);
}
