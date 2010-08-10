package org.citygml4j.impl.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;

public class MultiCurvePropertyImpl extends GeometryPropertyImpl<MultiCurve> implements MultiCurveProperty {

	public MultiCurve getMultiCurve() {
		return super.getGeometry();
	}

	public boolean isSetMultiCurve() {
		return super.isSetGeometry();
	}

	public void setMultiCurve(MultiCurve multiCurve) {
		super.setGeometry(multiCurve);
	}

	public void unsetMultiCurve() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_CURVE_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiCurvePropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiCurveProperty copy = (target == null) ? new MultiCurvePropertyImpl() : (MultiCurveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
