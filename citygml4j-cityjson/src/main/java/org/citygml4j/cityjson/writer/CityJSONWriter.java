/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.model.CityJSONType;
import org.citygml4j.core.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.core.model.core.AbstractFeature;
import tools.jackson.core.JacksonException;
import tools.jackson.core.PrettyPrinter;
import tools.jackson.core.util.DefaultIndenter;
import tools.jackson.core.util.DefaultPrettyPrinter;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.databind.node.ObjectNode;

public class CityJSONWriter extends AbstractCityJSONWriter<CityJSONWriter> {
    private String indent;

    CityJSONWriter(ObjectWriter objectWriter, JsonGeneratorCreator generatorCreator) {
        super(objectWriter, generatorCreator);
    }

    public String getIndent() {
        return indent;
    }

    public CityJSONWriter withIndent(String indent) {
        this.indent = indent;
        return this;
    }

    @Override
    ObjectWriter configureObjectWriter(ObjectWriter objectWriter) throws JacksonException {
        if (indent == null) {
            return objectWriter;
        }

        DefaultIndenter indenter = new DefaultIndenter(indent, "\n");
        PrettyPrinter prettyPrinter = new DefaultPrettyPrinter()
                .withObjectIndenter(indenter)
                .withArrayIndenter(indenter);

        return objectWriter.with(prettyPrinter);
    }

    @Override
    void writeStartDocument(AbstractFeature feature) throws CityJSONWriteException {
        super.writeStartDocument(feature);
        try {
            generator.writeStartObject();
            generator.writeStringProperty(Fields.TYPE, CityJSONType.CITYJSON.toTypeName());
            generator.writeStringProperty(Fields.VERSION, helper.getVersion().toValue());
            generator.writeObjectPropertyStart(Fields.CITY_OBJECTS);

            getAndSetReferenceSystem(feature);
        } catch (JacksonException e) {
            throw new CityJSONWriteException("Caused by:", e);
        } finally {
            state = State.DOCUMENT_STARTED;
            templateLods.clear();
        }
    }

    @Override
    void writeCityObject(String id, ObjectNode node) throws CityJSONWriteException {
        try {
            generator.writeName(id);
            generator.writeTree(node);
        } catch (JacksonException e) {
            throw new CityJSONWriteException("Caused by:", e);
        }
    }

    @Override
    void writeChildObject(String id, ObjectNode node) throws CityJSONWriteException {
        writeCityObject(id, node);
    }

    private void writeEndDocument() throws CityJSONWriteException {
        if (state == State.INITIAL) {
            writeStartDocument(null);
        }

        for (CityObjectGroup group : referenceResolver.getCityObjectGroups()) {
            writeCityObject(group);
        }

        try {
            generator.writeEndObject();
            writeVertices(true);
            writeMetadata();
            writeExtensions();
            writeAppearance();
            writeTemplates();
            writeExtraRootProperties();
            generator.writeEndObject();
        } catch (JacksonException e) {
            throw new CityJSONWriteException("Caused by:", e);
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

    @Override
    CityJSONWriter self() {
        return this;
    }
}
