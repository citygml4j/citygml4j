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

	@Override
	public Polygon getPolygon() {
		if (polygonPropertyType.isSetPolygon())
			return new PolygonImpl(polygonPropertyType.getPolygon());

		return null;
	}

	@Override
	public void setPolygon(Polygon polygon) {
		polygonPropertyType.setPolygon(((PolygonImpl)polygon).getJAXBObject());
	}

	@Override
	public String getActuate() {
		return polygonPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return polygonPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return polygonPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return polygonPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return polygonPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return polygonPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return polygonPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return polygonPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		polygonPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		polygonPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		polygonPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		polygonPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		polygonPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		polygonPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		polygonPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		polygonPropertyType.setType(type);
	}
	
	@Override
	public boolean isSetActuate() {
		return polygonPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return polygonPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return polygonPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return polygonPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return polygonPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return polygonPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return polygonPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return polygonPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		polygonPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		polygonPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		polygonPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		polygonPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		polygonPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		polygonPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		polygonPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		polygonPropertyType.setType(null);
	}

	@Override
	public boolean isSetPolygon() {
		return polygonPropertyType.isSetPolygon();
	}

	@Override
	public void unsetPolygon() {
		polygonPropertyType.setPolygon(null);
	}
	
}
