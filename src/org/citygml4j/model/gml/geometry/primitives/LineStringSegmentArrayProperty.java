package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.gml.base.ArrayAssociation;

public interface LineStringSegmentArrayProperty extends ArrayAssociation<LineStringSegment> {
	public List<LineStringSegment> getLineStringSegment();
	public boolean isSetLineStringSegment();
	
	public void addLineStringSegment(LineStringSegment lineStringSegment);
	public void setLineStringSegment(List<LineStringSegment> lineStringSegment);
	public void unsetLineStringSegment();
	public boolean unsetLineStringSegment(LineStringSegment lineStringSegment);
}
