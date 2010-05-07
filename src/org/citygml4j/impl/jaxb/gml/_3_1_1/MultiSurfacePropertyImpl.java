package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.MultiSurfacePropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;

public class MultiSurfacePropertyImpl extends GMLBaseImpl implements MultiSurfaceProperty {
	private MultiSurfacePropertyType multiSurfacePropertyType;

	public MultiSurfacePropertyImpl() {
		multiSurfacePropertyType = new MultiSurfacePropertyType();
	}

	public MultiSurfacePropertyImpl(MultiSurfacePropertyType multiSurfacePropertyType) {
		this.multiSurfacePropertyType = multiSurfacePropertyType;
	}

	@Override
	public MultiSurfacePropertyType getJAXBObject() {
		return multiSurfacePropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.MULTISURFACEPROPERTY;
	}

	public MultiSurface getMultiSurface() {
		if (multiSurfacePropertyType.isSetMultiSurface())
			return new MultiSurfaceImpl(multiSurfacePropertyType.getMultiSurface());

		return null;
	}

	public String getActuate() {
		return multiSurfacePropertyType.getActuate();
	}

	public String getArcrole() {
		return multiSurfacePropertyType.getArcrole();
	}

	public String getHref() {
		return multiSurfacePropertyType.getHref();
	}

	public String getRemoteSchema() {
		return multiSurfacePropertyType.getRemoteSchema();
	}

	public String getRole() {
		return multiSurfacePropertyType.getRole();
	}

	public String getShow() {
		return multiSurfacePropertyType.getShow();
	}

	public String getTitle() {
		return multiSurfacePropertyType.getTitle();
	}

	public String getType() {
		return multiSurfacePropertyType.getType();
	}

	public void setActuate(String actuate) {
		multiSurfacePropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		multiSurfacePropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		multiSurfacePropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		multiSurfacePropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		multiSurfacePropertyType.setRole(role);
	}

	public void setShow(String show) {
		multiSurfacePropertyType.setShow(show);
	}

	public void setTitle(String title) {
		multiSurfacePropertyType.setTitle(title);
	}

	public void setType(String type) {
		multiSurfacePropertyType.setType(type);
	}

	public void setMultiSurface(MultiSurface multiSurface) {
		multiSurfacePropertyType.setMultiSurface(((MultiSurfaceImpl)multiSurface).getJAXBObject());
	}

	public boolean isSetActuate() {
		return multiSurfacePropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return multiSurfacePropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return multiSurfacePropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return multiSurfacePropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return multiSurfacePropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return multiSurfacePropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return multiSurfacePropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return multiSurfacePropertyType.isSetType();
	}

	public void unsetActuate() {
		multiSurfacePropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		multiSurfacePropertyType.setArcrole(null);
	}

	public void unsetHref() {
		multiSurfacePropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		multiSurfacePropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		multiSurfacePropertyType.setRole(null);
	}

	public void unsetShow() {
		multiSurfacePropertyType.setShow(null);
	}

	public void unsetTitle() {
		multiSurfacePropertyType.setTitle(null);
	}

	public void unsetType() {
		multiSurfacePropertyType.setType(null);
	}

	public boolean isSetMultiSurface() {
		return multiSurfacePropertyType.isSetMultiSurface();
	}

	public void unsetMultiSurface() {
		multiSurfacePropertyType.setMultiSurface(null);
	}
	
}
