/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.bridge;

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
import org.citygml4j.core.model.bridge.Bridge;
import org.citygml4j.core.model.bridge.BridgePart;
import org.citygml4j.core.model.bridge.BridgePartProperty;

import java.util.Iterator;

@CityJSONElements({
        @CityJSONElement(name = "Bridge", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "Bridge", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "Bridge", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class BridgeAdapter extends AbstractBridgeAdapter<Bridge> {

    @Override
    public Bridge createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Bridge();
    }

    @Override
    public void buildObject(Bridge object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            if ("BridgePart".equals(helper.getCityObjectType(child))) {
                object.getBridgeParts().add(new BridgePartProperty(helper.getCityObject(child, BridgePart.class)));
                children.remove();
            }
        }
    }

    @Override
    public String createType(Bridge object, CityJSONVersion version) throws CityJSONSerializeException {
        return "Bridge";
    }

    @Override
    public void writeObject(Bridge object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);

        if (object.isSetBridgeParts()) {
            for (BridgePartProperty property : object.getBridgeParts()) {
                helper.writeChildObject(property, object, node);
            }
        }
    }
}
