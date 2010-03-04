package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LineStringSegment;
import org.citygml4j.model.gml.LineStringSegmentArrayProperty;

public class LineStringSegmentArrayPropertyImpl implements LineStringSegmentArrayProperty {
	private List<LineStringSegment> lineStringSegment;
	private Object parent;

	public GMLClass getGMLClass() {
		return GMLClass.LINESTRINGSEGMENTARRAYPROPERTY;
	}

	public void addLineStringSegment(LineStringSegment lineStringSegment) {
		if (this.lineStringSegment == null)
			this.lineStringSegment = new ChildList<LineStringSegment>(this);

		this.lineStringSegment.add(lineStringSegment);
	}

	public List<LineStringSegment> getLineStringSegment() {
		if (lineStringSegment == null)
			lineStringSegment = new ChildList<LineStringSegment>(this);

		return lineStringSegment;
	}

	public boolean isSetLineStringSegment() {
		return lineStringSegment != null && !lineStringSegment.isEmpty();
	}

	public void setLineStringSegment(List<LineStringSegment> lineStringSegment) {
		this.lineStringSegment = new ChildList<LineStringSegment>(this, lineStringSegment);
	}

	public void unsetLineStringSegment() {
		if (isSetLineStringSegment())
			lineStringSegment.clear();

		lineStringSegment = null;
	}

	public boolean unsetLineStringSegment(LineStringSegment lineStringSegment) {
		return isSetLineStringSegment() ? this.lineStringSegment.remove(lineStringSegment) : false;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LineStringSegmentArrayProperty copy = (target == null) ? new LineStringSegmentArrayPropertyImpl() : (LineStringSegmentArrayProperty)target;

		if (isSetLineStringSegment()) {
			for (LineStringSegment part : lineStringSegment) {
				LineStringSegment copyPart = (LineStringSegment)copyBuilder.copy(part);
				copy.addLineStringSegment(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}			
		}
			
		copy.unsetParent();

		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LineStringSegmentArrayPropertyImpl(), copyBuilder);
	}
	
}
