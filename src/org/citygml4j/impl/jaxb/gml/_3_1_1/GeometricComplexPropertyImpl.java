package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.GeometricComplexPropertyType;
import org.citygml4j.model.gml.CompositeCurve;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricComplexProperty;

public class GeometricComplexPropertyImpl extends GMLBaseImpl implements GeometricComplexProperty {
	private GeometricComplexPropertyType geometricComplexPropertyType;

	public GeometricComplexPropertyImpl() {
		geometricComplexPropertyType = new GeometricComplexPropertyType();
	}
	
	public GeometricComplexPropertyImpl(GeometricComplexPropertyType geometricComplexPropertyType) {
		this.geometricComplexPropertyType = geometricComplexPropertyType;
	}

	@Override
	public GeometricComplexPropertyType getJAXBObject() {
		return geometricComplexPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRICCOMPLEXPROPERTY;
	}

	@Override
	public CompositeCurve getCompositeCurve() {
		if (geometricComplexPropertyType.isSetCompositeCurve())
			return new CompositeCurveImpl(geometricComplexPropertyType.getCompositeCurve());

		return null;
	}

	@Override
	public CompositeSolid getCompositeSolid() {
		if (geometricComplexPropertyType.isSetCompositeSolid())
			return new CompositeSolidImpl(geometricComplexPropertyType.getCompositeSolid());

		return null;
	}

	@Override
	public CompositeSurface getCompositeSurface() {
		if (geometricComplexPropertyType.isSetCompositeSurface())
			return new CompositeSurfaceImpl(geometricComplexPropertyType.getCompositeSurface());

		return null;
	}

	@Override
	public GeometricComplex getGeometricComplex() {
		if (geometricComplexPropertyType.isSetGeometricComplex())
			return new GeometricComplexImpl(geometricComplexPropertyType.getGeometricComplex());

		return null;
	}
	
	@Override
	public void setGeometricComplex(GeometricComplex geometricComplex) {
		geometricComplexPropertyType.setGeometricComplex(((GeometricComplexImpl)geometricComplex).getJAXBObject());
		geometricComplexPropertyType.setCompositeCurve(null);
		geometricComplexPropertyType.setCompositeSolid(null);
		geometricComplexPropertyType.setCompositeSurface(null);
	}

	@Override
	public void setCompositeCurve(CompositeCurve compositeCurve) {
		geometricComplexPropertyType.setCompositeCurve(((CompositeCurveImpl)compositeCurve).getJAXBObject());
		geometricComplexPropertyType.setCompositeSolid(null);
		geometricComplexPropertyType.setCompositeSurface(null);
		geometricComplexPropertyType.setGeometricComplex(null);
	}

	@Override
	public void setCompositeSolid(CompositeSolid compositeSolid) {
		geometricComplexPropertyType.setCompositeSolid(((CompositeSolidImpl)compositeSolid).getJAXBObject());
		geometricComplexPropertyType.setCompositeCurve(null);
		geometricComplexPropertyType.setCompositeSurface(null);
		geometricComplexPropertyType.setGeometricComplex(null);
	}

	@Override
	public void setCompositeSurface(CompositeSurface compositeSurface) {
		geometricComplexPropertyType.setCompositeSurface(((CompositeSurfaceImpl)compositeSurface).getJAXBObject());
		geometricComplexPropertyType.setCompositeCurve(null);
		geometricComplexPropertyType.setCompositeSolid(null);
		geometricComplexPropertyType.setGeometricComplex(null);
	}

	@Override
	public String getActuate() {
		return geometricComplexPropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return geometricComplexPropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return geometricComplexPropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return geometricComplexPropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return geometricComplexPropertyType.getRole();
	}

	@Override
	public String getShow() {
		return geometricComplexPropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return geometricComplexPropertyType.getTitle();
	}

	@Override
	public String getType() {
		return geometricComplexPropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		geometricComplexPropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		geometricComplexPropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		geometricComplexPropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		geometricComplexPropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		geometricComplexPropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		geometricComplexPropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		geometricComplexPropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		geometricComplexPropertyType.setType(type);
	}
	
	@Override
	public boolean isSetActuate() {
		return geometricComplexPropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return geometricComplexPropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return geometricComplexPropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return geometricComplexPropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return geometricComplexPropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return geometricComplexPropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return geometricComplexPropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return geometricComplexPropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		geometricComplexPropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		geometricComplexPropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		geometricComplexPropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		geometricComplexPropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		geometricComplexPropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		geometricComplexPropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		geometricComplexPropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		geometricComplexPropertyType.setType(null);
	}

	@Override
	public boolean isSetCompositeCurve() {
		return geometricComplexPropertyType.isSetCompositeCurve();
	}

	@Override
	public boolean isSetCompositeSolid() {
		return geometricComplexPropertyType.isSetCompositeSolid();
	}

	@Override
	public boolean isSetCompositeSurface() {
		return geometricComplexPropertyType.isSetCompositeSurface();
	}

	@Override
	public boolean isSetGeometricComplex() {
		return geometricComplexPropertyType.isSetGeometricComplex();
	}

	@Override
	public void unsetCompositeCurve() {
		geometricComplexPropertyType.setCompositeCurve(null);
	}

	@Override
	public void unsetCompositeSolid() {
		geometricComplexPropertyType.setCompositeSolid(null);
	}

	@Override
	public void unsetCompositeSurface() {
		geometricComplexPropertyType.setCompositeSurface(null);
	}

	@Override
	public void unsetGeometricComplex() {
		geometricComplexPropertyType.setGeometricComplex(null);
	}
	
}
