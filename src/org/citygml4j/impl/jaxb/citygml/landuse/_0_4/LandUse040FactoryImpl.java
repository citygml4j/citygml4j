package org.citygml4j.impl.jaxb.citygml.landuse._0_4;

import org.citygml4j.impl.jaxb.citygml.AbstractLandUseFactoryImpl;
import org.citygml4j.model.citygml.landuse.LandUse;

public class LandUse040FactoryImpl extends AbstractLandUseFactoryImpl {

	@Override
	public LandUse createLandUse() {
		return new LandUseImpl();
	}

}
