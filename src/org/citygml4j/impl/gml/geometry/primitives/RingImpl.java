package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.geometry.primitives.Ring;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class RingImpl extends AbstractRingImpl implements Ring {
	private List<CurveProperty> curveMember;

	public void addCurveMember(CurveProperty curveMember) {
		if (this.curveMember == null)
			this.curveMember = new ChildList<CurveProperty>(this);

		this.curveMember.add(curveMember);
	}

	public List<CurveProperty> getCurveMember() {
		if (curveMember == null)
			curveMember = new ChildList<CurveProperty>(this);

		return curveMember;
	}

	public boolean isSetCurveMember() {
		return curveMember != null && !curveMember.isEmpty();
	}

	public void setCurveMember(List<CurveProperty> curveMember) {
		this.curveMember = new ChildList<CurveProperty>(this, curveMember);
	}

	public void unsetCurveMember() {
		if (isSetCurveMember())
			curveMember.clear();

		curveMember = null;
	}

	public boolean unsetCurveMember(CurveProperty curveMember) {
		return isSetCurveMember() ? this.curveMember.remove(curveMember) : false;
	}	

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();

		if (isSetCurveMember()) {
			for (CurveProperty curvePropery : getCurveMember())
				if (curvePropery.isSetCurve())
					bbox.update(curvePropery.getCurve().calcBoundingBox());
		}

		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.RING;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RingImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Ring copy = (target == null) ? new RingImpl() : (Ring)target;
		super.copyTo(copy, copyBuilder);

		if (isSetCurveMember()) {
			for (CurveProperty part : curveMember) {
				CurveProperty copyPart = (CurveProperty)copyBuilder.copy(part);
				copy.addCurveMember(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

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
