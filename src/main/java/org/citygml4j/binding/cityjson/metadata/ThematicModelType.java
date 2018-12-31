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
package org.citygml4j.binding.cityjson.metadata;

import com.google.gson.annotations.SerializedName;
import org.citygml4j.binding.cityjson.metadata.feature.AbstractFeatureDataType;
import org.citygml4j.binding.cityjson.metadata.feature.BridgeDataType;
import org.citygml4j.binding.cityjson.metadata.feature.BuildingDataType;
import org.citygml4j.binding.cityjson.metadata.feature.CityFurnitureDataType;
import org.citygml4j.binding.cityjson.metadata.feature.CityObjectGroupDataType;
import org.citygml4j.binding.cityjson.metadata.feature.GenericCityObjectDataType;
import org.citygml4j.binding.cityjson.metadata.feature.LandUseDataType;
import org.citygml4j.binding.cityjson.metadata.feature.PlantCoverDataType;
import org.citygml4j.binding.cityjson.metadata.feature.RailwayDataType;
import org.citygml4j.binding.cityjson.metadata.feature.RoadDataType;
import org.citygml4j.binding.cityjson.metadata.feature.SolitaryVegetationObjectDataType;
import org.citygml4j.binding.cityjson.metadata.feature.TINReliefDataType;
import org.citygml4j.binding.cityjson.metadata.feature.TransportSquareDataType;
import org.citygml4j.binding.cityjson.metadata.feature.TunnelDataType;
import org.citygml4j.binding.cityjson.metadata.feature.WaterBodyDataType;

public enum ThematicModelType {
	@SerializedName("Building")
	BUILDING("Building", BuildingDataType.class),
	@SerializedName("Road")
	ROAD("Road", RoadDataType.class),
	@SerializedName("Railway")
	RAILWAY("Railway", RailwayDataType.class),
	@SerializedName("TransportSquare")
	TRANSPORT_SQUARE("TransportSquare", TransportSquareDataType.class),
	@SerializedName("TINRelief")
	TIN_RELIEF("TINRelief", TINReliefDataType.class),
	@SerializedName("WaterBody")
	WATER_BODY("WaterBody", WaterBodyDataType.class),
	@SerializedName("PlantCover")
	PLANT_COVER("PlantCover", PlantCoverDataType.class),
	@SerializedName("SolitaryVegetationObject")
	SOLITARY_VEGETATION_OBJECT("SolitaryVegetationObject", SolitaryVegetationObjectDataType.class),
	@SerializedName("LandUse")
	LAND_USE("LandUse", LandUseDataType.class),
	@SerializedName("CityFurniture")
	CITY_FURNITURE("CityFurniture", CityFurnitureDataType.class),
	@SerializedName("GenericCityObject")
	GENERIC_CITY_OBJECT("GenericCityObject", GenericCityObjectDataType.class),
	@SerializedName("Bridge")
	BRIDGE("Bridge", BridgeDataType.class),
	@SerializedName("Tunnel")
	TUNNEL("Tunnel", TunnelDataType.class),
	@SerializedName("CityObjectGroup")
	CITY_OBJECT_GROUP("CityObjectGroup", CityObjectGroupDataType.class);

	private final String value;
	private final Class<? extends AbstractFeatureDataType> metadataClass;

	private ThematicModelType(String value, Class<? extends AbstractFeatureDataType> metadataClass) {
		this.value = value;
		this.metadataClass = metadataClass;
	}
	
	public String getValue() {
		return value;
	}

	public Class<? extends AbstractFeatureDataType> getMetadataClass() {
		return metadataClass;
	}

	@Override
	public String toString() {
		return value;
	}
	
	public static ThematicModelType fromValue(String value) {
		for (ThematicModelType type : ThematicModelType.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
