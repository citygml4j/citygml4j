package org.citygml4j.builder.json.objects.appearance;

import java.util.List;
import java.util.Objects;

public class TextureType {
	private TextureTypeName type;
	private String image;
	private WrapModeType wrapMode;	
	private TextureTypeType textureType;
	private List<Double> borderColor;
	
	public boolean isSetType() {
		return type != null;
	}
	
	public TextureTypeName getType() {
		return type;
	}
	
	public void setType(TextureTypeName type) {
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
	
	public WrapModeType getWrapMode() {
		return wrapMode;
	}
	
	public void setWrapMode(WrapModeType wrapMode) {
		this.wrapMode = wrapMode;
	}
	
	public boolean isSetTextureType() {
		return textureType != null;
	}
	
	public TextureTypeType getTextureType() {
		return textureType;
	}
	
	public void setTextureType(TextureTypeType textureType) {
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

	@Override
	public int hashCode() {
		return Objects.hash(type, image, wrapMode, textureType, borderColor);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		
		if (!(obj instanceof TextureType))
			return false;
		
		TextureType other = (TextureType)obj;
		return Objects.equals(type, other.type)
				&& Objects.equals(image, other.image)
				&& Objects.equals(wrapMode, other.wrapMode)
				&& Objects.equals(textureType, other.textureType)
				&& Objects.equals(borderColor, other.borderColor);
	}
	
}
