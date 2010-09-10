package org.citygml4j.model.gml.geometry.complexes;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface CompositeSurfaceProperty extends GeometryProperty<CompositeSurface> {
	public CompositeSurface getCompositeSurface();
	public boolean isSetCompositeSurface();
	
	public void setCompositeSurface(CompositeSurface compositeSurface);
	public void unsetCompositeSurface();
}
