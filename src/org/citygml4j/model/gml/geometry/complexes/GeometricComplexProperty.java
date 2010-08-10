package org.citygml4j.model.gml.geometry.complexes;

import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface GeometricComplexProperty extends GeometryProperty<AbstractGeometry> {
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
