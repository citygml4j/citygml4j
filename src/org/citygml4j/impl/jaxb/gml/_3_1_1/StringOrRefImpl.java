package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.StringOrRefType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.StringOrRef;

public class StringOrRefImpl extends GMLBaseImpl implements StringOrRef {
	private StringOrRefType stringOrRefType;

	public StringOrRefImpl() {
		stringOrRefType = new StringOrRefType();
	}

	public StringOrRefImpl(StringOrRefType stringOrRefType) {
		this.stringOrRefType = stringOrRefType;
	}

	@Override
	public StringOrRefType getJAXBObject() {
		return stringOrRefType;
	}

	public String getActuate() {
		return stringOrRefType.getActuate();
	}

	public String getArcrole() {
		return stringOrRefType.getArcrole();
	}

	public String getHref() {
		return stringOrRefType.getHref();
	}

	public String getRemoteSchema() {
		return stringOrRefType.getRemoteSchema();
	}

	public String getRole() {
		return stringOrRefType.getRole();
	}

	public String getShow() {
		return stringOrRefType.getShow();
	}

	public String getTitle() {
		return stringOrRefType.getTitle();
	}

	public String getType() {
		return stringOrRefType.getType();
	}

	public String getValue() {
		return stringOrRefType.getValue();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.STRINGORREF;
	}

	public void setActuate(String actuate) {
		stringOrRefType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		stringOrRefType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		stringOrRefType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		stringOrRefType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		stringOrRefType.setRole(role);
	}

	public void setShow(String show) {
		stringOrRefType.setShow(show);
	}

	public void setTitle(String title) {
		stringOrRefType.setTitle(title);
	}

	public void setType(String type) {
		stringOrRefType.setType(type);
	}

	public void setValue(String value) {
		stringOrRefType.setValue(value);
	}

	public boolean isSetActuate() {
		return stringOrRefType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return stringOrRefType.isSetArcrole();
	}

	public boolean isSetHref() {
		return stringOrRefType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return stringOrRefType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return stringOrRefType.isSetRole();
	}

	public boolean isSetShow() {
		return stringOrRefType.isSetShow();
	}

	public boolean isSetTitle() {
		return stringOrRefType.isSetTitle();
	}

	public boolean isSetType() {
		return stringOrRefType.isSetType();
	}

	public void unsetActuate() {
		stringOrRefType.setActuate(null);
	}

	public void unsetArcrole() {
		stringOrRefType.setArcrole(null);
	}

	public void unsetHref() {
		stringOrRefType.setHref(null);
	}

	public void unsetRemoteSchema() {
		stringOrRefType.setRemoteSchema(null);
	}

	public void unsetRole() {
		stringOrRefType.setRole(null);
	}

	public void unsetShow() {
		stringOrRefType.setShow(null);
	}

	public void unsetTitle() {
		stringOrRefType.setTitle(null);
	}

	public void unsetType() {
		stringOrRefType.setType(null);
	}

	public boolean isSetValue() {
		return stringOrRefType.isSetValue();
	}

	public void unsetValue() {
		stringOrRefType.setValue(null);
	}
	
}
