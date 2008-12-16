package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.OrientableCurveType;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.CurveProperty;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.OrientableCurve;

public class OrientableCurveImpl extends AbstractCurveImpl implements OrientableCurve {
	private OrientableCurveType orientableCurveType;
	
	public OrientableCurveImpl() {
		this(new OrientableCurveType());
	}
	
	public OrientableCurveImpl(OrientableCurveType orientableCurveType) {
		super(orientableCurveType);
		this.orientableCurveType = orientableCurveType;
	}
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ORIENTABLECURVE;
	}

	@Override
	public OrientableCurveType getJAXBObject() {
		return orientableCurveType;
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (getBaseCurve() != null) {
			CurveProperty curveProperty = getBaseCurve();
			AbstractCurve abstractCurve = curveProperty.getCurve();
			if (abstractCurve != null)
				abstractCurve.calcBoundingBox(min, max);
		}
	}

	@Override
	public CurveProperty getBaseCurve() {
		if (orientableCurveType.isSetBaseCurve())
			return new CurvePropertyImpl(orientableCurveType.getBaseCurve());
		
		return null;
	}

	@Override
	public String getOrientation() {
		return orientableCurveType.getOrientation();
	}

	@Override
	public boolean isSetBaseCurve() {
		return orientableCurveType.isSetBaseCurve();
	}

	@Override
	public boolean isSetOrientation() {
		return orientableCurveType.isSetOrientation();
	}

	@Override
	public void setBaseCurve(CurveProperty baseCurve) {
		orientableCurveType.setBaseCurve(((CurvePropertyImpl)baseCurve).getJAXBObject());
	}

	@Override
	public void setOrientation(String orientation) {
		orientableCurveType.setOrientation(orientation);
	}

	@Override
	public void unsetBaseCurve() {
		orientableCurveType.setBaseCurve(null);
	}

	@Override
	public void unsetOrientation() {
		orientableCurveType.setOrientation(null);
	}

}
