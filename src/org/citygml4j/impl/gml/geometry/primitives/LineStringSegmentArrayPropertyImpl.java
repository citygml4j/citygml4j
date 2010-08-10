package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.ArrayAssociationImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.LineStringSegment;
import org.citygml4j.model.gml.geometry.primitives.LineStringSegmentArrayProperty;

public class LineStringSegmentArrayPropertyImpl extends ArrayAssociationImpl<LineStringSegment> implements LineStringSegmentArrayProperty {
	
	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING_SEGMENT_ARRAY_PROPERTY;
	}

	public void addLineStringSegment(LineStringSegment lineStringSegment) {
		super.addObject(lineStringSegment);
	}

	public List<LineStringSegment> getLineStringSegment() {
		return super.getObject();
	}

	public boolean isSetLineStringSegment() {
		return super.isSetObject();
	}

	public void setLineStringSegment(List<LineStringSegment> lineStringSegment) {
		super.setObject(lineStringSegment);
	}

	public void unsetLineStringSegment() {
		super.unsetObject();
	}

	public boolean unsetLineStringSegment(LineStringSegment lineStringSegment) {
		return super.unsetObject(lineStringSegment);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LineStringSegmentArrayProperty copy = (target == null) ? new LineStringSegmentArrayPropertyImpl() : (LineStringSegmentArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LineStringSegmentArrayPropertyImpl(), copyBuilder);
	}
	
}
