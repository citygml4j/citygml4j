/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.model.CityJSONType;
import org.citygml4j.core.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.core.model.core.AbstractFeature;

import java.io.IOException;

public class CityJSONWriter extends AbstractCityJSONWriter<CityJSONWriter> {
    private String indent;

    CityJSONWriter(JsonGenerator writer) {
        super(writer);
    }

    public String getIndent() {
        return indent;
    }

    public CityJSONWriter withIndent(String indent) {
        this.indent = indent;

        PrettyPrinter printer = null;
        if (indent != null) {
            DefaultIndenter indenter = new DefaultIndenter(this.indent, "\n");
            printer = new DefaultPrettyPrinter()
                    .withObjectIndenter(indenter)
                    .withArrayIndenter(indenter);
        }

        writer.setPrettyPrinter(printer);
        return this;
    }

    @Override
    void writeStartDocument(AbstractFeature feature) throws CityJSONWriteException {
        super.writeStartDocument(feature);
        try {
            writer.writeStartObject();
            writer.writeStringField(Fields.TYPE, CityJSONType.CITYJSON.toTypeName());
            writer.writeStringField(Fields.VERSION, helper.getVersion().toValue());
            writer.writeObjectFieldStart(Fields.CITY_OBJECTS);

            getAndSetReferenceSystem(feature);
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        } finally {
            state = State.DOCUMENT_STARTED;
        }
    }

    @Override
    void writeCityObject(String id, ObjectNode node) throws CityJSONWriteException {
        try {
            writer.writeObjectField(id, node);
        } catch (IOException e) {
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
            writer.writeEndObject();
            writeVertices(true);
            writeMetadata();
            writeExtensions();
            writeAppearance();
            writeTemplates();
            writeExtraRootProperties();
            writer.writeEndObject();
        } catch (IOException e) {
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
