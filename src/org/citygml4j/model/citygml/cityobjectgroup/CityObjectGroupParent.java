/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.citygml.cityobjectgroup;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;

public class CityObjectGroupParent extends FeatureProperty<AbstractCityObject> implements CityObjectGroupModuleComponent {
	private CityObjectGroupModule module;
	
	public CityObjectGroupParent() {
		
	}
	
	public CityObjectGroupParent(AbstractCityObject abstractCityObject) {
		super(abstractCityObject);
	}
	
	public CityObjectGroupParent(String href) {
		super(href);
	}
	
	public CityObjectGroupParent(CityObjectGroupModule module) {
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
		return CityGMLClass.CITY_OBJECT_GROUP_PARENT;
	}

	public final CityObjectGroupModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<AbstractCityObject> getAssociableClass() {
		return AbstractCityObject.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CityObjectGroupParent(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CityObjectGroupParent copy = (target == null) ? new CityObjectGroupParent() : (CityObjectGroupParent)target;
		return super.copyTo(copy, copyBuilder);
	}

}
