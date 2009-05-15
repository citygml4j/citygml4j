package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.PolygonPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Polygon;
import org.citygml4j.model.gml.PolygonProperty;

public class PolygonPropertyImpl extends GMLBaseImpl implements PolygonProperty {
	private PolygonPropertyType polygonPropertyType;

	public PolygonPropertyImpl() {
		polygonPropertyType = new PolygonPropertyType();
	}
	
	public PolygonPropertyImpl(PolygonPropertyType polygonPropertyType) {
		this.polygonPropertyType = polygonPropertyType;
	}

	@Override
	public PolygonPropertyType getJAXBObject() {
		return polygonPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.POLYGONPROPERTY;
	}

	public Polygon getPolygon() {
		if (polygonPropertyType.isSetPolygon())
			return new PolygonImpl(polygonPropertyType.getPolygon());

		return null;
	}

	public void setPolygon(Polygon polygon) {
		polygonPropertyType.setPolygon(((PolygonImpl)polygon).getJAXBObject());
	}

	public String getActuate() {
		return polygonPropertyType.getActuate();
	}

	public String getArcrole() {
		return polygonPropertyType.getArcrole();
	}

	public String getHref() {
		return polygonPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return polygonPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return polygonPropertyType.getRole();
	}

	public String getShow() {
		return polygonPropertyType.getShow();
	}

	public String getTitle() {
		return polygonPropertyType.getTitle();
	}

	public String getType() {
		return polygonPropertyType.getType();
	}

	public void setActuate(String actuate) {
		polygonPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		polygonPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		polygonPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		polygonPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		polygonPropertyType.setRole(role);
	}

	public void setShow(String show) {
		polygonPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		polygonPropertyType.setTitle(title);
	}

	public void setType(String type) {
		polygonPropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return polygonPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return polygonPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return polygonPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return polygonPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return polygonPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return polygonPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return polygonPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return polygonPropertyType.isSetType();
	}

	public void unsetActuate() {
		polygonPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		polygonPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		polygonPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		polygonPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		polygonPropertyType.setRole(null);
	}

	public void unsetShow() {
		polygonPropertyType.setShow(null);
	}

	public void unsetTitle() {
		polygonPropertyType.setTitle(null);
	}

	public void unsetType() {
		polygonPropertyType.setType(null);
	}

	public boolean isSetPolygon() {
		return polygonPropertyType.isSetPolygon();
	}

	public void unsetPolygon() {
		polygonPropertyType.setPolygon(null);
	}
	
}
