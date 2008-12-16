package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.cityfurniture._0_4.CityFurniture040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.cityfurniture._1.CityFurniture100FactoryImpl;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityfurniture.CityFurnitureFactory;
import org.citygml4j.model.citygml.cityfurniture.CityFurnitureModule;

public abstract class AbstractCityFurnitureFactoryImpl implements CityFurnitureFactory {
	private static CityFurniture040FactoryImpl factory040 = new CityFurniture040FactoryImpl();
	private static CityFurniture100FactoryImpl factory100 = new CityFurniture100FactoryImpl();
	
	public static CityFurnitureFactory getInstance(CityFurnitureModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	@Override
	public abstract CityFurniture createCityFurniture();

}
