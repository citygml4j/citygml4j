package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.CurveProperty;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.OrientableCurve;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class OrientableCurveImpl extends AbstractCurveImpl implements OrientableCurve {
	private CurveProperty baseCurve;
	private String orientation;

	public CurveProperty getBaseCurve() {
		return baseCurve;
	}

	public String getOrientation() {
		if (orientation == null)
			return "+";
		else
			return orientation;
	}

	public boolean isSetBaseCurve() {
		return baseCurve != null;
	}

	public boolean isSetOrientation() {
		return orientation != null;
	}

	public void setBaseCurve(CurveProperty baseCurve) {
		if (baseCurve != null)
			baseCurve.setParent(this);

		this.baseCurve = baseCurve;
	}

	public void setOrientation(String orientation) {
		if (orientation.equals("+") || orientation.equals("-"))
			this.orientation = orientation;
	}

	public void unsetBaseCurve() {
		if (isSetBaseCurve())
			baseCurve.unsetParent();
		
		baseCurve = null;
	}

	public void unsetOrientation() {
		orientation = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetBaseCurve() && baseCurve.isSetCurve())
			bbox.update(baseCurve.getCurve().calcBoundingBox());
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ORIENTABLECURVE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OrientableCurveImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OrientableCurve copy = (target == null) ? new OrientableCurveImpl() : (OrientableCurve)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetBaseCurve()) {
			copy.setBaseCurve((CurveProperty)copyBuilder.copy(baseCurve));
			if (copy.getBaseCurve() == baseCurve)
				baseCurve.setParent(this);
		}
		
		if (isSetOrientation())
			copy.setOrientation(copyBuilder.copy(orientation));
		
		return copy;
	}
	
	public void visit(GeometryVisitor visitor) {
		visitor.accept(this);
	}

	public <T> T apply(GeometryFunction<T> visitor) {
		return visitor.accept(this);
	}
	
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

}
