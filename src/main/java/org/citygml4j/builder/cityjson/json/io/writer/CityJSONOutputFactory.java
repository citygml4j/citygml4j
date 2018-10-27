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
package org.citygml4j.builder.cityjson.json.io.writer;

import com.google.gson.stream.JsonWriter;
import org.citygml4j.builder.cityjson.marshal.util.TextureVerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesBuilder;
import org.citygml4j.builder.cityjson.marshal.util.VerticesTransformer;
import org.citygml4j.builder.cityjson.util.TextureFileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class CityJSONOutputFactory {
	protected VerticesBuilder verticesBuilder;
	protected VerticesTransformer verticesTransformer;
	protected TextureVerticesBuilder textureVerticesBuilder;
	protected TextureFileHandler textureFileHandler;
	protected VerticesBuilder templatesVerticesBuilder;
	
	public CityJSONWriter createCityJSONWriter(File file) throws CityJSONWriteException {
		try {
			createParentDirectories(file.toPath());
			return new CityJSONWriter(new JsonWriter(new BufferedWriter(new FileWriter(file))), this);
		} catch (IOException e) {
			throw new CityJSONWriteException("Caused by: ", e);
		}
	}

	public CityJSONWriter createCityJSONWriter(OutputStream outputStream) {
		return new CityJSONWriter(new JsonWriter(new OutputStreamWriter(outputStream)), this);
	}
	
	public CityJSONWriter createCityJSONWriter(Writer writer) {
		return new CityJSONWriter(new JsonWriter(writer), this);
	}

	public CityJSONChunkWriter createCityJSONChunkWriter(File file) throws CityJSONWriteException {
		try {
			createParentDirectories(file.toPath());
			return new CityJSONChunkWriter(new JsonWriter(new BufferedWriter(new FileWriter(file))), this);
		} catch (IOException e) {
			throw new CityJSONWriteException("Caused by: ", e);
		}
	}

	public CityJSONChunkWriter createCityJSONChunkWriter(OutputStream outputStream) {
		return new CityJSONChunkWriter(new JsonWriter(new OutputStreamWriter(outputStream)), this);
	}
	
	public CityJSONChunkWriter createCityJSONChunkWriter(Writer writer) {
		return new CityJSONChunkWriter(new JsonWriter(writer), this);
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

	private void createParentDirectories(Path path) throws IOException {
		Path parent = path.getParent();
		if (parent != null && !Files.exists(parent))
			Files.createDirectories(parent);
	}
	
}
