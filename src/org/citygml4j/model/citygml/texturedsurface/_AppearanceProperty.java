package org.citygml4j.model.citygml.texturedsurface;

import org.citygml4j.model.gml.base.AssociationByRepOrRef;

public interface _AppearanceProperty extends TexturedSurfaceModuleComponent, AssociationByRepOrRef<_AbstractAppearance> {
	public String getOrientation();
	public _AbstractAppearance getAppearance();
	public boolean isSetOrientation();
	public boolean isSetAppearance();

	public void setOrientation(String orientation);
	public void setAppearance(_AbstractAppearance _appearance);
	public void unsetAppearance();
}
