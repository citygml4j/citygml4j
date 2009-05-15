package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.CompositeSolidPropertyType;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSolidProperty;
import org.citygml4j.model.gml.GMLClass;

public class CompositeSolidPropertyImpl extends GMLBaseImpl implements CompositeSolidProperty {
	private CompositeSolidPropertyType compositeSolidPropertyType;

	public CompositeSolidPropertyImpl() {
		compositeSolidPropertyType = new CompositeSolidPropertyType();
	}

	public CompositeSolidPropertyImpl(CompositeSolidPropertyType compositeSolidPropertyType) {
		this.compositeSolidPropertyType = compositeSolidPropertyType;
	}

	@Override
	public CompositeSolidPropertyType getJAXBObject() {
		return compositeSolidPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITESOLIDPROPERTY;
	}

	public CompositeSolid getCompositeSolid() {
		if (compositeSolidPropertyType.isSetCompositeSolid())
			return new CompositeSolidImpl(compositeSolidPropertyType.getCompositeSolid());

		return null;
	}

	public String getActuate() {
		return compositeSolidPropertyType.getActuate();
	}

	public String getArcrole() {
		return compositeSolidPropertyType.getArcrole();
	}

	public String getHref() {
		return compositeSolidPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return compositeSolidPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return compositeSolidPropertyType.getRole();
	}

	public String getShow() {
		return compositeSolidPropertyType.getShow();
	}

	public String getTitle() {
		return compositeSolidPropertyType.getTitle();
	}

	public String getType() {
		return compositeSolidPropertyType.getType();
	}

	public void setActuate(String actuate) {
		compositeSolidPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		compositeSolidPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		compositeSolidPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		compositeSolidPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		compositeSolidPropertyType.setRole(role);
	}

	public void setShow(String show) {
		compositeSolidPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		compositeSolidPropertyType.setTitle(title);
	}

	public void setType(String type) {
		compositeSolidPropertyType.setType(type);
	}

	public void setCompositeSolid(CompositeSolid compositeSolid) {
		compositeSolidPropertyType.setCompositeSolid(((CompositeSolidImpl)compositeSolid).getJAXBObject());
	}

	public boolean isSetActuate() {
		return compositeSolidPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return compositeSolidPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return compositeSolidPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return compositeSolidPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return compositeSolidPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return compositeSolidPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return compositeSolidPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return compositeSolidPropertyType.isSetType();
	}

	public void unsetActuate() {
		compositeSolidPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		compositeSolidPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		compositeSolidPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		compositeSolidPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		compositeSolidPropertyType.setRole(null);
	}

	public void unsetShow() {
		compositeSolidPropertyType.setShow(null);
	}

	public void unsetTitle() {
		compositeSolidPropertyType.setTitle(null);
	}

	public void unsetType() {
		compositeSolidPropertyType.setType(null);
	}

	public boolean isSetCompositeSolid() {
		return compositeSolidPropertyType.isSetCompositeSolid();
	}

	public void unsetCompositeSolid() {
		compositeSolidPropertyType.setCompositeSolid(null);
	}
	
}
