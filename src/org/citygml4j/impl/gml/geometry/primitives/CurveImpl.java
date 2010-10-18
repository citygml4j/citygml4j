/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurveSegment;
import org.citygml4j.model.gml.geometry.primitives.Curve;
import org.citygml4j.model.gml.geometry.primitives.CurveSegmentArrayProperty;

public class CurveImpl extends AbstractCurveImpl implements Curve {
	private CurveSegmentArrayProperty segments;
	
	public CurveSegmentArrayProperty getSegments() {
		return segments;
	}

	public boolean isSetSegments() {
		return segments != null;
	}

	public void setSegments(CurveSegmentArrayProperty segments) {
		if (segments != null)
			segments.setParent(this);
		
		this.segments = segments;
	}

	public void unsetSegments() {
		if (isSetSegments())
			segments.unsetParent();
		
		segments = null;
	}

	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		
		if (isSetSegments()) {
			CurveSegmentArrayProperty arrayProperty = getSegments();
			
			if (arrayProperty.isSetCurveSegment())
				for (AbstractCurveSegment curveSegment : arrayProperty.getCurveSegment())
					bbox.update(curveSegment.calcBoundingBox());
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Curve copy = (target == null) ? new CurveImpl() : (Curve)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetSegments()) {
			copy.setSegments((CurveSegmentArrayProperty)copyBuilder.copy(segments));
			if (copy.getSegments() == segments)
				segments.setParent(this);
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
