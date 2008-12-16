package org.citygml4j.model.gml;

public interface SurfaceProperty extends GMLBase, AssociationAttributeGroup {
	public AbstractSurface getSurface();
	public boolean isSetSurface();
	
	public void setSurface(AbstractSurface abstractSurface);
	public void unsetSurface();
}
