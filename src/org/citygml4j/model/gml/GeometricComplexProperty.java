package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface GeometricComplexProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public GeometricComplex getGeometricComplex();
	public CompositeCurve getCompositeCurve();
	public CompositeSurface getCompositeSurface();
	public CompositeSolid getCompositeSolid();
	public boolean isSetGeometricComplex();
	public boolean isSetCompositeCurve();
	public boolean isSetCompositeSurface();
	public boolean isSetCompositeSolid();
	
	public void setGeometricComplex(GeometricComplex geometricComplex);
	public void setCompositeCurve(CompositeCurve compositeCurve);
	public void setCompositeSurface(CompositeSurface compositeSurface);
	public void setCompositeSolid(CompositeSolid compositeSolid);
	public void unsetGeometricComplex();
	public void unsetCompositeCurve();
	public void unsetCompositeSurface();
	public void unsetCompositeSolid();
}
