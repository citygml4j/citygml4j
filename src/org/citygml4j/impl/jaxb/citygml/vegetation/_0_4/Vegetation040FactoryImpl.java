package org.citygml4j.impl.jaxb.citygml.vegetation._0_4;

import org.citygml4j.impl.jaxb.citygml.AbstractVegetationFactoryImpl;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;

public class Vegetation040FactoryImpl extends AbstractVegetationFactoryImpl {

	@Override
	public PlantCover createPlantCover() {
		return new PlantCoverImpl();
	}

	@Override
	public SolitaryVegetationObject createSolitaryVegetationObject() {
		return new SolitaryVegetationObjectImpl();
	}

}
