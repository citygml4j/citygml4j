package org.citygml4j.binding.cityjson.appearance;

import com.google.gson.annotations.SerializedName;

public enum TextureTypeType {
	@SerializedName("unknown")
	UNKNOWN("unknown"),
	@SerializedName("specific")
	SPECIFIC("specific"),
	@SerializedName("typical")
	TYPICAL("typical");
	
	private final String value;
	
	private TextureTypeType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static TextureTypeType fromValue(String value) {
		for (TextureTypeType type : TextureTypeType.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
}
