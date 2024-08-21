/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

public class InteriorRoomProperty extends FeatureProperty<Room> implements BuildingModuleComponent {

	public InteriorRoomProperty() {
		
	}
	
	public InteriorRoomProperty(Room room) {
		super(room);
	}
	
	public InteriorRoomProperty(String href) {
		super(href);
	}
	
	public Room getRoom() {
		return super.getObject();
	}

	public boolean isSetRoom() {
		return super.isSetObject();
	}

	public void setRoom(Room room) {
		super.setObject(room);
	}

	public void unsetRoom() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIOR_ROOM_PROPERTY;
	}

	@Override
	public Class<Room> getAssociableClass() {
		return Room.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorRoomProperty(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InteriorRoomProperty copy = (target == null) ? new InteriorRoomProperty() : (InteriorRoomProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
