package org.citygml4j.impl.jaxb.citygml.cityfurniture._1;

import org.citygml4j.impl.jaxb.citygml.AbstractCityFurnitureFactoryImpl;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;

public class CityFurniture100FactoryImpl extends AbstractCityFurnitureFactoryImpl {

	@Override
	public CityFurniture createCityFurniture() {
		return new CityFurnitureImpl();
	}

}
