package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryArrayPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.CurveArrayProperty;

public class CurveArrayPropertyImpl extends GeometryArrayPropertyImpl<AbstractCurve> implements CurveArrayProperty {

	public void addCurve(AbstractCurve abstractCurve) {
		super.addGeometry(abstractCurve);
	}

	public List<AbstractCurve> getCurve() {
		return super.getGeometry();
	}

	public boolean isSetCurve() {
		return super.isSetGeometry();
	}

	public void setCurve(List<AbstractCurve> abstractCurve) {
		super.setGeometry(abstractCurve);
	}

	public void unsetCurve() {
		super.unsetGeometry();
	}

	public boolean unsetCurve(AbstractCurve abstractCurve) {
		return super.unsetGeometry(abstractCurve);
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE_ARRAY_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveArrayProperty copy = (target == null) ? new CurveArrayPropertyImpl() : (CurveArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
