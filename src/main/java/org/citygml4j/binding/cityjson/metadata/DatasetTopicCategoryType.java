/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.binding.cityjson.metadata;

import com.google.gson.annotations.SerializedName;

public enum DatasetTopicCategoryType {
	@SerializedName("farming")
	FARMING("farming"),
	@SerializedName("bioata")
	BIOATA("bioata"),
	@SerializedName("boundaries")
	BOUNDARIES("boundaries"),
	@SerializedName("climatology")
	CLIMATOLOGY("climatology"),
	@SerializedName("meteorology")
	METEOROLOGY("meteorology"),
	@SerializedName("atmosphere")
	ATMOSPHERE("atmosphere"),
	@SerializedName("economy")
	ECONOMY("economy"),
	@SerializedName("elevation")
	ELEVATION("elevation"),
	@SerializedName("environment")
	ENVIRONMENT("environment"),
	@SerializedName("geoscientificInformation")
	GEOSCIENTIFIC_INFORMATION("geoscientificInformation"),
	@SerializedName("health")
	HEALTH("health"),
	@SerializedName("imageryBaseMapsEarthCover")
	IMAGERY_BASED_MAPS_EARTH_COVER("imageryBaseMapsEarthCover"),
	@SerializedName("intelligenceMilitary")
	INTELLIGENCE_MILITARY("intelligenceMilitary"),
	@SerializedName("inlandWaters")
	INLAND_WATERS("inlandWaters"),
	@SerializedName("location")
	LOCATION("location"),
	@SerializedName("oceans")
	OCEANS("oceans"),
	@SerializedName("planningCadastre")
	PLANNING_CADASTRE("planningCadastre"),
	@SerializedName("society")
	SOCIETY("society"),
	@SerializedName("structure")
	STRCTURE("structure"),
	@SerializedName("transportation")
	TRANSPORTATION("transportation"),
	@SerializedName("utilitiesCommunication")
	UTILITIES_COMMUNICATION("utilitiesCommunication"),
	@SerializedName("extraTerrestrial")
	EXTRA_TERRESTRIAL("extraTerrestrial"),
	@SerializedName("disaster")
	DISASTER("disaster");

	private final String value;

	private DatasetTopicCategoryType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static DatasetTopicCategoryType fromValue(String value) {
		for (DatasetTopicCategoryType type : DatasetTopicCategoryType.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
