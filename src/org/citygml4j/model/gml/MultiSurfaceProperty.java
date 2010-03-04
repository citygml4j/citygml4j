package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface MultiSurfaceProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public MultiSurface getMultiSurface();
	public boolean isSetMultiSurface();

	public void setMultiSurface(MultiSurface multiSurface);
	public void unsetMultiSurface();
}
