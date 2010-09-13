package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.CoreModule;

public class GeneralizationRelationImpl extends FeaturePropertyImpl<AbstractCityObject> implements GeneralizationRelation {
	private CoreModule module;
	
	public GeneralizationRelationImpl() {
		
	}
	
	public GeneralizationRelationImpl(CoreModule module) {
		this.module = module;
	}
	
	public AbstractCityObject getCityObject() {
		return super.getObject();
	}

	public boolean isSetCityObject() {
		return super.isSetObject();
	}

	public void setCityObject(AbstractCityObject cityObject) {
		super.setObject(cityObject);
	}

	public void unsetCityObject() {
		super.unsetObject();
	}
	
	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERALIZATION_RELATION;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeneralizationRelationImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeneralizationRelation copy = (target == null) ? new GeneralizationRelationImpl() : (GeneralizationRelation)target;
		return super.copyTo(copy, copyBuilder);
	}

}
