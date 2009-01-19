package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.CompositeCurveType;
import org.citygml4j.jaxb.gml._3_1_1.CurvePropertyType;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.CompositeCurve;
import org.citygml4j.model.gml.CurveProperty;
import org.citygml4j.model.gml.GMLClass;

public class CompositeCurveImpl extends AbstractCurveImpl implements CompositeCurve {
	private CompositeCurveType compositeCurveType;

	public CompositeCurveImpl() {
		this(new CompositeCurveType());
	}

	public CompositeCurveImpl(CompositeCurveType compositeCurveType) {
		super(compositeCurveType);
		this.compositeCurveType = compositeCurveType;
	}

	@Override
	public CompositeCurveType getJAXBObject() {
		return compositeCurveType;
	}

	@Override
	public List<CurveProperty> getCurveMember() {
		List<CurveProperty> curvePropertyList = new ArrayList<CurveProperty>();

		for (CurvePropertyType curvePropertyType : compositeCurveType.getCurveMember())
			curvePropertyList.add(new CurvePropertyImpl(curvePropertyType));

		return curvePropertyList;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITECURVE;
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (isSetCurveMember()) {
			for (CurveProperty curvePropery : getCurveMember()) {
				AbstractCurve abstractCurve = curvePropery.getCurve();
				if (abstractCurve != null)
					abstractCurve.calcBoundingBox(min, max);
			}
		}
	}

	@Override
	public void addCurveMember(CurveProperty curveMember) {
		compositeCurveType.getCurveMember().add(((CurvePropertyImpl)curveMember).getJAXBObject());
	}

	@Override
	public boolean isSetCurveMember() {
		return compositeCurveType.isSetCurveMember();
	}

	@Override
	public void setCurveMember(List<CurveProperty> curveMember) {
		List<CurvePropertyType> curvePropList = new ArrayList<CurvePropertyType>();

		for (CurveProperty curve : curveMember)
			curvePropList.add(((CurvePropertyImpl)curve).getJAXBObject());

		compositeCurveType.unsetCurveMember();
		compositeCurveType.getCurveMember().addAll(curvePropList);
	}

	@Override
	public void unsetCurveMember() {
		compositeCurveType.unsetCurveMember();
	}

	@Override
	public boolean unsetCurveMember(CurveProperty curveMember) {
		if (compositeCurveType.isSetCurveMember())
			return compositeCurveType.getCurveMember().remove(((CurvePropertyImpl)curveMember).getJAXBObject());
		
		return false;
	}

}
