package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.gml.Association;

public interface SurfaceDataProperty extends AppearanceModuleComponent, Association<AbstractSurfaceData> {
	public AbstractSurfaceData getSurfaceData();
	public boolean isSetSurfaceData();
	
	public void setSurfaceData(AbstractSurfaceData surfaceData);
	public void unsetSurfaceData();
}
