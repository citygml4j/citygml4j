package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.SerializedName;

public enum TextureType {
	@SerializedName("unknown")
	UNKNOWN("unknown"),
	@SerializedName("specific")
	SPECIFIC("specific"),
	@SerializedName("typical")
	TYPICAL("typical");
	
	private final String name;
	
	private TextureType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static TextureType fromName(String name) {
		for (TextureType type : TextureType.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
