package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.MultiPointPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiPoint;
import org.citygml4j.model.gml.MultiPointProperty;

public class MultiPointPropertyImpl extends GMLBaseImpl implements MultiPointProperty {
	private MultiPointPropertyType multiPointPropertyType;

	public MultiPointPropertyImpl() {
		multiPointPropertyType = new MultiPointPropertyType();
	}
	
	public MultiPointPropertyImpl(MultiPointPropertyType multiPointPropertyType) {
		this.multiPointPropertyType = multiPointPropertyType;
	}

	@Override
	public MultiPointPropertyType getJAXBObject() {
		return multiPointPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTIPOINTPROPERTY;
	}

	public MultiPoint getMultiPoint() {
		if (multiPointPropertyType.isSetMultiPoint())
			return new MultiPointImpl(multiPointPropertyType.getMultiPoint());

		return null;
	}

	public String getActuate() {
		return multiPointPropertyType.getActuate();
	}

	public String getArcrole() {
		return multiPointPropertyType.getArcrole();
	}

	public String getHref() {
		return multiPointPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return multiPointPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return multiPointPropertyType.getRole();
	}

	public String getShow() {
		return multiPointPropertyType.getShow();
	}

	public String getTitle() {
		return multiPointPropertyType.getTitle();
	}

	public String getType() {
		return multiPointPropertyType.getType();
	}

	public void setActuate(String actuate) {
		multiPointPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		multiPointPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		multiPointPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		multiPointPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		multiPointPropertyType.setRole(role);
	}

	public void setShow(String show) {
		multiPointPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		multiPointPropertyType.setTitle(title);
	}

	public void setType(String type) {
		multiPointPropertyType.setType(type);
	}

	public void setMultiPoint(MultiPoint multiPoint) {
		multiPointPropertyType.setMultiPoint(((MultiPointImpl)multiPoint).getJAXBObject());
	}
	
	public boolean isSetActuate() {
		return multiPointPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return multiPointPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return multiPointPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return multiPointPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return multiPointPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return multiPointPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return multiPointPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return multiPointPropertyType.isSetType();
	}

	public void unsetActuate() {
		multiPointPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		multiPointPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		multiPointPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		multiPointPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		multiPointPropertyType.setRole(null);
	}

	public void unsetShow() {
		multiPointPropertyType.setShow(null);
	}

	public void unsetTitle() {
		multiPointPropertyType.setTitle(null);
	}

	public void unsetType() {
		multiPointPropertyType.setType(null);
	}

	public boolean isSetMultiPoint() {
		return multiPointPropertyType.isSetMultiPoint();
	}

	public void unsetMultiPoint() {
		multiPointPropertyType.setMultiPoint(null);
	}
	
}
