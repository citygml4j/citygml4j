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
