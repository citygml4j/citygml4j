package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.impl.jaxb.ObjectFactory;
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
import org.citygml4j.model.gml.PointRep;

public class LinearRingImpl extends AbstractRingImpl implements LinearRing {
	private LinearRingType linearRingType;

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

	public List<GMLBase> getPosOrPointPropertyOrPointRep() {
		List<GMLBase> posOrPointPropOrPointRepList = new ArrayList<GMLBase>();

		for (JAXBElement<?> pointElem : linearRingType.getPosOrPointPropertyOrPointRep()) {
			if (pointElem.getValue() != null) {
				if (pointElem.getValue() instanceof PointPropertyType) {
					if (pointElem.getName().getNamespaceURI().equals("http://www.opengis.net/gml") &&
							pointElem.getName().getLocalPart().equals("pointRep"))
						posOrPointPropOrPointRepList.add(new PointRepImpl((PointPropertyType)pointElem.getValue()));
					else
						posOrPointPropOrPointRepList.add(new PointPropertyImpl((PointPropertyType)pointElem.getValue()));
					
				} else if (pointElem.getValue() instanceof DirectPositionType)
					posOrPointPropOrPointRepList.add(new DirectPositionImpl((DirectPositionType)pointElem.getValue()));
			}			
		}

		return posOrPointPropOrPointRepList;
	}

	public List<Coord> getCoord() {
		List<Coord> coordList = new ArrayList<Coord>();

		for (CoordType coordType : linearRingType.getCoord())
			coordList.add(new CoordImpl(coordType));

		return coordList;
	}

	public Coordinates getCoordinates() {
		if (linearRingType.isSetCoordinates())
			return new CoordinatesImpl(linearRingType.getCoordinates());

		return null;
	}

	public DirectPositionList getPosList() {
		if (linearRingType.isSetPosList())
			return new DirectPositionListImpl(linearRingType.getPosList());

		return null;
	}

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

	public void setPosList(DirectPositionList posList) {
		linearRingType.setPosList(((DirectPositionListImpl)posList).getJAXBObject());
	}

	public void addPointProperty(PointProperty pointProperty) {
		JAXBElement<PointPropertyType> elem = ObjectFactory.GML.createPointProperty(((PointPropertyImpl)pointProperty).getJAXBObject());
		linearRingType.getPosOrPointPropertyOrPointRep().add(elem);
	}
	
	public void addPointRep(PointRep pointRep) {
		JAXBElement<PointPropertyType> elem = ObjectFactory.GML.createPointRep(((PointRepImpl)pointRep).getJAXBObject());
		linearRingType.getPosOrPointPropertyOrPointRep().add(elem);
	}

	public void addPos(DirectPosition pos) {
		JAXBElement<DirectPositionType> elem = ObjectFactory.GML.createPos(((DirectPositionImpl)pos).getJAXBObject());
		linearRingType.getPosOrPointPropertyOrPointRep().add(elem);		
	}

	public void setPosOrPointPropertyOrPointRep(List<GMLBase> controlPoints) {
		List<JAXBElement<?>> posOrPointOrPointRepList = new ArrayList<JAXBElement<?>>();
		
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
			}
			
			if (controlPointType != null)
				posOrPointOrPointRepList.add(controlPointType);
		}
		
		linearRingType.unsetPosOrPointPropertyOrPointRep();
		linearRingType.getPosOrPointPropertyOrPointRep().addAll(posOrPointOrPointRepList);
	}

	
	public void addCoord(Coord coord) {
		linearRingType.getCoord().add(((CoordImpl)coord).getJAXBObject());
	}

	public void setCoord(List<Coord> coord) {
		List<CoordType> coordTypeList = new ArrayList<CoordType>();
		
		for (Coord item : coord)
			coordTypeList.add(((CoordImpl)item).getJAXBObject());
		
		linearRingType.unsetCoord();
		linearRingType.getCoord().addAll(coordTypeList);
	}

	public void setCoordinates(Coordinates coordinates) {
		linearRingType.setCoordinates(((CoordinatesImpl)coordinates).getJAXBObject());
	}

	public List<Double> toList() {
		List<Double> tmp = new ArrayList<Double>();

		if (isSetPosList()) {
			List<Double> points = getPosList().toList();
			if (points != null)
				tmp.addAll(points);
		}
		
		if (isSetPosOrPointPropertyOrPointRep()) {
			for (GMLBase pointElem : getPosOrPointPropertyOrPointRep()) {
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
				}
			}
		}

		if (isSetCoord()) {
			for (Coord coord : getCoord()) {
				List<Double> point = coord.toList();
				if (point != null)
					tmp.addAll(point);
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

	public boolean isSetCoord() {
		return linearRingType.isSetCoord();
	}

	public boolean isSetCoordinates() {
		return linearRingType.isSetCoordinates();
	}

	public boolean isSetPosList() {
		return linearRingType.isSetPosList();
	}

	public boolean isSetPosOrPointPropertyOrPointRep() {
		return linearRingType.isSetPosOrPointPropertyOrPointRep();
	}

	public void unsetCoord() {
		linearRingType.unsetCoord();
	}

	public void unsetCoordinates() {
		linearRingType.setCoordinates(null);
	}

	public void unsetPosList() {
		linearRingType.setPosList(null);
	}

	public void unsetPosOrPointPropertyOrPointRep() {
		linearRingType.unsetPosOrPointPropertyOrPointRep();
	}

}
