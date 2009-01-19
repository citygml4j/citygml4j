package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.CurvePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiCurveType;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.CurveArrayProperty;
import org.citygml4j.model.gml.CurveProperty;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiCurve;

public class MultiCurveImpl extends AbstractGeometricAggregateImpl implements MultiCurve {
	private MultiCurveType multiCurveType;

	public MultiCurveImpl() {
		this(new MultiCurveType());
	}

	public MultiCurveImpl(MultiCurveType multiCurveType) {
		super(multiCurveType);
		this.multiCurveType = multiCurveType;
	}

	@Override
	public MultiCurveType getJAXBObject() {
		return multiCurveType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTICURVE;
	}

	@Override
	public List<CurveProperty> getCurveMember() {
		List<CurveProperty> curvePropertyList = new ArrayList<CurveProperty>();

		for (CurvePropertyType curvePropertyType : multiCurveType.getCurveMember())
			curvePropertyList.add(new CurvePropertyImpl(curvePropertyType));

		return curvePropertyList;
	}

	@Override
	public CurveArrayProperty getCurveMembers() {
		if (multiCurveType.isSetCurveMembers())
			return new CurveArrayPropertyImpl(multiCurveType.getCurveMembers());

		return null;
	}

	@Override
	public void addCurveMember(CurveProperty curveMember) {
		multiCurveType.getCurveMember().add(((CurvePropertyImpl)curveMember).getJAXBObject());
	}

	@Override
	public void setCurveMember(List<CurveProperty> curveMember) {
		List<CurvePropertyType> curvePropertyTypeList = new ArrayList<CurvePropertyType>();

		for (CurveProperty curveProperty : curveMember) 
			curvePropertyTypeList.add(((CurvePropertyImpl)curveProperty).getJAXBObject());

		multiCurveType.unsetCurveMember();
		multiCurveType.getCurveMember().addAll(curvePropertyTypeList);
	}

	@Override
	public void setCurveMembers(CurveArrayProperty curveMembers) {
		multiCurveType.setCurveMembers(((CurveArrayPropertyImpl)curveMembers).getJAXBObject());
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (isSetCurveMember()) {
			for (CurveProperty curveProperty : getCurveMember()) {
				AbstractCurve abstractCurve = curveProperty.getCurve();
				if (abstractCurve != null)
					abstractCurve.calcBoundingBox(min, max);
			}
		}

		if (isSetCurveMembers()) {
			CurveArrayProperty curveArrayProperty = getCurveMembers();

			if (curveArrayProperty.isSetCurve()) {
				for (AbstractCurve abstractCurve : curveArrayProperty.getCurve()) {
					abstractCurve.calcBoundingBox(min, max);
				}
			}
		}
	}

	@Override
	public boolean isSetCurveMember() {
		return multiCurveType.isSetCurveMember();
	}

	@Override
	public boolean isSetCurveMembers() {
		return multiCurveType.isSetCurveMembers();
	}

	@Override
	public void unsetCurveMember() {
		multiCurveType.unsetCurveMember();
	}

	@Override
	public void unsetCurveMembers() {
		multiCurveType.setCurveMembers(null);
	}

	@Override
	public boolean unsetCurveMember(CurveProperty curveMember) {
		if (multiCurveType.isSetCurveMember())
			return multiCurveType.getCurveMember().remove(((CurvePropertyImpl)curveMember).getJAXBObject());
		
		return false;
	}

}
