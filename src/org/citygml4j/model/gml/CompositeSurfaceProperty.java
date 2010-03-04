package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface CompositeSurfaceProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public CompositeSurface getCompositeSurface();
	public boolean isSetCompositeSurface();
	
	public void setCompositeSurface(CompositeSurface compositeSurface);
	public void unsetCompositeSurface();
}
