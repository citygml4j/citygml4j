package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.SerializedName;

public enum TextureImageType {
	@SerializedName("PNG")
	PNG("PNG"),
	@SerializedName("JPG")
	JPG("JPG");
	
	private final String name;
	
	private TextureImageType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static TextureImageType fromName(String name) {
		for (TextureImageType type : TextureImageType.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
