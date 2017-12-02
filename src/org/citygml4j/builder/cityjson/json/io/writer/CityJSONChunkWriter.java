package org.citygml4j.builder.cityjson.json.io.writer;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.MetadataType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.builder.cityjson.marshal.util.AppearanceResolver;
import org.citygml4j.model.citygml.core.AbstractCityObject;

import com.google.gson.stream.JsonWriter;

public class CityJSONChunkWriter extends AbstractCityJSONWriter {
	private final String TYPE = "type";
	private final String CITYJSON = "CityJSON";
	private final String VERSION = "version";
	private final String CITY_OBJECTS = "CityObjects";
	private final String VERTICES = "vertices";
	private final String APPEARANCE = "appearance";
	private final String MATERIALS = "materials";
	private final String TEXTURES = "textures";
	private final String VERTICES_TEXTURE = "vertices-texture";
	private final String METADATA = "metadata";
	
	private DocumentState documentState = DocumentState.INITIAL;
	private Set<Number> lods; 

	private enum DocumentState {
		INITIAL,
		START_DOCUMENT,
		END_DOCUMENT,
	}

	public CityJSONChunkWriter(JsonWriter writer, CityJSONOutputFactory factory) {
		super(writer, factory);
		lods = new HashSet<>();
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
			writer.value("0.5");

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

		try {
			List<AbstractCityObjectType> cityObjects = marshaller.marshal(cityObject);
			if (!cityObjects.isEmpty()) {
				for (AbstractCityObjectType tmp : cityObjects) {
					for (AbstractGeometryType geometry : tmp.getGeometry())
						lods.add(geometry.getLod());
					
					writer.name(tmp.getGmlId());
					gson.toJson(tmp, AbstractCityObjectType.class, writer);
				}
			}
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

			writer.name(VERTICES);
			gson.toJson(vertices, List.class, writer);			

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

			// metadata
			MetadataType metadata = this.metadata != null ? this.metadata : new MetadataType();

			if (!metadata.isSetBBox() && !vertices.isEmpty()) {
				CityJSON cityJSON = new CityJSON();
				cityJSON.setVertices(vertices);
				metadata.setBBox(cityJSON.calcBoundingBox());
			}

			if (!metadata.isSetPresentLoDs() && !lods.isEmpty())
				metadata.setPresentLoDs(lods.stream().sorted().collect(Collectors.toList()));

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
