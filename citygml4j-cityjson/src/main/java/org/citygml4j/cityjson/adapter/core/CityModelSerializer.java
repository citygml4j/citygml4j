/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.core;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.ade.ADEProperty;
import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.citygml4j.core.model.core.CityModel;

@CityJSONElements({
        @CityJSONElement(name = "CityModel", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "CityModel", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "CityModel", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class CityModelSerializer implements JsonObjectSerializer<CityModel> {

    @Override
    public void writeObject(CityModel object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetCityObjectMembers()) {
            for (AbstractCityObjectProperty property : object.getCityObjectMembers()) {
                helper.writeCityObject(property.getObject());
            }
        }

        if (object.hasADEProperties()) {
            for (ADEProperty property : object.getADEProperties()) {
                helper.addADEProperty(property, node);
            }
        }
    }
}
