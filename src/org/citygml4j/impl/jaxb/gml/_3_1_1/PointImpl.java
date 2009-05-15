package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.PointType;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Point;

public class PointImpl extends AbstractGeometryImpl implements Point {
	private PointType pointType;

	public PointImpl() {
		this(new PointType());
	}

	public PointImpl(PointType pointType) {
		super(pointType);
		this.pointType = pointType;
	}

	@Override
	public PointType getJAXBObject() {
		return pointType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.POINT;
	}

	public Coord getCoord() {
		if (pointType.isSetCoord())
			return new CoordImpl(pointType.getCoord());

		return null;
	}

	public Coordinates getCoordinates() {
		if (pointType.isSetCoordinates())
			return new CoordinatesImpl(pointType.getCoordinates());

		return null;
	}

	public DirectPosition getPos() {
		if (pointType.isSetPos())
			return new DirectPositionImpl(pointType.getPos());

		return null;
	}

	public void calcBoundingBox(org.citygml4j.geometry.Point min, org.citygml4j.geometry.Point max) {
		List<Double> point = toList();

		if (point != null) {
			for (int i = 0; i < point.size(); i += 3) {
				if (min.getX() > point.get(i))
					min.setX(point.get(i));
				if (min.getY() > point.get(i + 1))
					min.setY(point.get(i + 1));
				if (min.getZ() > point.get(i + 2))
					min.setZ(point.get(i + 2));

				if (max.getX() < point.get(i))
					max.setX(point.get(i));
				if (max.getY() < point.get(i + 1))
					max.setY(point.get(i + 1));
				if (max.getZ() < point.get(i + 2))
					max.setZ(point.get(i + 2));
			}
		}
	}

	public void setPos(DirectPosition pos) {
		pointType.setPos(((DirectPositionImpl)pos).getJAXBObject());
	}

	public void setCoord(Coord coord) {
		pointType.setCoord(((CoordImpl)coord).getJAXBObject());
	}

	public void setCoordinates(Coordinates coordinates) {
		pointType.setCoordinates(((CoordinatesImpl)coordinates).getJAXBObject());
	}

	public List<Double> toList() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetPos()) {
			List<Double> point = getPos().toList();
			if (point != null)
				tmp.addAll(point);
		}

		else if (isSetCoord()) {
			List<Double> point = getCoord().toList();
			if (point != null)
				tmp.addAll(point);
		}

		else if (isSetCoordinates()) {
			List<Double> points = getCoordinates().toList();
			if (points != null)
				tmp.addAll(points.subList(0, 3));
		}
		
		if (tmp.size() != 0)
			return tmp;
		
		return null;
	}

	public boolean isSetCoord() {
		return pointType.isSetCoord();
	}

	public boolean isSetCoordinates() {
		return pointType.isSetCoordinates();
	}

	public boolean isSetPos() {
		return pointType.isSetPos();
	}

	public void unsetCoord() {
		pointType.setCoord(null);
	}

	public void unsetCoordinates() {
		pointType.setCoordinates(null);
	}

	public void unsetPos() {
		pointType.setPos(null);
	}

}
