/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import org.citygml4j.cityjson.ExtensionLoader;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.adapter.extension.ExtensionInfo;
import org.citygml4j.cityjson.adapter.extension.ExtensionInfoAdapter;
import org.citygml4j.cityjson.adapter.geometry.serializer.GeometrySerializer;
import org.citygml4j.cityjson.adapter.metadata.MetadataAdapter;
import org.citygml4j.cityjson.extension.Extension;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.generics.GenericAttributeTypes;
import org.citygml4j.cityjson.model.geometry.TextureVertex;
import org.citygml4j.cityjson.model.geometry.Transform;
import org.citygml4j.cityjson.model.geometry.Vertex;
import org.citygml4j.cityjson.model.metadata.Metadata;
import org.citygml4j.cityjson.model.metadata.ReferenceSystem;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.ArrayBuffer;
import org.citygml4j.core.ade.ADERegistry;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.core.model.core.ADEOfCityModel;
import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractCityJSONWriter<T extends AbstractCityJSONWriter<?>> implements AutoCloseable {
    final JsonMapper jsonMapper;
    final JsonGeneratorFactory generatorFactory;
    final ReferenceResolver referenceResolver = new ReferenceResolver();
    final Map<String, Number> templateLods = new HashMap<>();

    JsonGenerator generator;
    CityJSONSerializerHelper helper;
    State state = State.INITIAL;
    boolean htmlSafe;

    enum State {
        INITIAL,
        DOCUMENT_STARTED,
        CLOSED
    }

    AbstractCityJSONWriter(JsonMapper jsonMapper, JsonGeneratorFactory generatorFactory) {
        this.jsonMapper = jsonMapper;
        this.generatorFactory = generatorFactory;
    }

    abstract ObjectWriter configureObjectWriter(ObjectWriter objectWriter) throws JacksonException;

    abstract void writeCityObject(String id, ObjectNode node) throws CityJSONWriteException;

    abstract void writeChildObject(String id, ObjectNode node) throws CityJSONWriteException;

    abstract T self();

    public Metadata getMetadata() {
        return helper.getMetadata();
    }

    public T withMetadata(Metadata metadata) {
        helper.setMetadata(metadata);
        return self();
    }

    public T withGlobalCityObjectGroup(CityObjectGroup group) {
        referenceResolver.add(Objects.requireNonNull(group, "The city object group must not be null."));
        return self();
    }

    public T withGlobalAppearance(Appearance appearance) {
        referenceResolver.add(Objects.requireNonNull(appearance, "The appearance must not be null."));
        return self();
    }

    public T withGlobalTemplateGeometry(AbstractGeometry geometry, Number lod) {
        Objects.requireNonNull(geometry, "The template geometry must not be null.");
        if (geometry.getId() != null) {
            referenceResolver.add(geometry);
            if (lod != null) {
                templateLods.put(geometry.getId(), lod);
            }
        }

        return self();
    }

    public T withGlobalTemplateGeometry(AbstractGeometry geometry) {
        return withGlobalTemplateGeometry(geometry, null);
    }

    public T withExtraRootProperty(ADEOfCityModel property) throws CityJSONWriteException {
        try {
            helper.addExtraRootProperty(property);
            return self();
        } catch (CityJSONSerializeException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    public T withExtraRootProperty(String propertyName, JsonNode value) {
        helper.addExtraRootProperty(propertyName, value);
        return self();
    }

    public boolean isHtmlSafe() {
        return htmlSafe;
    }

    public T setHtmlSafe(boolean htmlSafe) {
        this.htmlSafe = htmlSafe;
        return self();
    }

    void beginTopLevelObject() {
    }

    void writeStartDocument(AbstractFeature feature) throws CityJSONWriteException {
        if (state != State.INITIAL) {
            throw new CityJSONWriteException("The document has already been started.");
        }

        try {
            ensureGenerator();
        } catch (JacksonException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }

        referenceResolver.initialize();
    }

    public void writeCityObject(AbstractFeature feature) throws CityJSONWriteException {
        switch (state) {
            case CLOSED:
                throw new CityJSONWriteException("Illegal to write city objects after writer has been closed.");
            case INITIAL:
                writeStartDocument(feature);
        }

        if (feature != null) {
            try {
                referenceResolver.resolveReferences(feature);
                helper.writeCityObject(feature);
            } catch (CityJSONSerializeException e) {
                throw new CityJSONWriteException("Caused by:", e);
            }
        }
    }

    public void flush() throws CityJSONWriteException {
        try {
            ensureGenerator();
            generator.flush();
        } catch (JacksonException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    @Override
    public void close() throws CityJSONWriteException {
        try {
            ensureGenerator();
            generator.close();
        } catch (JacksonException e) {
            throw new CityJSONWriteException("Caused by:", e);
        } finally {
            helper.reset();
            referenceResolver.clear();
        }
    }

    void writeVertices(boolean writeTransform) {
        GeometrySerializer geometrySerializer = helper.getGeometrySerializer();
        ArrayBuffer<Vertex> vertices = geometrySerializer.getVerticesBuilder().build();
        if (!vertices.isEmpty()) {
            if (helper.isComputeCityModelExtent()) {
                helper.getMetadata().setGeographicalExtent(helper.computeExtent(vertices));
            }

            if (helper.isApplyTransformation()) {
                Transform transform = geometrySerializer.getVerticesBuilder().transform();
                if (writeTransform) {
                    writeTransform(transform);
                }

                writeTransformedVertices(Fields.VERTICES, vertices);
            } else {
                writeVertices(Fields.VERTICES, vertices);
            }
        } else {
            if (writeTransform && helper.getVersion() != CityJSONVersion.v1_0) {
                writeTransform(new Transform());
            }

            generator.writeArrayPropertyStart(Fields.VERTICES);
            generator.writeEndArray();
        }
    }

    void writeTransform(Transform transform) {
        Vertex scale = transform.getScale();
        Vertex translate = transform.getTranslate();

        generator.writeObjectPropertyStart(Fields.TRANSFORM);
        generator.writeArrayPropertyStart(Fields.SCALE);
        generator.writeNumber(scale.getX());
        generator.writeNumber(scale.getY());
        generator.writeNumber(scale.getZ());
        generator.writeEndArray();

        generator.writeArrayPropertyStart(Fields.TRANSLATE);
        generator.writeNumber(translate.getX());
        generator.writeNumber(translate.getY());
        generator.writeNumber(translate.getZ());
        generator.writeEndArray();
        generator.writeEndObject();
    }

    void writeExtensions() throws CityJSONWriteException {
        ExtensionLoader loader = ADERegistry.getInstance().getADELoader(ExtensionLoader.class);
        if (loader.hasExtensions() || helper.hasExtensions()) {
            try {
                generator.writeObjectPropertyStart(Fields.EXTENSIONS);
                for (Extension extension : loader.getExtensions()) {
                    ObjectNode node = helper.getObjectUsingSerializer(ExtensionInfo.of(extension), ExtensionInfoAdapter.class);
                    if (node != null) {
                        generator.writeName(extension.getName());
                        generator.writeTree(node);
                    }
                }

                for (Map.Entry<String, ObjectNode> entry : helper.getExternalExtensions().entrySet()) {
                    if (loader.getExtension(entry.getKey()) == null) {
                        generator.writeName(entry.getKey());
                        generator.writeTree(entry.getValue());
                    }
                }

                generator.writeEndObject();
            } catch (CityJSONSerializeException e) {
                throw new CityJSONWriteException("Failed to serialize the extensions property.", e);
            }
        }
    }

    void writeMetadata() throws CityJSONWriteException {
        if (helper.hasMetadata()) {
            try {
                ObjectNode metadata = helper.getObjectUsingSerializer(helper.getMetadata(), MetadataAdapter.class);
                if (!metadata.isEmpty()) {
                    generator.writeName(Fields.METADATA);
                    generator.writeTree(metadata);
                }
            } catch (CityJSONSerializeException e) {
                throw new CityJSONWriteException("Failed to serialize the metadata property.", e);
            }
        }
    }

    void writeAppearance() {
        AppearanceSerializer appearanceSerializer = helper.getAppearanceSerializer();
        if (appearanceSerializer.hasMaterials() || appearanceSerializer.hasTextures()) {
            generator.writeObjectPropertyStart(Fields.APPEARANCE);

            if (appearanceSerializer.hasMaterials()) {
                writeAsArray(Fields.MATERIALS, appearanceSerializer.getMaterials());
            }

            if (appearanceSerializer.hasTextures()) {
                writeAsArray(Fields.TEXTURES, appearanceSerializer.getTextures());
                ArrayBuffer<TextureVertex> textureVertices = appearanceSerializer.getTextureVerticesBuilder().build();
                if (!textureVertices.isEmpty()) {
                    generator.writeArrayPropertyStart(Fields.VERTICES_TEXTURE);
                    for (TextureVertex textureVertex : textureVertices) {
                        generator.writeStartArray();
                        generator.writeNumber(textureVertex.getS());
                        generator.writeNumber(textureVertex.getT());
                        generator.writeEndArray();
                    }

                    generator.writeEndArray();
                }
            }

            generator.writeEndObject();
        }
    }

    void writeTemplates() {
        GeometrySerializer geometrySerializer = helper.getGeometrySerializer();
        if (geometrySerializer.hasTemplates()) {
            generator.writeObjectPropertyStart(Fields.GEOMETRY_TEMPLATES);
            writeAsArray(Fields.TEMPLATES, geometrySerializer.getTemplates());
            writeVertices(Fields.VERTICES_TEMPLATES, geometrySerializer.getTemplatesVerticesBuilder().build());
            generator.writeEndObject();
        }
    }

    void writeExtraRootProperties() {
        if (helper.isWriteGenericAttributeTypes()) {
            try {
                helper.addExtraRootProperty(helper.getProperties().get(GenericAttributeTypes.class.getName(), ADEOfCityModel.class));
            } catch (Exception e) {
                //
            }
        }

        if (helper.hasExtraRootProperties()) {
            for (Map.Entry<String, JsonNode> entry : helper.getExtraRootProperties().properties()) {
                generator.writeName(entry.getKey());
                generator.writeTree(entry.getValue());
            }
        }
    }

    void writeAsArray(String propertyName, Iterator<ObjectNode> iterator) {
        generator.writeArrayPropertyStart(propertyName);
        while (iterator.hasNext()) {
            generator.writeTree(iterator.next());
        }

        generator.writeEndArray();
    }

    void writeVertices(String propertyName, ArrayBuffer<Vertex> vertices) {
        generator.writeArrayPropertyStart(propertyName);
        for (Vertex vertex : vertices) {
            generator.writeStartArray();
            generator.writeNumber(vertex.getX());
            generator.writeNumber(vertex.getY());
            generator.writeNumber(vertex.getZ());
            generator.writeEndArray();
        }

        generator.writeEndArray();
    }

    void writeTransformedVertices(String propertyName, ArrayBuffer<Vertex> vertices) {
        generator.writeArrayPropertyStart(propertyName);
        for (Vertex vertex : vertices) {
            generator.writeStartArray();
            generator.writeNumber((long) vertex.getX());
            generator.writeNumber((long) vertex.getY());
            generator.writeNumber((long) vertex.getZ());
            generator.writeEndArray();
        }

        generator.writeEndArray();
    }

    void getAndSetReferenceSystem(AbstractFeature feature) {
        if (feature != null && (!helper.hasMetadata() || helper.getMetadata().getReferenceSystem() == null)) {
            String referenceSystem = helper.getReferenceSystem(feature);
            if (referenceSystem != null) {
                helper.getMetadata().setReferenceSystem(ReferenceSystem.parse(referenceSystem));
            }
        }
    }

    final void ensureGenerator() throws JacksonException {
        if (generator == null) {
            ObjectWriter configuredWriter = htmlSafe
                    ? jsonMapper.writer().with(new HtmlEscapes())
                    : jsonMapper.writer();

            configuredWriter = configureObjectWriter(configuredWriter);
            generator = generatorFactory.create(configuredWriter);
        }
    }

    @FunctionalInterface
    interface JsonGeneratorFactory {
        JsonGenerator create(ObjectWriter objectWriter) throws JacksonException;
    }
}
