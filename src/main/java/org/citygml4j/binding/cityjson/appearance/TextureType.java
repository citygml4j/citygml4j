/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.binding.cityjson.appearance;

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
	
	public void unsetType() {
		type = null;
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
	
	public void unsetImage() {
		image = null;
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
	
	public void unsetWrapMode() {
		wrapMode = null;
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
	
	public void unsetTextureType() {
		textureType = null;
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
	
	public void unsetBorderColor() {
		borderColor = null;
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
