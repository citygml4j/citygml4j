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
package org.citygml4j.model.citygml.tunnel;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.TunnelModule;

public class InteriorHollowSpaceProperty extends FeatureProperty<HollowSpace> implements TunnelModuleComponent {
	private TunnelModule module;
	
	public InteriorHollowSpaceProperty() {
		
	}
	
	public InteriorHollowSpaceProperty(HollowSpace hollowSpace) {
		super(hollowSpace);
	}
	
	public InteriorHollowSpaceProperty(String href) {
		super(href);
	}
	
	public InteriorHollowSpaceProperty(TunnelModule module) {
		this.module = module;
	}
	
	public HollowSpace getHollowSpace() {
		return super.getObject();
	}

	public boolean isSetHollowSpace() {
		return super.isSetObject();
	}

	public void setHollowSpace(HollowSpace hollowSpace) {
		super.setObject(hollowSpace);
	}

	public void unsetHollowSpace() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIOR_HOLLOW_SPACE_PROPERTY;
	}

	public final TunnelModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<HollowSpace> getAssociableClass() {
		return HollowSpace.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorHollowSpaceProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InteriorHollowSpaceProperty copy = (target == null) ? new InteriorHollowSpaceProperty() : (InteriorHollowSpaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
