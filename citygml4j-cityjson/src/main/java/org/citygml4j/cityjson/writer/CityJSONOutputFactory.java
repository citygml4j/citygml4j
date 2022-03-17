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

package org.citygml4j.cityjson.writer;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.adapter.geometry.serializer.GeometrySerializer;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.util.texture.DefaultTextureFileHandler;
import org.citygml4j.cityjson.util.texture.TextureFileHandler;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.util.Properties;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class CityJSONOutputFactory {
    private final ObjectMapper objectMapper;
    private final CityJSONContext context;
    private final Properties properties = new Properties();

    private CityJSONVersion version;
    private IdCreator idCreator;
    private int vertexPrecision = GeometrySerializer.DEFAULT_VERTEX_PRECISION;
    private int templatePrecision = GeometrySerializer.DEFAULT_TEMPLATE_PRECISION;
    private int textureVertexPrecision = AppearanceSerializer.DEFAULT_TEXTURE_VERTEX_PRECISION;
    private boolean applyTransformation;
    private boolean computeCityModelExtent = true;
    private boolean transformTemplateGeometries;
    private boolean writeGenericAttributeTypes;

    public CityJSONOutputFactory(CityJSONVersion version, ObjectMapper objectMapper, CityJSONContext context) {
        this.version = version;
        this.objectMapper = objectMapper;
        this.context = context;

        withTextureFileHandler(new DefaultTextureFileHandler());
        useMaterialDefaults(true);
    }

    public CityJSONVersion getVersion() {
        return version;
    }

    public CityJSONOutputFactory withVersion(CityJSONVersion version) {
        this.version = Objects.requireNonNull(version, "The CityJSON version must not be null.");
        return this;
    }

    public IdCreator getIdCreator() {
        return idCreator;
    }

    public CityJSONOutputFactory withIdCreator(IdCreator idCreator) {
        this.idCreator = Objects.requireNonNull(idCreator, "The ID creator must not be null.");
        return this;
    }

    public int getVertexPrecision() {
        return vertexPrecision;
    }

    public CityJSONOutputFactory withVertexPrecision(int vertexPrecision) {
        if (vertexPrecision >= 0) {
            this.vertexPrecision = vertexPrecision;
        }

        return this;
    }

    public int getTemplatePrecision() {
        return templatePrecision;
    }

    public CityJSONOutputFactory withTemplatePrecision(int templatePrecision) {
        if (templatePrecision >= 0) {
            this.templatePrecision = templatePrecision;
        }

        return this;
    }

    public int getTextureVertexPrecision() {
        return textureVertexPrecision;
    }

    public CityJSONOutputFactory withTextureVertexPrecision(int textureVertexPrecision) {
        if (textureVertexPrecision >= 0) {
            this.textureVertexPrecision = textureVertexPrecision;
        }

        return this;
    }

    public boolean isApplyTransformation() {
        return applyTransformation;
    }

    public CityJSONOutputFactory applyTransformation(boolean applyTransformation) {
        this.applyTransformation = applyTransformation;
        return this;
    }

    public boolean isComputeCityModelExtent() {
        return computeCityModelExtent;
    }

    public CityJSONOutputFactory computeCityModelExtent(boolean computeCityModelExtent) {
        this.computeCityModelExtent = computeCityModelExtent;
        return this;
    }

    public boolean isTransformTemplateGeometries() {
        return transformTemplateGeometries;
    }

    public CityJSONOutputFactory transformTemplateGeometries(boolean convertTemplateGeometries) {
        this.transformTemplateGeometries = convertTemplateGeometries;
        return this;
    }

    public boolean isWriteGenericAttributeTypes() {
        return writeGenericAttributeTypes;
    }

    public CityJSONOutputFactory writeGenericAttributeTypes(boolean writeGenericAttributeTypes) {
        this.writeGenericAttributeTypes = writeGenericAttributeTypes;
        return this;
    }

    public TextureFileHandler getTextureFileHandler() {
        return properties.get(TextureFileHandler.class.getName(), TextureFileHandler.class);
    }

    public CityJSONOutputFactory withTextureFileHandler(TextureFileHandler textureFileHandler) {
        Objects.requireNonNull(textureFileHandler, "The texture file handler must not be null.");
        withProperty(TextureFileHandler.class.getName(), textureFileHandler);
        return this;
    }

    public boolean isUseMaterialDefaults() {
        return properties.getAndCompare(CityJSONConstants.USE_MATERIAL_DEFAULTS, true);
    }

    public CityJSONOutputFactory useMaterialDefaults(boolean useMaterialDefaults) {
        withProperty(CityJSONConstants.USE_MATERIAL_DEFAULTS, useMaterialDefaults);
        return this;
    }

    public Properties getProperties() {
        return properties;
    }

    public CityJSONOutputFactory withProperty(String name, Object value) {
        properties.set(name, value);
        return this;
    }

    public CityJSONWriter createCityJSONWriter(File file) throws CityJSONWriteException {
        return createCityJSONWriter(file, JsonEncoding.UTF8);
    }

    public CityJSONWriter createCityJSONWriter(File file, JsonEncoding encoding) throws CityJSONWriteException {
        try {
            return initialize(new CityJSONWriter(objectMapper.createGenerator(file, encoding)));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONWriter createCityJSONWriter(Path path) throws CityJSONWriteException {
        return createCityJSONWriter(path, JsonEncoding.UTF8);
    }

    public CityJSONWriter createCityJSONWriter(Path path, JsonEncoding encoding) throws CityJSONWriteException {
        try {
            return createCityJSONWriter(new OutputStreamWriter(Files.newOutputStream(path), encoding.getJavaName()));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONWriter createCityJSONWriter(OutputStream stream) throws CityJSONWriteException {
        return createCityJSONWriter(stream, JsonEncoding.UTF8);
    }

    public CityJSONWriter createCityJSONWriter(OutputStream stream, JsonEncoding encoding) throws CityJSONWriteException {
        try {
            return initialize(new CityJSONWriter(objectMapper.createGenerator(stream, encoding)));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONWriter createCityJSONWriter(Writer writer) throws CityJSONWriteException {
        try {
            return initialize(new CityJSONWriter(objectMapper.createGenerator(writer)));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONWriter createCityJSONWriter(DataOutput dataOutput) throws CityJSONWriteException {
        try {
            return initialize(new CityJSONWriter(objectMapper.createGenerator(dataOutput)));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(File file) throws CityJSONWriteException {
        return createCityJSONFeatureWriter(file, JsonEncoding.UTF8);
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(File file, JsonEncoding encoding) throws CityJSONWriteException {
        try {
            return initialize(new CityJSONFeatureWriter(objectMapper.createGenerator(file, encoding)));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(Path path) throws CityJSONWriteException {
        return createCityJSONFeatureWriter(path, JsonEncoding.UTF8);
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(Path path, JsonEncoding encoding) throws CityJSONWriteException {
        try {
            return createCityJSONFeatureWriter(new OutputStreamWriter(Files.newOutputStream(path), encoding.getJavaName()));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(OutputStream stream) throws CityJSONWriteException {
        return createCityJSONFeatureWriter(stream, JsonEncoding.UTF8);
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(OutputStream stream, JsonEncoding encoding) throws CityJSONWriteException {
        try {
            return initialize(new CityJSONFeatureWriter(objectMapper.createGenerator(stream, encoding)));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(Writer writer) throws CityJSONWriteException {
        try {
            return initialize(new CityJSONFeatureWriter(objectMapper.createGenerator(writer)));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(DataOutput dataOutput) throws CityJSONWriteException {
        try {
            return initialize(new CityJSONFeatureWriter(objectMapper.createGenerator(dataOutput)));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    private <T extends AbstractCityJSONWriter<?>> T initialize(T writer) {
        boolean writeCityJSONFeature = writer instanceof CityJSONFeatureWriter;

        CityJSONSerializerHelper helper = new CityJSONSerializerHelper(writer,
                writeCityJSONFeature ? CityJSONVersion.max(version, CityJSONVersion.v1_1) : version,
                objectMapper, context);

        helper.setProperties(properties);
        helper.setApplyTransformation(writeCityJSONFeature || applyTransformation);
        helper.setComputeCityModelExtent(!writeCityJSONFeature && computeCityModelExtent);
        helper.setWriteGenericAttributeTypes(!writeCityJSONFeature && writeGenericAttributeTypes);

        GeometrySerializer geometrySerializer = helper.getGeometrySerializer();
        geometrySerializer.setTransformTemplateGeometries(writeCityJSONFeature || transformTemplateGeometries);

        if (vertexPrecision != GeometrySerializer.DEFAULT_VERTEX_PRECISION) {
            geometrySerializer.getVerticesBuilder().setPrecision(vertexPrecision);
        }

        if (templatePrecision != GeometrySerializer.DEFAULT_TEMPLATE_PRECISION) {
            geometrySerializer.getTemplatesVerticesBuilder().setPrecision(templatePrecision);
        }

        if (textureVertexPrecision != AppearanceSerializer.DEFAULT_TEXTURE_VERTEX_PRECISION) {
            helper.getAppearanceSerializer().getTextureVerticesBuilder().setPrecision(textureVertexPrecision);
        }

        if (idCreator != null) {
            helper.setIdCreator(idCreator);
        }

        writer.helper = helper;
        return writer;
    }
}
