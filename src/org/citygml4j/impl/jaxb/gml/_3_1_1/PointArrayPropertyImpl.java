package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.PointArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.PointType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Point;
import org.citygml4j.model.gml.PointArrayProperty;

public class PointArrayPropertyImpl extends GMLBaseImpl implements PointArrayProperty {
	private PointArrayPropertyType pointArayPropertyType;

	public PointArrayPropertyImpl() {
		pointArayPropertyType = new PointArrayPropertyType();
	}

	public PointArrayPropertyImpl(PointArrayPropertyType pointArayPropertyType) {
		this.pointArayPropertyType = pointArayPropertyType;
	}

	@Override
	public PointArrayPropertyType getJAXBObject() {
		return pointArayPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.POINTARRAYPROPERTY;
	}

	public List<Point> getPoint() {
		List<Point> pointList = new ArrayList<Point>();

		for (PointType pointType : pointArayPropertyType.getPoint())
			pointList.add(new PointImpl(pointType));

		return pointList;
	}

	public void addPoint(Point point) {
		pointArayPropertyType.getPoint().add(((PointImpl)point).getJAXBObject());
	}

	public boolean isSetPoint() {
		return pointArayPropertyType.isSetPoint();
	}

	public void setPoint(List<Point> point) {
		List<PointType> pointTypeList = new ArrayList<PointType>();

		for (Point elem : point)
			pointTypeList.add(((PointImpl)elem).getJAXBObject());

		pointArayPropertyType.unsetPoint();
		pointArayPropertyType.getPoint().addAll(pointTypeList);
	}

	public void unsetPoint() {
		pointArayPropertyType.unsetPoint();
	}

	public boolean unsetPoint(Point point) {
		if (pointArayPropertyType.isSetPoint())
			return pointArayPropertyType.getPoint().remove(((PointImpl)point).getJAXBObject());
		
		return false;
	}

}
