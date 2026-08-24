/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.geometry.serializer.VerticesBuilder;
import org.citygml4j.cityjson.model.CityJSONType;
import org.citygml4j.cityjson.model.geometry.Transform;
import org.citygml4j.cityjson.model.geometry.Vertex;
import org.citygml4j.core.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.gml.model.geometry.Envelope;
import tools.jackson.core.JacksonException;
import tools.jackson.core.util.MinimalPrettyPrinter;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class CityJSONFeatureWriter extends AbstractCityJSONWriter<CityJSONFeatureWriter> {
    private final Deque<ObjectNode> topLevelObjects = new ArrayDeque<>();

    CityJSONFeatureWriter(JsonMapper jsonMapper, JsonGeneratorFactory generatorFactory) {
        super(jsonMapper, generatorFactory);
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
    ObjectWriter configureObjectWriter(ObjectWriter objectWriter) throws JacksonException {
        return objectWriter.with(new MinimalPrettyPrinter("\n"));
    }

    @Override
    void writeStartDocument(AbstractFeature feature) throws CityJSONWriteException {
        super.writeStartDocument(feature);
        try {
            generator.writeStartObject();
            generator.writeStringProperty(Fields.TYPE, CityJSONType.CITYJSON.toTypeName());
            generator.writeStringProperty(Fields.VERSION, helper.getVersion().toValue());

            // write empty CityObjects field
            generator.writeObjectPropertyStart(Fields.CITY_OBJECTS);
            generator.writeEndObject();

            // write empty vertices field
            generator.writeArrayPropertyStart(Fields.VERTICES);
            generator.writeEndArray();

            writeTransform(computeTransform(feature));
            getAndSetReferenceSystem(feature);
            writeMetadata();
            writeExtensions();

            if (!helper.getGeometrySerializer().isTransformTemplateGeometries()) {
                processGlobalTemplates();
                writeAppearance();
                writeTemplates();
            }

            generator.writeEndObject();
        } catch (JacksonException e) {
            throw new CityJSONWriteException("Caused by:", e);
        } finally {
            state = State.DOCUMENT_STARTED;
            helper.reset();
            templateLods.clear();
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

                generator.writeStartObject();
                generator.writeStringProperty(Fields.TYPE, CityJSONType.CITYJSON_FEATURE.toTypeName());
                generator.writeStringProperty(Fields.ID, id);
                generator.writeName(Fields.CITY_OBJECTS);
                generator.writeTree(topLevelObject);

                writeVertices(false);
                writeAppearance();
                writeExtraRootProperties();

                generator.writeEndObject();
            } catch (JacksonException e) {
                throw new CityJSONWriteException("Caused by:", e);
            } finally {
                helper.reset();
                helper.getExtraRootProperties().removeAll();
            }
        }
    }

    @Override
    void writeChildObject(String id, ObjectNode node) {
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
        referenceResolver.consumeAndRemoveTemplateGeometries(template -> helper.getGeometrySerializer()
                .addTemplateGeometry(template, templateLods.getOrDefault(template.getId(), 0)));
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
