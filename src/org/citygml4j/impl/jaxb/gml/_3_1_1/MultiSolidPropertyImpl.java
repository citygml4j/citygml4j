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

	@Override
	public MultiSolid getMultiSolid() {
		if (multiSolidPropertyType.isSetMultiSolid())
			return new MultiSolidImpl(multiSolidPropertyType.getMultiSolid());

		return null;
	}

	@Override
	public String getActuate() {
		return multiSolidPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return multiSolidPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return multiSolidPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return multiSolidPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return multiSolidPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return multiSolidPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return multiSolidPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return multiSolidPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		multiSolidPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		multiSolidPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		multiSolidPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		multiSolidPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		multiSolidPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		multiSolidPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		multiSolidPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		multiSolidPropertyType.setType(type);
	}

	@Override
	public void setMultiSolid(MultiSolid multiSolid) {
		multiSolidPropertyType.setMultiSolid(((MultiSolidImpl)multiSolid).getJAXBObject());
	}
	
	@Override
	public boolean isSetActuate() {
		return multiSolidPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return multiSolidPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return multiSolidPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return multiSolidPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return multiSolidPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return multiSolidPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return multiSolidPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return multiSolidPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		multiSolidPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		multiSolidPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		multiSolidPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		multiSolidPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		multiSolidPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		multiSolidPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		multiSolidPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		multiSolidPropertyType.setType(null);
	}

	@Override
	public boolean isSetMultiSolid() {
		return multiSolidPropertyType.isSetMultiSolid();
	}

	@Override
	public void unsetMultiSolid() {
		multiSolidPropertyType.setMultiSolid(null);
	}

}
