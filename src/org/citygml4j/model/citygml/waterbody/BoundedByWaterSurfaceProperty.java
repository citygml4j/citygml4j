package org.citygml4j.model.citygml.waterbody;

import org.citygml4j.model.gml.Association;

public interface BoundedByWaterSurfaceProperty extends WaterBodyModuleComponent, Association<WaterBoundarySurface> {
	public WaterBoundarySurface getWaterBoundarySurface();
	public boolean isSetWaterBoundarySurface();
	
	public void setWaterBoundarySurface(WaterBoundarySurface waterBoundarySurface);
	public void unsetWaterBoundarySurface();
}
