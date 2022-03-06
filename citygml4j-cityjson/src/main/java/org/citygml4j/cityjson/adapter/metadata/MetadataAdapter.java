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

package org.citygml4j.cityjson.adapter.metadata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.metadata.Metadata;
import org.citygml4j.cityjson.model.metadata.ReferenceSystem;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MetadataAdapter implements JsonObjectBuilder<Metadata>, JsonObjectSerializer<Metadata> {

    @Override
    public Metadata createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Metadata();
    }

    @Override
    public void buildObject(Metadata object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        CityJSONVersion version = helper.getVersion();

        JsonNode identifier = node.path(version == CityJSONVersion.v1_0 ? "fileIdentifier" : "identifier");
        if (identifier.isTextual()) {
            object.setIdentifier(identifier.asText());
        }

        JsonNode pointOfContact = node.path(version == CityJSONVersion.v1_0 ? "datasetPointOfContact" : "pointOfContact");
        if (pointOfContact.isObject()) {
            object.setPointOfContact(helper.getObjectUsingBuilder(pointOfContact, PointOfContactAdapter.class));
        }

        JsonNode referenceDate = node.path(version == CityJSONVersion.v1_0 ? "datasetReferenceDate" : "referenceDate");
        if (referenceDate.isTextual()) {
            try {
                object.setReferenceDate(LocalDate.parse(referenceDate.asText(), DateTimeFormatter.ISO_LOCAL_DATE));
            } catch (Exception e) {
                //
            }
        }

        JsonNode title = node.path(version == CityJSONVersion.v1_0 ? "datasetTitle" : "title");
        if (title.isTextual()) {
            object.setTitle(title.asText());
        }

        JsonNode geographicalExtent = node.path(Fields.GEOGRAPHICAL_EXTENT);
        if (geographicalExtent.isArray() && geographicalExtent.size() > 5) {
            List<Double> extent = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                extent.add(geographicalExtent.path(i).asDouble());
            }

            object.setGeographicalExtent(extent);
        }

        JsonNode referenceSystem = node.path("referenceSystem");
        if (referenceSystem.isTextual()) {
            object.setReferenceSystem(ReferenceSystem.parse(referenceSystem.asText()));
        }
    }

    @Override
    public void writeObject(Metadata object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        CityJSONVersion version = helper.getVersion();

        if (object.getIdentifier() != null) {
            String propertyName = version == CityJSONVersion.v1_0 ? "fileIdentifier" : "identifier";
            node.put(propertyName, object.getIdentifier());
        }

        if (object.getPointOfContact() != null) {
            String propertyName = version == CityJSONVersion.v1_0 ? "datasetPointOfContact" : "pointOfContact";
            node.set(propertyName, helper.getObjectUsingSerializer(object.getPointOfContact(), PointOfContactAdapter.class));
        }

        if (object.getReferenceDate() != null) {
            String propertyName = version == CityJSONVersion.v1_0 ? "datasetReferenceDate" : "referenceDate";
            node.put(propertyName, object.getReferenceDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }

        if (object.getTitle() != null) {
            String propertyName = version == CityJSONVersion.v1_0 ? "datasetTitle" : "title";
            node.put(propertyName, object.getTitle());
        }

        if (object.isSetGeographicalExtent()) {
            ArrayNode geographicalExtent = node.putArray(Fields.GEOGRAPHICAL_EXTENT);
            object.getGeographicalExtent().forEach(geographicalExtent::add);
        }

        if (object.getReferenceSystem() != null) {
            node.put("referenceSystem", object.getReferenceSystem().toURI(version));
        }
    }
}
