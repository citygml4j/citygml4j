/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.tunnel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.construction.AbstractInstallationAdapter;
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
import org.citygml4j.core.model.tunnel.TunnelInstallation;

@CityJSONElements({
        @CityJSONElement(name = "TunnelInstallation", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "TunnelInstallation", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "TunnelInstallation", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class TunnelInstallationAdapter extends AbstractInstallationAdapter<TunnelInstallation> {

    @Override
    public TunnelInstallation createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new TunnelInstallation();
    }

    @Override
    public void buildObject(TunnelInstallation object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        super.buildObject(object, attributes, node, parent, helper);

        helper.buildStandardObjectClassifier(object, attributes);
    }

    @Override
    public String createType(TunnelInstallation object, CityJSONVersion version) throws CityJSONSerializeException {
        return "TunnelInstallation";
    }

    @Override
    public void writeObject(TunnelInstallation object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);
        ObjectNode attributes = helper.getOrPutObject(Fields.ATTRIBUTES, node);

        helper.writeStandardObjectClassifier(object, attributes);
    }
}
