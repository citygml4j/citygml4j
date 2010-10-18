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
package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.geometry.primitives.Ring;

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
