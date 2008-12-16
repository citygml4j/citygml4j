package org.citygml4j.model.gml;

public interface CompositeSurfaceProperty extends GMLBase, AssociationAttributeGroup {
	public CompositeSurface getCompositeSurface();
	public boolean isSetCompositeSurface();
	
	public void setCompositeSurface(CompositeSurface compositeSurface);
	public void unsetCompositeSurface();
}
