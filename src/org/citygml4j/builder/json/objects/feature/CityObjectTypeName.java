package org.citygml4j.builder.json.objects.feature;

import com.google.gson.annotations.SerializedName;

public enum CityObjectTypeName {
	@SerializedName("Building")
	BUILDING("Building", BuildingType.class),
	@SerializedName("BuildingPart")
	BUILDING_PART("BuildingPart", BuildingPartType.class),
	@SerializedName("BuildingInstallation")
	BUILDING_INSTALLATION("BuildingInstallation", BuildingInstallationType.class),
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
	TRANSPOR_SQUARE("TransportSquare", TransportSquareType.class);
	
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
