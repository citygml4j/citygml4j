package org.citygml4j.builder.json.marshal.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.citygml4j.builder.json.marshal.CityJSONMarshaller;
import org.citygml4j.builder.json.marshal.citygml.appearance.AppearanceMarshaller;
import org.citygml4j.builder.json.objects.appearance.MaterialType;
import org.citygml4j.builder.json.objects.appearance.TextureType;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureCoordinates;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.util.walker.GMLWalker;

public class AppearanceResolver {
	private final String defaultTheme;
	private final AppearanceMarshaller app;
	
	private final AtomicInteger texturesIndex = new AtomicInteger(0);
	private final AtomicInteger materialsIndex = new AtomicInteger(0);
	private final ConcurrentHashMap<TextureType, Integer> textures = new ConcurrentHashMap<>();
	private final ConcurrentHashMap<MaterialType, Integer> materials = new ConcurrentHashMap<>();
	
	private enum ResolverState {
		GET_SURFACE_DATA,
		ASSIGN_SURFACE_DATA
	};

	public AppearanceResolver(String defaultTheme, AppearanceMarshaller app) {
		this.defaultTheme = defaultTheme;
		this.app = app;
	}

	public void resolve(AbstractGML object) {
		Walker walker = new Walker();
		object.accept(walker);

		if (!walker.surfaceDatas.isEmpty()) {
			walker.state = ResolverState.ASSIGN_SURFACE_DATA;
			object.accept(walker);
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
		public void visit(AbstractSurfaceData surfaceData) {
			if (surfaceData.getParent() instanceof FeatureProperty<?>)
				((FeatureProperty<?>)surfaceData.getParent()).unsetFeature();
		}

		@Override
		public void visit(ParameterizedTexture parameterizedTexture) {
			if (state == ResolverState.GET_SURFACE_DATA) {
				TextureType texture = app.marshalParameterizedTexture(parameterizedTexture);
				if (!texture.isSetTextureType())
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
