package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractCurveType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeCurveType;
import org.citygml4j.jaxb.gml._3_1_1.CurveArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.CurveType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringType;
import org.citygml4j.jaxb.gml._3_1_1.OrientableCurveType;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.CurveArrayProperty;
import org.citygml4j.model.gml.GMLClass;

public class CurveArrayPropertyImpl extends GMLBaseImpl implements	CurveArrayProperty {
	private CurveArrayPropertyType curveArrayPropertyType;

	public CurveArrayPropertyImpl() {
		curveArrayPropertyType = new CurveArrayPropertyType();
	}

	public CurveArrayPropertyImpl(CurveArrayPropertyType curveArrayPropertyType) {
		this.curveArrayPropertyType = curveArrayPropertyType;
	}

	@Override
	public CurveArrayPropertyType getJAXBObject() {
		return curveArrayPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.CURVEARRAYPROPERTY;
	}

	@Override
	public List<AbstractCurve> getCurve() {
		List<AbstractCurve> abstractCurveList = new ArrayList<AbstractCurve>();

		for (JAXBElement<? extends AbstractCurveType> abstractCurveType : curveArrayPropertyType.get_Curve()) {
			if (abstractCurveType.getValue() != null) {
				if (abstractCurveType.getValue() instanceof LineStringType)
					abstractCurveList.add(new LineStringImpl((LineStringType)abstractCurveType.getValue()));
				else if (abstractCurveType.getValue() instanceof CompositeCurveType)
					abstractCurveList.add(new CompositeCurveImpl((CompositeCurveType)abstractCurveType.getValue()));
				else if (abstractCurveType.getValue() instanceof OrientableCurveType)
					abstractCurveList.add(new OrientableCurveImpl((OrientableCurveType)abstractCurveType.getValue()));
				else if (abstractCurveType.getValue() instanceof CurveType)
					abstractCurveList.add(new CurveImpl((CurveType)abstractCurveType.getValue()));
			}
		}

		return abstractCurveList;
	}

	@Override
	public void addCurve(AbstractCurve abstractCurve) {
		JAXBElement<? extends AbstractCurveType> jaxbElem = null;

		switch (abstractCurve.getGMLClass()) {
		case LINESTRING:
			jaxbElem = ObjectFactory.GML.createLineString(((LineStringImpl)abstractCurve).getJAXBObject());
			break;
		case COMPOSITECURVE:
			jaxbElem = ObjectFactory.GML.createCompositeCurve(((CompositeCurveImpl)abstractCurve).getJAXBObject());
			break;
		case ORIENTABLECURVE:
			jaxbElem = ObjectFactory.GML.createOrientableCurve(((OrientableCurveImpl)abstractCurve).getJAXBObject());
			break;
		case CURVE:
			jaxbElem = ObjectFactory.GML.createCurve(((CurveImpl)abstractCurve).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			curveArrayPropertyType.get_Curve().add(jaxbElem);
	}

	@Override
	public boolean isSetCurve() {
		return curveArrayPropertyType.isSet_Curve();
	}

	@Override
	public void setCurve(List<AbstractCurve> abstractCurve) {
		List<JAXBElement<? extends AbstractCurveType>> jaxbElemList = new ArrayList<JAXBElement<? extends AbstractCurveType>>();

		for (AbstractCurve curve : abstractCurve) {
			JAXBElement<? extends AbstractCurveType> jaxbElem = null;

			switch (curve.getGMLClass()) {
			case LINESTRING:
				jaxbElem = ObjectFactory.GML.createLineString(((LineStringImpl)abstractCurve).getJAXBObject());
				break;
			case COMPOSITECURVE:
				jaxbElem = ObjectFactory.GML.createCompositeCurve(((CompositeCurveImpl)abstractCurve).getJAXBObject());
				break;
			case ORIENTABLECURVE:
				jaxbElem = ObjectFactory.GML.createOrientableCurve(((OrientableCurveImpl)abstractCurve).getJAXBObject());
				break;
			case CURVE:
				jaxbElem = ObjectFactory.GML.createCurve(((CurveImpl)abstractCurve).getJAXBObject());
				break;
			}

			if (jaxbElem != null)
				jaxbElemList.add(jaxbElem);
		}

		if (!jaxbElemList.isEmpty()) {
			curveArrayPropertyType.unset_Curve();
			curveArrayPropertyType.get_Curve().addAll(jaxbElemList);
		}
	}

	@Override
	public void unsetCurve() {
		curveArrayPropertyType.unset_Curve();
	}

	@Override
	public boolean unsetCurve(AbstractCurve abstractCurve) {
		if (curveArrayPropertyType.isSet_Curve())
			return curveArrayPropertyType.get_Curve().remove(((AbstractCurveImpl)abstractCurve).getJAXBObject());
		
		return false;
	}

	
}
