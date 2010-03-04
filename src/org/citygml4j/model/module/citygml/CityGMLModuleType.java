package org.citygml4j.model.module.citygml;

import org.citygml4j.model.module.ModuleType;

public enum CityGMLModuleType implements ModuleType {
	CORE("Core"),
	APPEARANCE("Appearance"),
	BUILDING("Building"),
	CITYFURNITURE("CityFurniture"),
	CITYOBJECTGROUP("CityObjectGroup"),
	GENERICS("Generics"),
	LANDUSE("LandUse"),
	RELIEF("Relief"),
	TRANSPORTATION("Transportation"),
	VEGETATION("Vegetation"),
	WATERBODY("WaterBody"),
	TEXTUREDSURFACE("TexturedSurface");

	private final String value;

	CityGMLModuleType(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
	
}
