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
package org.citygml4j.binding.cityjson.geometry;

import com.google.gson.annotations.JsonAdapter;
import org.citygml4j.binding.cityjson.appearance.MaterialAdapter;
import org.citygml4j.binding.cityjson.appearance.SolidCollectionMaterialObject;
import org.citygml4j.binding.cityjson.appearance.SolidCollectionTextureObject;
import org.citygml4j.binding.cityjson.appearance.TextureAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractSolidCollectionType extends AbstractSolidType
implements GeometryWithAppearance<SolidCollectionMaterialObject, SolidCollectionTextureObject> {
	private final GeometryTypeName type;
	private List<List<List<List<List<Integer>>>>> boundaries = new ArrayList<>();	
	private SolidCollectionSemanticsObject semantics;
	@JsonAdapter(MaterialAdapter.class)
	private Map<String, SolidCollectionMaterialObject> material;
	@JsonAdapter(TextureAdapter.class)
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
			boundaries.add(solid);
	}

	public List<List<List<List<List<Integer>>>>> getSolids() {
		return boundaries;
	}

	public void setSolids(List<List<List<List<List<Integer>>>>> solids) {
		if (solids != null)
			boundaries = solids;
	}
	
	public void unsetSolids() {
		boundaries.clear();
	}
	
	@Override
	public boolean isSetSemantics() {
		return semantics != null;
	}

	@Override
	public SolidCollectionSemanticsObject getSemantics() {
		return semantics;
	}

	public void setSemantics(SolidCollectionSemanticsObject semantics) {
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
	
	public void addMaterial(SolidCollectionMaterialObject materialObject) {
		if (material == null)
			material = new HashMap<>();
		
		material.put(materialObject.getTheme(), materialObject);
	}
	
	@Override
	public Collection<SolidCollectionMaterialObject> getMaterial() {
		return material.values();
	}
	
	@Override
	public SolidCollectionMaterialObject getMaterial(String theme) {
		return material != null ? material.get(theme) : null;
	}

	public void setMaterial(List<SolidCollectionMaterialObject> material) {
		if (material == null)
			this.material = null;
		else {
			for (SolidCollectionMaterialObject object : material)
				this.material.put(object.getTheme(), object);
		}
	}
	
	@Override
	public void removeMaterial(SolidCollectionMaterialObject materialObject) {
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
	
	public void addTexture(SolidCollectionTextureObject textureObject) {
		if (texture == null)
			texture = new HashMap<>();
		
		texture.put(textureObject.getTheme(), textureObject);
	}
	
	@Override
	public Collection<SolidCollectionTextureObject> getTexture() {
		return texture.values();
	}
	
	@Override
	public SolidCollectionTextureObject getTexture(String theme) {
		return texture != null ? texture.get(theme) : null;
	}

	public void setTexture(List<SolidCollectionTextureObject> texture) {
		if (texture == null)
			this.texture = null;
		else {
			for (SolidCollectionTextureObject object : texture)
				this.texture.put(object.getTheme(), object);
		}
	}
	
	@Override
	public void removeTexture(SolidCollectionTextureObject textureObject) {
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

	@Override
	public void updateIndexes(Map<Integer, Integer> indexMap) {
		for (List<List<List<List<Integer>>>> solid : boundaries) {
			for (List<List<List<Integer>>> shell : solid) {
				for (List<List<Integer>> surface : shell) {
					for (List<Integer> ring : surface) {
						for (int index = 0; index < ring.size(); index++) {
							Integer update = indexMap.get(ring.get(index));
							if (update != null)
								ring.set(index, update);
						}
					}
				}
			}
		}
	}
}
