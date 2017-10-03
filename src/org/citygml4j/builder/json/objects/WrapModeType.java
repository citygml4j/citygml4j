package org.citygml4j.builder.json.objects;

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
	
	private final String name;
	
	private WrapModeType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static WrapModeType fromName(String name) {
		for (WrapModeType type : WrapModeType.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
