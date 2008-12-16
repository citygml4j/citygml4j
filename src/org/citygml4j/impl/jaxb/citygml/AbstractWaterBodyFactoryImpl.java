package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.waterbody._0_4.WaterBody040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.waterbody._1.WaterBody100FactoryImpl;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBodyFactory;
import org.citygml4j.model.citygml.waterbody.WaterBodyModule;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;

public abstract class AbstractWaterBodyFactoryImpl implements WaterBodyFactory {
	private static WaterBody040FactoryImpl factory040 = new WaterBody040FactoryImpl();
	private static WaterBody100FactoryImpl factory100 = new WaterBody100FactoryImpl();
	
	public static WaterBodyFactory getInstance(WaterBodyModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	@Override
	public abstract BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty();

	@Override
	public abstract WaterBody createWaterBody();

	@Override
	public abstract WaterClosureSurface createWaterClosureSurface();

	@Override
	public abstract WaterGroundSurface createWaterGroundSurface();

	@Override
	public abstract WaterSurface createWaterSurface();

}
