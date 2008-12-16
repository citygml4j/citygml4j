package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.gml.FeatureProperty;

public interface AppearanceProperty extends CityGMLBase, FeatureProperty {
	public Appearance getAppearance();
	public boolean isSetAppearance();
	
	public void setAppearance(Appearance appearance);
	public void unsetAppearance();
}
