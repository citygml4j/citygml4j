/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.appearance.AppearanceType;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.GeometryTemplatesType;
import org.citygml4j.binding.cityjson.geometry.TransformType;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.gml.GMLMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.AppearanceResolver;
import org.citygml4j.builder.cityjson.marshal.util.DefaultTextureVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.DefaultVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.GeometryXlinkResolver;
import org.citygml4j.builder.cityjson.marshal.util.TextureVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesTransformer;
import org.citygml4j.builder.cityjson.util.DefaultTextureFileHandler;
import org.citygml4j.builder.cityjson.util.TextureFileHandler;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;

import java.util.List;
import java.util.Objects;

public class CityJSONMarshaller {
	public static final String GEOMETRY_XLINK = "org.citygml4j.geometry.xlink";
	public static final String GEOMETRY_XLINK_TARGET = "org.citygml4j.geometry.xlinkTarget";
	public static final String GEOMETRY_SURFACE_DATA = "org.citygml4j.geometry.surfaceData";
	public static final String POSTPROCESS_GROUP_MEMBERS = "org.citygml4j.group.checkMembers";

	private final CityGMLMarshaller citygml;
	private final GMLMarshaller gml;	
	private final GeometryXlinkResolver xlinkResolver;
	private final AppearanceResolver appearanceResolver;
	
	private VerticesBuilder verticesBuilder;
	private VerticesTransformer verticesTransformer;
	private TextureVerticesBuilder textureVerticesBuilder;
	private TextureFileHandler textureFileHandler;
	private VerticesBuilder templatesVerticesBuilder;
	private String defaultTheme = "";

	public CityJSONMarshaller(VerticesBuilder verticesBuilder,
							  TextureVerticesBuilder textureVerticesBuilder,
							  TextureFileHandler textureFileHandler,
							  VerticesBuilder templatesVerticesBuilder) {
		this.verticesBuilder = verticesBuilder != null ? verticesBuilder : new DefaultVerticesBuilder();
		this.textureVerticesBuilder = textureVerticesBuilder != null ? textureVerticesBuilder : new DefaultTextureVerticesBuilder();
		this.textureFileHandler = textureFileHandler != null ? textureFileHandler : new DefaultTextureFileHandler();
		this.templatesVerticesBuilder = templatesVerticesBuilder != null ? templatesVerticesBuilder : new DefaultVerticesBuilder();

		citygml = new CityGMLMarshaller(this);
		gml = new GMLMarshaller(this, this::getVerticesBuilder);

		xlinkResolver = new GeometryXlinkResolver();
		appearanceResolver = new AppearanceResolver(defaultTheme, citygml.getAppearanceMarshaller());
	}

	public CityJSONMarshaller() {
		this (new DefaultVerticesBuilder(), new DefaultTextureVerticesBuilder(), new DefaultTextureFileHandler(), new DefaultVerticesBuilder());
	}
	
	public CityJSON marshal(CityModel src) {
		xlinkResolver.resolve(src);
		appearanceResolver.resolve(src);

		CityJSON dest = new CityJSON();

		List<AbstractCityObjectType> cityObjects = citygml.marshal(src);
		if (!cityObjects.isEmpty()) {
			dest.setCityObjects(cityObjects);
			
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
		}

		return dest;
	}
	
	public List<AbstractCityObjectType> marshal(AbstractCityObject src) {
		xlinkResolver.resolve(src);
		appearanceResolver.resolve(src);

		return citygml.marshal(src);
	}

	public CityGMLMarshaller getCityGMLMarshaller() {
		return citygml;
	}

	public GMLMarshaller getGMLMarshaller() {
		return gml;
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

	public TextureFileHandler getTextureFileHandler() {
		return textureFileHandler;
	}

	public void setTextureFileHandler(TextureFileHandler textureFileHandler) {
		this.textureFileHandler = Objects.requireNonNull(textureFileHandler, "texture file handler builder may not be null.");
	}

	public VerticesBuilder getTemplatesVerticesBuilder() {
		return templatesVerticesBuilder;
	}

	public void setTemplatesVerticesBuilder(VerticesBuilder templatesVerticesBuilder) {
		this.templatesVerticesBuilder = Objects.requireNonNull(templatesVerticesBuilder, "templates vertices builder may not be null.");
	}
}
