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

	@Override
	public MultiPolygon getMultiPolygon() {
		if (multiPolygonPropertyType.isSetMultiPolygon())
			return new MultiPolygonImpl(multiPolygonPropertyType.getMultiPolygon());

		return null;
	}

	@Override
	public String getActuate() {
		return multiPolygonPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return multiPolygonPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return multiPolygonPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return multiPolygonPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return multiPolygonPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return multiPolygonPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return multiPolygonPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return multiPolygonPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		multiPolygonPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		multiPolygonPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		multiPolygonPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		multiPolygonPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		multiPolygonPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		multiPolygonPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		multiPolygonPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		multiPolygonPropertyType.setType(type);
	}
	
	@Override
	public boolean isSetActuate() {
		return multiPolygonPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return multiPolygonPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return multiPolygonPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return multiPolygonPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return multiPolygonPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return multiPolygonPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return multiPolygonPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return multiPolygonPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		multiPolygonPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		multiPolygonPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		multiPolygonPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		multiPolygonPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		multiPolygonPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		multiPolygonPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		multiPolygonPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		multiPolygonPropertyType.setType(null);
	}

	@Override
	public boolean isSetMultiPolygon() {
		return multiPolygonPropertyType.isSetMultiPolygon();
	}

	@Override
	public void setMultiPolygon(MultiPolygon multiPolygon) {
		multiPolygonPropertyType.setMultiPolygon(((MultiPolygonImpl)multiPolygon).getJAXBObject());
	}

	@Override
	public void unsetMultiPolygon() {
		multiPolygonPropertyType.setMultiPolygon(null);
	}
	
}
