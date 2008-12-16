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

	@Override
	public Point getPoint() {
		if (pointPropertyType.isSetPoint())
			return new PointImpl(pointPropertyType.getPoint());

		return null;
	}

	@Override
	public void setPoint(Point point) {
		pointPropertyType.setPoint(((PointImpl)point).getJAXBObject());
	}

	@Override
	public String getActuate() {
		return pointPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return pointPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return pointPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return pointPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return pointPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return pointPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return pointPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return pointPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		pointPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		pointPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		pointPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		pointPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		pointPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		pointPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		pointPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		pointPropertyType.setType(type);
	}
	
	@Override
	public boolean isSetActuate() {
		return pointPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return pointPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return pointPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return pointPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return pointPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return pointPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return pointPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return pointPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		pointPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		pointPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		pointPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		pointPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		pointPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		pointPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		pointPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		pointPropertyType.setType(null);
	}

	@Override
	public boolean isSetPoint() {
		return pointPropertyType.isSetPoint();
	}

	@Override
	public void unsetPoint() {
		pointPropertyType.setPoint(null);
	}
	
}
