package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.SerializedName;

public enum SemanticsType {
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
	WATER_CLOSURE_SURFACE("WaterClosureSurface");
	
	private final String name;
	
	private SemanticsType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static SemanticsType fromName(String name) {
		for (SemanticsType type : SemanticsType.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
