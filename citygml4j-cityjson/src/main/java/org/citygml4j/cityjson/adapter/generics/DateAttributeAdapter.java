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
import org.citygml4j.core.model.generics.DateAttribute;

import java.time.LocalDate;

@CityJSONElements({
        @CityJSONElement(name = "DateAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "DateAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "DateAttribute", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class DateAttributeAdapter extends AbstractGenericAttributeAdapter<DateAttribute> {

    @Override
    public DateAttribute createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new DateAttribute();
    }

    @Override
    public void buildObject(DateAttribute object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        String[] items = node.asText().split("-");
        if (items.length == 3 && items[0].length() == 4 && items[1].length() == 2 && items[2].length() == 2) {
            try {
                object.setValue(LocalDate.of(Integer.parseInt(items[0]),
                        Integer.parseInt(items[1]),
                        Integer.parseInt(items[2])));
            } catch (Exception e) {
                //
            }
        }
    }

    @Override
    public void writeObject(DateAttribute object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.getName() != null && object.isSetValue()) {
            node.put(object.getName(), object.getValue().toString());
            registerType(object.getName(), GenericAttributeType.DATE_ATTRIBUTE, helper);
        }
    }
}
