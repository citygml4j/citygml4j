/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.address;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.model.address.AddressComponent;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.xmlobjects.xal.model.Locality;
import org.xmlobjects.xal.model.types.LocalityName;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LocalityAdapter implements JsonObjectBuilder<Locality>, JsonObjectSerializer<Locality> {

    @Override
    public Locality createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Locality();
    }

    @Override
    public void buildObject(Locality object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (Map.Entry<String, JsonNode> property : node.properties()) {
            if (property.getValue().isValueNode()) {
                LocalityName name = new LocalityName(property.getValue().asText());
                object.getNameElements().add(name);
            }
        }
    }

    @Override
    public void writeObject(Locality object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetNameElements()) {
            String name = helper.getAddressRegistry().getComponentName(AddressComponent.LOCALITY, helper.getVersion());
            String value = object.getNameElements().stream()
                    .map(LocalityName::getContent)
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(", "));
            if (!value.isEmpty()) {
                node.put(name, value);
            }
        }
    }
}
