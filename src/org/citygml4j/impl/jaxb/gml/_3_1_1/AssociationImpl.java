package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AssociationType;
import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.Association;
import org.citygml4j.model.gml.GMLClass;

public abstract class AssociationImpl<T extends AbstractGML> extends GMLBaseImpl implements Association<T> {
	private AssociationType associationType;
		
	public AssociationImpl(AssociationType associationType) {
		this.associationType = associationType;
	}
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ASSOCIATION;
	}

	@Override
	public AssociationType getJAXBObject() {
		return associationType;
	}

	@Override
	public boolean isSetObject() {
		return associationType.isSet_Object();
	}

	@Override
	public void unsetObject() {
		associationType.set_Object(null);
	}

	@Override
	public String getActuate() {
		return associationType.getActuate();
	}

	@Override
	public String getArcrole() {
		return associationType.getArcrole();
	}

	@Override
	public String getHref() {
		return associationType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return associationType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return associationType.getRole();
	}

	@Override
	public String getShow() {
		return associationType.getShow();
	}

	@Override
	public String getTitle() {
		return associationType.getTitle();
	}

	@Override
	public String getType() {
		return associationType.getType();
	}

	@Override
	public boolean isSetActuate() {
		return associationType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return associationType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return associationType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return associationType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return associationType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return associationType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return associationType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return associationType.isSetType();
	}

	@Override
	public void setActuate(String actuate) {
		associationType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		associationType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		associationType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		associationType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		associationType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		associationType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		associationType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		associationType.setType(type);
	}

	@Override
	public void unsetActuate() {
		associationType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		associationType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		associationType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		associationType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		associationType.setRole(null);
	}

	@Override
	public void unsetShow() {
		associationType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		associationType.setTitle(null);
	}

	@Override
	public void unsetType() {
		associationType.setType(null);
	}	
}
