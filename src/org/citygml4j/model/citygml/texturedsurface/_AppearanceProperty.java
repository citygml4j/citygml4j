package org.citygml4j.model.citygml.texturedsurface;

import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.gml.AssociationAttributeGroup;

public interface _AppearanceProperty extends CityGMLBase, AssociationAttributeGroup {
	public String getOrientation();
	public _Appearance getAppearance();
	public boolean isSetOrientation();
	public boolean isSetAppearance();

	public void setOrientation(String orientation);
	public void setAppearance(_Appearance _appearance);
	public void unsetAppearance();
}
