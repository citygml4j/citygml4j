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
package org.citygml4j.builder.cityjson.json.io.writer;

import com.google.gson.stream.JsonWriter;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.TransformType;
import org.citygml4j.binding.cityjson.geometry.VerticesList;
import org.citygml4j.binding.cityjson.metadata.LoDType;
import org.citygml4j.binding.cityjson.metadata.MetadataType;
import org.citygml4j.builder.cityjson.marshal.citygml.core.CoreMarshaller;
import org.citygml4j.builder.cityjson.marshal.util.AppearanceResolver;
import org.citygml4j.builder.cityjson.marshal.util.VerticesTransformer;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.core.AbstractCityObject;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityJSONChunkWriter extends AbstractCityJSONWriter {
	private final String TYPE = "type";
	private final String CITYJSON = "CityJSON";
	private final String VERSION = "version";
	private final String CITY_OBJECTS = "CityObjects";
	private final String VERTICES = "vertices";
	private final String TRANSFORM = "transform";
	private final String APPEARANCE = "appearance";
	private final String MATERIALS = "materials";
	private final String TEXTURES = "textures";
	private final String VERTICES_TEXTURE = "vertices-texture";
	private final String GEOMETRY_TEMPLATES = "geometry-templates";
	private final String TEMPLATES = "templates";
	private final String VERTICES_TEMPLATES = "vertices-templates";
	private final String METADATA = "metadata";

	private DocumentState documentState = DocumentState.INITIAL;
	private Map<LoDType, Integer> lods;

	private enum DocumentState {
		INITIAL,
		START_DOCUMENT,
		END_DOCUMENT,
	}

	public CityJSONChunkWriter(JsonWriter writer, CityJSONOutputFactory factory) {
		super(writer, factory);
		lods = new HashMap<>();
	}

	public void registerGlobalAppearance(Appearance appearance) {
		switch (documentState) {
		case START_DOCUMENT:
		case END_DOCUMENT:
			throw new IllegalStateException("Global appearances cannot be registered after document has been initialized.");
		case INITIAL:
			break;
		}

		marshaller.getAppearanceResolver().registerGlobalAppearance(appearance);
	}

	public void writeStartDocument() throws CityJSONWriteException {
		switch (documentState) {
		case START_DOCUMENT:
			throw new IllegalStateException("CityJSON document is already initialized.");
		case END_DOCUMENT:
			throw new IllegalStateException("CityJSON document is already complete.");
		case INITIAL:
			break;
		}

		try {
			writer.beginObject();
			writer.name(TYPE);
			writer.value(CITYJSON);
			writer.name(VERSION);
			writer.value("0.8");

			writer.name(CITY_OBJECTS);
			writer.beginObject();

			documentState = DocumentState.START_DOCUMENT;
		} catch (IOException e) {
			throw new CityJSONWriteException("Caused by: ", e);
		}
	}

	public void writeCityObject(AbstractCityObject cityObject) throws CityJSONWriteException {
		switch (documentState) {
		case END_DOCUMENT:
			throw new IllegalStateException("CityJSON document is already complete.");
		case INITIAL:
			writeStartDocument();
			break;
		case START_DOCUMENT:
			break;
		}

		List<AbstractCityObjectType> cityObjects = marshaller.marshal(cityObject);
		for (AbstractCityObjectType tmp : cityObjects)
			write(tmp);
	}

	public void writeCityObject(AbstractCityObjectType cityObject) throws CityJSONWriteException {
		switch (documentState) {
		case END_DOCUMENT:
			throw new IllegalStateException("CityJSON document is already complete.");
		case INITIAL:
			writeStartDocument();
			break;
		case START_DOCUMENT:
			break;
		}

		write(cityObject);
	}

	private void write(AbstractCityObjectType cityObject) throws CityJSONWriteException {
		try {
			for (AbstractGeometryType geometry : cityObject.getGeometry()) {
				if (geometry instanceof AbstractGeometryObjectType) {
					LoDType lod = LoDType.fromLoD(((AbstractGeometryObjectType) geometry).getLod());
					if (lod != null)
						lods.merge(lod, 1, Integer::sum);
				}
			}

			writer.name(cityObject.getGmlId());
			gson.toJson(cityObject, AbstractCityObjectType.class, writer);
		} catch (IOException e) {
			throw new CityJSONWriteException("Caused by: ", e);
		}
	}

	public void writeEndDocument() throws CityJSONWriteException {
		switch (documentState) {
		case END_DOCUMENT:
			throw new IllegalStateException("CityJSON document is already complete.");
		case INITIAL:
			writeStartDocument();
		case START_DOCUMENT:
			break;
		}

		try {
			writer.endObject();

			// vertices
			List<List<Double>> vertices = marshaller.getVerticesBuilder().build();
			if (vertices == null)
				vertices = Collections.emptyList();

			TransformType transform = null;
			VerticesTransformer verticesTransformer = marshaller.getVerticesTransformer();
			if (!vertices.isEmpty() && verticesTransformer != null) {
				transform = verticesTransformer.applyTransformation(vertices);
				if (transform != null) {
					writer.name(TRANSFORM);
					gson.toJson(transform, TransformType.class, writer);
				}
			}

			writer.name(VERTICES);
			gson.toJson(new VerticesList(vertices), VerticesList.class, writer);

			// appearance
			AppearanceResolver appearanceResolver = marshaller.getAppearanceResolver();
			if (appearanceResolver.hasTextures() || appearanceResolver.hasMaterials()) {
				writer.name(APPEARANCE);
				writer.beginObject();

				if (appearanceResolver.hasMaterials()) {
					writer.name(MATERIALS);
					gson.toJson(appearanceResolver.getMaterials(), List.class, writer);					
				}

				if (appearanceResolver.hasTextures()) {
					List<List<Double>> textureVertices = marshaller.getTextureVerticesBuilder().build();
					if (textureVertices.size() > 0) {
						writer.name(TEXTURES);
						gson.toJson(appearanceResolver.getTextures(), List.class, writer);

						writer.name(VERTICES_TEXTURE);
						gson.toJson(textureVertices, List.class, writer);
					}
				}

				writer.endObject();
			}

			// geometry templates
			CoreMarshaller coreMarshaller = marshaller.getCityGMLMarshaller().getCoreMarshaller();
			if (coreMarshaller.hasGeometryTemplates()) {
				writer.name(GEOMETRY_TEMPLATES);
				writer.beginObject();

				List<AbstractGeometryObjectType> geometryTemplates = coreMarshaller.getGeometryTemplates();
				writer.name(TEMPLATES);
				gson.toJson(geometryTemplates, List.class, writer);
				geometryTemplates.forEach(g -> {
					LoDType lod = LoDType.fromLoD(g.getLod());
					if (lod != null)
						lods.merge(lod, 1, Integer::sum);
				});

				List<List<Double>> templatesVertices = marshaller.getTemplatesVerticesBuilder().build();
				if (templatesVertices.size() > 0) {
					writer.name(VERTICES_TEMPLATES);
					gson.toJson(templatesVertices, List.class, writer);
				}

				writer.endObject();
			}

			// metadata
			MetadataType metadata = this.metadata != null ? this.metadata : new MetadataType();

			if (!metadata.isSetGeographicalExtent() && !vertices.isEmpty()) {
				CityJSON cityJSON = new CityJSON();
				cityJSON.setVertices(vertices);

				List<Double> bbox = cityJSON.calcBoundingBox();
				if (transform != null) {
					for (int i = 0; i < bbox.size(); i++)
						bbox.set(i, bbox.get(i) * transform.getScale().get(i%3) + transform.getTranslate().get(i%3));
				}

				metadata.setGeographicalExtent(bbox);
			}

			if (!metadata.isSetPresentLoDs() && !lods.isEmpty())
				metadata.setPresentLoDs(lods);

			writer.name(METADATA);
			gson.toJson(metadata, MetadataType.class, writer);

			writer.endObject();

			documentState = DocumentState.END_DOCUMENT;
		} catch (IOException e) {
			throw new CityJSONWriteException("Caused by: ", e);
		}
	}

	@Override
	public void close() throws CityJSONWriteException {
		if (documentState == DocumentState.START_DOCUMENT)
			writeEndDocument();

		lods.clear();
		super.close();
	}

}
