package org.citygml4j.model.gml;

import java.util.List;

public interface Tin extends TriangulatedSurface {
	public List<LineStringSegmentArrayProperty> getStopLines();
	public List<LineStringSegmentArrayProperty> getBreakLines();
	public Length getMaxLength();
	public ControlPoint getControlPoint();
	public boolean isSetStopLines();
	public boolean isSetBreakLines();
	public boolean isSetMaxLength();
	public boolean isSetControlPoint();
	
	public void addStopLines(LineStringSegmentArrayProperty stopLines);
	public void setStopLines(List<LineStringSegmentArrayProperty> stopLines);
	public void addBreakLines(LineStringSegmentArrayProperty breakLines);
	public void setBreakLines(List<LineStringSegmentArrayProperty> breakLines);
	public void setMaxLength(Length maxLength);
	public void setControlPoint(ControlPoint controlPoint);
	public void unsetStopLines();
	public boolean unsetStopLines(LineStringSegmentArrayProperty stopLines);
	public void unsetBreakLines();
	public boolean unsetBreakLines(LineStringSegmentArrayProperty breakLines);
	public void unsetMaxLength();
	public void unsetControlPoint();
}
