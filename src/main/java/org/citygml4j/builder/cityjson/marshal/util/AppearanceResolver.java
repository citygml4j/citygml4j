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
package org.citygml4j.builder.cityjson.marshal.util;

import org.citygml4j.binding.cityjson.appearance.MaterialType;
import org.citygml4j.binding.cityjson.appearance.TextureType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.appearance.AppearanceMarshaller;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.util.walker.GMLWalker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AppearanceResolver {
	private final String defaultTheme;
	private final AppearanceMarshaller app;
	
	private final AtomicInteger texturesIndex = new AtomicInteger(0);
	private final AtomicInteger materialsIndex = new AtomicInteger(0);
	private final ConcurrentHashMap<TextureType, Integer> textures = new ConcurrentHashMap<>();
	private final ConcurrentHashMap<MaterialType, Integer> materials = new ConcurrentHashMap<>();
	private final Map<String, List<SurfaceDataInfo>> globalSurfaceDatas = new ConcurrentHashMap<>();
	
	private volatile boolean hasGlobalAppearance;
	
	private enum ResolverState {
		GET_SURFACE_DATA,
		ASSIGN_SURFACE_DATA
	};

	public AppearanceResolver(String defaultTheme, AppearanceMarshaller app) {
		this.defaultTheme = defaultTheme;
		this.app = app;
	}

	public void resolve(AbstractCityObject cityObject) {
		resolve((AbstractGML)cityObject);
	}
	
	public void resolve(CityModel cityModel) {
		resolve((AbstractGML)cityModel);
	}
	
	private void resolve(AbstractGML object) {
		Walker walker = new Walker();
		object.accept(walker);

		if (!walker.surfaceDatas.isEmpty()) {
			walker.state = ResolverState.ASSIGN_SURFACE_DATA;
			object.accept(walker);
		}
	}
	
	public void registerGlobalAppearance(Appearance appearance) {
		Walker walker = new Walker();
		appearance.accept(walker);
		
		if (!walker.surfaceDatas.isEmpty()) {
			globalSurfaceDatas.putAll(walker.surfaceDatas);
			hasGlobalAppearance = true;
		}
	}
	
	public void resolveGlobalAppearance(AbstractGeometry geometry) {
		if (geometry.isSetId()) {
			List<SurfaceDataInfo> surfaceData = globalSurfaceDatas.get(geometry.getId());
			if (surfaceData != null)
				geometry.setLocalProperty(CityJSONMarshaller.GEOMETRY_SURFACE_DATA, surfaceData);
		}
	}
	
	public boolean hasTextures() {
		return !textures.isEmpty();
	}
	
	public List<TextureType> getTextures() {
		List<TextureType> result = textures.entrySet().stream()
				.sorted(Entry.comparingByValue())
				.map(Entry::getKey).collect(Collectors.toList());
		
		textures.clear();
		texturesIndex.set(0);
		return result;
	}
	
	public boolean hasMaterials() {
		return !materials.isEmpty();
	}
	
	public List<MaterialType> getMaterials() {
		List<MaterialType> result = materials.entrySet().stream()
				.sorted(Entry.comparingByValue())
				.map(Entry::getKey).collect(Collectors.toList());
		
		materials.clear();
		materialsIndex.set(0);
		return result;
	}
	
	public boolean hasGlobalAppearance() {
		return hasGlobalAppearance;
	}

	private class Walker extends GMLWalker {
		private ResolverState state = ResolverState.GET_SURFACE_DATA;
		private Map<String, List<SurfaceDataInfo>> surfaceDatas = new HashMap<>();
		private String theme;

		@Override
		public void visit(Appearance appearance) {
			theme = appearance.isSetTheme() ? appearance.getTheme() : defaultTheme;
			super.visit(appearance);
		}

		@Override
		public void visit(ParameterizedTexture parameterizedTexture) {
			if (state == ResolverState.GET_SURFACE_DATA) {
				TextureType texture = app.marshalParameterizedTexture(parameterizedTexture);
				if (!texture.isSetImage() || !texture.isSetType())
					return;
				
				int sequenceNumber = addTexture(texture);
				
				for (TextureAssociation association : parameterizedTexture.getTarget()) {
					AbstractTextureParameterization parameterization = association.getTextureParameterization();
					if (parameterization instanceof TexCoordList) {
						TexCoordList texCoordList = (TexCoordList)parameterization;
						if (texCoordList.isSetTextureCoordinates()) {
							for (TextureCoordinates coordinates : texCoordList.getTextureCoordinates()) {
								if (coordinates.isSetRing() && coordinates.isSetValue()) {
									SurfaceDataInfo info = new SurfaceDataInfo(theme, sequenceNumber, parameterizedTexture.getIsFront(), coordinates.getValue());
									addSurfaceData(clipGMLId(coordinates.getRing()), info);
								}
							}
						}
					}
				}
			}

			super.visit(parameterizedTexture);
		}

		@Override
		public void visit(X3DMaterial x3dMaterial) {
			if (state == ResolverState.GET_SURFACE_DATA) {
				MaterialType material = app.marshalX3DMaterial(x3dMaterial);
				int sequenceNumber = addMaterial(material);
				
				for (String target : x3dMaterial.getTarget()) {
					if (target != null) {
						SurfaceDataInfo info = new SurfaceDataInfo(theme, sequenceNumber, x3dMaterial.getIsFront());
						addSurfaceData(clipGMLId(target), info);
					}
				}
			}

			super.visit(x3dMaterial);
		}

		@Override
		public void visit(AbstractGeometry geometry) {
			if (state == ResolverState.ASSIGN_SURFACE_DATA && geometry.isSetId()) {
				List<SurfaceDataInfo> surfaceData = surfaceDatas.get(geometry.getId());
				if (surfaceData != null)
					geometry.setLocalProperty(CityJSONMarshaller.GEOMETRY_SURFACE_DATA, surfaceData);
			}

			super.visit(geometry);
		}

		@Override
		public void visit(ADEGenericElement ade) {
			// nothing to do here
		}
		
		private int addTexture(TextureType texture) {
			Integer sequenceNumber = textures.get(texture);
			if (sequenceNumber == null) {
				int tmp = texturesIndex.getAndIncrement();
				sequenceNumber = textures.putIfAbsent(texture, tmp);
				if (sequenceNumber == null)
					sequenceNumber = tmp;
			}
			
			return sequenceNumber;
		}
		
		private int addMaterial(MaterialType material) {
			Integer sequenceNumber = materials.get(material);
			if (sequenceNumber == null) {
				int tmp = materialsIndex.getAndIncrement();
				sequenceNumber = materials.putIfAbsent(material, tmp);
				if (sequenceNumber == null)
					sequenceNumber = tmp;
			}
			
			return sequenceNumber;
		}

		private void addSurfaceData(String key, SurfaceDataInfo info) {
			List<SurfaceDataInfo> surfaceData = surfaceDatas.get(key);
			if (surfaceData == null) {
				surfaceData = new ArrayList<>();
				surfaceDatas.put(key, surfaceData);
			}

			surfaceData.add(info);
		}

		private String clipGMLId(String target) {
			return target.replaceAll("^.*?#+?", "");
		}
	}
	
}
