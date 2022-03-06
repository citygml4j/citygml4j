/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
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

package org.citygml4j.cityjson.adapter.geometry.builder;

import com.fasterxml.jackson.databind.JsonNode;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.util.BoundaryFilter;
import org.citygml4j.core.model.core.AbstractFeature;

public abstract class GeometryObjectBuilder {
    final AbstractFeature object;
    final BoundaryFilter filter;

    GeometryObjectBuilder(AbstractFeature object, BoundaryFilter filter) {
        this.object = object;
        this.filter = filter;
    }

    abstract void build(JsonNode node, GeometryType type, int lod, GeometryObject geometryObject);
}
