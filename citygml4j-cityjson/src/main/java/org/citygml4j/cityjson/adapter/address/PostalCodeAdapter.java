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
import org.xmlobjects.xal.model.PostCode;
import org.xmlobjects.xal.model.types.Identifier;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PostalCodeAdapter implements JsonObjectBuilder<PostCode>, JsonObjectSerializer<PostCode> {

    @Override
    public PostCode createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new PostCode();
    }

    @Override
    public void buildObject(PostCode object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (Map.Entry<String, JsonNode> property : node.properties()) {
            if (property.getValue().isValueNode()) {
                Identifier identifier = new Identifier(property.getValue().asText());
                object.getIdentifiers().add(identifier);
            }
        }
    }

    @Override
    public void writeObject(PostCode object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetIdentifiers()) {
            String name = helper.getAddressRegistry().getComponentName(AddressComponent.POSTAL_CODE, helper.getVersion());
            String value = object.getIdentifiers().stream()
                    .map(Identifier::getContent)
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(", "));
            if (!value.isEmpty()) {
                node.put(name, value);
            }
        }
    }
}
