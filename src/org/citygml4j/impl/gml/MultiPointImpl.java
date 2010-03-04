package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiPoint;
import org.citygml4j.model.gml.Point;
import org.citygml4j.model.gml.PointArrayProperty;
import org.citygml4j.model.gml.PointProperty;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class MultiPointImpl extends AbstractGeometricAggregateImpl implements MultiPoint {
	private List<PointProperty> pointMember;
	private PointArrayProperty pointMembers;
	
	public void addPointMember(PointProperty pointMember) {
		if (this.pointMember == null)
			this.pointMember = new ChildList<PointProperty>(this);
		
		this.pointMember.add(pointMember);
	}

	public List<PointProperty> getPointMember() {
		if (pointMember == null)
			pointMember = new ChildList<PointProperty>(this);
		
		return pointMember;
	}

	public PointArrayProperty getPointMembers() {
		return pointMembers;
	}

	public boolean isSetPointMember() {
		return pointMember != null && !pointMember.isEmpty();
	}

	public boolean isSetPointMembers() {
		return pointMembers != null;
	}

	public void setPointMember(List<PointProperty> pointMember) {
		this.pointMember = new ChildList<PointProperty>(this, pointMember);
	}

	public void setPointMembers(PointArrayProperty pointMembers) {
		if (pointMembers != null)
			pointMembers.setParent(this);
		
		this.pointMembers = pointMembers;
	}

	public void unsetPointMember() {
		if (isSetPointMember())
			pointMember.clear();
		
		pointMember = null;
	}

	public boolean unsetPointMember(PointProperty pointMember) {
		return isSetPointMember() ? this.pointMember.remove(pointMember) : false;
	}

	public void unsetPointMembers() {
		if (isSetPointMembers())
			pointMembers.unsetParent();
		
		pointMembers = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetPointMember()) {
			for (PointProperty pointProperty : getPointMember())
				if (pointProperty.isSetPoint())
					bbox.update(pointProperty.getPoint().calcBoundingBox());
		}

		if (isSetPointMembers()) {
			PointArrayProperty pointArrayProperty = getPointMembers();
			
			if (pointArrayProperty.isSetPoint())
				for (Point point : pointArrayProperty.getPoint())
					bbox.update(point.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTIPOINT;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPointImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPoint copy = (target == null) ? new MultiPointImpl() : (MultiPoint)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetPointMember()) {
			for (PointProperty part : pointMember) {
				PointProperty copyPart = (PointProperty)copyBuilder.copy(part);
				copy.addPointMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetPointMembers()) {
			copy.setPointMembers((PointArrayProperty)copyBuilder.copy(pointMembers));
			if (copy.getPointMembers() == pointMembers)
				pointMembers.setParent(this);
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
