package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.CoreModule;

public class CityObjectMemberImpl extends FeaturePropertyImpl<AbstractCityObject> implements CityObjectMember {
	private CoreModule module;
	
	public CityObjectMemberImpl() {
		
	}
	
	public CityObjectMemberImpl(CoreModule module) {
		this.module = module;
	}
	
	public AbstractCityObject getCityObject() {
		return super.getFeature();
	}

	public boolean isSetCityObject() {
		return super.isSetFeature();
	}

	public void setCityObject(AbstractCityObject cityObject) {
		super.setFeature(cityObject);
	}

	public void unsetCityObject() {
		super.unsetFeature();
	}
	
	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITY_OBJECT_MEMBER;
	}

	public CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CityObjectMemberImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CityObjectMember copy = (target == null) ? new CityObjectMemberImpl() : (CityObjectMember)target;
		return super.copyTo(copy, copyBuilder);
	}

}
