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

	public boolean isSetObject() {
		return associationType.isSet_Object();
	}

	public void unsetObject() {
		associationType.set_Object(null);
	}

	public String getActuate() {
		return associationType.getActuate();
	}

	public String getArcrole() {
		return associationType.getArcrole();
	}

	public String getHref() {
		return associationType.getHref();
	}

	public String getRemoteSchema() {
		return associationType.getRemoteSchema();
	}

	public String getRole() {
		return associationType.getRole();
	}

	public String getShow() {
		return associationType.getShow();
	}

	public String getTitle() {
		return associationType.getTitle();
	}

	public String getType() {
		return associationType.getType();
	}

	public boolean isSetActuate() {
		return associationType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return associationType.isSetArcrole();
	}

	public boolean isSetHref() {
		return associationType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return associationType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return associationType.isSetRole();
	}

	public boolean isSetShow() {
		return associationType.isSetShow();
	}

	public boolean isSetTitle() {
		return associationType.isSetTitle();
	}

	public boolean isSetType() {
		return associationType.isSetType();
	}

	public void setActuate(String actuate) {
		associationType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		associationType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		associationType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		associationType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		associationType.setRole(role);
	}

	public void setShow(String show) {
		associationType.setShow(show);
	}

	public void setTitle(String title) {
		associationType.setTitle(title);
	}

	public void setType(String type) {
		associationType.setType(type);
	}

	public void unsetActuate() {
		associationType.setActuate(null);
	}

	public void unsetArcrole() {
		associationType.setArcrole(null);
	}

	public void unsetHref() {
		associationType.setHref(null);
	}

	public void unsetRemoteSchema() {
		associationType.setRemoteSchema(null);
	}

	public void unsetRole() {
		associationType.setRole(null);
	}

	public void unsetShow() {
		associationType.setShow(null);
	}

	public void unsetTitle() {
		associationType.setTitle(null);
	}

	public void unsetType() {
		associationType.setType(null);
	}	
}
