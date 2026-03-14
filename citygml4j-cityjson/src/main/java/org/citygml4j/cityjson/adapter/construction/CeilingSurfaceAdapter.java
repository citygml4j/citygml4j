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
import org.citygml4j.core.model.construction.CeilingSurface;

@CityJSONElements({
        @CityJSONElement(name = "CeilingSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v2_0),
        @CityJSONElement(name = "CeilingSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1)
})
public class CeilingSurfaceAdapter extends AbstractConstructionSurfaceAdapter<CeilingSurface> {

    @Override
    public CeilingSurface createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new CeilingSurface();
    }

    @Override
    public String createType(CeilingSurface object, CityJSONVersion version) throws CityJSONSerializeException {
        return "CeilingSurface";
    }
}
