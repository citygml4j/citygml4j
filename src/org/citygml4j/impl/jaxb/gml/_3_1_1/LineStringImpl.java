package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.CoordType;
import org.citygml4j.jaxb.gml._3_1_1.DirectPositionType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringType;
import org.citygml4j.jaxb.gml._3_1_1.PointPropertyType;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.GMLBase;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LineString;
import org.citygml4j.model.gml.PointProperty;
import org.citygml4j.model.gml.PointRep;

public class LineStringImpl extends AbstractCurveImpl implements LineString {
	private LineStringType lineStringType;

	public LineStringImpl() {
		this(new LineStringType());
	}

	public LineStringImpl(LineStringType lineStringType) {
		super(lineStringType);
		this.lineStringType = lineStringType;
	}

	@Override
	public LineStringType getJAXBObject() {
		return lineStringType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.LINESTRING;
	}

	@Override
	public List<GMLBase> getPosOrPointPropertyOrPointRepOrCoord() {
		List<GMLBase> posOrPointOrPointRepList = new ArrayList<GMLBase>();

		for (JAXBElement<?> pointElem : lineStringType.getPosOrPointPropertyOrPointRep()) {
			if (pointElem.getValue() != null) {
				if (pointElem.getValue() instanceof PointPropertyType) {
					if (pointElem.getName().getNamespaceURI().equals("http://www.opengis.net/gml") &&
							pointElem.getName().getLocalPart().equals("pointRep"))
						posOrPointOrPointRepList.add(new PointRepImpl((PointPropertyType)pointElem.getValue()));
					else
						posOrPointOrPointRepList.add(new PointPropertyImpl((PointPropertyType)pointElem.getValue()));
				} 
				else if (pointElem.getValue() instanceof DirectPositionType)
					posOrPointOrPointRepList.add(new DirectPositionImpl((DirectPositionType)pointElem.getValue()));
				else if (pointElem.getValue() instanceof CoordType)
					posOrPointOrPointRepList.add(new CoordImpl((CoordType)pointElem.getValue()));
			}			
		}

		return posOrPointOrPointRepList;
	}

	@Override
	public Coordinates getCoordinates() {
		if (lineStringType.isSetCoordinates())
			return new CoordinatesImpl(lineStringType.getCoordinates());

		return null;
	}

	@Override
	public DirectPositionList getPosList() {
		if (lineStringType.isSetPosList())
			return new DirectPositionListImpl(lineStringType.getPosList());

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
	public List<Double> toList() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetPosList()) {
			List<Double> points = getPosList().toList();
			if (points != null)
				tmp.addAll(points);
		}
		
		if (isSetPosOrPointPropertyOrPointRepOrCoord()) {
			for (GMLBase pointElem : getPosOrPointPropertyOrPointRepOrCoord()) {
				if (pointElem.getGMLClass() == GMLClass.DIRECTPOSITION) {
					List<Double> point = ((DirectPosition)pointElem).toList();
					if (point != null)
						tmp.addAll(point);
				} else if (pointElem.getGMLClass() == GMLClass.POINTPROPERTY ||
						pointElem.getGMLClass() == GMLClass.POINTREP) {
					org.citygml4j.model.gml.Point point = ((PointProperty)pointElem).getPoint();				
					if (point != null) {
						List<Double> coords = point.toList();
						if (coords != null)
							tmp.addAll(coords);
					}
				} else if (pointElem.getGMLClass() == GMLClass.COORD) {
					List<Double> coord = ((Coord)pointElem).toList();
					if (coord != null)
						tmp.addAll(coord);
				}
			}
		}

		if (isSetCoordinates()) {
			List<Double> points = getCoordinates().toList();
			if (points != null)
				tmp.addAll(points);
		}
		
		if (tmp.size() != 0)
			return tmp;
		
		return null;
	}

	@Override
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

	@Override
	public void setPosList(DirectPositionList posList) {
		lineStringType.setPosList(((DirectPositionListImpl)posList).getJAXBObject());
	}

	@Override
	public void addCoord(Coord coord) {
		JAXBElement<CoordType> elem = ObjectFactory.GML.createCoord(((CoordImpl)coord).getJAXBObject());
		lineStringType.getPosOrPointPropertyOrPointRep().add(elem);		
	}

	@Override
	public void addPointProperty(PointProperty pointProperty) {
		JAXBElement<PointPropertyType> elem = ObjectFactory.GML.createPointProperty(((PointPropertyImpl)pointProperty).getJAXBObject());
		lineStringType.getPosOrPointPropertyOrPointRep().add(elem);
	}

	@Override
	public void addPointRep(PointRep pointRep) {
		JAXBElement<PointPropertyType> elem = ObjectFactory.GML.createPointRep(((PointRepImpl)pointRep).getJAXBObject());
		lineStringType.getPosOrPointPropertyOrPointRep().add(elem);
	}

	@Override
	public void addPos(DirectPosition pos) {
		JAXBElement<DirectPositionType> elem = ObjectFactory.GML.createPos(((DirectPositionImpl)pos).getJAXBObject());
		lineStringType.getPosOrPointPropertyOrPointRep().add(elem);
	}

	@Override
	public void setCoordinates(Coordinates coordinates) {
		lineStringType.setCoordinates(((CoordinatesImpl)coordinates).getJAXBObject());
	}

	@Override
	public void setPosOrPointPropertyOrPointRepOrCoord(List<GMLBase> controlPoints) {
		List<JAXBElement<?>> posOrPointPropertyOrPointRepOrCoordList = new ArrayList<JAXBElement<?>>();
		
		for (GMLBase controlPoint : controlPoints) {
			JAXBElement<?> controlPointType = null;
			
			switch (controlPoint.getGMLClass()) {
			case POINTPROPERTY:
				controlPointType = ObjectFactory.GML.createPointProperty(((PointPropertyImpl)controlPoint).getJAXBObject());
				break;
			case DIRECTPOSITION:
				controlPointType = ObjectFactory.GML.createPos(((DirectPositionImpl)controlPoint).getJAXBObject());
				break;
			case POINTREP:
				controlPointType = ObjectFactory.GML.createPointRep(((PointRepImpl)controlPoint).getJAXBObject());
				break;
			case COORD:
				controlPointType = ObjectFactory.GML.createCoord(((CoordImpl)controlPoint).getJAXBObject());
				break;
			}
			
			if (controlPointType != null)
				posOrPointPropertyOrPointRepOrCoordList.add(controlPointType);
		}
		
		lineStringType.unsetPosOrPointPropertyOrPointRep();
		lineStringType.getPosOrPointPropertyOrPointRep().addAll(posOrPointPropertyOrPointRepOrCoordList);
	}

	@Override
	public boolean isSetCoordinates() {
		return lineStringType.isSetCoordinates();
	}

	@Override
	public boolean isSetPosList() {
		return lineStringType.isSetPosList();
	}

	@Override
	public boolean isSetPosOrPointPropertyOrPointRepOrCoord() {
		return lineStringType.isSetPosOrPointPropertyOrPointRep();
	}

	@Override
	public void unsetCoordinates() {
		lineStringType.setCoordinates(null);
	}

	@Override
	public void unsetPosList() {
		lineStringType.setPosList(null);
	}

	@Override
	public void unsetPosOrPointPropertyOrPointRepOrCoord() {
		lineStringType.unsetPosOrPointPropertyOrPointRep();
	}

}
