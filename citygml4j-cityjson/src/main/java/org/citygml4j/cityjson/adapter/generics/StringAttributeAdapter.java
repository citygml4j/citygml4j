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
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.generics.GenericAttributeType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.generics.StringAttribute;

@CityJSONElements({
        @CityJSONElement(name = "StringAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "StringAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "StringAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class StringAttributeAdapter extends AbstractGenericAttributeAdapter<StringAttribute> {

    @Override
    public StringAttribute createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new StringAttribute();
    }

    @Override
    public void buildObject(StringAttribute object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        object.setValue(node.asText());
    }

    @Override
    public void writeObject(StringAttribute object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.getName() != null && object.isSetValue()) {
            node.put(object.getName(), object.getValue());
            registerType(object.getName(), GenericAttributeType.STRING_ATTRIBUTE, helper);
        }
    }
}
