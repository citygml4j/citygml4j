package org.citygml4j.impl.gml.geometry.complexes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurve;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurveProperty;

public class CompositeCurvePropertyImpl extends GeometryPropertyImpl<CompositeCurve> implements CompositeCurveProperty {
	
	public CompositeCurve getCompositeCurve() {
		return super.getGeometry();
	}
	
	public boolean isSetCompositeCurve() {
		return super.isSetGeometry();
	}
	
	public void setCompositeCurve(CompositeCurve compositeCurve) {
		super.setGeometry(compositeCurve);
	}
	
	public void unsetCompositeCurve() {
		super.unsetGeometry();
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_CURVE_PROPERTY;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeCurvePropertyImpl(), copyBuilder);
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeCurveProperty copy = (target == null) ? new CompositeCurvePropertyImpl() : (CompositeCurveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}
	
}
