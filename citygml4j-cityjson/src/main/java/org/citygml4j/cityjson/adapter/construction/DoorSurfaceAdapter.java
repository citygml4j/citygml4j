/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.construction;

import com.fasterxml.jackson.databind.JsonNode;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.core.model.construction.DoorSurface;

@CityJSONElements({
        @CityJSONElement(name = "Door", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "Door", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "Door", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class DoorSurfaceAdapter extends AbstractFillingSurfaceAdapter<DoorSurface> {

    @Override
    public DoorSurface createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new DoorSurface();
    }

    @Override
    public String createType(DoorSurface object, CityJSONVersion version) throws CityJSONSerializeException {
        return "Door";
    }
}
