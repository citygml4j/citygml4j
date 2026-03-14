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
import org.citygml4j.core.model.building.BuildingUnit;
import org.citygml4j.core.model.building.BuildingUnitProperty;
import org.citygml4j.core.model.building.Storey;

import java.util.Iterator;

@CityJSONElements({
        @CityJSONElement(name = "BuildingStorey", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "BuildingStorey", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1)
})
public class StoreyAdapter extends AbstractBuildingSubdivisionAdapter<Storey> {

    @Override
    public Storey createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Storey();
    }

    @Override
    public void buildObject(Storey object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            if ("BuildingUnit".equals(helper.getCityObjectType(child))) {
                object.getBuildingUnits().add(new BuildingUnitProperty(helper.getCityObject(child, BuildingUnit.class)));
                children.remove();
            }
        }
    }

    @Override
    public String createType(Storey object, CityJSONVersion version) throws CityJSONSerializeException {
        return "BuildingStorey";
    }

    @Override
    public void writeObject(Storey object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);

        if (object.isSetBuildingUnits()) {
            for (BuildingUnitProperty property : object.getBuildingUnits()) {
                if (property.isSetInlineObject()) {
                    helper.writeChildObject(property.getObject(), object, node);
                }
            }
        }
    }
}
