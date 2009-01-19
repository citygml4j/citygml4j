package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.LineStringSegmentArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.TinType;
import org.citygml4j.jaxb.gml._3_1_1.TriangulatedSurfaceType;
import org.citygml4j.model.gml.ControlPoint;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GeometricPositionGroup;
import org.citygml4j.model.gml.Length;
import org.citygml4j.model.gml.LineStringSegmentArrayProperty;
import org.citygml4j.model.gml.PointProperty;
import org.citygml4j.model.gml.Tin;
import org.citygml4j.model.gml.TriangulatedSurface;

public class TinImpl extends TriangulatedSurfaceImpl implements Tin {
	private TinType tinType;

	public TinImpl() {
		this(new TinType());
	}

	public TinImpl(TriangulatedSurface triangulatedSurface) {
		this();
		TriangulatedSurfaceType tsType = ((TriangulatedSurfaceImpl)triangulatedSurface).getJAXBObject();
		tinType.setPatches(tsType.getPatches());
	}

	public TinImpl(TinType tinType) {
		super(tinType);
		this.tinType = tinType;
	}	

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TIN;
	}

	@Override
	public TinType getJAXBObject() {
		return tinType;
	}

	@Override
	public void addBreakLines(LineStringSegmentArrayProperty breakLines) {
		tinType.getBreakLines().add(((LineStringSegmentArrayPropertyImpl)breakLines).getJAXBObject());
	}

	@Override
	public void addStopLines(LineStringSegmentArrayProperty stopLines) {
		tinType.getBreakLines().add(((LineStringSegmentArrayPropertyImpl)stopLines).getJAXBObject());
	}

	@Override
	public List<LineStringSegmentArrayProperty> getBreakLines() {
		List<LineStringSegmentArrayProperty> breakLines = new ArrayList<LineStringSegmentArrayProperty>();

		for (LineStringSegmentArrayPropertyType breakLineType : tinType.getBreakLines())
			breakLines.add(new LineStringSegmentArrayPropertyImpl(breakLineType));

		return breakLines;
	}

	@Override
	public ControlPoint getControlPoint() {
		if (tinType.isSetControlPoint())
			return new ControlPointImpl(tinType.getControlPoint());

		return null;
	}

	@Override
	public Length getMaxLength() {
		if (tinType.isSetMaxLength())
			return new LengthImpl(tinType.getMaxLength());

		return null;
	}

	@Override
	public List<LineStringSegmentArrayProperty> getStopLines() {
		List<LineStringSegmentArrayProperty> stopLines = new ArrayList<LineStringSegmentArrayProperty>();

		for (LineStringSegmentArrayPropertyType stopLineType : tinType.getStopLines())
			stopLines.add(new LineStringSegmentArrayPropertyImpl(stopLineType));

		return stopLines;
	}

	@Override
	public void setBreakLines(List<LineStringSegmentArrayProperty> breakLines) {
		List<LineStringSegmentArrayPropertyType> breakLinesType = new ArrayList<LineStringSegmentArrayPropertyType>();

		for (LineStringSegmentArrayProperty breakLine : breakLines)
			breakLinesType.add(((LineStringSegmentArrayPropertyImpl)breakLine).getJAXBObject());

		tinType.unsetBreakLines();
		tinType.getBreakLines().addAll(breakLinesType);
	}

	@Override
	public void setControlPoint(ControlPoint controlPoint) {
		tinType.setControlPoint(((ControlPointImpl)controlPoint).getJAXBObject());
	}

	@Override
	public void setMaxLength(Length maxLength) {
		tinType.setMaxLength(((LengthImpl)maxLength).getJAXBObject());
	}

	@Override
	public void setStopLines(List<LineStringSegmentArrayProperty> stopLines) {
		List<LineStringSegmentArrayPropertyType> stopLinesType = new ArrayList<LineStringSegmentArrayPropertyType>();

		for (LineStringSegmentArrayProperty stopLine : stopLines)
			stopLinesType.add(((LineStringSegmentArrayPropertyImpl)stopLine).getJAXBObject());

		tinType.unsetStopLines();
		tinType.getStopLines().addAll(stopLinesType);
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (getTrianglePatches() != null && getTrianglePatches().isSetTriangle())
			super.calcBoundingBox(min, max);

		if (getControlPoint() != null) {
			ControlPoint controlPoint = getControlPoint();
			List<Double> points = new ArrayList<Double>();

			if (controlPoint.getPosList() != null) {
				List<Double> posList = controlPoint.getPosList().toList();
				if (posList != null)
					points.addAll(posList);
			} else if (controlPoint.isSetGeometricPositionGroup()) {
				List<Double> point = new ArrayList<Double>();

				for (GeometricPositionGroup group : controlPoint.getGeometricPositionGroup()) {
					if (group.getPos() != null) {
						point = group.getPos().toList();
					} else if (group.getPointProperty() != null) {
						PointProperty pointProperty = group.getPointProperty();
						if (pointProperty.getPoint() != null)
							point = pointProperty.getPoint().toList();
					}

					if (point != null)
						points.addAll(point);
				}
			}

			if (!points.isEmpty()) {
				for (int i = 0; i < points.size(); i += 3) {
					if (min.getX() > points.get(i))
						min.setX(points.get(i));
					if (min.getY() > points.get(i + 1))
						min.setY(points.get(i + 1));
					if (min.getZ() > points.get(i + 2))
						min.setZ(points.get(i + 2));

					if (max.getX() < points.get(i))
						max.setX(points.get(i));
					if (max.getY() < points.get(i + 1))
						max.setY(points.get(i + 1));
					if (max.getZ() < points.get(i + 2))
						max.setZ(points.get(i + 2));
				}
			}
		}
	}

	@Override
	public boolean isSetTrianglePatches() {
		return tinType.isSetPatches();
	}

	@Override
	public void unsetTrianglePatches() {
		tinType.setPatches(null);
	}

	@Override
	public boolean isSetBreakLines() {
		return tinType.isSetBreakLines();
	}

	@Override
	public boolean isSetControlPoint() {
		return tinType.isSetControlPoint();
	}

	@Override
	public boolean isSetMaxLength() {
		return tinType.isSetMaxLength();
	}

	@Override
	public boolean isSetStopLines() {
		return tinType.isSetStopLines();
	}

	@Override
	public void unsetBreakLines() {
		tinType.unsetBreakLines();
	}

	@Override
	public void unsetControlPoint() {
		tinType.setControlPoint(null);
	}

	@Override
	public void unsetMaxLength() {
		tinType.setMaxLength(null);
	}

	@Override
	public void unsetStopLines() {
		tinType.unsetStopLines();
	}

	@Override
	public boolean unsetBreakLines(LineStringSegmentArrayProperty breakLines) {
		if (tinType.isSetBreakLines())
			return tinType.getBreakLines().remove(((LineStringSegmentArrayPropertyImpl)breakLines).getJAXBObject());
			
		return false;
	}

	@Override
	public boolean unsetStopLines(LineStringSegmentArrayProperty stopLines) {
		if (tinType.isSetStopLines())
			return tinType.getStopLines().remove(((LineStringSegmentArrayPropertyImpl)stopLines).getJAXBObject());
			
		return false;
	}

}
