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
package org.citygml4j.model.citygml.bridge;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
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

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
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
