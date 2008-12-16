package org.citygml4j.model.gml;

public interface CompositeSolidProperty extends GMLBase, AssociationAttributeGroup {
	public CompositeSolid getCompositeSolid();
	public boolean isSetCompositeSolid();

	public void setCompositeSolid(CompositeSolid compositeSolid);
	public void unsetCompositeSolid();
}
