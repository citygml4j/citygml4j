package org.citygml4j.builder.json.objects;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AppearanceType {
	private List<MaterialType> materials;
	private List<TextureType> textures;
	@SerializedName("vertices-texture")
	private List<List<Double>> textureVertices;
	
	public boolean isSetMaterials() {
		return materials != null;
	}
	
	public void addMaterial(MaterialType material) {
		if (material != null)
			materials.add(material);
	}
	
	public List<MaterialType> getMaterials() {
		return materials;
	}
	
	public void setMaterials(List<MaterialType> materials) {
		this.materials = materials;
	}
	
	public boolean isSetTextures() {
		return textures != null;
	}
	
	public void addTexture(TextureType texture) {
		if (texture != null)
			textures.add(texture);
	}
	
	public List<TextureType> getTextures() {
		return textures;
	}
	
	public void setTextures(List<TextureType> textures) {
		this.textures = textures;
	}
	
	public boolean isSetTextureVertices() {
		return textureVertices != null;
	}
	
	public void addTextureVertex(List<Double> textureVertex) {
		if (textureVertex != null && textureVertex.size() == 2)
			textureVertices.add(textureVertex);
	}
	
	public List<List<Double>> getTextureVertices() {
		return textureVertices;
	}
	
	public void setTextureVertices(List<List<Double>> textureVertices) {
		this.textureVertices = textureVertices;
	}
	
}
