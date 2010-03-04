package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface SurfaceProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public AbstractSurface getSurface();
	public boolean isSetSurface();
	
	public void setSurface(AbstractSurface abstractSurface);
	public void unsetSurface();
}
