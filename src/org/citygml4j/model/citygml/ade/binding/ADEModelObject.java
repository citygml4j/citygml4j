package org.citygml4j.model.citygml.ade.binding;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.ade.ADEModule;

public interface ADEModelObject extends ADEComponent {

	@Override
	default CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADE_COMPONENT;
	}

	@Override
	default ModelType getModelType() {
		return ModelType.CITYGML_ADE;
	}

	@Override
	default ADEClass getADEClass() {
		return ADEClass.MODEL_OBJECT;
	}
	
	default ADEModule getADEModule() {
		return null;
	}
	
}
