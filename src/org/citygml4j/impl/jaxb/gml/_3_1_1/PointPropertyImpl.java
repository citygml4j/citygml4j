package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.PointPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Point;
import org.citygml4j.model.gml.PointProperty;

public class PointPropertyImpl extends GMLBaseImpl implements PointProperty {
	private PointPropertyType pointPropertyType;

	public PointPropertyImpl() {
		pointPropertyType = new PointPropertyType();
	}

	public PointPropertyImpl(PointPropertyType pointPropertyType) {
		this.pointPropertyType = pointPropertyType;
	}

	@Override
	public PointPropertyType getJAXBObject() {
		return pointPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.POINTPROPERTY;
	}

	public Point getPoint() {
		if (pointPropertyType.isSetPoint())
			return new PointImpl(pointPropertyType.getPoint());

		return null;
	}

	public void setPoint(Point point) {
		pointPropertyType.setPoint(((PointImpl)point).getJAXBObject());
	}

	public String getActuate() {
		return pointPropertyType.getActuate();
	}

	public String getArcrole() {
		return pointPropertyType.getArcrole();
	}

	public String getHref() {
		return pointPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return pointPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return pointPropertyType.getRole();
	}

	public String getShow() {
		return pointPropertyType.getShow();
	}

	public String getTitle() {
		return pointPropertyType.getTitle();
	}

	public String getType() {
		return pointPropertyType.getType();
	}

	public void setActuate(String actuate) {
		pointPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		pointPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		pointPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		pointPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		pointPropertyType.setRole(role);
	}

	public void setShow(String show) {
		pointPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		pointPropertyType.setTitle(title);
	}

	public void setType(String type) {
		pointPropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return pointPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return pointPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return pointPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return pointPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return pointPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return pointPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return pointPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return pointPropertyType.isSetType();
	}

	public void unsetActuate() {
		pointPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		pointPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		pointPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		pointPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		pointPropertyType.setRole(null);
	}

	public void unsetShow() {
		pointPropertyType.setShow(null);
	}

	public void unsetTitle() {
		pointPropertyType.setTitle(null);
	}

	public void unsetType() {
		pointPropertyType.setType(null);
	}

	public boolean isSetPoint() {
		return pointPropertyType.isSetPoint();
	}

	public void unsetPoint() {
		pointPropertyType.setPoint(null);
	}
	
}
