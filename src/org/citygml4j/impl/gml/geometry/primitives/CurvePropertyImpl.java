package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;

public class CurvePropertyImpl extends GeometryPropertyImpl<AbstractCurve> implements CurveProperty {
	
	public AbstractCurve getCurve() {
		return super.getGeometry();
	}

	public boolean isSetCurve() {
		return super.isSetGeometry();
	}

	public void setCurve(AbstractCurve curve) {
		super.setGeometry(curve);
	}

	public void unsetCurve() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurvePropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveProperty copy = (target == null) ? new CurvePropertyImpl() : (CurveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
