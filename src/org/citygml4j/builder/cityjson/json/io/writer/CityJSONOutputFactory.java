package org.citygml4j.builder.cityjson.json.io.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Objects;

import org.citygml4j.builder.cityjson.marshal.util.TextureVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesBuilder;

import com.google.gson.stream.JsonWriter;

public class CityJSONOutputFactory {
	public static final String VERTICES_BUILDER = "org.citygml4j.cityjson.verticesBuilder";
	public static final String TEXTURE_VERTICES_BUILDER = "org.citygml4j.cityjson.textureVerticesBuilder";

	protected VerticesBuilder verticesBuilder;
	protected TextureVerticesBuilder textureVerticesBuilder;

	public CityJSONWriter createCityJSONWriter(File file) throws CityJSONWriteException {
		try {
			return new CityJSONWriter(new JsonWriter(new BufferedWriter(new FileWriter(file))), this);
		} catch (IOException e) {
			throw new CityJSONWriteException("Caused by: ", e);
		}
	}

	public CityJSONWriter createCityJSONWriter(OutputStream outputStream) throws CityJSONWriteException {
		return new CityJSONWriter(new JsonWriter(new OutputStreamWriter(outputStream)), this);
	}
	
	public CityJSONWriter createCityJSONWriter(Writer writer) throws CityJSONWriteException {
		return new CityJSONWriter(new JsonWriter(writer), this);
	}

	public CityJSONChunkWriter createCityJSONChunkWriter(File file) throws CityJSONWriteException {
		try {
			return new CityJSONChunkWriter(new JsonWriter(new BufferedWriter(new FileWriter(file))), this);
		} catch (IOException e) {
			throw new CityJSONWriteException("Caused by: ", e);
		}
	}

	public CityJSONChunkWriter createCityJSONChunkWriter(OutputStream outputStream) throws CityJSONWriteException {
		return new CityJSONChunkWriter(new JsonWriter(new OutputStreamWriter(outputStream)), this);
	}
	
	public CityJSONChunkWriter createCityJSONChunkWriter(Writer writer) throws CityJSONWriteException {
		return new CityJSONChunkWriter(new JsonWriter(writer), this);
	}

	public Object getProperty(String name) {
		Objects.requireNonNull(name, "property name may not be null.");

		if (name.equals(VERTICES_BUILDER))
			return verticesBuilder;
		if (name.equals(TEXTURE_VERTICES_BUILDER))
			return textureVerticesBuilder;

		throw new IllegalArgumentException("the property '" + name + "' is not supported.");
	}

	public void setProperty(String name, Object value) {
		Objects.requireNonNull(name, "property name may not be null.");

		if (name.equals(VERTICES_BUILDER)) {
			if (value instanceof VerticesBuilder)
				verticesBuilder = (VerticesBuilder)value;
			
			return;
		}
		
		if (name.equals(TEXTURE_VERTICES_BUILDER)) {
			if (value instanceof TextureVerticesBuilder)
				textureVerticesBuilder = (TextureVerticesBuilder)value;
			
			return;
		}

		throw new IllegalArgumentException("the key-value pair '" + name + " - " + value.getClass().getName() + "' is not supported.");
	}
	
}
