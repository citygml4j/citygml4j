package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.SerializedName;

public enum WrapMode {
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
	
	private WrapMode(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static WrapMode fromName(String name) {
		for (WrapMode type : WrapMode.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
