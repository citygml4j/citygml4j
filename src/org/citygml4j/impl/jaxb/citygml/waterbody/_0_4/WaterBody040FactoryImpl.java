package org.citygml4j.impl.jaxb.citygml.waterbody._0_4;

import org.citygml4j.impl.jaxb.citygml.AbstractWaterBodyFactoryImpl;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;

public class WaterBody040FactoryImpl extends AbstractWaterBodyFactoryImpl {

	@Override
	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty() {
		return new BoundedByWaterSurfacePropertyImpl();
	}

	@Override
	public WaterBody createWaterBody() {
		return new WaterBodyImpl();
	}

	@Override
	public WaterClosureSurface createWaterClosureSurface() {
		return new WaterClosureSurfaceImpl();
	}

	@Override
	public WaterGroundSurface createWaterGroundSurface() {
		return new WaterGroundSurfaceImpl();
	}

	@Override
	public WaterSurface createWaterSurface() {
		return new WaterSurfaceImpl();
	}

}
