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
import org.citygml4j.model.gml.geometry.aggregates.MultiLineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringProperty;

public class MultiLineStringImpl extends AbstractGeometricAggregateImpl implements MultiLineString {
	private List<LineStringProperty> lineStringMember;		
	
	public void addLineStringMember(LineStringProperty lineStringMember) {
		if (this.lineStringMember == null)
			this.lineStringMember = new ChildList<LineStringProperty>(this);
		
		this.lineStringMember.add(lineStringMember);
	}

	public List<LineStringProperty> getLineStringMember() {
		if (lineStringMember == null)
			lineStringMember = new ChildList<LineStringProperty>(this);
		
		return lineStringMember;
	}

	public boolean isSetLineStringMember() {
		return lineStringMember != null && !lineStringMember.isEmpty();
	}

	public void setLineStringMember(List<LineStringProperty> lineStringMember) {
		this.lineStringMember = new ChildList<LineStringProperty>(this, lineStringMember);
	}

	public void unsetLineStringMember() {
		if (isSetLineStringMember())
			lineStringMember.clear();
		
		lineStringMember = null;
	}

	public boolean unsetLineStringMember(LineStringProperty lineStringMember) {
		return isSetLineStringMember() ? this.lineStringMember.remove(lineStringMember) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetLineStringMember()) {
			for (LineStringProperty lineStringProperty : getLineStringMember())
				if (lineStringProperty.isSetLineString())
					bbox.update(lineStringProperty.getLineString().calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_LINE_STRING;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiLineStringImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiLineString copy = (target == null) ? new MultiLineStringImpl() : (MultiLineString)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLineStringMember()) {
			for (LineStringProperty part : lineStringMember) {
				LineStringProperty copyPart = (LineStringProperty)copyBuilder.copy(part);
				copy.addLineStringMember(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
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
