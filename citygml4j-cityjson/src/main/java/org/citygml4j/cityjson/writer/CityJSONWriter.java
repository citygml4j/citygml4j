/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.visitor.Visitable;

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

    private void writeStartDocument() throws CityJSONWriteException {
        if (state != State.INITIAL) {
            throw new CityJSONWriteException("The document has already been started.");
        }

        try {
            writer.writeStartObject();
            writer.writeStringField(Fields.TYPE, CityJSONType.CITYJSON.toTypeName());
            writer.writeStringField(Fields.VERSION, helper.getVersion().toValue());
            writer.writeObjectFieldStart(Fields.CITY_OBJECTS);
        } catch (IOException e) {
            throw new CityJSONWriteException("Caused by:", e);
        } finally {
            state = State.DOCUMENT_STARTED;
        }
    }

    @Override
    public void writeCityObject(AbstractFeature feature) throws CityJSONWriteException {
        switch (state) {
            case CLOSED:
                throw new CityJSONWriteException("Illegal to write city objects after writer has been closed.");
            case INITIAL:
                writeStartDocument();
        }

        super.writeCityObject(feature);
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
            writeStartDocument();
        }

        for (Visitable visitable : resolveScopes) {
            if (visitable instanceof CityObjectGroup) {
                writeCityObject((CityObjectGroup) visitable);
            }
        }

        try {
            writer.writeEndObject();
            writeVertices(true);
            writeExtensions();
            writeMetadata();
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
}