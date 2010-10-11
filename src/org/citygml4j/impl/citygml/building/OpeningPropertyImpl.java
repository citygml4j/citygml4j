package org.citygml4j.impl.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.AbstractOpening;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.BuildingModule;

public class OpeningPropertyImpl extends FeaturePropertyImpl<AbstractOpening> implements OpeningProperty {
	private BuildingModule module;
	
	public OpeningPropertyImpl() {
		
	}
	
	public OpeningPropertyImpl(BuildingModule module) {
		this.module = module;
	}
	
	public AbstractOpening getOpening() {
		return super.getObject();
	}

	public boolean isSetOpening() {
		return super.isSetObject();
	}

	public void setOpening(AbstractOpening opening) {
		super.setObject(opening);
	}

	public void unsetOpening() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.OPENING_PROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OpeningPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OpeningProperty copy = (target == null) ? new OpeningPropertyImpl() : (OpeningProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
