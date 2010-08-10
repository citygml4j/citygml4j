package org.citygml4j.model.module.citygml;

import org.citygml4j.model.module.ModuleType;

public enum CityGMLModuleType implements ModuleType {
	CORE("Core"),
	APPEARANCE("Appearance"),
	BUILDING("Building"),
	CITY_FURNITURE("CityFurniture"),
	CITY_OBJECT_GROUP("CityObjectGroup"),
	GENERICS("Generics"),
	LAND_USE("LandUse"),
	RELIEF("Relief"),
	TRANSPORTATION("Transportation"),
	VEGETATION("Vegetation"),
	WATER_BODY("WaterBody"),
	TEXTURED_SURFACE("TexturedSurface");

	private final String value;

	CityGMLModuleType(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
	
}
