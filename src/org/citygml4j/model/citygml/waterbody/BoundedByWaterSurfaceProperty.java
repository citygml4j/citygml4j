package org.citygml4j.model.citygml.waterbody;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface BoundedByWaterSurfaceProperty extends WaterBodyModuleComponent, FeatureProperty<AbstractWaterBoundarySurface> {
	public AbstractWaterBoundarySurface getWaterBoundarySurface();
	public boolean isSetWaterBoundarySurface();
	
	public void setWaterBoundarySurface(AbstractWaterBoundarySurface waterBoundarySurface);
	public void unsetWaterBoundarySurface();
}
