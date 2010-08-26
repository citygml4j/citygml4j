package org.citygml4j.impl.gml.geometry.aggregates;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.CurveArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;

public class MultiCurveImpl extends AbstractGeometricAggregateImpl implements MultiCurve {
	private List<CurveProperty> curveMember;
	private CurveArrayProperty curveMembers;

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

	public CurveArrayProperty getCurveMembers() {
		return curveMembers;
	}

	public boolean isSetCurveMember() {
		return curveMember != null && !curveMember.isEmpty();
	}

	public boolean isSetCurveMembers() {
		return curveMembers != null;
	}

	public void setCurveMember(List<CurveProperty> curveMember) {
		this.curveMember = new ChildList<CurveProperty>(this, curveMember);
	}

	public void setCurveMembers(CurveArrayProperty curveMembers) {
		if (curveMembers != null)
			curveMembers.setParent(this);

		this.curveMembers = curveMembers;
	}

	public void unsetCurveMember() {
		if (isSetCurveMember())
			curveMember.clear();

		curveMember = null;
	}

	public boolean unsetCurveMember(CurveProperty curveMember) {
		return isSetCurveMember() ? this.curveMember.remove(curveMember) : false;
	}

	public void unsetCurveMembers() {
		if (isSetCurveMembers())
			curveMembers.unsetParent();

		curveMembers = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetCurveMember()) {
			for (CurveProperty curveProperty : getCurveMember()) 
				if (curveProperty.isSetCurve())
					bbox.update(curveProperty.getCurve().calcBoundingBox());
		}

		if (isSetCurveMembers()) {
			CurveArrayProperty curveArrayProperty = getCurveMembers();

			if (curveArrayProperty.isSetCurve())
				for (AbstractCurve abstractCurve : curveArrayProperty.getCurve())
					bbox.update(abstractCurve.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_CURVE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiCurveImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiCurve copy = (target == null) ? new MultiCurveImpl() : (MultiCurve)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCurveMember()) {
			for (CurveProperty part : curveMember) {
				CurveProperty copyPart = (CurveProperty)copyBuilder.copy(part);
				copy.addCurveMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetCurveMembers()) {
			copy.setCurveMembers((CurveArrayProperty)copyBuilder.copy(curveMembers));
			if (copy.getCurveMembers() == curveMembers)
				curveMembers.setParent(this);
		}
		
		return copy;
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
