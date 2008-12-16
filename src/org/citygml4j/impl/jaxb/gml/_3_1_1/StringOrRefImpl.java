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

	@Override
	public String getActuate() {
		return stringOrRefType.getActuate();
	}

	@Override
	public String getArcrole() {
		return stringOrRefType.getArcrole();
	}

	@Override
	public String getHref() {
		return stringOrRefType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return stringOrRefType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return stringOrRefType.getRole();
	}

	@Override
	public String getShow() {
		return stringOrRefType.getShow();
	}

	@Override
	public String getTitle() {
		return stringOrRefType.getTitle();
	}

	@Override
	public String getType() {
		return stringOrRefType.getType();
	}

	@Override
	public String getValue() {
		return stringOrRefType.getValue();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.STRINGORREF;
	}

	@Override
	public void setActuate(String actuate) {
		stringOrRefType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		stringOrRefType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		stringOrRefType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		stringOrRefType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		stringOrRefType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		stringOrRefType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		stringOrRefType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		stringOrRefType.setType(type);
	}

	@Override
	public void setValue(String value) {
		stringOrRefType.setValue(value);
	}

	@Override
	public boolean isSetActuate() {
		return stringOrRefType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return stringOrRefType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return stringOrRefType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return stringOrRefType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return stringOrRefType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return stringOrRefType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return stringOrRefType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return stringOrRefType.isSetType();
	}

	@Override
	public void unsetActuate() {
		stringOrRefType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		stringOrRefType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		stringOrRefType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		stringOrRefType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		stringOrRefType.setRole(null);
	}

	@Override
	public void unsetShow() {
		stringOrRefType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		stringOrRefType.setTitle(null);
	}

	@Override
	public void unsetType() {
		stringOrRefType.setType(null);
	}

	@Override
	public boolean isSetValue() {
		return stringOrRefType.isSetValue();
	}

	@Override
	public void unsetValue() {
		stringOrRefType.setValue(null);
	}
	
}
