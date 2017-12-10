package org.citygml4j.binding.cityjson.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.binding.cityjson.appearance.MaterialAdapter;
import org.citygml4j.binding.cityjson.appearance.SurfaceCollectionMaterialObject;
import org.citygml4j.binding.cityjson.appearance.SurfaceCollectionTextureObject;
import org.citygml4j.binding.cityjson.appearance.TextureAdapter;

import com.google.gson.annotations.JsonAdapter;

public abstract class AbstractSurfaceCollectionType extends AbstractGeometryType 
implements GeometryWithSemantics, GeometryWithAppearance<SurfaceCollectionMaterialObject, SurfaceCollectionTextureObject> {
	private final GeometryTypeName type;
	private List<List<List<Integer>>> boundaries = new ArrayList<>();
	private SurfaceCollectionSemanticsObject semantics;
	@JsonAdapter(MaterialAdapter.class)
	private Map<String, SurfaceCollectionMaterialObject> material;
	@JsonAdapter(TextureAdapter.class)
	private Map<String, SurfaceCollectionTextureObject> texture;
	
	protected AbstractSurfaceCollectionType(GeometryTypeName type) {
		this.type = type;
	}
	
	@Override
	public GeometryTypeName getType() {
		return type;
	}
	
	public void addSurface(List<List<Integer>> surface) {
		if (surface != null && surface.size() > 0)
			boundaries.add(surface);
	}

	public List<List<List<Integer>>> getSurfaces() {
		return boundaries;
	}

	public void setSurfaces(List<List<List<Integer>>> surfaces) {
		if (surfaces != null)
			boundaries = surfaces;
	}
	
	public void unsetSurfaces() {
		boundaries.clear();
	}
	
	@Override
	public boolean isSetSemantics() {
		return semantics != null;
	}

	@Override
	public SurfaceCollectionSemanticsObject getSemantics() {
		return semantics;
	}

	public void setSemantics(SurfaceCollectionSemanticsObject semantics) {
		this.semantics = semantics;
	}
	
	@Override
	public void unsetSemantics() {
		semantics = null;
	}
	
	@Override
	public boolean isSetMaterial() {
		return material != null;
	}
	
	public void addMaterial(SurfaceCollectionMaterialObject materialObject) {
		if (material == null)
			material = new HashMap<>();
		
		material.put(materialObject.getTheme(), materialObject);
	}
	
	@Override
	public Collection<SurfaceCollectionMaterialObject> getMaterial() {
		return material.values();
	}
	
	@Override
	public SurfaceCollectionMaterialObject getMaterial(String theme) {
		return material != null ? material.get(theme) : null;
	}

	public void setMaterial(List<SurfaceCollectionMaterialObject> material) {
		if (material == null)
			this.material = null;
		else {
			for (SurfaceCollectionMaterialObject object : material)
				this.material.put(object.getTheme(), object);
		}
	}
	
	@Override
	public void removeMaterial(SurfaceCollectionMaterialObject materialObject) {
		if (this.material != null)
			this.material.remove(materialObject.getTheme());
	}
	
	@Override
	public void removeMaterial(String theme) {
		if (this.material != null)
			this.material.remove(theme);
	}
	
	@Override
	public void unsetMaterial() {
		material = null;
	}

	@Override
	public boolean isSetTexture() {
		return texture != null;
	}
	
	public void addTexture(SurfaceCollectionTextureObject textureObject) {
		if (texture == null)
			texture = new HashMap<>();
		
		texture.put(textureObject.getTheme(), textureObject);
	}
	
	@Override
	public Collection<SurfaceCollectionTextureObject> getTexture() {
		return texture.values();
	}
	
	@Override
	public SurfaceCollectionTextureObject getTexture(String theme) {
		return texture != null ? texture.get(theme) : null;
	}

	public void setTexture(List<SurfaceCollectionTextureObject> texture) {
		if (texture == null)
			this.texture = null;
		else {
			for (SurfaceCollectionTextureObject object : texture)
				this.texture.put(object.getTheme(), object);
		}
	}
	
	@Override
	public void removeTexture(SurfaceCollectionTextureObject textureObject) {
		if (texture != null)
			texture.remove(textureObject.getTheme());
	}
	
	@Override
	public void removeTexture(String theme) {
		if (texture != null)
			texture.remove(theme);
	}
	
	@Override
	public void unsetTexture() {
		texture = null;
	}
	
	@Override
	public void unsetAppearance() {
		material = null;
		texture = null;
	}

}
