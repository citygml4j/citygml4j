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
package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

public class Polygon extends AbstractSurface {
	private AbstractRingProperty exterior;
	private List<AbstractRingProperty> interior;

	public void addInterior(AbstractRingProperty abstractRingProperty) {
		if (interior == null)
			interior = new ChildList<AbstractRingProperty>(this);

		interior.add(abstractRingProperty);
	}

	public AbstractRingProperty getExterior() {
		return exterior;
	}

	public List<AbstractRingProperty> getInterior() {
		if (interior == null)
			interior = new ChildList<AbstractRingProperty>(this);

		return interior;
	}

	public boolean isSetExterior() {
		return exterior != null;
	}

	public boolean isSetInterior() {
		return interior != null && !interior.isEmpty();
	}

	public void setExterior(AbstractRingProperty abstractRingProperty) {
		if (abstractRingProperty != null)
			abstractRingProperty.setParent(this);

		exterior = abstractRingProperty;
	}

	public void setInterior(List<AbstractRingProperty> abstractRingProperty) {
		interior = new ChildList<AbstractRingProperty>(this, abstractRingProperty);
	}

	public void unsetExterior() {
		if (isSetExterior())
			exterior.unsetParent();

		exterior = null;
	}

	public void unsetInterior() {
		if (isSetInterior())
			interior.clear();

		interior = null;
	}

	public boolean unsetInterior(AbstractRingProperty abstractRingProperty) {
		return isSetInterior() ? interior.remove(abstractRingProperty) : false;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetExterior() && exterior.isSetRing())
			bbox.update(exterior.getRing().calcBoundingBox());
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.POLYGON;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Polygon(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Polygon copy = (target == null) ? new Polygon() : (Polygon)target;
		super.copyTo(copy, copyBuilder);

		if (isSetExterior()) {
			copy.setExterior((AbstractRingProperty)copyBuilder.copy(exterior));
			if (copy.getExterior() == exterior)
				exterior.setParent(this);
		}

		if (isSetInterior()) {
			for (AbstractRingProperty part : interior) {
				AbstractRingProperty copyPart = (AbstractRingProperty)copyBuilder.copy(part);
				copy.addInterior(copyPart);

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
