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
package org.citygml4j.model.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.BuildingModule;

public class IntBuildingInstallationProperty extends FeatureProperty<IntBuildingInstallation> implements BuildingModuleComponent {
	private BuildingModule module;
	
	public IntBuildingInstallationProperty() {
		
	}
	
	public IntBuildingInstallationProperty(IntBuildingInstallation intBuildingInstallation) {
		super(intBuildingInstallation);
	}
	
	public IntBuildingInstallationProperty(String href) {
		super(href);
	}
	
	public IntBuildingInstallationProperty(BuildingModule module) {
		this.module = module;
	}
	
	public IntBuildingInstallation getIntBuildingInstallation() {
		return super.getObject();
	}

	public boolean isSetIntBuildingInstallation() {
		return super.isSetObject();
	}

	public void setIntBuildingInstallation(IntBuildingInstallation intBuildingInstallation) {
		super.setObject(intBuildingInstallation);
	}

	public void unsetIntBuildingInstallation() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INT_BUILDING_INSTALLATION_PROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<IntBuildingInstallation> getAssociableClass() {
		return IntBuildingInstallation.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntBuildingInstallationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntBuildingInstallationProperty copy = (target == null) ? new IntBuildingInstallationProperty() : (IntBuildingInstallationProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
