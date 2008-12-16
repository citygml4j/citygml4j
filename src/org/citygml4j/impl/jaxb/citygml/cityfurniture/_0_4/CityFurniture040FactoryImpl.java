package org.citygml4j.impl.jaxb.citygml.cityfurniture._0_4;

import org.citygml4j.impl.jaxb.citygml.AbstractCityFurnitureFactoryImpl;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;

public class CityFurniture040FactoryImpl extends AbstractCityFurnitureFactoryImpl {

	@Override
	public CityFurniture createCityFurniture() {
		return new CityFurnitureImpl();
	}

}
