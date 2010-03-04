package org.citygml4j.impl.gml;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.model.gml.ControlPoint;
import org.citygml4j.model.gml.Length;
import org.citygml4j.model.gml.LineStringSegmentArrayProperty;
import org.citygml4j.model.gml.Tin;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class TinImpl extends TriangulatedSurfaceImpl implements Tin {
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
				for (int i = 0; i < points.size(); i += 3) {
					bbox.updateLowerCorner(points.get(i), points.get(i + 1), points.get(i + 2));
					bbox.updateUpperCorner(points.get(i), points.get(i + 1), points.get(i + 2));
				}
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
		return copyTo(new TinImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Tin copy = (target == null) ? new TinImpl() : (Tin)target;
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
	
	public void visit(GeometryVisitor visitor) {
		visitor.accept(this);
	}

	public <T> T apply(GeometryFunction<T> visitor) {
		return visitor.accept(this);
	}

}
