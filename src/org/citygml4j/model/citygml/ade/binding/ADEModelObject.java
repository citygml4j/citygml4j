package org.citygml4j.model.citygml.ade.binding;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;

public interface ADEModelObject extends ADEComponent {

	@Override
	default CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADE_COMPONENT;
	}

	@Override
	default ADEClass getADEClass() {
		return ADEClass.MODEL_OBJECT;
	}
	
}
