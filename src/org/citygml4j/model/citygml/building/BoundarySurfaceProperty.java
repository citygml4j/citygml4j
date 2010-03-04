package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.Association;

public interface BoundarySurfaceProperty extends BuildingModuleComponent, Association<BoundarySurface> {
	public BoundarySurface getBoundarySurface();
	public boolean isSetBoundarySurface();
	
	public void setBoundarySurface(BoundarySurface boundarySurface);
	public void unsetBoundarySurface();
}
