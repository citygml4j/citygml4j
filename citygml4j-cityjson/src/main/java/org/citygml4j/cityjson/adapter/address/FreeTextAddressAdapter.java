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
import org.xmlobjects.xal.model.FreeTextAddress;
import org.xmlobjects.xal.model.types.AddressLine;

import java.util.Objects;
import java.util.stream.Collectors;

public class FreeTextAddressAdapter implements JsonObjectBuilder<FreeTextAddress>, JsonObjectSerializer<FreeTextAddress> {

    @Override
    public FreeTextAddress createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new FreeTextAddress();
    }

    @Override
    public void buildObject(FreeTextAddress object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (JsonNode value : node) {
            if (value.isValueNode()) {
                object.getAddressLines().add(new AddressLine(value.asText()));
            } else if (value.isArray()) {
                for (JsonNode element : value) {
                    object.getAddressLines().add(new AddressLine(element.asText()));
                }
            }
        }
    }

    @Override
    public void writeObject(FreeTextAddress object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetAddressLines()) {
            String name = helper.getAddressRegistry().getComponentName(AddressComponent.FREE_TEXT_ADDRESS, helper.getVersion());
            String value = object.getAddressLines().stream()
                    .map(AddressLine::getContent)
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(", "));
            if (!value.isEmpty()) {
                node.put(name, value);
            }
        }
    }
}
