package org.citygml4j.impl.jaxb.citygml.landuse._1;

import org.citygml4j.impl.jaxb.citygml.AbstractLandUseFactoryImpl;
import org.citygml4j.model.citygml.landuse.LandUse;

public class LandUse100FactoryImpl extends AbstractLandUseFactoryImpl {

	@Override
	public LandUse createLandUse() {
		return new LandUseImpl();
	}

}
