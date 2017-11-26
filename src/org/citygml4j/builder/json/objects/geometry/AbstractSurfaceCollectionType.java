package org.citygml4j.builder.json.objects.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.builder.json.objects.appearance.MaterialAdapter;
import org.citygml4j.builder.json.objects.appearance.SurfaceCollectionMaterialObject;
import org.citygml4j.builder.json.objects.appearance.SurfaceCollectionTextureObject;
import org.citygml4j.builder.json.objects.appearance.TextureAdapter;

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

}
