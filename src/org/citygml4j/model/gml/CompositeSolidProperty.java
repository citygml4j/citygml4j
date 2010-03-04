package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface CompositeSolidProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public CompositeSolid getCompositeSolid();
	public boolean isSetCompositeSolid();

	public void setCompositeSolid(CompositeSolid compositeSolid);
	public void unsetCompositeSolid();
}
