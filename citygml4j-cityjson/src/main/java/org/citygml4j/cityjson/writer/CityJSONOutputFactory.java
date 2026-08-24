/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.adapter.geometry.serializer.GeometrySerializer;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.util.texture.DefaultTextureFileHandler;
import org.citygml4j.cityjson.util.texture.TextureFileHandler;
import org.xmlobjects.gml.util.id.IdCreator;
import org.xmlobjects.util.Properties;
import tools.jackson.databind.json.JsonMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class CityJSONOutputFactory {
    private final JsonMapper jsonMapper;
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
    private String fallbackTheme = AppearanceSerializer.FALLBACK_THEME;

    public CityJSONOutputFactory(CityJSONVersion version, JsonMapper jsonMapper, CityJSONContext context) {
        this.version = version;
        this.jsonMapper = jsonMapper;
        this.context = context;

        withTextureFileHandler(new DefaultTextureFileHandler());
        useMaterialDefaults(true);
    }

    public CityJSONVersion getVersion() {
        return version;
    }

    public CityJSONOutputFactory withCityJSONVersion(CityJSONVersion version) {
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

    public String getFallbackTheme() {
        return fallbackTheme;
    }

    public CityJSONOutputFactory withFallbackTheme(String fallbackTheme) {
        this.fallbackTheme = fallbackTheme != null ? fallbackTheme : AppearanceSerializer.FALLBACK_THEME;
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

    public CityJSONWriter createCityJSONWriter(File file) {
        return createCityJSONWriter(file, OutputEncoding.UTF8);
    }

    public CityJSONWriter createCityJSONWriter(File file, OutputEncoding encoding) {
        return initialize(new CityJSONWriter(jsonMapper, objectWriter ->
                objectWriter.createGenerator(file, encoding.toJsonEncoding())));
    }

    public CityJSONWriter createCityJSONWriter(Path path) throws CityJSONWriteException {
        return createCityJSONWriter(path, OutputEncoding.UTF8);
    }

    public CityJSONWriter createCityJSONWriter(Path path, OutputEncoding encoding) throws CityJSONWriteException {
        try {
            return createCityJSONWriter(new OutputStreamWriter(Files.newOutputStream(path),
                    encoding.toJsonEncoding().getJavaName()));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONWriter createCityJSONWriter(OutputStream stream) {
        return createCityJSONWriter(stream, OutputEncoding.UTF8);
    }

    public CityJSONWriter createCityJSONWriter(OutputStream stream, OutputEncoding encoding) {
        return initialize(new CityJSONWriter(jsonMapper, objectWriter ->
                objectWriter.createGenerator(stream, encoding.toJsonEncoding())));
    }

    public CityJSONWriter createCityJSONWriter(Writer writer) {
        return initialize(new CityJSONWriter(jsonMapper, objectWriter ->
                objectWriter.createGenerator(writer)));
    }

    public CityJSONWriter createCityJSONWriter(DataOutput dataOutput) {
        return initialize(new CityJSONWriter(jsonMapper, objectWriter ->
                objectWriter.createGenerator(dataOutput)));
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(File file) {
        return createCityJSONFeatureWriter(file, OutputEncoding.UTF8);
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(File file, OutputEncoding encoding) {
        return initialize(new CityJSONFeatureWriter(jsonMapper, objectWriter ->
                objectWriter.createGenerator(file, encoding.toJsonEncoding())));
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(Path path) throws CityJSONWriteException {
        return createCityJSONFeatureWriter(path, OutputEncoding.UTF8);
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(Path path, OutputEncoding encoding) throws CityJSONWriteException {
        try {
            return createCityJSONFeatureWriter(new OutputStreamWriter(Files.newOutputStream(path), encoding.toJsonEncoding().getJavaName()));
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(OutputStream stream) {
        return createCityJSONFeatureWriter(stream, OutputEncoding.UTF8);
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(OutputStream stream, OutputEncoding encoding) {
        return initialize(new CityJSONFeatureWriter(jsonMapper, objectWriter ->
                objectWriter.createGenerator(stream, encoding.toJsonEncoding())));
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(Writer writer) {
        return initialize(new CityJSONFeatureWriter(jsonMapper, objectWriter ->
                objectWriter.createGenerator(writer)));
    }

    public CityJSONFeatureWriter createCityJSONFeatureWriter(DataOutput dataOutput) {
        return initialize(new CityJSONFeatureWriter(jsonMapper, objectWriter ->
                objectWriter.createGenerator(dataOutput)));
    }

    private <T extends AbstractCityJSONWriter<?>> T initialize(T writer) {
        boolean writeCityJSONFeature = writer instanceof CityJSONFeatureWriter;
        CityJSONVersion targetVersion = writeCityJSONFeature ?
                CityJSONVersion.max(version, CityJSONVersion.v1_1) :
                version;

        CityJSONSerializerHelper helper = new CityJSONSerializerHelper(writer, targetVersion, context);

        helper.setProperties(properties);
        helper.setApplyTransformation(targetVersion != CityJSONVersion.v1_0 || applyTransformation);
        helper.setComputeCityModelExtent(!writeCityJSONFeature && computeCityModelExtent);
        helper.setWriteGenericAttributeTypes(!writeCityJSONFeature && writeGenericAttributeTypes);

        GeometrySerializer geometrySerializer = helper.getGeometrySerializer();
        geometrySerializer.setTransformTemplateGeometries(transformTemplateGeometries);

        if (vertexPrecision != GeometrySerializer.DEFAULT_VERTEX_PRECISION) {
            geometrySerializer.getVerticesBuilder().setPrecision(vertexPrecision);
        }

        if (templatePrecision != GeometrySerializer.DEFAULT_TEMPLATE_PRECISION) {
            geometrySerializer.getTemplatesVerticesBuilder().setPrecision(templatePrecision);
        }

        AppearanceSerializer appearanceSerializer = helper.getAppearanceSerializer();
        appearanceSerializer.setFallbackTheme(fallbackTheme);

        if (textureVertexPrecision != AppearanceSerializer.DEFAULT_TEXTURE_VERTEX_PRECISION) {
            appearanceSerializer.getTextureVerticesBuilder().setPrecision(textureVertexPrecision);
        }

        if (idCreator != null) {
            helper.setIdCreator(idCreator);
        }

        writer.helper = helper;
        return writer;
    }
}
