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

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AppearanceType {
	@SerializedName("default-theme-texture")
	private String defaultTextureTheme;
	@SerializedName("default-theme-material")
	private String defaultMaterialTheme;
	private List<MaterialType> materials;
	private List<TextureType> textures;
	@SerializedName("vertices-texture")
	private List<List<Double>> textureVertices;

	public boolean isSetDefaultTextureTheme() {
		return defaultTextureTheme != null;
	}

	public String getDefaultTextureTheme() {
		return defaultTextureTheme;
	}

	public void setDefaultTextureTheme(String defaultTextureTheme) {
		this.defaultTextureTheme = defaultTextureTheme;
	}

	public void unsetDefaultTextureTheme() {
		defaultTextureTheme = null;
	}

	public boolean isSetDefaultMaterialTheme() {
		return defaultMaterialTheme != null;
	}

	public String getDefaultMaterialTheme() {
		return defaultMaterialTheme;
	}

	public void setDefaultMaterialTheme(String defaultMaterialTheme) {
		this.defaultMaterialTheme = defaultMaterialTheme;
	}

	public void unsetDefaultMaterialTheme() {
		defaultMaterialTheme = null;
	}

	public boolean isSetMaterials() {
		return materials != null;
	}

	public void addMaterial(MaterialType material) {
		if (materials == null)
			materials = new ArrayList<>();

		materials.add(material);
	}

	public List<MaterialType> getMaterials() {
		return materials;
	}

	public void setMaterials(List<MaterialType> materials) {
		this.materials = materials;
	}

	public void removeMaterial(MaterialType material) {
		if (materials != null)
			materials.remove(material);
	}

	public void unsetMaterials() {
		materials = null;
	}

	public boolean isSetTextures() {
		return textures != null;
	}

	public void addTexture(TextureType texture) {
		if (textures == null)
			textures = new ArrayList<>();

		textures.add(texture);
	}

	public List<TextureType> getTextures() {
		return textures;
	}

	public void setTextures(List<TextureType> textures) {
		this.textures = textures;
	}

	public void removeTexture(TextureType texture) {
		if (textures != null)
			textures.remove(texture);
	}

	public void unsetTextures() {
		textures = null;
	}

	public boolean isSetTextureVertices() {
		return textureVertices != null;
	}

	public void addTextureVertex(List<Double> textureVertex) {
		if (textureVertex != null && textureVertex.size() == 2) {
			if (textureVertices == null)
				textureVertices = new ArrayList<>();
			
			textureVertices.add(textureVertex);
		}
	}

	public List<List<Double>> getTextureVertices() {
		return textureVertices;
	}

	public void setTextureVertices(List<List<Double>> textureVertices) {
		this.textureVertices = textureVertices;
	}

	public void unsetTextureVertices() {
		textureVertices = null;
	}

}
