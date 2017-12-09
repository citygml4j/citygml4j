package org.citygml4j.binding.cityjson.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.binding.cityjson.appearance.MaterialAdapter;
import org.citygml4j.binding.cityjson.appearance.SolidMaterialObject;
import org.citygml4j.binding.cityjson.appearance.SolidTextureObject;
import org.citygml4j.binding.cityjson.appearance.TextureAdapter;

import com.google.gson.annotations.JsonAdapter;

public class SolidType extends AbstractSolidType
implements GeometryWithAppearance<SolidMaterialObject, SolidTextureObject> {
	private final GeometryTypeName type = GeometryTypeName.SOLID;
	private List<List<List<List<Integer>>>> boundaries = new ArrayList<>();	
	private SolidSemanticsObject semantics;
	@JsonAdapter(MaterialAdapter.class)
	private Map<String, SolidMaterialObject> material;
	@JsonAdapter(TextureAdapter.class)
	private Map<String, SolidTextureObject> texture;
	
	@Override
	public GeometryTypeName getType() {
		return type;
	}
	
	public void addShell(List<List<List<Integer>>> shell) {
		if (shell != null && shell.size() > 0)
			boundaries.add(shell);
	}

	public List<List<List<List<Integer>>>> getShells() {
		return boundaries;
	}

	public void setShells(List<List<List<List<Integer>>>> shells) {
		if (shells != null)
			boundaries = shells;
	}
	
	public void unsetShells() {
		boundaries.clear();
	}
	
	@Override
	public boolean isSetSemantics() {
		return semantics != null;
	}

	@Override
	public SolidSemanticsObject getSemantics() {
		return semantics;
	}

	public void setSemantics(SolidSemanticsObject semantics) {
		this.semantics = semantics;
	}
	
	public void unsetSemantics() {
		semantics = null;
	}
	
	@Override
	public boolean isSetMaterial() {
		return material != null;
	}
	
	public void addMaterial(SolidMaterialObject materialObject) {
		if (material == null)
			material = new HashMap<>();
		
		material.put(materialObject.getTheme(), materialObject);
	}
	
	@Override
	public Collection<SolidMaterialObject> getMaterial() {
		return material.values();
	}
	
	public SolidMaterialObject getMaterial(String theme) {
		return material != null ? material.get(theme) : null;
	}

	public void setMaterial(List<SolidMaterialObject> material) {
		if (material == null)
			this.material = null;
		else {
			for (SolidMaterialObject object : material)
				this.material.put(object.getTheme(), object);
		}
	}
	
	public void removeMaterial(SolidMaterialObject materialObject) {
		if (this.material != null)
			this.material.remove(materialObject.getTheme());
	}
	
	public void removeMaterial(String theme) {
		if (this.material != null)
			this.material.remove(theme);
	}
	
	public void unsetMaterial() {
		material = null;
	}

	@Override
	public boolean isSetTexture() {
		return texture != null;
	}
	
	public void addTexture(SolidTextureObject textureObject) {
		if (texture == null)
			texture = new HashMap<>();
		
		texture.put(textureObject.getTheme(), textureObject);
	}
	
	@Override
	public Collection<SolidTextureObject> getTexture() {
		return texture.values();
	}
	
	public SolidTextureObject getTexture(String theme) {
		return texture != null ? texture.get(theme) : null;
	}

	public void setTexture(List<SolidTextureObject> texture) {
		if (texture == null)
			this.texture = null;
		else {
			for (SolidTextureObject object : texture)
				this.texture.put(object.getTheme(), object);
		}
	}
	
	public void removeTexture(SolidTextureObject textureObject) {
		if (texture != null)
			texture.remove(textureObject.getTheme());
	}
	
	public void removeTexture(String theme) {
		if (texture != null)
			texture.remove(theme);
	}
	
	public void unsetTexture() {
		texture = null;
	}
	
}
