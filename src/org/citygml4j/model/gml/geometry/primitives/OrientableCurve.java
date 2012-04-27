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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;

public class OrientableCurve extends AbstractCurve {
	private CurveProperty baseCurve;
	private Sign orientation;

	public OrientableCurve() {
		
	}
	
	public OrientableCurve(AbstractCurve base, Sign orientation) {
		setBaseCurve(new CurveProperty(base));
		setOrientation(orientation);
	}
	
	public OrientableCurve(String xlink, Sign orientation) {
		setBaseCurve(new CurveProperty(xlink));
		setOrientation(orientation);
	}
	
	public CurveProperty getBaseCurve() {
		return baseCurve;
	}

	public Sign getOrientation() {
		return (orientation == null) ? Sign.PLUS : orientation;
	}

	public boolean isSetBaseCurve() {
		return baseCurve != null;
	}

	public boolean isSetOrientation() {
		return orientation != null;
	}

	public void setBaseCurve(CurveProperty baseCurve) {
		if (baseCurve != null)
			baseCurve.setParent(this);

		this.baseCurve = baseCurve;
	}

	public void setOrientation(Sign orientation) {
		this.orientation = orientation;
	}

	public void unsetBaseCurve() {
		if (isSetBaseCurve())
			baseCurve.unsetParent();
		
		baseCurve = null;
	}

	public void unsetOrientation() {
		orientation = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetBaseCurve() && baseCurve.isSetCurve())
			bbox.update(baseCurve.getCurve().calcBoundingBox());
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ORIENTABLE_CURVE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OrientableCurve(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OrientableCurve copy = (target == null) ? new OrientableCurve() : (OrientableCurve)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetBaseCurve()) {
			copy.setBaseCurve((CurveProperty)copyBuilder.copy(baseCurve));
			if (copy.getBaseCurve() == baseCurve)
				baseCurve.setParent(this);
		}
		
		if (isSetOrientation())
			copy.setOrientation((Sign)copyBuilder.copy(orientation));
		
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
