package org.citygml4j.impl.gml.geometry.complexes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurve;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolid;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplex;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;

public class GeometricComplexPropertyImpl extends GeometryPropertyImpl<AbstractGeometry> implements GeometricComplexProperty {

	@Override
	public void setObject(AbstractGeometry geometry) {
		if (geometry instanceof CompositeCurve ||
				geometry instanceof CompositeSolid ||
				geometry instanceof CompositeSurface ||
				geometry instanceof GeometricComplex)		
			super.setObject(geometry);
	}

	public CompositeCurve getCompositeCurve() {
		return (super.getGeometry() instanceof CompositeCurve) ? (CompositeCurve)super.getGeometry() : null;
	}

	public CompositeSolid getCompositeSolid() {
		return (super.getGeometry() instanceof CompositeSolid) ? (CompositeSolid)super.getGeometry() : null;
	}

	public CompositeSurface getCompositeSurface() {
		return (super.getGeometry() instanceof CompositeSurface) ? (CompositeSurface)super.getGeometry() : null;
	}

	public GeometricComplex getGeometricComplex() {
		return (super.getGeometry() instanceof GeometricComplex) ? (GeometricComplex)super.getGeometry() : null;
	}

	public boolean isSetCompositeCurve() {
		return (super.getGeometry() instanceof CompositeCurve);
	}

	public boolean isSetCompositeSolid() {
		return (super.getGeometry() instanceof CompositeSolid);
	}

	public boolean isSetCompositeSurface() {
		return (super.getGeometry() instanceof CompositeSurface);
	}

	public boolean isSetGeometricComplex() {
		return (super.getGeometry() instanceof GeometricComplex);
	}

	public void setCompositeCurve(CompositeCurve compositeCurve) {
		super.setObject(compositeCurve);
	}

	public void setCompositeSolid(CompositeSolid compositeSolid) {
		super.setObject(compositeSolid);
	}

	public void setCompositeSurface(CompositeSurface compositeSurface) {
		super.setObject(compositeSurface);
	}

	public void setGeometricComplex(GeometricComplex geometricComplex) {
		super.setGeometry(geometricComplex);
	}

	public void unsetCompositeCurve() {
		super.unsetGeometry();
	}

	public void unsetCompositeSolid() {
		super.unsetGeometry();
	}

	public void unsetCompositeSurface() {
		super.unsetGeometry();
	}

	public void unsetGeometricComplex() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRIC_COMPLEX_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricComplexPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricComplexProperty copy = (target == null) ? new GeometricComplexPropertyImpl() : (GeometricComplexProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
