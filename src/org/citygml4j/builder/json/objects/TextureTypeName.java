package org.citygml4j.builder.json.objects;

import com.google.gson.annotations.SerializedName;

public enum TextureTypeName {
	@SerializedName("PNG")
	PNG("PNG"),
	@SerializedName("JPG")
	JPG("JPG");
	
	private final String name;
	
	private TextureTypeName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static TextureTypeName fromName(String name) {
		for (TextureTypeName type : TextureTypeName.values()) {
			if (type.name.equals(name))
				return type;
		}
		
		return null;
	}
	
}
