/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.tunnel;

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
import org.citygml4j.core.model.tunnel.Tunnel;
import org.citygml4j.core.model.tunnel.TunnelPart;
import org.citygml4j.core.model.tunnel.TunnelPartProperty;

import java.util.Iterator;

@CityJSONElements({
        @CityJSONElement(name = "Tunnel", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "Tunnel", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "Tunnel", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class TunnelAdapter extends AbstractTunnelAdapter<Tunnel> {

    @Override
    public Tunnel createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Tunnel();
    }

    @Override
    public void buildObject(Tunnel object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        Iterator<JsonNode> children = node.path(Fields.CHILDREN).elements();
        while (children.hasNext()) {
            String child = children.next().asText();
            if ("TunnelPart".equals(helper.getCityObjectType(child))) {
                object.getTunnelParts().add(new TunnelPartProperty(helper.getCityObject(child, TunnelPart.class)));
                children.remove();
            }
        }
    }

    @Override
    public String createType(Tunnel object, CityJSONVersion version) throws CityJSONSerializeException {
        return "Tunnel";
    }

    @Override
    public void writeObject(Tunnel object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);

        if (object.isSetTunnelParts()) {
            for (TunnelPartProperty property : object.getTunnelParts()) {
                helper.writeChildObject(property, object, node);
            }
        }
    }
}
