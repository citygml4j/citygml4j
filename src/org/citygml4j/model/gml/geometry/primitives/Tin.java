/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
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
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.measures.Length;

public class Tin extends TriangulatedSurface {
	private List<LineStringSegmentArrayProperty> stopLines;
	private List<LineStringSegmentArrayProperty> breakLines;
	private Length maxLength;
	private ControlPoint controlPoint;

	public void addBreakLines(LineStringSegmentArrayProperty breakLines) {
		if (this.breakLines == null)
			this.breakLines = new ChildList<LineStringSegmentArrayProperty>(this);

		this.breakLines.add(breakLines);
	}

	public void addStopLines(LineStringSegmentArrayProperty stopLines) {
		if (this.stopLines == null)
			this.stopLines = new ChildList<LineStringSegmentArrayProperty>(this);

		this.stopLines.add(stopLines);
	}

	public List<LineStringSegmentArrayProperty> getBreakLines() {
		if (breakLines == null)
			breakLines = new ChildList<LineStringSegmentArrayProperty>(this);

		return breakLines;
	}

	public ControlPoint getControlPoint() {
		return controlPoint;
	}

	public Length getMaxLength() {
		return maxLength;
	}

	public List<LineStringSegmentArrayProperty> getStopLines() {
		if (stopLines == null)
			stopLines = new ChildList<LineStringSegmentArrayProperty>(this);

		return stopLines;
	}

	public boolean isSetBreakLines() {
		return breakLines != null && !breakLines.isEmpty();
	}

	public boolean isSetControlPoint() {
		return controlPoint != null;
	}

	public boolean isSetMaxLength() {
		return maxLength != null;
	}

	public boolean isSetStopLines() {
		return stopLines != null && !stopLines.isEmpty();
	}

	public void setBreakLines(List<LineStringSegmentArrayProperty> breakLines) {
		this.breakLines = new ChildList<LineStringSegmentArrayProperty>(this, breakLines);
	}

	public void setControlPoint(ControlPoint controlPoint) {
		if (controlPoint != null)
			controlPoint.setParent(this);

		this.controlPoint = controlPoint;
	}

	public void setMaxLength(Length maxLength) {
		if (maxLength != null)
			maxLength.setParent(this);

		this.maxLength = maxLength;
	}

	public void setStopLines(List<LineStringSegmentArrayProperty> stopLines) {
		this.stopLines = new ChildList<LineStringSegmentArrayProperty>(this, stopLines);
	}

	public void unsetBreakLines() {
		if (isSetBreakLines())
			breakLines.clear();
		
		breakLines = null;
	}

	public boolean unsetBreakLines(LineStringSegmentArrayProperty breakLines) {
		return isSetBreakLines() ? this.breakLines.remove(breakLines) : false;
	}

	public void unsetControlPoint() {
		if (isSetControlPoint())
			controlPoint.unsetParent();
		
		controlPoint = null;
	}

	public void unsetMaxLength() {
		if (isSetMaxLength())
			maxLength.unsetParent();
		
		maxLength = null;
	}

	public void unsetStopLines() {
		if (isSetStopLines())
			stopLines.clear();
		
		stopLines = null;
	}

	public boolean unsetStopLines(LineStringSegmentArrayProperty stopLines) {
		return isSetStopLines() ? this.stopLines.remove(stopLines) : false;
	}

	@Override
	public BoundingBox calcBoundingBox() {
		BoundingBox bbox = new BoundingBox();
		bbox.update(super.calcBoundingBox());

		if (isSetControlPoint()) {
			List<Double> points = controlPoint.toList3d();

			if (!points.isEmpty()) {
				for (int i = 0; i < points.size(); i += 3)
					bbox.update(points.get(i), points.get(i + 1), points.get(i + 2));
			}
		}
		
		if (bbox.getLowerCorner().isEqual(Double.MAX_VALUE) && 
				bbox.getUpperCorner().isEqual(-Double.MAX_VALUE))
			return null;
		else
			return bbox;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Tin(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Tin copy = (target == null) ? new Tin() : (Tin)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetStopLines()) {
			for (LineStringSegmentArrayProperty part : stopLines) {
				LineStringSegmentArrayProperty copyPart = (LineStringSegmentArrayProperty)copyBuilder.copy(part);
				copy.addStopLines(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetBreakLines()) {
			for (LineStringSegmentArrayProperty part : breakLines) {
				LineStringSegmentArrayProperty copyPart = (LineStringSegmentArrayProperty)copyBuilder.copy(part);
				copy.addBreakLines(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetMaxLength()) {
			copy.setMaxLength((Length)copyBuilder.copy(maxLength));
			if (copy.getMaxLength() == maxLength)
				maxLength.setParent(this);
		}
		
		if (isSetControlPoint()) {
			copy.setControlPoint((ControlPoint)copyBuilder.copy(controlPoint));
			if (copy.getControlPoint() == controlPoint)
				controlPoint.setParent(this);
		}
		
		return copy;
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
