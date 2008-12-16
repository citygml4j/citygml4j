package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.landuse._0_4.LandUse040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.landuse._1.LandUse100FactoryImpl;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.landuse.LandUseFactory;
import org.citygml4j.model.citygml.landuse.LandUseModule;

public abstract class AbstractLandUseFactoryImpl implements LandUseFactory {
	private static LandUse040FactoryImpl factory040 = new LandUse040FactoryImpl();
	private static LandUse100FactoryImpl factory100 = new LandUse100FactoryImpl();
	
	public static LandUseFactory getInstance(LandUseModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	@Override
	public abstract LandUse createLandUse();

}
