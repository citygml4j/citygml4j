package org.citygml4j.builder.json.objects;

import java.util.List;

public class Texture {
	private TextureImageType type;
	private String image;
	private WrapMode wrapMode;	
	private TextureType textureType;
	private List<Double> borderColor;
	
	public boolean isSetType() {
		return type != null;
	}
	
	public TextureImageType getType() {
		return type;
	}
	
	public void setType(TextureImageType type) {
		this.type = type;
	}
	
	public boolean isSetImage() {
		return image != null;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public boolean isSetWrapMode() {
		return wrapMode != null;
	}
	
	public WrapMode getWrapMode() {
		return wrapMode;
	}
	
	public void setWrapMode(WrapMode wrapMode) {
		this.wrapMode = wrapMode;
	}
	
	public boolean isSetTextureType() {
		return textureType != null;
	}
	
	public TextureType getTextureType() {
		return textureType;
	}
	
	public void setTextureType(TextureType textureType) {
		this.textureType = textureType;
	}
	
	public boolean isSetBorderColor() {
		return borderColor != null && borderColor.size() >= 3;
	}
	
	public List<Double> getBorderColor() {
		if (isSetBorderColor())
			return borderColor.size() == 3 ? borderColor : borderColor.subList(0, 4);
		
		return null;
	}
	
	public void setBorderColor(List<Double> borderColor) {
		if (borderColor == null)
			this.borderColor = null;
		else if (borderColor.size() == 3)
			this.borderColor = borderColor;
		else if (borderColor.size() >= 4)
			this.borderColor = borderColor.subList(0, 4);
	}
	
}
