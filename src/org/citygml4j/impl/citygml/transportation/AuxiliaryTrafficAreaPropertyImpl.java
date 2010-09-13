package org.citygml4j.impl.citygml.transportation;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.TransportationModule;

public class AuxiliaryTrafficAreaPropertyImpl extends FeaturePropertyImpl<AuxiliaryTrafficArea> implements AuxiliaryTrafficAreaProperty {
	private TransportationModule module;
	
	public AuxiliaryTrafficAreaPropertyImpl() {
		
	}
	
	public AuxiliaryTrafficAreaPropertyImpl(TransportationModule module) {
		this.module = module;
	}
	
	public AuxiliaryTrafficArea getAuxiliaryTrafficArea() {
		return super.getObject();
	}

	public boolean isSetAuxiliaryTrafficArea() {
		return super.isSetObject();
	}

	public void setAuxiliaryTrafficArea(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		super.setObject(auxiliaryTrafficArea);
	}

	public void unsetAuxiliaryTrafficArea() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.AUXILIARY_TRAFFIC_AREA_PROPERTY;
	}

	public final TransportationModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AuxiliaryTrafficAreaPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AuxiliaryTrafficAreaProperty copy = (target == null) ? new AuxiliaryTrafficAreaPropertyImpl() : (AuxiliaryTrafficAreaProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
