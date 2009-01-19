package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.MultiPointType;
import org.citygml4j.jaxb.gml._3_1_1.PointPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiPoint;
import org.citygml4j.model.gml.Point;
import org.citygml4j.model.gml.PointArrayProperty;
import org.citygml4j.model.gml.PointProperty;

public class MultiPointImpl extends AbstractGeometricAggregateImpl implements MultiPoint {
	private MultiPointType multiPointType;

	public MultiPointImpl() {
		this(new MultiPointType());
	}

	public MultiPointImpl(MultiPointType multiPointType) {
		super(multiPointType);
		this.multiPointType = multiPointType;
	}

	@Override
	public MultiPointType getJAXBObject() {
		return multiPointType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTIPOINT;
	}

	@Override
	public List<PointProperty> getPointMember() {
		List<PointProperty> pointPropertyList = new ArrayList<PointProperty>();

		for (PointPropertyType pointPropertyType : multiPointType.getPointMember())
			pointPropertyList.add(new PointPropertyImpl(pointPropertyType));

		return pointPropertyList;
	}

	@Override
	public PointArrayProperty getPointMembers() {
		if (multiPointType.isSetPointMembers())
			return new PointArrayPropertyImpl(multiPointType.getPointMembers());

		return null;
	}

	@Override
	public void calcBoundingBox(org.citygml4j.geometry.Point min, org.citygml4j.geometry.Point max) {
		if (isSetPointMember()) {
			for (PointProperty pointProperty : getPointMember()) {
				Point point = pointProperty.getPoint();
				if (point != null)
					point.calcBoundingBox(min, max);
			}
		}

		if (isSetPointMembers()) {
			PointArrayProperty pointArrayProperty = getPointMembers();

			if (pointArrayProperty.isSetPoint()) {
				for (Point point : pointArrayProperty.getPoint()) {
					point.calcBoundingBox(min, max);
				}
			}
		}
	}

	@Override
	public void addPointMember(PointProperty pointMember) {
		multiPointType.getPointMember().add(((PointPropertyImpl)pointMember).getJAXBObject());
	}

	@Override
	public void setPointMember(List<PointProperty> pointMember) {
		List<PointPropertyType> pointPropertyList = new ArrayList<PointPropertyType>();

		for (PointProperty pointProperty : pointMember)
			pointPropertyList.add(((PointPropertyImpl)pointProperty).getJAXBObject());

		multiPointType.unsetPointMember();
		multiPointType.getPointMember().addAll(pointPropertyList);
	}

	@Override
	public void setPointMembers(PointArrayProperty pointMembers) {
		multiPointType.setPointMembers(((PointArrayPropertyImpl)pointMembers).getJAXBObject());
	}

	@Override
	public boolean isSetPointMember() {
		return multiPointType.isSetPointMember();
	}

	@Override
	public boolean isSetPointMembers() {
		return multiPointType.isSetPointMembers();
	}

	@Override
	public void unsetPointMember() {
		multiPointType.unsetPointMember();
	}

	@Override
	public void unsetPointMembers() {
		multiPointType.setPointMembers(null);
	}

	@Override
	public boolean unsetPointMember(PointProperty pointMember) {
		if (multiPointType.isSetPointMember())
			return multiPointType.getPointMember().remove(((PointPropertyImpl)pointMember).getJAXBObject());
		
		return false;
	}

}
