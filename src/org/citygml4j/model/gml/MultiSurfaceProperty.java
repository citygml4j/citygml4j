package org.citygml4j.model.gml;

public interface MultiSurfaceProperty extends GMLBase, AssociationAttributeGroup {
	public MultiSurface getMultiSurface();
	public boolean isSetMultiSurface();

	public void setMultiSurface(MultiSurface multiSurface);
	public void unsetMultiSurface();
}
