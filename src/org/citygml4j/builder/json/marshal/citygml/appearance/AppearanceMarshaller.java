package org.citygml4j.builder.json.marshal.citygml.appearance;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.citygml4j.binding.json.appearance.MaterialType;
import org.citygml4j.binding.json.appearance.TextureType;
import org.citygml4j.binding.json.appearance.TextureTypeName;
import org.citygml4j.binding.json.appearance.TextureTypeType;
import org.citygml4j.binding.json.appearance.WrapModeType;
import org.citygml4j.builder.json.marshal.CityJSONMarshaller;
import org.citygml4j.builder.json.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.json.marshal.util.SurfaceDataInfo;
import org.citygml4j.builder.json.marshal.util.TextureVerticesBuilder;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.primitives.AbstractRing;
import org.citygml4j.model.gml.geometry.primitives.AbstractRingProperty;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;

public class AppearanceMarshaller {
	private final TextureVerticesBuilder textureVertexArrayBuilder;
	private final ChildInfo childInfo;

	public AppearanceMarshaller(CityGMLMarshaller citygml) {
		textureVertexArrayBuilder = citygml.getCityJSONMarshaller().getTextureVerticesBuilder();
		childInfo = new ChildInfo();
	}

	public void marshalParameterizedTexture(ParameterizedTexture src, TextureType dest) {
		if (src.isSetImageURI()) {
			String fileName = Paths.get(src.getImageURI()).getFileName().toString();
			dest.setType(TextureTypeName.fromFileName(fileName));
			dest.setImage(fileName);
		}

		if (src.isSetWrapMode())
			dest.setWrapMode(WrapModeType.fromValue(src.getWrapMode().getValue()));

		if (src.isSetTextureType())
			dest.setTextureType(TextureTypeType.fromValue(src.getTextureType().getValue()));

		if (src.isSetBorderColor())
			dest.setBorderColor(src.getBorderColor().toList());
	}

	public TextureType marshalParameterizedTexture(ParameterizedTexture src) {
		TextureType dest = new TextureType();
		marshalParameterizedTexture(src, dest);

		return dest;
	}

	public void marshalX3DMaterial(X3DMaterial src, MaterialType dest) {
		if (src.isSetName()) {
			for (Code name : src.getName()) {
				if (name.isSetValue()) {
					dest.setName(name.getValue());
					break;
				}
			}
		}
		
		if (!dest.isSetName())
			dest.setName(src.isSetId() ? src.getId() : DefaultGMLIdManager.getInstance().generateUUID());

		if (src.isSetAmbientIntensity())
			dest.setAmbientIntensity(src.getAmbientIntensity());

		if (src.isSetDiffuseColor())
			dest.setDiffuseColor(src.getDiffuseColor().toList());

		if (src.isSetEmissiveColor())
			dest.setEmissiveColor(src.getEmissiveColor().toList());

		if (src.isSetSpecularColor())
			dest.setSpecularColor(src.getSpecularColor().toList());

		if (src.isSetShininess())
			dest.setShininess(src.getShininess());

		if (src.isSetTransparency())
			dest.setTransparency(src.getTransparency());

		if (src.isSetIsSmooth())
			dest.setIsSmooth(src.getIsSmooth());
	}

	public MaterialType marshalX3DMaterial(X3DMaterial src) {
		MaterialType dest = new MaterialType();
		marshalX3DMaterial(src, dest);

		return dest;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Integer> getMaterials(AbstractGeometry geometry, boolean reverse) {
		Map<String, Integer> materials = null;
		
		do {
			if (geometry.hasLocalProperty(CityJSONMarshaller.GEOMETRY_SURFACE_DATA)) {
				materials = new HashMap<>();
				
				List<SurfaceDataInfo> surfaceDatas = (List<SurfaceDataInfo>)geometry.getLocalProperty(CityJSONMarshaller.GEOMETRY_SURFACE_DATA);
				for (SurfaceDataInfo surfaceData : surfaceDatas) {
					if (!surfaceData.isMaterial())
						continue;
					
					// check that the material fits the face orientation
					if (surfaceData.isFront() != reverse) {
						// one material per theme
						String theme = surfaceData.getTheme();						
						if (materials.containsKey(surfaceData.getTheme()))
							continue;
						
						materials.put(theme, surfaceData.getSequenceNumber());
					}
				}
			}
			
		} while ((geometry = childInfo.getParentGeometry(geometry)) != null);
		
		return materials != null && !materials.isEmpty() ? materials : null;
	}

	public Map<String, List<List<Integer>>> getTextures(Polygon polygon, boolean reverse) {
		Map<String, List<List<Integer>>> textures = null;
		
		if (polygon.isSetExterior()) {
			AbstractRing exterior = polygon.getExterior().getRing();
			if (exterior instanceof LinearRing) {
				LinearRing linearRing = (LinearRing)exterior;
				Map<String, List<Integer>> tmp = collectTextures(linearRing, reverse);
				if (tmp != null && !tmp.isEmpty()) {
					textures = new HashMap<>();
					
					for (Entry<String, List<Integer>> entry : tmp.entrySet()) {
						List<List<Integer>> indexes = new ArrayList<>();
						indexes.add(entry.getValue());
						textures.put(entry.getKey(), indexes);
					}
					
					// add texture coordinates for interior rings
					if (polygon.isSetInterior()) {
						for (AbstractRingProperty property : polygon.getInterior()) {
							AbstractRing interior = property.getRing();
							if (interior instanceof LinearRing) {
								linearRing = (LinearRing)interior;
								
								tmp = collectTextures(linearRing, reverse);
								if (tmp != null && !tmp.isEmpty()) {
									for (Entry<String, List<Integer>> entry : tmp.entrySet()) {
										List<List<Integer>> indexes = textures.get(entry.getKey());
										if (indexes != null && indexes.size() > 0)
											indexes.add(entry.getValue());
									}
								}
							}
						}
					}
				}
			}
		}
		
		return textures;
	}
	
	public Map<String, List<List<Integer>>> getTextures(LinearRing linearRing, boolean reverse) {
		Map<String, List<List<Integer>>> textures = null;
		
		Map<String, List<Integer>> tmp = collectTextures(linearRing, reverse);
		if (tmp != null && !tmp.isEmpty()) {
			textures = new HashMap<>();
			for (Entry<String, List<Integer>> entry : tmp.entrySet())
				textures.put(entry.getKey(), Collections.singletonList(entry.getValue()));
		}
		
		return textures;
	}

	@SuppressWarnings("unchecked")
	private Map<String, List<Integer>> collectTextures(LinearRing linearRing, boolean reverse) {
		Map<String, List<Integer>> textures = null;
		
		if (linearRing.hasLocalProperty(CityJSONMarshaller.GEOMETRY_SURFACE_DATA)) {
			textures = new HashMap<>();
			
			List<SurfaceDataInfo> surfaceDatas = (List<SurfaceDataInfo>)linearRing.getLocalProperty(CityJSONMarshaller.GEOMETRY_SURFACE_DATA);
			for (SurfaceDataInfo surfaceData : surfaceDatas) {
				if (surfaceData.isMaterial())
					continue;					

				// check that the texture fits the face orientation
				if (surfaceData.isFront() != reverse) {
					// one texture per theme
					String theme = surfaceData.getTheme();						
					if (textures.containsKey(surfaceData.getTheme()))
						continue;

					List<Double> textureCoordinates = surfaceData.getTextureCoordinates();
					if (textureCoordinates != null && textureCoordinates.size() > 7) {
						List<Integer> indexes = textureVertexArrayBuilder.addTextureVertices(textureCoordinates.subList(0, textureCoordinates.size() - 2));
						
						// add reference to texture
						indexes.add(0, surfaceData.getSequenceNumber());
						textures.put(theme, indexes);
					}
				}
			}			
		}
		
		return textures;
	}
}
