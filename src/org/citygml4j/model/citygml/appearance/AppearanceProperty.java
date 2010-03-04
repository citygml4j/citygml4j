package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.gml.FeatureProperty;

public interface AppearanceProperty extends AppearanceModuleComponent, FeatureProperty<Appearance> {
	public Appearance getAppearance();
	public boolean isSetAppearance();
	
	public void setAppearance(Appearance appearance);
	public void unsetAppearance();
}
