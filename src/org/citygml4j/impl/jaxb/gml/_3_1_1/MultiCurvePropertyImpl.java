package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.MultiCurvePropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiCurve;
import org.citygml4j.model.gml.MultiCurveProperty;

public class MultiCurvePropertyImpl extends GMLBaseImpl implements MultiCurveProperty {
	private MultiCurvePropertyType multiCurvePropertyType;

	public MultiCurvePropertyImpl() {
		multiCurvePropertyType = new MultiCurvePropertyType();
	}
	
	public MultiCurvePropertyImpl(MultiCurvePropertyType multiCurvePropertyType) {
		this.multiCurvePropertyType = multiCurvePropertyType;
	}

	@Override
	public MultiCurvePropertyType getJAXBObject() {
		return multiCurvePropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTICURVEPROPERTY;
	}

	public MultiCurve getMultiCurve() {
		if (multiCurvePropertyType.isSetMultiCurve())
			return new MultiCurveImpl(multiCurvePropertyType.getMultiCurve());

		return null;
	}

	public void setMultiCurve(MultiCurve multiCurve) {
		multiCurvePropertyType.setMultiCurve(((MultiCurveImpl)multiCurve).getJAXBObject());
	}

	public String getActuate() {
		return multiCurvePropertyType.getActuate();
	}

	public String getArcrole() {
		return multiCurvePropertyType.getArcrole();
	}

	public String getHref() {
		return multiCurvePropertyType.getHref();
	}

	public String getRemoteSchema() {
		return multiCurvePropertyType.getRemoteSchema();
	}

	public String getRole() {
		return multiCurvePropertyType.getRole();
	}

	public String getShow() {
		return multiCurvePropertyType.getShow();
	}

	public String getTitle() {
		return multiCurvePropertyType.getTitle();
	}

	public String getType() {
		return multiCurvePropertyType.getType();
	}

	public void setActuate(String actuate) {
		multiCurvePropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		multiCurvePropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		multiCurvePropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		multiCurvePropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		multiCurvePropertyType.setRole(role);
	}

	public void setShow(String show) {
		multiCurvePropertyType.setShow(show);
	}

	public void setTitle(String title) {
		multiCurvePropertyType.setTitle(title);
	}

	public void setType(String type) {
		multiCurvePropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return multiCurvePropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return multiCurvePropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return multiCurvePropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return multiCurvePropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return multiCurvePropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return multiCurvePropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return multiCurvePropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return multiCurvePropertyType.isSetType();
	}

	public void unsetActuate() {
		multiCurvePropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		multiCurvePropertyType.setArcrole(null);
	}

	public void unsetHref() {
		multiCurvePropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		multiCurvePropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		multiCurvePropertyType.setRole(null);
	}

	public void unsetShow() {
		multiCurvePropertyType.setShow(null);
	}

	public void unsetTitle() {
		multiCurvePropertyType.setTitle(null);
	}

	public void unsetType() {
		multiCurvePropertyType.setType(null);
	}

	public boolean isSetMultiCurve() {
		return multiCurvePropertyType.isSetMultiCurve();
	}

	public void unsetMultiCurve() {
		multiCurvePropertyType.setMultiCurve(null);
	}
	
}
