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

public class InteriorBridgeRoomProperty extends FeatureProperty<BridgeRoom> implements BridgeModuleComponent {
	private BridgeModule module;
	
	public InteriorBridgeRoomProperty() {
		
	}
	
	public InteriorBridgeRoomProperty(BridgeRoom bridgeRoom) {
		super(bridgeRoom);
	}
	
	public InteriorBridgeRoomProperty(String href) {
		super(href);
	}
	
	public InteriorBridgeRoomProperty(BridgeModule module) {
		this.module = module;
	}
	
	public BridgeRoom getBridgeRoom() {
		return super.getObject();
	}

	public boolean isSetBridgeRoom() {
		return super.isSetObject();
	}

	public void setBridgeRoom(BridgeRoom room) {
		super.setObject(room);
	}

	public void unsetBridgeRoom() {
		super.unsetObject();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIOR_BRIDGE_ROOM_PROPERTY;
	}

	public final BridgeModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Class<BridgeRoom> getAssociableClass() {
		return BridgeRoom.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorBridgeRoomProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InteriorBridgeRoomProperty copy = (target == null) ? new InteriorBridgeRoomProperty() : (InteriorBridgeRoomProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
