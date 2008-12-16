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

	@Override
	public CompositeSurface getCompositeSurface() {
		if (compositeSurfacePropertyType.isSetCompositeSurface())
			return new CompositeSurfaceImpl(compositeSurfacePropertyType.getCompositeSurface());

		return null;
	}

	@Override
	public String getActuate() {
		return compositeSurfacePropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return compositeSurfacePropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return compositeSurfacePropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return compositeSurfacePropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return compositeSurfacePropertyType.getRole();
	}

	@Override
	public String getShow() {
		return compositeSurfacePropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return compositeSurfacePropertyType.getTitle();
	}

	@Override
	public String getType() {
		return compositeSurfacePropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		compositeSurfacePropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		compositeSurfacePropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		compositeSurfacePropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		compositeSurfacePropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		compositeSurfacePropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		compositeSurfacePropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		compositeSurfacePropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		compositeSurfacePropertyType.setType(type);
	}
	
	@Override
	public boolean isSetActuate() {
		return compositeSurfacePropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return compositeSurfacePropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return compositeSurfacePropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return compositeSurfacePropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return compositeSurfacePropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return compositeSurfacePropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return compositeSurfacePropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return compositeSurfacePropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		compositeSurfacePropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		compositeSurfacePropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		compositeSurfacePropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		compositeSurfacePropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		compositeSurfacePropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		compositeSurfacePropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		compositeSurfacePropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		compositeSurfacePropertyType.setType(null);
	}

	@Override
	public boolean isSetCompositeSurface() {
		return compositeSurfacePropertyType.isSetCompositeSurface();
	}

	@Override
	public void setCompositeSurface(CompositeSurface compositeSurface) {
		compositeSurfacePropertyType.setCompositeSurface(((CompositeSurfaceImpl)compositeSurface).getJAXBObject());
	}

	@Override
	public void unsetCompositeSurface() {
		compositeSurfacePropertyType.setCompositeSurface(null);
	}
	
}
