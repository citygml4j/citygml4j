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

	@Override
	public MultiSurface getMultiSurface() {
		if (multiSurfacePropertyType.isSetMultiSurface())
			return new MultiSurfaceImpl(multiSurfacePropertyType.getMultiSurface());

		return null;
	}

	@Override
	public String getActuate() {
		return multiSurfacePropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return multiSurfacePropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return multiSurfacePropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return multiSurfacePropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return multiSurfacePropertyType.getRole();
	}

	@Override
	public String getShow() {
		return multiSurfacePropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return multiSurfacePropertyType.getTitle();
	}

	@Override
	public String getType() {
		return multiSurfacePropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		multiSurfacePropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		multiSurfacePropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		multiSurfacePropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		multiSurfacePropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		multiSurfacePropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		multiSurfacePropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		multiSurfacePropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		multiSurfacePropertyType.setType(type);
	}

	@Override
	public void setMultiSurface(MultiSurface multiSurface) {
		multiSurfacePropertyType.setMultiSurface(((MultiSurfaceImpl)multiSurface).getJAXBObject());
	}

	@Override
	public boolean isSetActuate() {
		return multiSurfacePropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return multiSurfacePropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return multiSurfacePropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return multiSurfacePropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return multiSurfacePropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return multiSurfacePropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return multiSurfacePropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return multiSurfacePropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		multiSurfacePropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		multiSurfacePropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		multiSurfacePropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		multiSurfacePropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		multiSurfacePropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		multiSurfacePropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		multiSurfacePropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		multiSurfacePropertyType.setType(null);
	}

	@Override
	public boolean isSetMultiSurface() {
		return multiSurfacePropertyType.isSetMultiSurface();
	}

	@Override
	public void unsetMultiSurface() {
		multiSurfacePropertyType.setMultiSurface(null);
	}
	
}
