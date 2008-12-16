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

	@Override
	public LineString getLineString() {
		if (lineStringPropertyType.isSetLineString())
			return new LineStringImpl(lineStringPropertyType.getLineString());

		return null;
	}

	@Override
	public void setLineString(LineString lineString) {
		lineStringPropertyType.setLineString(((LineStringImpl)lineString).getJAXBObject());
	}

	@Override
	public String getActuate() {
		return lineStringPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return lineStringPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return lineStringPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return lineStringPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return lineStringPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return lineStringPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return lineStringPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return lineStringPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		lineStringPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		lineStringPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		lineStringPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		lineStringPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		lineStringPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		lineStringPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		lineStringPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		lineStringPropertyType.setType(type);
	}
	
	@Override
	public boolean isSetActuate() {
		return lineStringPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return lineStringPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return lineStringPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return lineStringPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return lineStringPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return lineStringPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return lineStringPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return lineStringPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		lineStringPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		lineStringPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		lineStringPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		lineStringPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		lineStringPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		lineStringPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		lineStringPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		lineStringPropertyType.setType(null);
	}

	@Override
	public boolean isSetLineString() {
		return lineStringPropertyType.isSetLineString();
	}

	@Override
	public void unsetLineString() {
		lineStringPropertyType.setLineString(null);
	}
	
}
