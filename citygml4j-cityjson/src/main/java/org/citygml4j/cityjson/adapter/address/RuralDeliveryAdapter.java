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
import org.xmlobjects.xal.model.RuralDelivery;
import org.xmlobjects.xal.model.types.Identifier;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RuralDeliveryAdapter implements JsonObjectBuilder<RuralDelivery>, JsonObjectSerializer<RuralDelivery> {

    @Override
    public RuralDelivery createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new RuralDelivery();
    }

    @Override
    public void buildObject(RuralDelivery object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (Map.Entry<String, JsonNode> property : node.properties()) {
            if (property.getValue().isValueNode()) {
                Identifier identifier = new Identifier(property.getValue().asText());
                object.getIdentifiers().add(identifier);
            }
        }
    }

    @Override
    public void writeObject(RuralDelivery object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetIdentifiers()) {
            String name = helper.getAddressRegistry().getComponentName(AddressComponent.RURAL_DELIVERY, helper.getVersion());
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
