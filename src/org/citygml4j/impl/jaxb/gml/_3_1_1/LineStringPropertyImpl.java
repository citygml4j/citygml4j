package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.LineStringPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LineString;
import org.citygml4j.model.gml.LineStringProperty;

public class LineStringPropertyImpl extends GMLBaseImpl implements	LineStringProperty {
	private LineStringPropertyType lineStringPropertyType;

	public LineStringPropertyImpl() {
		lineStringPropertyType = new LineStringPropertyType();
	}
	
	public LineStringPropertyImpl(LineStringPropertyType lineStringPropertyType) {
		this.lineStringPropertyType = lineStringPropertyType;
	}

	@Override
	public LineStringPropertyType getJAXBObject() {
		return lineStringPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.LINESTRINGPROPERTY;
	}

	public LineString getLineString() {
		if (lineStringPropertyType.isSetLineString())
			return new LineStringImpl(lineStringPropertyType.getLineString());

		return null;
	}

	public void setLineString(LineString lineString) {
		lineStringPropertyType.setLineString(((LineStringImpl)lineString).getJAXBObject());
	}

	public String getActuate() {
		return lineStringPropertyType.getActuate();
	}

	public String getArcrole() {
		return lineStringPropertyType.getArcrole();
	}

	public String getHref() {
		return lineStringPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return lineStringPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return lineStringPropertyType.getRole();
	}

	public String getShow() {
		return lineStringPropertyType.getShow();
	}

	public String getTitle() {
		return lineStringPropertyType.getTitle();
	}

	public String getType() {
		return lineStringPropertyType.getType();
	}

	public void setActuate(String actuate) {
		lineStringPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		lineStringPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		lineStringPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		lineStringPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		lineStringPropertyType.setRole(role);
	}

	public void setShow(String show) {
		lineStringPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		lineStringPropertyType.setTitle(title);
	}

	public void setType(String type) {
		lineStringPropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return lineStringPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return lineStringPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return lineStringPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return lineStringPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return lineStringPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return lineStringPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return lineStringPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return lineStringPropertyType.isSetType();
	}

	public void unsetActuate() {
		lineStringPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		lineStringPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		lineStringPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		lineStringPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		lineStringPropertyType.setRole(null);
	}

	public void unsetShow() {
		lineStringPropertyType.setShow(null);
	}

	public void unsetTitle() {
		lineStringPropertyType.setTitle(null);
	}

	public void unsetType() {
		lineStringPropertyType.setType(null);
	}

	public boolean isSetLineString() {
		return lineStringPropertyType.isSetLineString();
	}

	public void unsetLineString() {
		lineStringPropertyType.setLineString(null);
	}
	
}
