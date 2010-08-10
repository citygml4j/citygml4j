package org.citygml4j.impl.gml.geometry.aggregates;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.SolidArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class MultiSolidImpl extends AbstractGeometricAggregateImpl implements MultiSolid {
	private List<SolidProperty> solidMember;
	private SolidArrayProperty solidMembers;

	public void addSolidMember(SolidProperty solidMember) {
		if (this.solidMember == null)
			this.solidMember = new ChildList<SolidProperty>(this);

		this.solidMember.add(solidMember);
	}

	public List<SolidProperty> getSolidMember() {
		if (solidMember == null)
			solidMember = new ChildList<SolidProperty>(this);

		return solidMember;
	}

	public SolidArrayProperty getSolidMembers() {
		return solidMembers;
	}

	public boolean isSetSolidMember() {
		return solidMember != null && !solidMember.isEmpty();
	}

	public boolean isSetSolidMembers() {
		return solidMembers != null;
	}

	public void setSolidMember(List<SolidProperty> solidMember) {
		this.solidMember = new ChildList<SolidProperty>(this, solidMember);
	}

	public void setSolidMembers(SolidArrayProperty solidMembers) {
		if (solidMembers != null)
			solidMembers.setParent(this);

		this.solidMembers = solidMembers;
	}

	public void unsetSolidMember() {
		if (isSetSolidMember())
			solidMember.clear();

		solidMember = null;
	}

	public boolean unsetSolidMember(SolidProperty solidMember) {
		return isSetSolidMember() ? this.solidMember.remove(solidMember) : false;
	}

	public void unsetSolidMembers() {
		if (solidMembers != null)
			solidMembers.unsetParent();

		solidMembers = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetSolidMember()) {
			for (SolidProperty solidProperty : getSolidMember())
				if (solidProperty.isSetSolid())
					bbox.update(solidProperty.getSolid().calcBoundingBox());
		}

		if (isSetSolidMembers()) {
			SolidArrayProperty solidArrayProperty = getSolidMembers();

			if (solidArrayProperty.isSetSolid())
				for (AbstractSolid abstractSolid : solidArrayProperty.getSolid())
					bbox.update(abstractSolid.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_SOLID;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiSolidImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiSolid copy = (target == null) ? new MultiSolidImpl() : (MultiSolid)target;
		super.copyTo(copy, copyBuilder);

		if (isSetSolidMember()) {
			for (SolidProperty part : solidMember) {
				SolidProperty copyPart = (SolidProperty)copyBuilder.copy(part);
				copy.addSolidMember(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetSolidMembers()) {
			copy.setSolidMembers((SolidArrayProperty)copyBuilder.copy(solidMembers));
			if (copy.getSolidMembers() == solidMembers)
				solidMembers.setParent(this);
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
