/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.reader;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.util.lod.LodMapper;
import org.citygml4j.cityjson.util.texture.DefaultTextureFileHandler;
import org.citygml4j.cityjson.util.texture.TextureFileHandler;
import org.citygml4j.core.model.CityGMLVersion;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.gml.util.reference.ReferenceResolver;
import org.xmlobjects.util.Properties;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class CityJSONInputFactory {
    private final ObjectMapper objectMapper;
    private final CityJSONContext context;
    private final Properties properties = new Properties();

    private CityGMLVersion targetCityGMLVersion = CityGMLVersion.v3_0;
    private boolean chunkByTopLevelCityObjects;
    private boolean mapUnsupportedTypesToGenerics = true;
    private boolean transformTemplateGeometries;
    private boolean assignAppearanceToImplicitGeometry;
    private ReferenceResolver resolver;
    private LodMapper lodMapper;
    private IdCreator idCreator;

    public CityJSONInputFactory(ObjectMapper objectMapper, CityJSONContext context) {
        this.objectMapper = objectMapper;
        this.context = context;
        withTextureFileHandler(new DefaultTextureFileHandler());
    }

    public CityGMLVersion getTargetCityGMLVersion() {
        return targetCityGMLVersion;
    }

    public CityJSONInputFactory withTargetCityGMLVersion(CityGMLVersion targetCityGMLVersion) {
        this.targetCityGMLVersion = targetCityGMLVersion;
        return this;
    }

    public boolean isChunkByTopLevelCityObjects() {
        return chunkByTopLevelCityObjects;
    }

    public CityJSONInputFactory chunkByTopLevelCityObjects(boolean chunkByTopLevelCityObjects) {
        this.chunkByTopLevelCityObjects = chunkByTopLevelCityObjects;
        return this;
    }

    public boolean isMapUnsupportedTypesToGenerics() {
        return mapUnsupportedTypesToGenerics;
    }

    public CityJSONInputFactory mapUnsupportedTypesToGenerics(boolean mapUnsupportedTypesToGenerics) {
        this.mapUnsupportedTypesToGenerics = mapUnsupportedTypesToGenerics;
        return this;
    }

    public boolean isTransformTemplateGeometries() {
        return transformTemplateGeometries;
    }

    public CityJSONInputFactory transformTemplateGeometries(boolean transformTemplateGeometries) {
        this.transformTemplateGeometries = transformTemplateGeometries;
        return this;
    }

    public boolean isAssignAppearanceToImplicitGeometry() {
        return assignAppearanceToImplicitGeometry;
    }

    public CityJSONInputFactory assignAppearanceToImplicitGeometry(boolean assignAppearanceToImplicitGeometry) {
        this.assignAppearanceToImplicitGeometry = assignAppearanceToImplicitGeometry;
        return this;
    }

    public ReferenceResolver getReferenceResolver() {
        return resolver;
    }

    public CityJSONInputFactory withReferenceResolver(ReferenceResolver resolver) {
        this.resolver = resolver;
        return this;
    }

    public LodMapper getLodMapper() {
        return lodMapper;
    }

    public void setLodMapper(LodMapper lodMapper) {
        this.lodMapper = Objects.requireNonNull(lodMapper, "The LoD mapper must not be null.");
    }

    public IdCreator getIdCreator() {
        return idCreator;
    }

    public CityJSONInputFactory withIdCreator(IdCreator idCreator) {
        this.idCreator = Objects.requireNonNull(idCreator, "The ID creator must not be null.");
        return this;
    }

    public TextureFileHandler getTextureFileHandler() {
        return properties.get(TextureFileHandler.class.getName(), TextureFileHandler.class);
    }

    public CityJSONInputFactory withTextureFileHandler(TextureFileHandler textureFileHandler) {
        Objects.requireNonNull(textureFileHandler, "The texture file handler must not be null.");
        withProperty(TextureFileHandler.class.getName(), textureFileHandler);
        return this;
    }

    public String getCodeSpaceForIdentifiers(String codeSpace) {
        return properties.get(CityJSONConstants.IDENTIFIER_CODE_SPACE, String.class);
    }

    public CityJSONInputFactory withCodeSpaceForIdentifiers(String codeSpace) {
        withProperty(CityJSONConstants.IDENTIFIER_CODE_SPACE, codeSpace);
        return this;
    }

    public Properties getProperties() {
        return properties;
    }

    public CityJSONInputFactory withProperty(String name, Object value) {
        properties.set(name, value);
        return this;
    }

    public CityJSONReader createCityJSONReader(File file) throws CityJSONReadException {
        try {
            return createReader(objectMapper.createParser(file));
        } catch (IOException e) {
            throw new CityJSONReadException("Caused by:", e);
        }
    }

    public CityJSONReader createCityJSONReader(File file, String encoding) throws CityJSONReadException {
        try {
            return createReader(objectMapper.createParser(new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding))));
        } catch (IOException e) {
            throw new CityJSONReadException("Caused by:", e);
        }
    }

    public CityJSONReader createCityJSONReader(Path path) throws CityJSONReadException {
        try {
            return createReader(objectMapper.createParser(new BufferedInputStream(Files.newInputStream(path))));
        } catch (IOException e) {
            throw new CityJSONReadException("Caused by:", e);
        }
    }

    public CityJSONReader createCityJSONReader(Path path, String encoding) throws CityJSONReadException {
        try {
            return createReader(objectMapper.createParser(new BufferedReader(new InputStreamReader(Files.newInputStream(path), encoding))));
        } catch (IOException e) {
            throw new CityJSONReadException("Caused by:", e);
        }
    }

    public CityJSONReader createCityJSONReader(URL url) throws CityJSONReadException {
        try {
            return createReader(objectMapper.createParser(url));
        } catch (IOException e) {
            throw new CityJSONReadException("Caused by:", e);
        }
    }

    public CityJSONReader createCityJSONReader(InputStream stream) throws CityJSONReadException {
        try {
            return createReader(objectMapper.createParser(stream));
        } catch (IOException e) {
            throw new CityJSONReadException("Caused by:", e);
        }
    }

    public CityJSONReader createCityJSONReader(Reader reader) throws CityJSONReadException {
        try {
            return createReader(objectMapper.createParser(reader));
        } catch (IOException e) {
            throw new CityJSONReadException("Caused by:", e);
        }
    }

    public CityJSONReader createFilteredCityJSONReader(CityJSONReader reader, CityJSONInputFilter filter) {
        reader.filter = filter;
        return reader;
    }

    private CityJSONReader createReader(JsonParser jsonReader) throws CityJSONReadException {
        CityJSONReader reader = chunkByTopLevelCityObjects ?
                new CityJSONChunkReader(jsonReader, objectMapper, context) :
                new CityJSONSimpleReader(jsonReader, objectMapper, context);

        reader.targetCityGMLVersion = targetCityGMLVersion;
        reader.mapUnsupportedTypesToGenerics = mapUnsupportedTypesToGenerics;
        reader.transformTemplateGeometries = transformTemplateGeometries;
        reader.assignAppearanceToImplicitGeometry = targetCityGMLVersion == CityGMLVersion.v3_0 && assignAppearanceToImplicitGeometry;
        reader.resolver = resolver;
        reader.lodMapper = lodMapper;
        reader.idCreator = idCreator;
        reader.properties = properties;

        return reader;
    }
}
