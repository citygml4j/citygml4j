package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.MultiSolidPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiSolid;
import org.citygml4j.model.gml.MultiSolidProperty;

public class MultiSolidPropertyImpl extends GMLBaseImpl implements	MultiSolidProperty {
	private MultiSolidPropertyType multiSolidPropertyType;

	public MultiSolidPropertyImpl() {
		multiSolidPropertyType = new MultiSolidPropertyType();
	}

	public MultiSolidPropertyImpl(MultiSolidPropertyType multiSolidPropertyType) {
		this.multiSolidPropertyType = multiSolidPropertyType;
	}

	@Override
	public MultiSolidPropertyType getJAXBObject() {
		return multiSolidPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTISOLIDPROPERTY;
	}

	public MultiSolid getMultiSolid() {
		if (multiSolidPropertyType.isSetMultiSolid())
			return new MultiSolidImpl(multiSolidPropertyType.getMultiSolid());

		return null;
	}

	public String getActuate() {
		return multiSolidPropertyType.getActuate();
	}

	public String getArcrole() {
		return multiSolidPropertyType.getArcrole();
	}

	public String getHref() {
		return multiSolidPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return multiSolidPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return multiSolidPropertyType.getRole();
	}

	public String getShow() {
		return multiSolidPropertyType.getShow();
	}

	public String getTitle() {
		return multiSolidPropertyType.getTitle();
	}

	public String getType() {
		return multiSolidPropertyType.getType();
	}

	public void setActuate(String actuate) {
		multiSolidPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		multiSolidPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		multiSolidPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		multiSolidPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		multiSolidPropertyType.setRole(role);
	}

	public void setShow(String show) {
		multiSolidPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		multiSolidPropertyType.setTitle(title);
	}

	public void setType(String type) {
		multiSolidPropertyType.setType(type);
	}

	public void setMultiSolid(MultiSolid multiSolid) {
		multiSolidPropertyType.setMultiSolid(((MultiSolidImpl)multiSolid).getJAXBObject());
	}
	
	public boolean isSetActuate() {
		return multiSolidPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return multiSolidPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return multiSolidPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return multiSolidPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return multiSolidPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return multiSolidPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return multiSolidPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return multiSolidPropertyType.isSetType();
	}

	public void unsetActuate() {
		multiSolidPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		multiSolidPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		multiSolidPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		multiSolidPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		multiSolidPropertyType.setRole(null);
	}

	public void unsetShow() {
		multiSolidPropertyType.setShow(null);
	}

	public void unsetTitle() {
		multiSolidPropertyType.setTitle(null);
	}

	public void unsetType() {
		multiSolidPropertyType.setType(null);
	}

	public boolean isSetMultiSolid() {
		return multiSolidPropertyType.isSetMultiSolid();
	}

	public void unsetMultiSolid() {
		multiSolidPropertyType.setMultiSolid(null);
	}

}
