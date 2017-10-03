package org.citygml4j.builder.json.objects;

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
	GENERIC_CITY_OBJECT("GenericCityObject", GenericCityObjectType.class);
	
	private final String name;
	private final Class<? extends AbstractCityObjectType> typeClass;
	
	private CityObjectTypeName(String name, Class<? extends AbstractCityObjectType> typeClass) {
		this.name = name;
		this.typeClass = typeClass;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<? extends AbstractCityObjectType> getTypeClass() {
		return typeClass;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static CityObjectTypeName fromName(String name) {
		for (CityObjectTypeName type : CityObjectTypeName.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
