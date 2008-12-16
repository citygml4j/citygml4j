package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.CoordType;
import org.citygml4j.jaxb.gml._3_1_1.DirectPositionType;
import org.citygml4j.jaxb.gml._3_1_1.LinearRingType;
import org.citygml4j.jaxb.gml._3_1_1.PointPropertyType;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.GMLBase;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.PointProperty;

public class LinearRingImpl extends AbstractRingImpl implements LinearRing {
	private LinearRingType linearRingType;
	private List<Double> pointList;

	public LinearRingImpl() {
		this(new LinearRingType());
	}

	public LinearRingImpl(LinearRingType linearRingType) {
		super(linearRingType);
		this.linearRingType = linearRingType;
	}

	@Override
	public LinearRingType getJAXBObject() {
		return linearRingType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.LINEARRING;
	}

	@Override
	public List<GMLBase> getPosOrPointPropertyOrPointRep() {
		List<GMLBase> posOrPointOrPointRepList = new ArrayList<GMLBase>();
		List<JAXBElement<?>> pointList = linearRingType.getPosOrPointPropertyOrPointRep();

		for (JAXBElement<?> pointElem : pointList) {
			if (pointElem.getValue() != null) {
				if (pointElem.getValue() instanceof PointPropertyType) {
					if (pointElem.getName().getNamespaceURI().equals("http://www.opengis.net/gml") &&
							pointElem.getName().getLocalPart().equals("pointProperty"))
						posOrPointOrPointRepList.add(new PointPropertyImpl((PointPropertyType)pointElem.getValue()));
					else if (pointElem.getName().getNamespaceURI().equals("http://www.opengis.net/gml") &&
							pointElem.getName().getLocalPart().equals("pointRep"))
						posOrPointOrPointRepList.add(new PointPropertyImpl((PointPropertyType)pointElem.getValue()));

				} else if (pointElem.getValue() instanceof DirectPositionType)
					posOrPointOrPointRepList.add(new DirectPositionImpl((DirectPositionType)pointElem.getValue()));
			}			
		}

		return posOrPointOrPointRepList;
	}

	@Override
	public List<Coord> getCoord() {
		List<Coord> coordList = new ArrayList<Coord>();
		List<CoordType> coordTypeList = linearRingType.getCoord();

		for (CoordType coordType : coordTypeList)
			coordList.add(new CoordImpl(coordType));

		return coordList;
	}

	@Override
	public Coordinates getCoordinates() {
		if (linearRingType.isSetCoordinates())
			return new CoordinatesImpl(linearRingType.getCoordinates());

		return null;
	}

	@Override
	public DirectPositionList getPosList() {
		if (linearRingType.isSetPosList())
			return new DirectPositionListImpl(linearRingType.getPosList());

		return null;
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		List<Double> points = toList();

		if (points != null) {
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

	@Override
	public void setPosList(DirectPositionList posList) {
		linearRingType.setPosList(((DirectPositionListImpl)posList).getJAXBObject());
	}

	public List<Double> toList() {
		if (pointList == null)
			generatePointList();

		return pointList;
	}

	public List<Double> toList(boolean reverseOrder) {
		List<Double> points = toList();

		if (reverseOrder && points != null) {
			List<Double> reversed = new ArrayList<Double>();

			for (int i = points.size() - 3; i >= 0; i -=3)
				reversed.addAll(points.subList(i, i + 3));

			points = reversed;
		}

		return points;
	}

	private void generatePointList() {
		if (pointList != null)
			return;

		List<Double> tmp = new ArrayList<Double>();

		if (isSetPosOrPointPropertyOrPointRep()) {
			for (GMLBase pointElem : getPosOrPointPropertyOrPointRep()) {
				if (pointElem.getGMLClass() == GMLClass.DIRECTPOSITION) {
					List<Double> point = ((DirectPosition)pointElem).toList();
					if (point != null)
						tmp.addAll(point);
				} else if (pointElem.getGMLClass() == GMLClass.POINTPROPERTY) {
					org.citygml4j.model.gml.Point point = ((PointProperty)pointElem).getPoint();				
					if (point != null) {
						List<Double> coords = point.toList();
						if (coords != null)
							tmp.addAll(coords);
					}
				}
			}
		}

		if (isSetPosList()) {
			List<Double> points = getPosList().toList();
			if (points != null)
				tmp.addAll(points);
		}

		if (tmp.size() != 0)
			pointList = tmp;
	}

	@Override
	public boolean isSetCoord() {
		return linearRingType.isSetCoord();
	}

	@Override
	public boolean isSetCoordinates() {
		return linearRingType.isSetCoordinates();
	}

	@Override
	public boolean isSetPosList() {
		return linearRingType.isSetPosList();
	}

	@Override
	public boolean isSetPosOrPointPropertyOrPointRep() {
		return linearRingType.isSetPosOrPointPropertyOrPointRep();
	}

	@Override
	public void unsetCoord() {
		linearRingType.unsetCoord();
	}

	@Override
	public void unsetCoordinates() {
		linearRingType.setCoordinates(null);
	}

	@Override
	public void unsetPosList() {
		linearRingType.setPosList(null);
	}

	@Override
	public void unsetPosOrPointPropertyOrPointRep() {
		linearRingType.unsetPosOrPointPropertyOrPointRep();
	}

}
