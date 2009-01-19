package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.DirectPositionType;
import org.citygml4j.jaxb.gml._3_1_1.PointPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.TinType;
import org.citygml4j.model.gml.ControlPoint;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GeometricPositionGroup;

public class ControlPointImpl extends GMLBaseImpl implements ControlPoint {
	private TinType.ControlPoint controlPoint;

	public ControlPointImpl() {
		controlPoint = new TinType.ControlPoint();
	}

	public ControlPointImpl(TinType.ControlPoint controlPoint) {
		this.controlPoint = controlPoint;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.CONTROLPOINT;
	}

	@Override
	public TinType.ControlPoint getJAXBObject() {
		return controlPoint;
	}

	@Override
	public void addGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup) {
		controlPoint.getGeometricPositionGroup().add(((GeometricPositionGroupImpl)geometricPositionGroup).getJAXBObject());
	}

	@Override
	public List<GeometricPositionGroup> getGeometricPositionGroup() {
		List<GeometricPositionGroup> group = new ArrayList<GeometricPositionGroup>();

		for (Object object : controlPoint.getGeometricPositionGroup()) {
			if (object instanceof DirectPositionType)
				group.add(new GeometricPositionGroupImpl((DirectPositionType)object));
			else if (object instanceof PointPropertyType)
				group.add(new GeometricPositionGroupImpl((PointPropertyType)object));
		}

		return group;
	}

	@Override
	public DirectPositionList getPosList() {
		if (controlPoint.isSetPosList())
			return new DirectPositionListImpl(controlPoint.getPosList());

		return null;
	}

	@Override
	public void setGeometricPositionGroup(List<GeometricPositionGroup> geometricPositionGroup) {
		List<Object> objectGroup = new ArrayList<Object>();

		for (GeometricPositionGroup group : geometricPositionGroup)
			objectGroup.add(((GeometricPositionGroupImpl)group).getJAXBObject());

		controlPoint.unsetGeometricPositionGroup();
		controlPoint.getGeometricPositionGroup().addAll(objectGroup);
	}

	@Override
	public void setPosList(DirectPositionList posList) {
		controlPoint.setPosList(((DirectPositionListImpl)posList).getJAXBObject());
	}

	@Override
	public boolean isSetGeometricPositionGroup() {
		return controlPoint.isSetGeometricPositionGroup();
	}

	@Override
	public boolean isSetPosList() {
		return controlPoint.isSetPosList();
	}

	@Override
	public void unsetGeometricPositionGroup() {
		controlPoint.unsetGeometricPositionGroup();
	}

	@Override
	public void unsetPosList() {
		controlPoint.setPosList(null);
	}

	@Override
	public boolean unsetGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup) {
		if (controlPoint.isSetGeometricPositionGroup())
			return controlPoint.getGeometricPositionGroup().remove(((GeometricPositionGroupImpl)geometricPositionGroup).getJAXBObject());

		return false;
	}

}
