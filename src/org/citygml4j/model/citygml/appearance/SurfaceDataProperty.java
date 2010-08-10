package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface SurfaceDataProperty extends AppearanceModuleComponent, FeatureProperty<AbstractSurfaceData> {
	public AbstractSurfaceData getSurfaceData();
	public boolean isSetSurfaceData();
	
	public void setSurfaceData(AbstractSurfaceData surfaceData);
	public void unsetSurfaceData();
}
