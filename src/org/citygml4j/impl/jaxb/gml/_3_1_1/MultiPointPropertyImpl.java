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

	@Override
	public MultiPoint getMultiPoint() {
		if (multiPointPropertyType.isSetMultiPoint())
			return new MultiPointImpl(multiPointPropertyType.getMultiPoint());

		return null;
	}

	@Override
	public String getActuate() {
		return multiPointPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return multiPointPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return multiPointPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return multiPointPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return multiPointPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return multiPointPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return multiPointPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return multiPointPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		multiPointPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		multiPointPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		multiPointPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		multiPointPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		multiPointPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		multiPointPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		multiPointPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		multiPointPropertyType.setType(type);
	}

	@Override
	public void setMultiPoint(MultiPoint multiPoint) {
		multiPointPropertyType.setMultiPoint(((MultiPointImpl)multiPoint).getJAXBObject());
	}
	
	@Override
	public boolean isSetActuate() {
		return multiPointPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return multiPointPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return multiPointPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return multiPointPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return multiPointPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return multiPointPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return multiPointPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return multiPointPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		multiPointPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		multiPointPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		multiPointPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		multiPointPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		multiPointPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		multiPointPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		multiPointPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		multiPointPropertyType.setType(null);
	}

	@Override
	public boolean isSetMultiPoint() {
		return multiPointPropertyType.isSetMultiPoint();
	}

	@Override
	public void unsetMultiPoint() {
		multiPointPropertyType.setMultiPoint(null);
	}
	
}
