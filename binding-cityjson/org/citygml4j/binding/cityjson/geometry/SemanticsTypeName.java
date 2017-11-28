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
