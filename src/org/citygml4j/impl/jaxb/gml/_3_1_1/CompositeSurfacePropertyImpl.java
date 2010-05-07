package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.CompositeSurfacePropertyType;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.CompositeSurfaceProperty;
import org.citygml4j.model.gml.GMLClass;

public class CompositeSurfacePropertyImpl extends GMLBaseImpl implements CompositeSurfaceProperty {
	private CompositeSurfacePropertyType compositeSurfacePropertyType;

	public CompositeSurfacePropertyImpl() {
		compositeSurfacePropertyType = new CompositeSurfacePropertyType();
	}
	
	public CompositeSurfacePropertyImpl(CompositeSurfacePropertyType compositeSurfacePropertyType) {
		this.compositeSurfacePropertyType = compositeSurfacePropertyType;
	}

	@Override
	public CompositeSurfacePropertyType getJAXBObject() {
		return compositeSurfacePropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITESURFACEPROPERTY;
	}

	public CompositeSurface getCompositeSurface() {
		if (compositeSurfacePropertyType.isSetCompositeSurface())
			return new CompositeSurfaceImpl(compositeSurfacePropertyType.getCompositeSurface());

		return null;
	}

	public String getActuate() {
		return compositeSurfacePropertyType.getActuate();
	}

	public String getArcrole() {
		return compositeSurfacePropertyType.getArcrole();
	}

	public String getHref() {
		return compositeSurfacePropertyType.getHref();
	}

	public String getRemoteSchema() {
		return compositeSurfacePropertyType.getRemoteSchema();
	}

	public String getRole() {
		return compositeSurfacePropertyType.getRole();
	}

	public String getShow() {
		return compositeSurfacePropertyType.getShow();
	}

	public String getTitle() {
		return compositeSurfacePropertyType.getTitle();
	}

	public String getType() {
		return compositeSurfacePropertyType.getType();
	}

	public void setActuate(String actuate) {
		compositeSurfacePropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		compositeSurfacePropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		compositeSurfacePropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		compositeSurfacePropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		compositeSurfacePropertyType.setRole(role);
	}

	public void setShow(String show) {
		compositeSurfacePropertyType.setShow(show);
	}

	public void setTitle(String title) {
		compositeSurfacePropertyType.setTitle(title);
	}

	public void setType(String type) {
		compositeSurfacePropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return compositeSurfacePropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return compositeSurfacePropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return compositeSurfacePropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return compositeSurfacePropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return compositeSurfacePropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return compositeSurfacePropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return compositeSurfacePropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return compositeSurfacePropertyType.isSetType();
	}

	public void unsetActuate() {
		compositeSurfacePropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		compositeSurfacePropertyType.setArcrole(null);
	}

	public void unsetHref() {
		compositeSurfacePropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		compositeSurfacePropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		compositeSurfacePropertyType.setRole(null);
	}

	public void unsetShow() {
		compositeSurfacePropertyType.setShow(null);
	}

	public void unsetTitle() {
		compositeSurfacePropertyType.setTitle(null);
	}

	public void unsetType() {
		compositeSurfacePropertyType.setType(null);
	}

	public boolean isSetCompositeSurface() {
		return compositeSurfacePropertyType.isSetCompositeSurface();
	}

	public void setCompositeSurface(CompositeSurface compositeSurface) {
		compositeSurfacePropertyType.setCompositeSurface(((CompositeSurfaceImpl)compositeSurface).getJAXBObject());
	}

	public void unsetCompositeSurface() {
		compositeSurfacePropertyType.setCompositeSurface(null);
	}
	
}
