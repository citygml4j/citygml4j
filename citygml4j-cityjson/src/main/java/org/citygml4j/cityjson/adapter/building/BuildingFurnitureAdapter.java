/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.building;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.construction.AbstractFurnitureAdapter;
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
import org.citygml4j.core.model.building.BuildingFurniture;

@CityJSONElements({
        @CityJSONElement(name = "BuildingFurniture", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "BuildingFurniture", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1)
})
public class BuildingFurnitureAdapter extends AbstractFurnitureAdapter<BuildingFurniture> {

    @Override
    public BuildingFurniture createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new BuildingFurniture();
    }

    @Override
    public void buildObject(BuildingFurniture object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);
    }

    @Override
    public String createType(BuildingFurniture object, CityJSONVersion version) throws CityJSONSerializeException {
        return "BuildingFurniture";
    }

    @Override
    public void writeObject(BuildingFurniture object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);
    }
}
