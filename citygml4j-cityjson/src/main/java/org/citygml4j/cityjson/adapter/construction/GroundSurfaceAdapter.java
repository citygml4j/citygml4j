/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.cityjson.adapter.construction;

import com.fasterxml.jackson.databind.JsonNode;
import org.citygml4j.cityjson.annotation.CityJSONElement;
import org.citygml4j.cityjson.annotation.CityJSONElements;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.core.model.construction.GroundSurface;

@CityJSONElements({
        @CityJSONElement(name = "GroundSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_1),
        @CityJSONElement(name = "GroundSurface", schema = CityJSONConstants.CORE_SCHEMA, version = CityJSONVersion.v1_0)
})
public class GroundSurfaceAdapter extends AbstractConstructionSurfaceAdapter<GroundSurface> {

    @Override
    public GroundSurface createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new GroundSurface();
    }

    @Override
    public String createType(GroundSurface object, CityJSONVersion version) throws CityJSONSerializeException {
        return "GroundSurface";
    }
}