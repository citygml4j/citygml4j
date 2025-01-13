/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CityJSONOutputFactory {
    boolean removeDuplicateChildGeometries;
    boolean generateCityGMLMetadata;
    boolean useMaterialDefaults = true;
    String fallbackTheme = "unnamed";

    public CityJSONWriter createCityJSONWriter(File file) throws CityJSONWriteException {
        try {
            createParentDirectories(file.toPath());
            return new CityJSONWriter(new JsonWriter(new BufferedWriter(new FileWriter(file))), this);
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by: ", e);
        }
    }

    public CityJSONWriter createCityJSONWriter(File file, String encoding) throws CityJSONWriteException {
        try {
            createParentDirectories(file.toPath());
            return new CityJSONWriter(new JsonWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding))), this);
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by: ", e);
        }
    }

    public CityJSONWriter createCityJSONWriter(OutputStream outputStream) {
        return new CityJSONWriter(new JsonWriter(new BufferedWriter(new OutputStreamWriter(outputStream))), this);
    }

    public CityJSONWriter createCityJSONWriter(OutputStream outputStream, String encoding) throws CityJSONWriteException {
        try {
            return new CityJSONWriter(new JsonWriter(new BufferedWriter(new OutputStreamWriter(outputStream, encoding))), this);
        } catch (UnsupportedEncodingException e) {
            throw new CityJSONWriteException("Caused by: ", e);
        }
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

    public CityJSONChunkWriter createCityJSONChunkWriter(File file, String encoding) throws CityJSONWriteException {
        try {
            createParentDirectories(file.toPath());
            return new CityJSONChunkWriter(new JsonWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding))), this);
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by: ", e);
        }
    }

    public CityJSONChunkWriter createCityJSONChunkWriter(OutputStream outputStream) {
        return new CityJSONChunkWriter(new JsonWriter(new BufferedWriter(new OutputStreamWriter(outputStream))), this);
    }

    public CityJSONChunkWriter createCityJSONChunkWriter(OutputStream outputStream, String encoding) throws CityJSONWriteException {
        try {
            return new CityJSONChunkWriter(new JsonWriter(new BufferedWriter(new OutputStreamWriter(outputStream, encoding))), this);
        } catch (UnsupportedEncodingException e) {
            throw new CityJSONWriteException("Caused by: ", e);
        }
    }

    public CityJSONChunkWriter createCityJSONChunkWriter(Writer writer) {
        return new CityJSONChunkWriter(new JsonWriter(writer), this);
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

    private void createParentDirectories(Path path) throws IOException {
        Path parent = path.getParent();
        if (parent != null && !Files.exists(parent))
            Files.createDirectories(parent);
    }

}
