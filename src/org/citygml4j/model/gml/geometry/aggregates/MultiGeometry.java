/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.geometry.aggregates;

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
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class MultiGeometry extends AbstractGeometricAggregate {
	private List<GeometryProperty<? extends AbstractGeometry>> geometryMember;
	private GeometryArrayProperty<? extends AbstractGeometry> geometryMembers;

	public MultiGeometry() {
		
	}
	
	public MultiGeometry(List<? extends AbstractGeometry> abstractGeometrys) {
		for (AbstractGeometry abstractGeometry : abstractGeometrys)
			addGeometryMember(new GeometryProperty<AbstractGeometry>(abstractGeometry));
	}
	
	public MultiGeometry(AbstractGeometry... abstractGeometrys) {
		this(Arrays.asList(abstractGeometrys));
	}
	
	public void addGeometryMember(GeometryProperty<? extends AbstractGeometry> geometryMember) {
		if (this.geometryMember == null)
			this.geometryMember = new ChildList<GeometryProperty<? extends AbstractGeometry>>(this);

		this.geometryMember.add(geometryMember);
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getGeometryMember() {
		if (geometryMember == null)
			geometryMember = new ChildList<GeometryProperty<? extends AbstractGeometry>>(this);

		return geometryMember;
	}

	public GeometryArrayProperty<? extends AbstractGeometry> getGeometryMembers() {
		return geometryMembers;
	}

	public boolean isSetGeometryMember() {
		return geometryMember != null && !geometryMember.isEmpty();
	}

	public boolean isSetGeometryMembers() {
		return geometryMembers != null;
	}

	public void setGeometryMember(List<GeometryProperty<? extends AbstractGeometry>> geometryMember) {
		this.geometryMember = new ChildList<GeometryProperty<? extends AbstractGeometry>>(this, geometryMember);
	}

	public void setGeometryMembers(GeometryArrayProperty<? extends AbstractGeometry> geometryMembers) {
		if (geometryMembers != null)
			geometryMembers.setParent(this);

		this.geometryMembers = geometryMembers;
	}

	public void unsetGeometryMember() {
		if (isSetGeometryMember())
			geometryMember.clear();

		geometryMember = null;
	}

	public boolean unsetGeometryMember(GeometryProperty<? extends AbstractGeometry> geometryMember) {
		return isSetGeometryMember() ? this.geometryMember.remove(geometryMember) : false;
	}

	public void unsetGeometryMembers() {
		if (geometryMembers != null)
			geometryMembers.unsetParent();

		geometryMembers = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetGeometryMember()) {
			for (GeometryProperty<? extends AbstractGeometry> geometryProperty : getGeometryMember())
				if (geometryProperty.isSetGeometry())
					bbox.update(geometryProperty.getGeometry().calcBoundingBox());
		}

		if (isSetGeometryMembers()) {
			GeometryArrayProperty<? extends AbstractGeometry> geometryArrayProperty = getGeometryMembers();

			if (geometryArrayProperty.isSetGeometry())
				for (AbstractGeometry abstractGeometry : geometryArrayProperty.getGeometry())
					bbox.update(abstractGeometry.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_GEOMETRY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiGeometry(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiGeometry copy = (target == null) ? new MultiGeometry() : (MultiGeometry)target;
		super.copyTo(copy, copyBuilder);

		if (isSetGeometryMember()) {
			for (GeometryProperty<? extends AbstractGeometry> part : geometryMember) {
				GeometryProperty<? extends AbstractGeometry> copyPart = (GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(part);
				copy.addGeometryMember(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetGeometryMembers()) {
			copy.setGeometryMembers((GeometryArrayProperty<? extends AbstractGeometry>)copyBuilder.copy(geometryMembers));
			if (copy.getGeometryMembers() == geometryMembers)
				geometryMembers.setParent(this);
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
