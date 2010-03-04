package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.Association;

public interface ImplicitRepresentationProperty extends CoreModuleComponent, Association<ImplicitGeometry> {
	public ImplicitGeometry getImplicitGeometry();
	public boolean isSetImplicitGeometry();
	
	public void setImplicitGeometry(ImplicitGeometry implicitGeometry);
	public void unsetImplicitGeometry();
}
