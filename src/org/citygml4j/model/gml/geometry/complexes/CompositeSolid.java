/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.gml.geometry.complexes;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;

public class CompositeSolid extends AbstractSolid {
	private List<SolidProperty> solidMember;
	
	public CompositeSolid() {
		
	}
	
	public CompositeSolid(List<? extends AbstractSolid> abstractSolids) {
		for (AbstractSolid abstractSolid : abstractSolids)
			addSolidMember(new SolidProperty(abstractSolid));
	}
	
	public CompositeSolid(AbstractSolid... abstractSolids) {
		this(Arrays.asList(abstractSolids));
	}

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

	public boolean isSetSolidMember() {
		return solidMember != null && !solidMember.isEmpty();
	}

	public void setSolidMember(List<SolidProperty> solidMember) {
		this.solidMember = new ChildList<SolidProperty>(this, solidMember);
	}

	public void unsetSolidMember() {
		if (isSetSolidMember())
			solidMember.clear();

		solidMember = null;
	}

	public boolean unsetSolidMember(SolidProperty solidMember) {
		return isSetSolidMember() ? this.solidMember.remove(solidMember) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetSolidMember()) {
			for (SolidProperty solidProperty : getSolidMember())
				if (solidProperty.isSetSolid())
					bbox.update(solidProperty.getSolid().calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_SOLID;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeSolid(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeSolid copy = (target == null) ? new CompositeSolid() : (CompositeSolid)target;
		super.copyTo(copy, copyBuilder);

		if (isSetSolidMember()) {
			for (SolidProperty part : solidMember) {
				SolidProperty copyPart = (SolidProperty)copyBuilder.copy(part);
				copy.addSolidMember(copyPart);

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
