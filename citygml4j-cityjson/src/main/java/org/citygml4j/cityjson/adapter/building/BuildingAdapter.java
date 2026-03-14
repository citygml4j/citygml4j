/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.building;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.building.BuildingPart;
import org.citygml4j.core.model.building.BuildingPartProperty;

import java.util.Iterator;

@CityJSONElements({
        @CityJSONElement(name = "Building", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "Building", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "Building", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class BuildingAdapter extends AbstractBuildingAdapter<Building> {

    @Override
    public Building createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Building();
    }

    @Override
    public void buildObject(Building object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            if ("BuildingPart".equals(helper.getCityObjectType(child))) {
                object.getBuildingParts().add(new BuildingPartProperty(helper.getCityObject(child, BuildingPart.class)));
                children.remove();
            }
        }
    }

    @Override
    public String createType(Building object, CityJSONVersion version) throws CityJSONSerializeException {
        return "Building";
    }

    @Override
    public void writeObject(Building object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);

        if (object.isSetBuildingParts()) {
            for (BuildingPartProperty property : object.getBuildingParts()) {
                helper.writeChildObject(property, object, node);
            }
        }
    }
}
