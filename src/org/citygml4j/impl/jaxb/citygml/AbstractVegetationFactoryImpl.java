package org.citygml4j.impl.jaxb.citygml;

import org.citygml4j.impl.jaxb.citygml.vegetation._0_4.Vegetation040FactoryImpl;
import org.citygml4j.impl.jaxb.citygml.vegetation._1.Vegetation100FactoryImpl;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.vegetation.VegetationFactory;
import org.citygml4j.model.citygml.vegetation.VegetationModule;

public abstract class AbstractVegetationFactoryImpl implements VegetationFactory {
	private static Vegetation040FactoryImpl factory040 = new Vegetation040FactoryImpl();
	private static Vegetation100FactoryImpl factory100 = new Vegetation100FactoryImpl();
	
	public static VegetationFactory getInstance(VegetationModule module) {
		switch (module) {
		case v0_4_0:
			return factory040;
		default:
			return factory100;
		}
	}
	
	public abstract PlantCover createPlantCover();

	public abstract SolitaryVegetationObject createSolitaryVegetationObject();

}
