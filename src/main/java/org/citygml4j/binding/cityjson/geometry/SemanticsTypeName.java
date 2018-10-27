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
package org.citygml4j.binding.cityjson.geometry;

import com.google.gson.annotations.SerializedName;

public enum SemanticsTypeName {
	@SerializedName("RoofSurface")
	ROOF_SURFACE("RoofSurface"),
	@SerializedName("GroundSurface")
	GROUND_SURFACE("GroundSurface"),
	@SerializedName("WallSurface")
	WALL_SURFACE("WallSurface"),
	@SerializedName("ClosureSurface")
	CLOSURE_SURFACE("ClosureSurface"),
	@SerializedName("OuterCeilingSurface")
	OUTER_CEILING_SURFACE("OuterCeilingSurface"),
	@SerializedName("OuterFloorSurface")
	OUTER_FLOOR_SURFACE("OuterFloorSurface"),
	@SerializedName("Window")
	WINDOW("Window"),
	@SerializedName("Door")
	DOOR("Door"),
	@SerializedName("WaterSurface")
	WATER_SURFACE("WaterSurface"),
	@SerializedName("WaterGroundSurface")
	WATER_GROUND_SURFACE("WaterGroundSurface"),
	@SerializedName("WaterClosureSurface")
	WATER_CLOSURE_SURFACE("WaterClosureSurface"),
	@SerializedName("TrafficArea")
	TRAFFIC_AREA("TrafficArea"),
	@SerializedName("AuxiliaryTrafficArea")
	AUXILIARY_TRAFFIC_AREA("AuxiliaryTrafficArea");
	
	private final String value;
	
	private SemanticsTypeName(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static SemanticsTypeName fromValue(String value) {
		for (SemanticsTypeName type : SemanticsTypeName.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
