package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.CurveInterpolationType;
import org.citygml4j.jaxb.gml._3_1_1.DirectPositionType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringSegmentType;
import org.citygml4j.jaxb.gml._3_1_1.PointPropertyType;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.CurveInterpolation;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.GMLBase;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LineStringSegment;
import org.citygml4j.model.gml.PointProperty;
import org.citygml4j.model.gml.PointRep;

public class LineStringSegmentImpl extends AbstractCurveSegmentImpl implements LineStringSegment {
	private LineStringSegmentType lineStringSegmentType;

	public LineStringSegmentImpl() {
		this(new LineStringSegmentType());
	}

	public LineStringSegmentImpl(LineStringSegmentType lineStringSegmentType) {
		super(lineStringSegmentType);
		this.lineStringSegmentType = lineStringSegmentType;
	}

	@Override
	public LineStringSegmentType getJAXBObject() {
		return lineStringSegmentType;
	}

	@Override
	public Coordinates getCoordinates() {
		if (lineStringSegmentType.isSetCoordinates())
			return new CoordinatesImpl(lineStringSegmentType.getCoordinates());

		return null;
	}

	@Override
	public CurveInterpolation getInterpolation() {
		// linear is fixed for gml:LineStringSegment
		if (lineStringSegmentType.isSetInterpolation())
			return CurveInterpolationImpl.LINEAR;

		return null;
	}

	@Override
	public List<GMLBase> getPosOrPointPropertyOrPointRep() {
		List<GMLBase> posOrPointOrPointRepList = new ArrayList<GMLBase>();

		for (JAXBElement<?> pointElem : lineStringSegmentType.getPosOrPointPropertyOrPointRep()) {
			if (pointElem.getValue() != null) {
				if (pointElem.getValue() instanceof PointPropertyType) {
					if (pointElem.getName().getNamespaceURI().equals("http://www.opengis.net/gml") &&
							pointElem.getName().getLocalPart().equals("pointRep"))
						posOrPointOrPointRepList.add(new PointRepImpl((PointPropertyType)pointElem.getValue()));
					else
						posOrPointOrPointRepList.add(new PointPropertyImpl((PointPropertyType)pointElem.getValue()));
				} else if (pointElem.getValue() instanceof DirectPositionType)
					posOrPointOrPointRepList.add(new DirectPositionImpl((DirectPositionType)pointElem.getValue()));
			}			
		}

		return posOrPointOrPointRepList;
	}

	@Override
	public DirectPositionList getPosList() {
		if (lineStringSegmentType.isSetPosList())
			return new DirectPositionListImpl(lineStringSegmentType.getPosList());

		return null;
	}

	@Override
	public void setInterpolation(CurveInterpolation interpolation) {
		// linear is fixed for gml:LineStringSegment
		lineStringSegmentType.setInterpolation(CurveInterpolationType.LINEAR);
	}

	@Override
	public void setPosList(DirectPositionList posList) {
		lineStringSegmentType.setPosList(((DirectPositionListImpl)posList).getJAXBObject());
	}

	@Override
	public void addPointProperty(PointProperty pointProperty) {
		JAXBElement<PointPropertyType> elem = ObjectFactory.GML.createPointProperty(((PointPropertyImpl)pointProperty).getJAXBObject());
		lineStringSegmentType.getPosOrPointPropertyOrPointRep().add(elem);
	}

	@Override
	public void addPointRep(PointRep pointRep) {
		JAXBElement<PointPropertyType> elem = ObjectFactory.GML.createPointRep(((PointRepImpl)pointRep).getJAXBObject());
		lineStringSegmentType.getPosOrPointPropertyOrPointRep().add(elem);
	}

	@Override
	public void addPos(DirectPosition pos) {
		JAXBElement<DirectPositionType> elem = ObjectFactory.GML.createPos(((DirectPositionImpl)pos).getJAXBObject());
		lineStringSegmentType.getPosOrPointPropertyOrPointRep().add(elem);		
	}

	@Override
	public void setCoordinates(Coordinates coordinates) {
		lineStringSegmentType.setCoordinates(((CoordinatesImpl)coordinates).getJAXBObject());
	}

	@Override
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
		
		lineStringSegmentType.unsetPosOrPointPropertyOrPointRep();
		lineStringSegmentType.getPosOrPointPropertyOrPointRep().addAll(posOrPointOrPointRepList);
	}

	@Override
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
	public GMLClass getGMLClass() {
		return GMLClass.LINESTRINGSEGMENT;
	}

	@Override
	public boolean isSetCoordinates() {
		return lineStringSegmentType.isSetCoordinates();
	}

	@Override
	public boolean isSetInterpolation() {
		return lineStringSegmentType.isSetInterpolation();
	}

	@Override
	public boolean isSetPosList() {
		return lineStringSegmentType.isSetPosList();
	}

	@Override
	public boolean isSetPosOrPointPropertyOrPointRep() {
		return lineStringSegmentType.isSetPosOrPointPropertyOrPointRep();
	}

	@Override
	public void unsetCoordinates() {
		lineStringSegmentType.setCoordinates(null);
	}

	@Override
	public void unsetInterpolation() {
		lineStringSegmentType.setInterpolation(null);
	}

	@Override
	public void unsetPosList() {
		lineStringSegmentType.setPosList(null);
	}

	@Override
	public void unsetPosOrPointPropertyOrPointRep() {
		lineStringSegmentType.unsetPosOrPointPropertyOrPointRep();
	}

}
