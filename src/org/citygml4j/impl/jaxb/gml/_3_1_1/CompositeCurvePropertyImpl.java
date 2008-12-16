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

	@Override
	public CompositeCurve getCompositeCurve() {
		if (compositeCurvePropertyType.isSetCompositeCurve())
			return new CompositeCurveImpl(compositeCurvePropertyType.getCompositeCurve());

		return null;
	}

	@Override
	public String getActuate() {
		return compositeCurvePropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return compositeCurvePropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return compositeCurvePropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return compositeCurvePropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return compositeCurvePropertyType.getRole();
	}

	@Override
	public String getShow() {
		return compositeCurvePropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return compositeCurvePropertyType.getTitle();
	}

	@Override
	public String getType() {
		return compositeCurvePropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		compositeCurvePropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		compositeCurvePropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		compositeCurvePropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		compositeCurvePropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		compositeCurvePropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		compositeCurvePropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		compositeCurvePropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		compositeCurvePropertyType.setType(type);
	}

	@Override
	public boolean isSetActuate() {
		return compositeCurvePropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return compositeCurvePropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return compositeCurvePropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return compositeCurvePropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return compositeCurvePropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return compositeCurvePropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return compositeCurvePropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return compositeCurvePropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		compositeCurvePropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		compositeCurvePropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		compositeCurvePropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		compositeCurvePropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		compositeCurvePropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		compositeCurvePropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		compositeCurvePropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		compositeCurvePropertyType.setType(null);
	}

	@Override
	public boolean isSetCompositeCurve() {
		return compositeCurvePropertyType.isSetCompositeCurve();
	}

	@Override
	public void setCompositeCurve(CompositeCurve compositeCurve) {
		compositeCurvePropertyType.setCompositeCurve(((CompositeCurveImpl)compositeCurve).getJAXBObject());
	}

	@Override
	public void unsetCompositeCurve() {
		compositeCurvePropertyType.setCompositeCurve(null);
	}
	
	
}
