package org.citygml4j.binding.cityjson.appearance;

import com.google.gson.annotations.SerializedName;

public enum WrapModeType {
	@SerializedName("none")
	NONE("none"),
	@SerializedName("wrap")
	WRAP("wrap"),
	@SerializedName("mirror")
	MIRROR("mirror"),
	@SerializedName("clamp")
	CLAMP("clamp"),
	@SerializedName("border")
	BORDER("border");
	
	private final String value;
	
	private WrapModeType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static WrapModeType fromValue(String value) {
		for (WrapModeType type : WrapModeType.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
