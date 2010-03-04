package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.gml.AbstractCurveSegment;
import org.citygml4j.model.gml.CurveSegmentArrayProperty;
import org.citygml4j.model.gml.GMLClass;

public class CurveSegmentArrayPropertyImpl implements CurveSegmentArrayProperty {
	private List<AbstractCurveSegment> curveSegment;
	private Object parent;
	
	public void addCurveSegment(AbstractCurveSegment curveSegment) {
		if (this.curveSegment == null)
			this.curveSegment = new ChildList<AbstractCurveSegment>(this);
		
		this.curveSegment.add(curveSegment);
	}

	public List<AbstractCurveSegment> getCurveSegment() {
		if (curveSegment == null)
			curveSegment = new ChildList<AbstractCurveSegment>(this);
		
		return curveSegment;
	}

	public boolean isSetCurveSegment() {
		return curveSegment != null && !curveSegment.isEmpty();
	}

	public void setCurveSegment(List<AbstractCurveSegment> curveSegment) {
		this.curveSegment = new ChildList<AbstractCurveSegment>(this, curveSegment);
	}

	public void unsetCurveSegment() {
		if (isSetCurveSegment())
			curveSegment.clear();
		
		curveSegment = null;
	}

	public boolean unsetCurveSegment(AbstractCurveSegment curveSegment) {
		return isSetCurveSegment() ? this.curveSegment.remove(curveSegment) : false;
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVESEGMENTARRAYPROPERTY;
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveSegmentArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveSegmentArrayProperty copy = (target == null) ? new CurveSegmentArrayPropertyImpl() : (CurveSegmentArrayProperty)target;
		
		if (isSetCurveSegment()) {
			for (AbstractCurveSegment part : curveSegment) {
				AbstractCurveSegment copyPart = (AbstractCurveSegment)copyBuilder.copy(part);
				copy.addCurveSegment(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		copy.unsetParent();
		
		return copy;
	}

}
