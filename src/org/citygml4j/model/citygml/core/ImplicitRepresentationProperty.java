package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.base.AssociationByRepOrRef;

public interface ImplicitRepresentationProperty extends CoreModuleComponent, AssociationByRepOrRef<ImplicitGeometry> {
	public ImplicitGeometry getImplicitGeometry();
	public boolean isSetImplicitGeometry();
	
	public void setImplicitGeometry(ImplicitGeometry implicitGeometry);
	public void unsetImplicitGeometry();
}
