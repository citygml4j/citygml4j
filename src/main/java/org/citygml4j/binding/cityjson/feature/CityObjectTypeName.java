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
package org.citygml4j.binding.cityjson.feature;

import com.google.gson.annotations.SerializedName;

public enum CityObjectTypeName {
	@SerializedName("Building")
	BUILDING("Building", BuildingType.class),
	@SerializedName("BuildingPart")
	BUILDING_PART("BuildingPart", BuildingPartType.class),
	@SerializedName("BuildingInstallation")
	BUILDING_INSTALLATION("BuildingInstallation", BuildingInstallationType.class),	
	@SerializedName("Bridge")
	BRIDGE("Bridge", BridgeType.class),
	@SerializedName("BridgePart")
	BRIDGE_PART("BridgePart", BridgePartType.class),
	@SerializedName("BridgeInstallation")
	BRIDGE_INSTALLATION("BridgeInstallation", BridgeInstallationType.class),
	@SerializedName("BridgeConstructionElement")
	BRIDGE_CONSTRUCTION_ELEMENT("BridgeConstructionElement", BridgeConstructionElementType.class),	
	@SerializedName("TINRelief")
	TIN_RELIEF("TINRelief", TINReliefType.class),
	@SerializedName("WaterBody")
	WATER_BODY("WaterBody", WaterBodyType.class),
	@SerializedName("PlantCover")
	PLANT_COVER("PlantCover", PlantCoverType.class),
	@SerializedName("SolitaryVegetationObject")
	SOLITARY_VEGETATION_OBJECT("SolitaryVegetationObject", SolitaryVegetationObjectType.class),
	@SerializedName("LandUse")
	LAND_USE("LandUse", LandUseType.class),
	@SerializedName("CityFurniture")
	CITY_FURNITURE("CityFurniture", CityFurnitureType.class),
	@SerializedName("GenericCityObject")
	GENERIC_CITY_OBJECT("GenericCityObject", GenericCityObjectType.class),
	@SerializedName("Road")
	ROAD("Road", RoadType.class),
	@SerializedName("Railway")
	RAILWAY("Railway", RailwayType.class),
	@SerializedName("TransportSquare")
	TRANSPOR_SQUARE("TransportSquare", TransportSquareType.class),
	@SerializedName("Tunnel")
	TUNNEL("Tunnel", TunnelType.class),
	@SerializedName("TunnelPart")
	TUNNEL_PART("TunnelPart", TunnelPartType.class),
	@SerializedName("TunnelInstallation")
	TUNNEL_INSTALLATION("TunnelInstallation", TunnelInstallationType.class),
	@SerializedName("CityObjectGroup")
	CITY_OBJECT_GROUP("CityObjectGroup", CityObjectGroupType.class);
	
	private final String value;
	private final Class<? extends AbstractCityObjectType> typeClass;
	
	private CityObjectTypeName(String value, Class<? extends AbstractCityObjectType> typeClass) {
		this.value = value;
		this.typeClass = typeClass;
	}
	
	public String getValue() {
		return value;
	}
	
	public Class<? extends AbstractCityObjectType> getTypeClass() {
		return typeClass;
	}

	@Override
	public String toString() {
		return value;
	}
	
	public static CityObjectTypeName fromValue(String value) {
		for (CityObjectTypeName type : CityObjectTypeName.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
