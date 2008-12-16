package org.citygml4j.impl.jaxb.citygml.vegetation._1;

import org.citygml4j.impl.jaxb.citygml.AbstractVegetationFactoryImpl;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;

public class Vegetation100FactoryImpl extends AbstractVegetationFactoryImpl {

	@Override
	public PlantCover createPlantCover() {
		return new PlantCoverImpl();
	}

	@Override
	public SolitaryVegetationObject createSolitaryVegetationObject() {
		return new SolitaryVegetationObjectImpl();
	}

}
