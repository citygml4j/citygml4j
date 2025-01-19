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
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.geometry.serializer.VerticesBuilder;
import org.citygml4j.cityjson.model.CityJSONType;
import org.citygml4j.cityjson.model.geometry.Transform;
import org.citygml4j.cityjson.model.geometry.Vertex;
import org.citygml4j.core.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class CityJSONFeatureWriter extends AbstractCityJSONWriter<CityJSONFeatureWriter> {
    private final Deque<ObjectNode> topLevelObjects = new ArrayDeque<>();

    CityJSONFeatureWriter(JsonGenerator writer) {
        super(writer);
        writer.setPrettyPrinter(new MinimalPrettyPrinter("\n"));
    }

    public boolean isSetExternalExtension(String name) {
        return helper.isSetExternalExtension(name);
    }

    public void addExternalExtension(String name, String url, String version) {
        helper.addExternalExtension(name, url, version);
    }

    public Vertex getTranslation() {
        return helper.getGeometrySerializer().getVerticesBuilder().getTranslation();
    }

    public CityJSONFeatureWriter withTranslation(Vertex translation) {
        Objects.requireNonNull(translation, "Translation must not be null.");
        helper.getGeometrySerializer().getVerticesBuilder().setTranslation(translation);
        return this;
    }

    @Override
    void writeStartDocument(AbstractFeature feature) throws CityJSONWriteException {
        super.writeStartDocument(feature);
        try {
            writer.writeStartObject();
            writer.writeStringField(Fields.TYPE, CityJSONType.CITYJSON.toTypeName());
            writer.writeStringField(Fields.VERSION, helper.getVersion().toValue());

            // write empty CityObjects field
            writer.writeObjectFieldStart(Fields.CITY_OBJECTS);
            writer.writeEndObject();

            // write empty vertices field
            writer.writeArrayFieldStart(Fields.VERTICES);
            writer.writeEndArray();

            writeTransform(computeTransform(feature));
            getAndSetReferenceSystem(feature);
            writeMetadata();
            writeExtensions();

            if (!helper.getGeometrySerializer().isTransformTemplateGeometries()) {
                processGlobalTemplates();
                writeAppearance();
                writeTemplates();
            }

            writer.writeEndObject();
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        } finally {
            state = State.DOCUMENT_STARTED;
            helper.reset(true);
        }
    }

    @Override
    void beginTopLevelObject() {
        topLevelObjects.push(helper.createObject());
    }

    @Override
    void writeCityObject(String id, ObjectNode node) throws CityJSONWriteException {
        ObjectNode topLevelObject = topLevelObjects.pop();
        if (topLevelObject != null) {
            try {
                topLevelObject.set(id, node);

                writer.writeStartObject();
                writer.writeStringField(Fields.TYPE, CityJSONType.CITYJSON_FEATURE.toTypeName());
                writer.writeStringField(Fields.ID, id);
                writer.writeObjectField(Fields.CITY_OBJECTS, topLevelObject);

                writeVertices(false);
                writeAppearance();

                writer.writeEndObject();
            } catch (IOException e) {
                throw new CityJSONWriteException("Caused by:", e);
            } finally {
                helper.reset(true);
            }
        }
    }

    @Override
    void writeChildObject(String id, ObjectNode node) throws CityJSONWriteException {
        ObjectNode topLevelObject = topLevelObjects.peek();
        if (topLevelObject != null) {
            topLevelObject.set(id, node);
        }
    }

    private void writeEndDocument() throws CityJSONWriteException {
        if (state == State.INITIAL) {
            writeStartDocument(null);
        }

        if (state == State.DOCUMENT_STARTED) {
            for (CityObjectGroup group : referenceResolver.getCityObjectGroups()) {
                if (state == State.INITIAL) {
                    writeStartDocument(group);
                }

                writeCityObject(group);
            }
        }
    }

    @Override
    public void close() throws CityJSONWriteException {
        if (state == State.CLOSED) {
            throw new CityJSONWriteException("The writer has already been closed.");
        }

        try {
            writeEndDocument();
            super.close();
        } finally {
            state = State.CLOSED;
        }
    }

    private void processGlobalTemplates() {
        for (AbstractGeometry template : referenceResolver.getTemplateGeometries()) {
            helper.getGeometrySerializer()
                    .addTemplateGeometry(template, templateLods.getOrDefault(template.getId(), 0));
        }
    }

    private Transform computeTransform(AbstractFeature feature) {
        VerticesBuilder builder = helper.getGeometrySerializer().getVerticesBuilder();
        Transform transform = new Transform();

        double scale = 1 / Math.pow(10, builder.getPrecision());
        transform.setScale(Vertex.of(scale, scale, scale));

        if (feature != null && builder.getTranslation() == null) {
            Envelope envelope = feature.computeEnvelope();
            List<Double> lowerCorner = envelope.getLowerCorner().toCoordinateList3D();
            if (!lowerCorner.isEmpty()) {
                transform.setTranslate(Vertex.of(
                        builder.round(lowerCorner.get(0)),
                        builder.round(lowerCorner.get(1)),
                        builder.round(lowerCorner.get(2))));
            }

            builder.setTranslation(transform.getTranslate());
        }

        return transform;
    }

    @Override
    CityJSONFeatureWriter self() {
        return this;
    }
}
