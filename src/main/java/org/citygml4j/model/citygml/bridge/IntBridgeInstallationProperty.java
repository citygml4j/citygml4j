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
package org.citygml4j.model.citygml.bridge;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.module.citygml.BridgeModule;

public class IntBridgeInstallationProperty extends FeatureProperty<IntBridgeInstallation> implements BridgeModuleComponent {
	private BridgeModule module;
	
	public IntBridgeInstallationProperty() {
		
	}
	
	public IntBridgeInstallationProperty(IntBridgeInstallation intBridgeInstallation) {
		super(intBridgeInstallation);
	}
	
	public IntBridgeInstallationProperty(String href) {
		super(href);
	}
	
	public IntBridgeInstallationProperty(BridgeModule module) {
		this.module = module;
	}
	
	public IntBridgeInstallation getIntBridgeInstallation() {
		return super.getObject();
	}

	public boolean isSetIntBridgeInstallation() {
		return super.isSetObject();
	}

	public void setIntBridgeInstallation(IntBridgeInstallation intBridgeInstallation) {
		super.setObject(intBridgeInstallation);
	}

	public void unsetIntBridgeInstallation() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INT_BRIDGE_INSTALLATION_PROPERTY;
	}

	public final BridgeModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<IntBridgeInstallation> getAssociableClass() {
		return IntBridgeInstallation.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntBridgeInstallationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntBridgeInstallationProperty copy = (target == null) ? new IntBridgeInstallationProperty() : (IntBridgeInstallationProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
