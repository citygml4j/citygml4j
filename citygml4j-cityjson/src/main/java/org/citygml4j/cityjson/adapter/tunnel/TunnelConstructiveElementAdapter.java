/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.tunnel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.construction.AbstractConstructiveElementAdapter;
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
import org.citygml4j.core.model.tunnel.TunnelConstructiveElement;

@CityJSONElements({
        @CityJSONElement(name = "TunnelConstructiveElement", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "TunnelConstructiveElement", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1)
})
public class TunnelConstructiveElementAdapter extends AbstractConstructiveElementAdapter<TunnelConstructiveElement> {

    @Override
    public TunnelConstructiveElement createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new TunnelConstructiveElement();
    }

    @Override
    public void buildObject(TunnelConstructiveElement object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);
    }

    @Override
    public String createType(TunnelConstructiveElement object, CityJSONVersion version) throws CityJSONSerializeException {
        return "TunnelConstructiveElement";
    }

    @Override
    public void writeObject(TunnelConstructiveElement object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);
    }
}
