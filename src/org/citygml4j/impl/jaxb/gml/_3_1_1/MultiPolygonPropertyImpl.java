package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.MultiPolygonPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiPolygon;
import org.citygml4j.model.gml.MultiPolygonProperty;

public class MultiPolygonPropertyImpl extends GMLBaseImpl implements MultiPolygonProperty {
	private MultiPolygonPropertyType multiPolygonPropertyType;

	public MultiPolygonPropertyImpl() {
		multiPolygonPropertyType = new MultiPolygonPropertyType();
	}
	
	public MultiPolygonPropertyImpl(MultiPolygonPropertyType multiPolygonPropertyType) {
		this.multiPolygonPropertyType = multiPolygonPropertyType;
	}

	@Override
	public MultiPolygonPropertyType getJAXBObject() {
		return multiPolygonPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTIPOLYGONPROPERTY;
	}

	public MultiPolygon getMultiPolygon() {
		if (multiPolygonPropertyType.isSetMultiPolygon())
			return new MultiPolygonImpl(multiPolygonPropertyType.getMultiPolygon());

		return null;
	}

	public String getActuate() {
		return multiPolygonPropertyType.getActuate();
	}

	public String getArcrole() {
		return multiPolygonPropertyType.getArcrole();
	}

	public String getHref() {
		return multiPolygonPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return multiPolygonPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return multiPolygonPropertyType.getRole();
	}

	public String getShow() {
		return multiPolygonPropertyType.getShow();
	}

	public String getTitle() {
		return multiPolygonPropertyType.getTitle();
	}

	public String getType() {
		return multiPolygonPropertyType.getType();
	}

	public void setActuate(String actuate) {
		multiPolygonPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		multiPolygonPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		multiPolygonPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		multiPolygonPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		multiPolygonPropertyType.setRole(role);
	}

	public void setShow(String show) {
		multiPolygonPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		multiPolygonPropertyType.setTitle(title);
	}

	public void setType(String type) {
		multiPolygonPropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return multiPolygonPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return multiPolygonPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return multiPolygonPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return multiPolygonPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return multiPolygonPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return multiPolygonPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return multiPolygonPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return multiPolygonPropertyType.isSetType();
	}

	public void unsetActuate() {
		multiPolygonPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		multiPolygonPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		multiPolygonPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		multiPolygonPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		multiPolygonPropertyType.setRole(null);
	}

	public void unsetShow() {
		multiPolygonPropertyType.setShow(null);
	}

	public void unsetTitle() {
		multiPolygonPropertyType.setTitle(null);
	}

	public void unsetType() {
		multiPolygonPropertyType.setType(null);
	}

	public boolean isSetMultiPolygon() {
		return multiPolygonPropertyType.isSetMultiPolygon();
	}

	public void setMultiPolygon(MultiPolygon multiPolygon) {
		multiPolygonPropertyType.setMultiPolygon(((MultiPolygonImpl)multiPolygon).getJAXBObject());
	}

	public void unsetMultiPolygon() {
		multiPolygonPropertyType.setMultiPolygon(null);
	}
	
}
