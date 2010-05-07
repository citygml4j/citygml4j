package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.CompositeCurvePropertyType;
import org.citygml4j.model.gml.CompositeCurve;
import org.citygml4j.model.gml.CompositeCurveProperty;
import org.citygml4j.model.gml.GMLClass;

public class CompositeCurvePropertyImpl extends GMLBaseImpl implements	CompositeCurveProperty {
	private CompositeCurvePropertyType compositeCurvePropertyType;

	public CompositeCurvePropertyImpl() {
		compositeCurvePropertyType = new CompositeCurvePropertyType();
	}
	
	public CompositeCurvePropertyImpl(CompositeCurvePropertyType compositeCurvePropertyType) {
		this.compositeCurvePropertyType = compositeCurvePropertyType;
	}

	@Override
	public CompositeCurvePropertyType getJAXBObject() {
		return compositeCurvePropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITECURVEPROPERTY;
	}

	public CompositeCurve getCompositeCurve() {
		if (compositeCurvePropertyType.isSetCompositeCurve())
			return new CompositeCurveImpl(compositeCurvePropertyType.getCompositeCurve());

		return null;
	}

	public String getActuate() {
		return compositeCurvePropertyType.getActuate();
	}

	public String getArcrole() {
		return compositeCurvePropertyType.getArcrole();
	}

	public String getHref() {
		return compositeCurvePropertyType.getHref();
	}

	public String getRemoteSchema() {
		return compositeCurvePropertyType.getRemoteSchema();
	}

	public String getRole() {
		return compositeCurvePropertyType.getRole();
	}

	public String getShow() {
		return compositeCurvePropertyType.getShow();
	}

	public String getTitle() {
		return compositeCurvePropertyType.getTitle();
	}

	public String getType() {
		return compositeCurvePropertyType.getType();
	}

	public void setActuate(String actuate) {
		compositeCurvePropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		compositeCurvePropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		compositeCurvePropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		compositeCurvePropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		compositeCurvePropertyType.setRole(role);
	}

	public void setShow(String show) {
		compositeCurvePropertyType.setShow(show);
	}

	public void setTitle(String title) {
		compositeCurvePropertyType.setTitle(title);
	}

	public void setType(String type) {
		compositeCurvePropertyType.setType(type);
	}

	public boolean isSetActuate() {
		return compositeCurvePropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return compositeCurvePropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return compositeCurvePropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return compositeCurvePropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return compositeCurvePropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return compositeCurvePropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return compositeCurvePropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return compositeCurvePropertyType.isSetType();
	}

	public void unsetActuate() {
		compositeCurvePropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		compositeCurvePropertyType.setArcrole(null);
	}

	public void unsetHref() {
		compositeCurvePropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		compositeCurvePropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		compositeCurvePropertyType.setRole(null);
	}

	public void unsetShow() {
		compositeCurvePropertyType.setShow(null);
	}

	public void unsetTitle() {
		compositeCurvePropertyType.setTitle(null);
	}

	public void unsetType() {
		compositeCurvePropertyType.setType(null);
	}

	public boolean isSetCompositeCurve() {
		return compositeCurvePropertyType.isSetCompositeCurve();
	}

	public void setCompositeCurve(CompositeCurve compositeCurve) {
		compositeCurvePropertyType.setCompositeCurve(((CompositeCurveImpl)compositeCurve).getJAXBObject());
	}

	public void unsetCompositeCurve() {
		compositeCurvePropertyType.setCompositeCurve(null);
	}
	
	
}
