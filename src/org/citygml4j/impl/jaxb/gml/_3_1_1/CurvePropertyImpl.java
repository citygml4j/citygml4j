package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractCurveType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeCurveType;
import org.citygml4j.jaxb.gml._3_1_1.CurvePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.CurveType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringType;
import org.citygml4j.jaxb.gml._3_1_1.OrientableCurveType;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.CurveProperty;
import org.citygml4j.model.gml.GMLClass;

public class CurvePropertyImpl extends GMLBaseImpl implements CurveProperty {
	private CurvePropertyType curvePropertyType;

	public CurvePropertyImpl() {
		curvePropertyType = new CurvePropertyType();
	}
	
	public CurvePropertyImpl(CurvePropertyType curvePropertyType) {
		this.curvePropertyType = curvePropertyType;
	}

	@Override
	public CurvePropertyType getJAXBObject() {
		return curvePropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.CURVEPROPERTY;
	}

	@Override
	public AbstractCurve getCurve() {
		if (curvePropertyType.isSet_Curve()) {
			JAXBElement<? extends AbstractCurveType> abstractCurveType = curvePropertyType.get_Curve();
			if (abstractCurveType.getValue() != null) {
				if (abstractCurveType.getValue() instanceof LineStringType)
					return new LineStringImpl((LineStringType)abstractCurveType.getValue());
				else if (abstractCurveType.getValue() instanceof CompositeCurveType)
					return new CompositeCurveImpl((CompositeCurveType)abstractCurveType.getValue());
				else if (abstractCurveType.getValue() instanceof OrientableCurveType)
					return new OrientableCurveImpl((OrientableCurveType)abstractCurveType.getValue());
				else if (abstractCurveType.getValue() instanceof CurveType)
					return new CurveImpl((CurveType)abstractCurveType.getValue());
			}
		}

		return null;
	}

	@Override
	public void setCurve(AbstractCurve curve) {
		JAXBElement<? extends AbstractCurveType> jaxbElem = null;
		
		switch (curve.getGMLClass()) {
		case LINESTRING:
			jaxbElem = ObjectFactory.GML.createLineString(((LineStringImpl)curve).getJAXBObject());
			break;
		case COMPOSITECURVE:
			jaxbElem = ObjectFactory.GML.createCompositeCurve(((CompositeCurveImpl)curve).getJAXBObject());
			break;
		case ORIENTABLECURVE:
			jaxbElem = ObjectFactory.GML.createOrientableCurve(((OrientableCurveImpl)curve).getJAXBObject());
			break;
		case CURVE:
			jaxbElem = ObjectFactory.GML.createCurve(((CurveImpl)curve).getJAXBObject());
			break;
		}
		
		if (jaxbElem != null)
			curvePropertyType.set_Curve(jaxbElem);
	}

	@Override
	public String getActuate() {
		return curvePropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return curvePropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return curvePropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return curvePropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return curvePropertyType.getRole();
	}

	@Override
	public String getShow() {
		return curvePropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return curvePropertyType.getTitle();
	}

	@Override
	public String getType() {
		return curvePropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		curvePropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		curvePropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		curvePropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		curvePropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		curvePropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		curvePropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		curvePropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		curvePropertyType.setType(type);
	}
	
	@Override
	public boolean isSetActuate() {
		return curvePropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return curvePropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return curvePropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return curvePropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return curvePropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return curvePropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return curvePropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return curvePropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		curvePropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		curvePropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		curvePropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		curvePropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		curvePropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		curvePropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		curvePropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		curvePropertyType.setType(null);
	}

	@Override
	public boolean isSetCurve() {
		return curvePropertyType.isSet_Curve();
	}

	@Override
	public void unsetCurve() {
		curvePropertyType.set_Curve(null);
	}
	
}
