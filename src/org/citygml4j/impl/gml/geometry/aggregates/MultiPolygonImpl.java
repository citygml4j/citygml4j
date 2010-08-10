package org.citygml4j.impl.gml.geometry.aggregates;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.MultiPolygon;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class MultiPolygonImpl extends AbstractGeometricAggregateImpl implements MultiPolygon {
	private List<PolygonProperty> polygonMember;

	public void addPolygonMember(PolygonProperty polygonMember) {
		if (this.polygonMember == null)
			this.polygonMember = new ChildList<PolygonProperty>(this);

		this.polygonMember.add(polygonMember);
	}

	public List<PolygonProperty> getPolygonMember() {
		if (polygonMember == null)
			polygonMember = new ChildList<PolygonProperty>(this);

		return polygonMember;
	}

	public boolean isSetPolygonMember() {
		return polygonMember != null && !polygonMember.isEmpty();
	}

	public void setPolygonMember(List<PolygonProperty> polygonMember) {
		this.polygonMember = new ChildList<PolygonProperty>(this, polygonMember);
	}

	public void unsetPolygonMember() {
		if (isSetPolygonMember())
			polygonMember.clear();
			
		polygonMember = null;
	}

	public boolean unsetPolygonMember(PolygonProperty polygonMember) {
		return isSetPolygonMember() ? this.polygonMember.remove(polygonMember) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetPolygonMember()) {
			for (PolygonProperty polygonProperty : getPolygonMember())
				if (polygonProperty.isSetPolygon())
					bbox.update(polygonProperty.getPolygon().calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_POLYGON;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPolygonImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPolygon copy = (target == null) ? new MultiPolygonImpl() : (MultiPolygon)target;
		super.copyTo(copy, copyBuilder);

		if (isSetPolygonMember()) {
			for (PolygonProperty part : polygonMember) {
				PolygonProperty copyPart = (PolygonProperty)copyBuilder.copy(part);
				copy.addPolygonMember(copyPart);

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
