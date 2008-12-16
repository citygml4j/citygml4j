package org.citygml4j.model.gml;

public interface GeometricComplexProperty extends GMLBase, AssociationAttributeGroup {
	public GeometricComplex getGeometricComplex();
	public CompositeCurve getCompositeCurve();
	public CompositeSurface getCompositeSurface();
	public CompositeSolid getCompositeSolid();
	public boolean isSetGeometricComplex();
	public boolean isSetCompositeCurve();
	public boolean isSetCompositeSurface();
	public boolean isSetCompositeSolid();
	
	public void setGeometricComplex(GeometricComplex geometricComplex);
	public void unsetGeometricComplex();
	public void unsetCompositeCurve();
	public void unsetCompositeSurface();
	public void unsetCompositeSolid();
}
