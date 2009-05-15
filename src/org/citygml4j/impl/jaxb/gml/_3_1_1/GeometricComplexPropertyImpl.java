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

	public CompositeCurve getCompositeCurve() {
		if (geometricComplexPropertyType.isSetCompositeCurve())
			return new CompositeCurveImpl(geometricComplexPropertyType.getCompositeCurve());

		return null;
	}

	public CompositeSolid getCompositeSolid() {
		if (geometricComplexPropertyType.isSetCompositeSolid())
			return new CompositeSolidImpl(geometricComplexPropertyType.getCompositeSolid());

		return null;
	}

	public CompositeSurface getCompositeSurface() {
		if (geometricComplexPropertyType.isSetCompositeSurface())
			return new CompositeSurfaceImpl(geometricComplexPropertyType.getCompositeSurface());

		return null;
	}

	public GeometricComplex getGeometricComplex() {
		if (geometricComplexPropertyType.isSetGeometricComplex())
			return new GeometricComplexImpl(geometricComplexPropertyType.getGeometricComplex());

		return null;
	}
	
	public void setGeometricComplex(GeometricComplex geometricComplex) {
		geometricComplexPropertyType.setGeometricComplex(((GeometricComplexImpl)geometricComplex).getJAXBObject());
		geometricComplexPropertyType.setCompositeCurve(null);
		geometricComplexPropertyType.setCompositeSolid(null);
		geometricComplexPropertyType.setCompositeSurface(null);
	}

	public void setCompositeCurve(CompositeCurve compositeCurve) {
		geometricComplexPropertyType.setCompositeCurve(((CompositeCurveImpl)compositeCurve).getJAXBObject());
		geometricComplexPropertyType.setCompositeSolid(null);
		geometricComplexPropertyType.setCompositeSurface(null);
		geometricComplexPropertyType.setGeometricComplex(null);
	}

	public void setCompositeSolid(CompositeSolid compositeSolid) {
		geometricComplexPropertyType.setCompositeSolid(((CompositeSolidImpl)compositeSolid).getJAXBObject());
		geometricComplexPropertyType.setCompositeCurve(null);
		geometricComplexPropertyType.setCompositeSurface(null);
		geometricComplexPropertyType.setGeometricComplex(null);
	}

	public void setCompositeSurface(CompositeSurface compositeSurface) {
		geometricComplexPropertyType.setCompositeSurface(((CompositeSurfaceImpl)compositeSurface).getJAXBObject());
		geometricComplexPropertyType.setCompositeCurve(null);
		geometricComplexPropertyType.setCompositeSolid(null);
		geometricComplexPropertyType.setGeometricComplex(null);
	}

	public String getActuate() {
		return geometricComplexPropertyType.getActuate();
	}

	public String getArcrole() {
		return geometricComplexPropertyType.getArcrole();
	}

	public String getHref() {
		return geometricComplexPropertyType.getHref();
	}

	public String getRemoteSchema() {
		return geometricComplexPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return geometricComplexPropertyType.getRole();
	}

	public String getShow() {
		return geometricComplexPropertyType.getShow();
	}

	public String getTitle() {
		return geometricComplexPropertyType.getTitle();
	}

	public String getType() {
		return geometricComplexPropertyType.getType();
	}

	public void setActuate(String actuate) {
		geometricComplexPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		geometricComplexPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		geometricComplexPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		geometricComplexPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		geometricComplexPropertyType.setRole(role);
	}

	public void setShow(String show) {
		geometricComplexPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		geometricComplexPropertyType.setTitle(title);
	}

	public void setType(String type) {
		geometricComplexPropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return geometricComplexPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return geometricComplexPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return geometricComplexPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return geometricComplexPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return geometricComplexPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return geometricComplexPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return geometricComplexPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return geometricComplexPropertyType.isSetType();
	}

	public void unsetActuate() {
		geometricComplexPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		geometricComplexPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		geometricComplexPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		geometricComplexPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		geometricComplexPropertyType.setRole(null);
	}

	public void unsetShow() {
		geometricComplexPropertyType.setShow(null);
	}

	public void unsetTitle() {
		geometricComplexPropertyType.setTitle(null);
	}

	public void unsetType() {
		geometricComplexPropertyType.setType(null);
	}

	public boolean isSetCompositeCurve() {
		return geometricComplexPropertyType.isSetCompositeCurve();
	}

	public boolean isSetCompositeSolid() {
		return geometricComplexPropertyType.isSetCompositeSolid();
	}

	public boolean isSetCompositeSurface() {
		return geometricComplexPropertyType.isSetCompositeSurface();
	}

	public boolean isSetGeometricComplex() {
		return geometricComplexPropertyType.isSetGeometricComplex();
	}

	public void unsetCompositeCurve() {
		geometricComplexPropertyType.setCompositeCurve(null);
	}

	public void unsetCompositeSolid() {
		geometricComplexPropertyType.setCompositeSolid(null);
	}

	public void unsetCompositeSurface() {
		geometricComplexPropertyType.setCompositeSurface(null);
	}

	public void unsetGeometricComplex() {
		geometricComplexPropertyType.setGeometricComplex(null);
	}
	
}
