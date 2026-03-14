/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.core;

import com.fasterxml.jackson.databind.JsonNode;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.core.model.core.AbstractSpace;
import org.citygml4j.core.model.core.ClosureSurface;
import org.citygml4j.core.model.waterbody.WaterBody;

@CityJSONElements({
        @CityJSONElement(name = "ClosureSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "ClosureSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "ClosureSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0),
        @CityJSONElement(name = "WaterClosureSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "WaterClosureSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "WaterClosureSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class ClosureSurfaceAdapter extends AbstractThematicSurfaceAdapter<ClosureSurface> {

    @Override
    public ClosureSurface createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new ClosureSurface();
    }

    @Override
    public String createType(ClosureSurface object, CityJSONVersion version) throws CityJSONSerializeException {
        AbstractSpace space = object.getParent(AbstractSpace.class);
        return space instanceof WaterBody ?
                "WaterClosureSurface" :
                "ClosureSurface";
    }
}
