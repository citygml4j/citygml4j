/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
