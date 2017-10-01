package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.SerializedName;

public enum CityObjectType {
	@SerializedName("Building")
	BUILDING("Building", Building.class),
	@SerializedName("BuildingPart")
	BUILDING_PART("BuildingPart", BuildingPart.class),
	@SerializedName("BuildingInstallation")
	BUILDING_INSTALLATION("BuildingInstallation", BuildingInstallation.class),
	@SerializedName("TINRelief")
	TIN_RELIEF("TINRelief", TINRelief.class),
	@SerializedName("WaterBody")
	WATER_BODY("WaterBody", WaterBody.class),
	@SerializedName("PlantCover")
	PLANT_COVER("PlantCover", PlantCover.class),
	@SerializedName("SolitaryVegetationObject")
	SOLITARY_VEGETATION_OBJECT("SolitaryVegetationObject", SolitaryVegetationObject.class),
	@SerializedName("LandUse")
	LAND_USE("LandUse", LandUse.class),
	@SerializedName("CityFurniture")
	CITY_FURNITURE("CityFurniture", CityFurniture.class),
	@SerializedName("GenericCityObject")
	GENERIC_CITY_OBJECT("GenericCityObject", GenericCityObject.class);
	
	private final String name;
	private final Class<? extends AbstractCityObject> typeClass;
	
	private CityObjectType(String name, Class<? extends AbstractCityObject> typeClass) {
		this.name = name;
		this.typeClass = typeClass;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<? extends AbstractCityObject> getTypeClass() {
		return typeClass;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static CityObjectType fromName(String name) {
		for (CityObjectType type : CityObjectType.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
