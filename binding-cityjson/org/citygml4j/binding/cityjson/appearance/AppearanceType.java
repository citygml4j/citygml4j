package org.citygml4j.binding.cityjson.appearance;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

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
