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

	public MultiLineString getMultiLineString() {
		if (multiLineStringPropertyType.isSetMultiLineString())
			return new MultiLineStringImpl(multiLineStringPropertyType.getMultiLineString());
		return null;
	}

	public String getActuate() {
		return multiLineStringPropertyType.getActuate();
	}

	public String getArcrole() {
		return multiLineStringPropertyType.getArcrole();
	}

	public String getHref() {
		return multiLineStringPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return multiLineStringPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return multiLineStringPropertyType.getRole();
	}

	public String getShow() {
		return multiLineStringPropertyType.getShow();
	}

	public String getTitle() {
		return multiLineStringPropertyType.getTitle();
	}

	public String getType() {
		return multiLineStringPropertyType.getType();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTILINESTRINGPROPERTY;
	}
	public void setActuate(String actuate) {
		multiLineStringPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		multiLineStringPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		multiLineStringPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		multiLineStringPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		multiLineStringPropertyType.setRole(role);
	}

	public void setShow(String show) {
		multiLineStringPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		multiLineStringPropertyType.setTitle(title);
	}

	public void setType(String type) {
		multiLineStringPropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return multiLineStringPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return multiLineStringPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return multiLineStringPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return multiLineStringPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return multiLineStringPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return multiLineStringPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return multiLineStringPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return multiLineStringPropertyType.isSetType();
	}

	public void unsetActuate() {
		multiLineStringPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		multiLineStringPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		multiLineStringPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		multiLineStringPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		multiLineStringPropertyType.setRole(null);
	}

	public void unsetShow() {
		multiLineStringPropertyType.setShow(null);
	}

	public void unsetTitle() {
		multiLineStringPropertyType.setTitle(null);
	}

	public void unsetType() {
		multiLineStringPropertyType.setType(null);
	}

	public boolean isSetMultiLineString() {
		return multiLineStringPropertyType.isSetMultiLineString();
	}

	public void setMultiLineString(MultiLineString multiLineString) {
		multiLineStringPropertyType.setMultiLineString(((MultiLineStringImpl)multiLineString).getJAXBObject());
	}

	public void unsetMultiLineString() {
		multiLineStringPropertyType.setMultiLineString(null);
	}
	
}
