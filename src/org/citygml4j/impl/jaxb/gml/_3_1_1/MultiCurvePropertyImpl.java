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

	@Override
	public MultiCurve getMultiCurve() {
		if (multiCurvePropertyType.isSetMultiCurve())
			return new MultiCurveImpl(multiCurvePropertyType.getMultiCurve());

		return null;
	}

	@Override
	public void setMultiCurve(MultiCurve multiCurve) {
		multiCurvePropertyType.setMultiCurve(((MultiCurveImpl)multiCurve).getJAXBObject());
	}

	@Override
	public String getActuate() {
		return multiCurvePropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return multiCurvePropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return multiCurvePropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return multiCurvePropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return multiCurvePropertyType.getRole();
	}

	@Override
	public String getShow() {
		return multiCurvePropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return multiCurvePropertyType.getTitle();
	}

	@Override
	public String getType() {
		return multiCurvePropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		multiCurvePropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		multiCurvePropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		multiCurvePropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		multiCurvePropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		multiCurvePropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		multiCurvePropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		multiCurvePropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		multiCurvePropertyType.setType(type);
	}
	
	@Override
	public boolean isSetActuate() {
		return multiCurvePropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return multiCurvePropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return multiCurvePropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return multiCurvePropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return multiCurvePropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return multiCurvePropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return multiCurvePropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return multiCurvePropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		multiCurvePropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		multiCurvePropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		multiCurvePropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		multiCurvePropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		multiCurvePropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		multiCurvePropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		multiCurvePropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		multiCurvePropertyType.setType(null);
	}

	@Override
	public boolean isSetMultiCurve() {
		return multiCurvePropertyType.isSetMultiCurve();
	}

	@Override
	public void unsetMultiCurve() {
		multiCurvePropertyType.setMultiCurve(null);
	}
	
}
