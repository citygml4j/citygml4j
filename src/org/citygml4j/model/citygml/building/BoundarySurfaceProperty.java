package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface BoundarySurfaceProperty extends BuildingModuleComponent, FeatureProperty<AbstractBoundarySurface> {
	public AbstractBoundarySurface getBoundarySurface();
	public boolean isSetBoundarySurface();
	
	public void setBoundarySurface(AbstractBoundarySurface boundarySurface);
	public void unsetBoundarySurface();
}
