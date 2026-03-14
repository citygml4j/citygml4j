/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.tunnel;

import com.fasterxml.jackson.databind.JsonNode;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.core.model.tunnel.TunnelPart;

@CityJSONElements({
        @CityJSONElement(name = "TunnelPart", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "TunnelPart", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "TunnelPart", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class TunnelPartAdapter extends AbstractTunnelAdapter<TunnelPart> {

    @Override
    public TunnelPart createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new TunnelPart();
    }

    @Override
    public String createType(TunnelPart object, CityJSONVersion version) throws CityJSONSerializeException {
        return "TunnelPart";
    }
}
