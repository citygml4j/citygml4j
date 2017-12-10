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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Objects;

import org.citygml4j.builder.cityjson.marshal.util.TextureFileHandler;
import org.citygml4j.builder.cityjson.marshal.util.TextureVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesBuilder;

import com.google.gson.stream.JsonWriter;

public class CityJSONOutputFactory {
	public static final String VERTICES_BUILDER = "org.citygml4j.cityjson.verticesBuilder";
	public static final String TEXTURE_VERTICES_BUILDER = "org.citygml4j.cityjson.textureVerticesBuilder";
	public static final String TEXTURE_FILE_HANDLER = "org.citygml4j.cityjson.textureFileHandler";

	protected VerticesBuilder verticesBuilder;
	protected TextureVerticesBuilder textureVerticesBuilder;
	protected TextureFileHandler textureFileHandler;
	
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
		if (name.equals(TEXTURE_FILE_HANDLER))
			return textureFileHandler;

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
		
		if (name.equals(TEXTURE_FILE_HANDLER)) {
			if (value instanceof TextureFileHandler)
				textureFileHandler = (TextureFileHandler)value;
			
			return;
		}

		throw new IllegalArgumentException("the key-value pair '" + name + " - " + value.getClass().getName() + "' is not supported.");
	}
	
}
