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

package org.citygml4j.cityjson.writer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractCityJSONWriter<T extends AbstractCityJSONWriter<?>> implements AutoCloseable {
    final JsonGenerator writer;
    final ReferenceResolver referenceResolver = new ReferenceResolver();
    final Map<String, Number> templateLods = new HashMap<>();

    CityJSONSerializerHelper helper;
    State state = State.INITIAL;

    enum State {
        INITIAL,
        DOCUMENT_STARTED,
        CLOSED
    }

    AbstractCityJSONWriter(JsonGenerator writer) {
        this.writer = writer;
    }

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
        return writer.getCharacterEscapes() instanceof HtmlEscapes;
    }

    public T setHtmlSafe(boolean htmlSafe) {
        writer.setCharacterEscapes(htmlSafe ? new HtmlEscapes() : null);
        return self();
    }

    void beginTopLevelObject() {
    }

    void writeStartDocument(AbstractFeature feature) throws CityJSONWriteException {
        if (state != State.INITIAL) {
            throw new CityJSONWriteException("The document has already been started.");
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
            writer.flush();
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    @Override
    public void close() throws CityJSONWriteException {
        try {
            writer.close();
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        } finally {
            helper.reset();
            referenceResolver.clear();
        }
    }

    void writeVertices(boolean writeTransform) throws IOException {
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

            writer.writeArrayFieldStart(Fields.VERTICES);
            writer.writeEndArray();
        }
    }

    void writeTransform(Transform transform) throws IOException {
        Vertex scale = transform.getScale();
        Vertex translate = transform.getTranslate();

        writer.writeObjectFieldStart(Fields.TRANSFORM);
        writer.writeArrayFieldStart(Fields.SCALE);
        writer.writeNumber(scale.getX());
        writer.writeNumber(scale.getY());
        writer.writeNumber(scale.getZ());
        writer.writeEndArray();

        writer.writeArrayFieldStart(Fields.TRANSLATE);
        writer.writeNumber(translate.getX());
        writer.writeNumber(translate.getY());
        writer.writeNumber(translate.getZ());
        writer.writeEndArray();
        writer.writeEndObject();
    }

    void writeExtensions() throws CityJSONWriteException, IOException {
        ExtensionLoader loader = ADERegistry.getInstance().getADELoader(ExtensionLoader.class);
        if (loader.hasExtensions() || helper.hasExtensions()) {
            try {
                writer.writeObjectFieldStart(Fields.EXTENSIONS);
                for (Extension extension : loader.getExtensions()) {
                    ObjectNode node = helper.getObjectUsingSerializer(ExtensionInfo.of(extension), ExtensionInfoAdapter.class);
                    if (node != null) {
                        writer.writeObjectField(extension.getName(), node);
                    }
                }

                for (Map.Entry<String, ObjectNode> entry : helper.getExternalExtensions().entrySet()) {
                    if (loader.getExtension(entry.getKey()) == null) {
                        writer.writeObjectField(entry.getKey(), entry.getValue());
                    }
                }

                writer.writeEndObject();
            } catch (CityJSONSerializeException e) {
                throw new CityJSONWriteException("Failed to serialize the extensions property.", e);
            }
        }
    }

    void writeMetadata() throws CityJSONWriteException, IOException {
        if (helper.hasMetadata()) {
            try {
                ObjectNode metadata = helper.getObjectUsingSerializer(helper.getMetadata(), MetadataAdapter.class);
                if (!metadata.isEmpty()) {
                    writer.writeObjectField(Fields.METADATA, metadata);
                }
            } catch (CityJSONSerializeException e) {
                throw new CityJSONWriteException("Failed to serialize the metadata property.", e);
            }
        }
    }

    void writeAppearance() throws IOException {
        AppearanceSerializer appearanceSerializer = helper.getAppearanceSerializer();
        if (appearanceSerializer.hasMaterials() || appearanceSerializer.hasTextures()) {
            writer.writeObjectFieldStart(Fields.APPEARANCE);

            if (appearanceSerializer.hasMaterials()) {
                writeAsArray(Fields.MATERIALS, appearanceSerializer.getMaterials());
            }

            if (appearanceSerializer.hasTextures()) {
                writeAsArray(Fields.TEXTURES, appearanceSerializer.getTextures());
                ArrayBuffer<TextureVertex> textureVertices = appearanceSerializer.getTextureVerticesBuilder().build();
                if (!textureVertices.isEmpty()) {
                    writer.writeArrayFieldStart(Fields.VERTICES_TEXTURE);
                    for (TextureVertex textureVertex : textureVertices) {
                        writer.writeStartArray();
                        writer.writeNumber(textureVertex.getS());
                        writer.writeNumber(textureVertex.getT());
                        writer.writeEndArray();
                    }

                    writer.writeEndArray();
                }
            }

            writer.writeEndObject();
        }
    }

    void writeTemplates() throws IOException {
        GeometrySerializer geometrySerializer = helper.getGeometrySerializer();
        if (geometrySerializer.hasTemplates()) {
            writer.writeObjectFieldStart(Fields.GEOMETRY_TEMPLATES);
            writeAsArray(Fields.TEMPLATES, geometrySerializer.getTemplates());
            writeVertices(Fields.VERTICES_TEMPLATES, geometrySerializer.getTemplatesVerticesBuilder().build());
            writer.writeEndObject();
        }
    }

    void writeExtraRootProperties() throws IOException {
        if (helper.isWriteGenericAttributeTypes()) {
            try {
                helper.addExtraRootProperty(helper.getProperties().get(GenericAttributeTypes.class.getName(), ADEOfCityModel.class));
            } catch (Exception e) {
                //
            }
        }

        if (helper.hasExtraRootProperties()) {
            for (Map.Entry<String, JsonNode> entry : helper.getExtraRootProperties().properties()) {
                writer.writeObjectField(entry.getKey(), entry.getValue());
            }
        }
    }

    void writeAsArray(String propertyName, Iterator<ObjectNode> iterator) throws IOException {
        writer.writeArrayFieldStart(propertyName);
        while (iterator.hasNext()) {
            writer.writeObject(iterator.next());
        }

        writer.writeEndArray();
    }

    void writeVertices(String propertyName, ArrayBuffer<Vertex> vertices) throws IOException {
        writer.writeArrayFieldStart(propertyName);
        for (Vertex vertex : vertices) {
            writer.writeStartArray();
            writer.writeNumber(vertex.getX());
            writer.writeNumber(vertex.getY());
            writer.writeNumber(vertex.getZ());
            writer.writeEndArray();
        }

        writer.writeEndArray();
    }

    void writeTransformedVertices(String propertyName, ArrayBuffer<Vertex> vertices) throws IOException {
        writer.writeArrayFieldStart(propertyName);
        for (Vertex vertex : vertices) {
            writer.writeStartArray();
            writer.writeNumber((long) vertex.getX());
            writer.writeNumber((long) vertex.getY());
            writer.writeNumber((long) vertex.getZ());
            writer.writeEndArray();
        }

        writer.writeEndArray();
    }

    void getAndSetReferenceSystem(AbstractFeature feature) {
        if (feature != null && (!helper.hasMetadata() || helper.getMetadata().getReferenceSystem() == null)) {
            String referenceSystem = helper.getReferenceSystem(feature);
            if (referenceSystem != null) {
                helper.getMetadata().setReferenceSystem(ReferenceSystem.parse(referenceSystem));
            }
        }
    }
}
