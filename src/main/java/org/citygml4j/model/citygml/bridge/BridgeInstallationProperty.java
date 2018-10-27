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

public class BridgeInstallationProperty extends FeatureProperty<BridgeInstallation> implements BridgeModuleComponent {
	private BridgeModule module;
	
	public BridgeInstallationProperty() {
		
	}
	
	public BridgeInstallationProperty(BridgeInstallation bridgeInstallation) {
		super(bridgeInstallation);
	}
	
	public BridgeInstallationProperty(String href) {
		super(href);
	}
	
	public BridgeInstallationProperty(BridgeModule module) {
		this.module = module;
	}
	
	public BridgeInstallation getBridgeInstallation() {
		return super.getObject();
	}

	public boolean isSetBridgeInstallation() {
		return super.isSetObject();
	}

	public void setBridgeInstallation(BridgeInstallation bridgeInstallation) {
		super.setObject(bridgeInstallation);
	}

	public void unsetBridgeInstallation() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BRIDGE_INSTALLATION_PROPERTY;
	}

	public final BridgeModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<BridgeInstallation> getAssociableClass() {
		return BridgeInstallation.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BridgeInstallationProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BridgeInstallationProperty copy = (target == null) ? new BridgeInstallationProperty() : (BridgeInstallationProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
