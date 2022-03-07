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

package org.citygml4j.cityjson.adapter.geometry.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.util.BoundaryFilter;
import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;
import org.xmlobjects.gml.model.geometry.primitives.LineString;

import java.util.List;

public class CurveGeometryBuilder extends GeometryObjectBuilder {
    private final VerticesBuilder verticesBuilder;

    CurveGeometryBuilder(AbstractFeature object, BoundaryFilter filter, VerticesBuilder verticesBuilder) {
        super(object, filter);
        this.verticesBuilder = verticesBuilder;
    }

    @Override
    void build(JsonNode node, GeometryType type, int lod, GeometryObject geometryObject) {
        JsonNode boundaries = node.path(Fields.BOUNDARIES);
        if (boundaries.isArray()) {
            geometryObject.setGeometry(createMultiCurve((ArrayNode) boundaries));
        }
    }

    private LineString createLineString(ArrayNode points) {
        List<Double> vertices = verticesBuilder.getVertices(points, false);
        if (!vertices.isEmpty()) {
            DirectPositionList posList = new DirectPositionList(vertices);
            posList.setSrsDimension(3);
            return new LineString(posList);
        } else {
            return null;
        }
    }

    private MultiCurve createMultiCurve(ArrayNode curves) {
        if (!curves.isEmpty()) {
            MultiCurve multiCurve = new MultiCurve();
            for (JsonNode points : curves) {
                LineString lineString = points.isArray() ? createLineString((ArrayNode) points) : null;
                if (lineString != null) {
                    multiCurve.getCurveMember().add(new CurveProperty(lineString));
                } else {
                    return null;
                }
            }

            return multiCurve;
        } else {
            return null;
        }
    }
}
