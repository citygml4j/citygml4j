package org.citygml4j.builder.json.objects.appearance;

import com.google.gson.annotations.SerializedName;

public enum TextureTypeName {
	@SerializedName("PNG")
	PNG("PNG", "image/png"),
	@SerializedName("JPG")
	JPG("JPG", "image/jpeg");
	
	private final String value;
	private final String mimeType;
	
	private TextureTypeName(String value, String mimeType) {
		this.value = value;
		this.mimeType = mimeType;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getMimeType() {
		return mimeType;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static TextureTypeName fromValue(String value) {
		for (TextureTypeName type : TextureTypeName.values()) {
			if (type.value.equals(value))
				return type;
		}
		
		return null;
	}
	
	public static TextureTypeName fromFileName(String fileName) {
		String tmp = fileName.toLowerCase();
		if (tmp.endsWith(".png"))
			return PNG;
		else if (tmp.endsWith(".jpg")
				|| tmp.endsWith(".jpeg")
				|| tmp.endsWith(".jpe")
				|| tmp.endsWith(".jfif")
				|| tmp.endsWith(".jif"))
			return JPG;
				
		return null;
	}
	
}
