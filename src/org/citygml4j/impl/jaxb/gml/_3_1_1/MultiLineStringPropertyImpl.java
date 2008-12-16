package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.MultiLineStringPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiLineString;
import org.citygml4j.model.gml.MultiLineStringProperty;

public class MultiLineStringPropertyImpl extends GMLBaseImpl implements MultiLineStringProperty {
	private MultiLineStringPropertyType multiLineStringPropertyType;

	public MultiLineStringPropertyImpl() {
		multiLineStringPropertyType = new MultiLineStringPropertyType();
	}
	
	public MultiLineStringPropertyImpl(MultiLineStringPropertyType multiLineStringPropertyType) {
		this.multiLineStringPropertyType = multiLineStringPropertyType;
	}

	@Override
	public MultiLineStringPropertyType getJAXBObject() {
		return multiLineStringPropertyType;
	}

	@Override
	public MultiLineString getMultiLineString() {
		if (multiLineStringPropertyType.isSetMultiLineString())
			return new MultiLineStringImpl(multiLineStringPropertyType.getMultiLineString());
		return null;
	}

	@Override
	public String getActuate() {
		return multiLineStringPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return multiLineStringPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return multiLineStringPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return multiLineStringPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return multiLineStringPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return multiLineStringPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return multiLineStringPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return multiLineStringPropertyType.getType();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTILINESTRINGPROPERTY;
	}
	@Override
	public void setActuate(String actuate) {
		multiLineStringPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		multiLineStringPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		multiLineStringPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		multiLineStringPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		multiLineStringPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		multiLineStringPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		multiLineStringPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		multiLineStringPropertyType.setType(type);
	}
	
	@Override
	public boolean isSetActuate() {
		return multiLineStringPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return multiLineStringPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return multiLineStringPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return multiLineStringPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return multiLineStringPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return multiLineStringPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return multiLineStringPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return multiLineStringPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		multiLineStringPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		multiLineStringPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		multiLineStringPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		multiLineStringPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		multiLineStringPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		multiLineStringPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		multiLineStringPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		multiLineStringPropertyType.setType(null);
	}

	@Override
	public boolean isSetMultiLineString() {
		return multiLineStringPropertyType.isSetMultiLineString();
	}

	@Override
	public void setMultiLineString(MultiLineString multiLineString) {
		multiLineStringPropertyType.setMultiLineString(((MultiLineStringImpl)multiLineString).getJAXBObject());
	}

	@Override
	public void unsetMultiLineString() {
		multiLineStringPropertyType.setMultiLineString(null);
	}
	
}
