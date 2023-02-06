/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.util.BoundaryFilter;
import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;

import java.util.List;

public class PointGeometryBuilder extends GeometryObjectBuilder {
    private final VerticesBuilder verticesBuilder;

    PointGeometryBuilder(AbstractFeature object, BoundaryFilter filter, VerticesBuilder verticesBuilder) {
        super(object, filter);
        this.verticesBuilder = verticesBuilder;
    }

    @Override
    void build(JsonNode node, GeometryType type, int lod, GeometryObject geometryObject) {
        JsonNode boundaries = node.path(Fields.BOUNDARIES);
        if (boundaries.isArray()) {
            geometryObject.setGeometry(createMultiPoint((ArrayNode) boundaries));
        }
    }

    private MultiPoint createMultiPoint(ArrayNode points) {
        List<Double> vertices = verticesBuilder.getVertices(points, false);
        if (!vertices.isEmpty()) {
            MultiPoint multiPoint = new MultiPoint();
            for (int i = 0; i < vertices.size(); i += 3) {
                DirectPosition pos = new DirectPosition(
                        vertices.get(i),
                        vertices.get(i + 1),
                        vertices.get(i + 2));
                pos.setSrsDimension(3);
                multiPoint.getPointMember().add(new PointProperty(new Point(pos)));
            }

            return multiPoint;
        } else {
            return null;
        }
    }
}
