package org.citygml4j.model.gml;

import java.util.List;

public interface LineStringSegmentArrayProperty extends GMLBase {
	public List<LineStringSegment> getLineStringSegment();
	public boolean isSetLineStringSegment();
	
	public void addLineStringSegment(LineStringSegment lineStringSegment);
	public void setLineStringSegment(List<LineStringSegment> lineStringSegment);
	public void unsetLineStringSegment();
	public boolean unsetLineStringSegment(LineStringSegment lineStringSegment);
}
