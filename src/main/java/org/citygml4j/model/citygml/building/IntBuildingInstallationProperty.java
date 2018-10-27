/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
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
