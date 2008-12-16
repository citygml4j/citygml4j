package org.citygml4j.model.citygml.waterbody;

public interface WaterBodyFactory {
	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty();
	public WaterBody createWaterBody();
	public WaterClosureSurface createWaterClosureSurface();
	public WaterGroundSurface createWaterGroundSurface();
	public WaterSurface createWaterSurface();
}
