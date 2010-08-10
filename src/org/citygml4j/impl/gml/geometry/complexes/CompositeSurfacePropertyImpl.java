package org.citygml4j.impl.gml.geometry.complexes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurfaceProperty;

public class CompositeSurfacePropertyImpl extends GeometryPropertyImpl<CompositeSurface> implements CompositeSurfaceProperty {

	public CompositeSurface getCompositeSurface() {
		return super.getGeometry();
	}

	public boolean isSetCompositeSurface() {
		return super.isSetGeometry();
	}

	public void setCompositeSurface(CompositeSurface compositeSurface) {
		super.setGeometry(compositeSurface);
	}

	public void unsetCompositeSurface() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_SURFACE_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeSurfacePropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeSurfaceProperty copy = (target == null) ? new CompositeSurfacePropertyImpl() : (CompositeSurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
