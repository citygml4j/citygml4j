package org.citygml4j.model.gml.geometry.primitives;


public interface Curve extends AbstractCurve {
	public CurveSegmentArrayProperty getSegments();
	public boolean isSetSegments();
	
	public void setSegments(CurveSegmentArrayProperty segments);
	public void unsetSegments();
}
