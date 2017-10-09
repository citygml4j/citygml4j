package org.citygml4j.builder.json.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractSolidCollectionType extends AbstractSolidType
implements GeometryWithAppearance<SolidCollectionMaterialObject, SolidCollectionTextureObject> {
	private final GeometryTypeName type;
	private List<List<List<List<List<Integer>>>>> geometry = new ArrayList<>();
	private List<List<List<SemanticsType>>> semantics;
	private Map<String, SolidCollectionMaterialObject> material;
	private Map<String, SolidCollectionTextureObject> texture;
	
	public AbstractSolidCollectionType(GeometryTypeName type) {
		this.type = type;
	}
	
	@Override
	public GeometryTypeName getType() {
		return type;
	}
	
	public void addSolid(List<List<List<List<Integer>>>> solid) {
		if (solid != null && solid.size() > 0)
			geometry.add(solid);
	}

	public List<List<List<List<List<Integer>>>>> getSolids() {
		return geometry;
	}

	public void setSolids(List<List<List<List<List<Integer>>>>> solids) {
		if (solids != null)
			geometry = solids;
	}
	
	public boolean isSetSemantics() {
		return semantics != null;
	}
	
	public void addSemantics(List<List<SemanticsType>> semantics) {
		if (this.semantics == null)
			this.semantics = new ArrayList<>();
		
		this.semantics.add(semantics);
	}

	public List<List<List<SemanticsType>>> getSemantics() {
		return semantics;
	}

	public void setSemantics(List<List<List<SemanticsType>>> semantics) {
		this.semantics = semantics;
	}
	
	@Override
	public boolean hasSemantics() {
		return semantics != null && semantics.stream().flatMap(List::stream).flatMap(List::stream)
				.filter(s -> s != SemanticsType.NULL_VALUE).findFirst().isPresent();
	}

	@Override
	public void unsetSemantics() {
		semantics = null;
	}

	@Override
	public boolean isSetMaterial() {
		return material != null;
	}
	
	public void addMaterial(SolidCollectionMaterialObject materialObject) {
		if (material == null)
			material = new HashMap<>();
		
		material.put(materialObject.getTheme(), materialObject);
	}
	
	@Override
	public Map<String, SolidCollectionMaterialObject> getMaterial() {
		return material;
	}
	
	public SolidCollectionMaterialObject getMaterial(String theme) {
		return material != null ? material.get(theme) : null;
	}

	public void setMaterial(Map<String, SolidCollectionMaterialObject> material) {
		this.material = material;
	}
	
	@Override
	public boolean isSetTexture() {
		return texture != null;
	}
	
	public void addTexture(SolidCollectionTextureObject textureObject) {
		if (texture == null)
			texture = new HashMap<>();
		
		texture.put(textureObject.getTheme(), textureObject);
	}
	
	@Override
	public Map<String, SolidCollectionTextureObject> getTexture() {
		return texture;
	}
	
	public SolidCollectionTextureObject getTexture(String theme) {
		return texture != null ? texture.get(theme) : null;
	}

	public void setTexture(Map<String, SolidCollectionTextureObject> texture) {
		this.texture = texture;
	}

}
