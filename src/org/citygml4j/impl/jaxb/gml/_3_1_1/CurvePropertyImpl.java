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

	public String getActuate() {
		return curvePropertyType.getActuate();
	}

	public String getArcrole() {
		return curvePropertyType.getArcrole();
	}

	public String getHref() {
		return curvePropertyType.getHref();
	}

	public String getRemoteSchema() {
		return curvePropertyType.getRemoteSchema();
	}

	public String getRole() {
		return curvePropertyType.getRole();
	}

	public String getShow() {
		return curvePropertyType.getShow();
	}

	public String getTitle() {
		return curvePropertyType.getTitle();
	}

	public String getType() {
		return curvePropertyType.getType();
	}

	public void setActuate(String actuate) {
		curvePropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		curvePropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		curvePropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		curvePropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		curvePropertyType.setRole(role);
	}

	public void setShow(String show) {
		curvePropertyType.setShow(show);
	}

	public void setTitle(String title) {
		curvePropertyType.setTitle(title);
	}

	public void setType(String type) {
		curvePropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return curvePropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return curvePropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return curvePropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return curvePropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return curvePropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return curvePropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return curvePropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return curvePropertyType.isSetType();
	}

	public void unsetActuate() {
		curvePropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		curvePropertyType.setArcrole(null);
	}

	public void unsetHref() {
		curvePropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		curvePropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		curvePropertyType.setRole(null);
	}

	public void unsetShow() {
		curvePropertyType.setShow(null);
	}

	public void unsetTitle() {
		curvePropertyType.setTitle(null);
	}

	public void unsetType() {
		curvePropertyType.setType(null);
	}

	public boolean isSetCurve() {
		return curvePropertyType.isSet_Curve();
	}

	public void unsetCurve() {
		curvePropertyType.set_Curve(null);
	}
	
}
