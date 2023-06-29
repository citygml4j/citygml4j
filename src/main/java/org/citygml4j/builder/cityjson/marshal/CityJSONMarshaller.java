/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.cityjson.marshal;

import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.ade.ADEMarshaller;
import org.citygml4j.builder.cityjson.marshal.gml.GMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.*;
import org.citygml4j.builder.cityjson.util.CityGMLMetadata;
import org.citygml4j.builder.cityjson.util.DefaultTextureFileHandler;
import org.citygml4j.builder.cityjson.util.TextureFileHandler;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.appearance.AppearanceType;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.geometry.GeometryTemplatesType;
import org.citygml4j.cityjson.geometry.TransformType;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;

import java.util.List;
import java.util.Objects;

public class CityJSONMarshaller {
	public static final String GEOMETRY_XLINK = "org.citygml4j.geometry.xlink";
	public static final String GEOMETRY_SURFACE_DATA = "org.citygml4j.geometry.surfaceData";
	public static final String GEOMETRY_DUMMY = "org.citygml4j.geometry.dummy";

	private final CityGMLMarshaller citygml;
	private final GMLMarshaller gml;
	private final ADEMarshaller ade;
	private final GeometryXlinkResolver xlinkResolver;
	private final AppearanceResolver appearanceResolver;
	
	private VerticesBuilder verticesBuilder;
	private VerticesTransformer verticesTransformer;
	private TextureVerticesBuilder textureVerticesBuilder;
	private TextureFileHandler textureFileHandler;
	private VerticesBuilder templatesVerticesBuilder;
	private boolean removeDuplicateChildGeometries;
	private boolean generateCityGMLMetadata;
	private boolean useMaterialDefaults = true;
	private String fallbackTheme = "unnamed";

	public CityJSONMarshaller() {
		this.verticesBuilder = new DefaultVerticesBuilder();
		this.textureVerticesBuilder = new DefaultTextureVerticesBuilder();
		this.textureFileHandler = new DefaultTextureFileHandler();
		this.templatesVerticesBuilder = new DefaultVerticesBuilder();

		citygml = new CityGMLMarshaller(this);
		gml = new GMLMarshaller(this, this::getVerticesBuilder);
		ade = new ADEMarshaller(this);

		xlinkResolver = new GeometryXlinkResolver();
		appearanceResolver = new AppearanceResolver(this);
	}

	public void reset() {
		verticesBuilder.reset();
		textureVerticesBuilder.reset();
		templatesVerticesBuilder.reset();
	}
	
	public CityJSON marshal(CityModel src) {
		xlinkResolver.resolve(src);
		appearanceResolver.resolve(src);

		CityJSON dest = new CityJSON();
		citygml.marshal(src, dest);

		if (dest.hasCityObjects()) {
			List<List<Double>> vertices = verticesBuilder.build();
			dest.setVertices(vertices);

			if (verticesTransformer != null) {
				TransformType transform = verticesTransformer.applyTransformation(vertices);
				if (transform != null) {
					dest.setTransform(transform);
					dest.removeDuplicateVertices();
				}
			}

			if (appearanceResolver.hasTextures() || appearanceResolver.hasMaterials()) {
				AppearanceType appearance = new AppearanceType();
				dest.setAppearance(appearance);

				if (appearanceResolver.hasMaterials())
					appearance.setMaterials(appearanceResolver.getMaterials());			

				if (appearanceResolver.hasTextures()) {
					List<List<Double>> textureVertices = textureVerticesBuilder.build();
					if (textureVertices.size() > 0) {
						appearance.setTextures(appearanceResolver.getTextures());
						appearance.setTextureVertices(textureVertices);
					}
				}
			}

			if (citygml.getCoreMarshaller().hasGeometryTemplates()) {
				GeometryTemplatesType geometryTemplates = new GeometryTemplatesType();
				dest.setGeometryTemplates(geometryTemplates);

				geometryTemplates.setTemplates(citygml.getCoreMarshaller().getGeometryTemplates());
				geometryTemplates.setTemplatesVertices(templatesVerticesBuilder.build());
			}

			if (citygml.getGenericsMarshaller().hasGenericAttributeTypes()) {
				CityGMLMetadata metadata = new CityGMLMetadata();
				metadata.setGenericAttributeTypes(citygml.getGenericsMarshaller().getGenericAttributeTypes());
				dest.addExtensionProperty(CityGMLMetadata.JSON_KEY, metadata);
			}
		}

		// remove local properties from input objects
		src.accept(new LocalPropertiesCleaner());

		return dest;
	}
	
	public AbstractCityObjectType marshal(AbstractCityObject src, CityJSON cityJSON) {
		xlinkResolver.resolve(src);
		appearanceResolver.resolve(src);

		AbstractCityObjectType dest = citygml.marshal(src, cityJSON);

		// remove local properties from input objects
		src.accept(new LocalPropertiesCleaner());

		return dest;
	}

	public CityGMLMarshaller getCityGMLMarshaller() {
		return citygml;
	}

	public GMLMarshaller getGMLMarshaller() {
		return gml;
	}

	public ADEMarshaller getADEMarshaller() {
		return ade;
	}

	public GeometryXlinkResolver getGeometryXlinkResolver() {
		return xlinkResolver;
	}

	public AppearanceResolver getAppearanceResolver() {
		return appearanceResolver;
	}

	public VerticesBuilder getVerticesBuilder() {
		return verticesBuilder;
	}

	public void setVerticesBuilder(VerticesBuilder verticesBuilder) {
		this.verticesBuilder = Objects.requireNonNull(verticesBuilder, "vertices builder may not be null.");
	}
	
	public VerticesTransformer getVerticesTransformer() {
		return verticesTransformer;
	}

	public void setVerticesTransformer(VerticesTransformer verticesTransformer) {
		this.verticesTransformer = Objects.requireNonNull(verticesTransformer, "vertices transformer may not be null.");
	}
	
	public TextureVerticesBuilder getTextureVerticesBuilder() {
		return textureVerticesBuilder;
	}

	public void setTextureVerticesBuilder(TextureVerticesBuilder textureVerticesBuilder) {
		this.textureVerticesBuilder = Objects.requireNonNull(textureVerticesBuilder, "texture vertices builder may not be null.");
	}

	public VerticesBuilder getTemplatesVerticesBuilder() {
		return templatesVerticesBuilder;
	}

	public void setTemplatesVerticesBuilder(VerticesBuilder templatesVerticesBuilder) {
		this.templatesVerticesBuilder = Objects.requireNonNull(templatesVerticesBuilder, "templates vertices builder may not be null.");
	}

	public TextureFileHandler getTextureFileHandler() {
		return textureFileHandler;
	}

	public void setTextureFileHandler(TextureFileHandler textureFileHandler) {
		this.textureFileHandler = Objects.requireNonNull(textureFileHandler, "texture file handler builder may not be null.");
	}

	public boolean isRemoveDuplicateChildGeometries() {
		return removeDuplicateChildGeometries;
	}

	public void setRemoveDuplicateChildGeometries(boolean removeDuplicateChildGeometries) {
		this.removeDuplicateChildGeometries = removeDuplicateChildGeometries;
	}

	public boolean isGenerateCityGMLMetadata() {
		return generateCityGMLMetadata;
	}

	public void setGenerateCityGMLMetadata(boolean generateCityGMLMetadata) {
		this.generateCityGMLMetadata = generateCityGMLMetadata;
	}

	public boolean isUseMaterialDefaults() {
		return useMaterialDefaults;
	}

	public void setUseMaterialDefaults(boolean useMaterialDefaults) {
		this.useMaterialDefaults = useMaterialDefaults;
	}

	public String getFallbackTheme() {
		return fallbackTheme;
	}

	public void setFallbackTheme(String fallbackTheme) {
		this.fallbackTheme = fallbackTheme;
	}
}
