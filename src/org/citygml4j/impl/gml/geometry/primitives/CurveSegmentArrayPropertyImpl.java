package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.ArrayAssociationImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurveSegment;
import org.citygml4j.model.gml.geometry.primitives.CurveSegmentArrayProperty;

public class CurveSegmentArrayPropertyImpl extends ArrayAssociationImpl<AbstractCurveSegment> implements CurveSegmentArrayProperty {

	public void addCurveSegment(AbstractCurveSegment curveSegment) {
		super.addObject(curveSegment);
	}

	public List<? extends AbstractCurveSegment> getCurveSegment() {
		return super.getObject();
	}

	public boolean isSetCurveSegment() {
		return super.isSetObject();
	}

	@SuppressWarnings("unchecked")
	public void setCurveSegment(List<? extends AbstractCurveSegment> curveSegment) {
		super.setObject((List<AbstractCurveSegment>)curveSegment);
	}

	public void unsetCurveSegment() {
		super.unsetObject();
	}

	public boolean unsetCurveSegment(AbstractCurveSegment curveSegment) {
		return super.unsetObject(curveSegment);
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE_SEGMENT_ARRAY_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveSegmentArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveSegmentArrayProperty copy = (target == null) ? new CurveSegmentArrayPropertyImpl() : (CurveSegmentArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
