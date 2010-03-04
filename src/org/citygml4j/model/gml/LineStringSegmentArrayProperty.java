package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface LineStringSegmentArrayProperty extends GML, Child, Copyable {
	public List<LineStringSegment> getLineStringSegment();
	public boolean isSetLineStringSegment();
	
	public void addLineStringSegment(LineStringSegment lineStringSegment);
	public void setLineStringSegment(List<LineStringSegment> lineStringSegment);
	public void unsetLineStringSegment();
	public boolean unsetLineStringSegment(LineStringSegment lineStringSegment);
}
