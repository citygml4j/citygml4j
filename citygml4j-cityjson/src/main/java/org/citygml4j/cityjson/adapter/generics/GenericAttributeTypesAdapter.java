/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.generics;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.generics.GenericAttributeType;
import org.citygml4j.cityjson.model.generics.GenericAttributeTypes;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;

import java.util.Map;

@CityJSONElements({
        @CityJSONElement(name = "+GenericAttributeTypes", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "+GenericAttributeTypes", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "+GenericAttributeTypes", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class GenericAttributeTypesAdapter implements JsonObjectBuilder<GenericAttributeTypes>, JsonObjectSerializer<GenericAttributeTypes> {

    @Override
    public GenericAttributeTypes createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new GenericAttributeTypes();
    }

    @Override
    public void buildObject(GenericAttributeTypes object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (Map.Entry<String, JsonNode> entry : node.properties()) {
            GenericAttributeType type = GenericAttributeType.fromValue(entry.getValue().asText());
            if (type != null) {
                object.addType(entry.getKey(), type);
            }
        }
    }

    @Override
    public void writeObject(GenericAttributeTypes object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        ObjectNode types = node.putObject(GenericAttributeTypes.PROPERTY_NAME);
        for (Map.Entry<String, GenericAttributeType> entry : object.getTypes().entrySet()) {
            types.put(entry.getKey(), entry.getValue().toTypeName());
        }
    }
}
