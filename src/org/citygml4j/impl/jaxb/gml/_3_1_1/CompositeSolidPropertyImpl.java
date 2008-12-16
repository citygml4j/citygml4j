package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.CompositeSolidPropertyType;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSolidProperty;
import org.citygml4j.model.gml.GMLClass;

public class CompositeSolidPropertyImpl extends GMLBaseImpl implements CompositeSolidProperty {
	CompositeSolidPropertyType compositeSolidPropertyType;

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

	@Override
	public CompositeSolid getCompositeSolid() {
		if (compositeSolidPropertyType.isSetCompositeSolid())
			return new CompositeSolidImpl(compositeSolidPropertyType.getCompositeSolid());

		return null;
	}

	@Override
	public String getActuate() {
		return compositeSolidPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return compositeSolidPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return compositeSolidPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return compositeSolidPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return compositeSolidPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return compositeSolidPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return compositeSolidPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return compositeSolidPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		compositeSolidPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		compositeSolidPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		compositeSolidPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		compositeSolidPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		compositeSolidPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		compositeSolidPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		compositeSolidPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		compositeSolidPropertyType.setType(type);
	}

	@Override
	public void setCompositeSolid(CompositeSolid compositeSolid) {
		compositeSolidPropertyType.setCompositeSolid(((CompositeSolidImpl)compositeSolid).getJAXBObject());
	}

	@Override
	public boolean isSetActuate() {
		return compositeSolidPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return compositeSolidPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return compositeSolidPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return compositeSolidPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return compositeSolidPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return compositeSolidPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return compositeSolidPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return compositeSolidPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		compositeSolidPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		compositeSolidPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		compositeSolidPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		compositeSolidPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		compositeSolidPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		compositeSolidPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		compositeSolidPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		compositeSolidPropertyType.setType(null);
	}

	@Override
	public boolean isSetCompositeSolid() {
		return compositeSolidPropertyType.isSetCompositeSolid();
	}

	@Override
	public void unsetCompositeSolid() {
		compositeSolidPropertyType.setCompositeSolid(null);
	}
	
}
