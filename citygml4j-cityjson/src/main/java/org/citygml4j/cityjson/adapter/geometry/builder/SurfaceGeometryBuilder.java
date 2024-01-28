/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.AbstractRingProperty;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SurfaceGeometryBuilder extends GeometryObjectBuilder implements SurfaceProvider {
    private final VerticesBuilder verticesBuilder;
    private List<SurfaceProperty> surfaces;

    SurfaceGeometryBuilder(AbstractFeature object, BoundaryFilter filter, VerticesBuilder verticesBuilder) {
        super(object, filter);
        this.verticesBuilder = verticesBuilder;
    }

    @Override
    void build(JsonNode node, GeometryType type, int lod, GeometryObject geometryObject) {
        JsonNode boundaries = node.path(Fields.BOUNDARIES);
        if (boundaries.isArray()) {
            surfaces = buildSurfaces((ArrayNode) boundaries);
            if (surfaces != null) {
                if (type == GeometryType.COMPOSITE_SURFACE) {
                    geometryObject.setGeometry(new CompositeSurface(surfaces));
                } else {
                    geometryObject.setGeometry(new MultiSurface(surfaces));
                }
            }
        }
    }

    @Override
    public List<SurfaceProperty> getSurfaces() {
        return surfaces != null ? surfaces : Collections.emptyList();
    }

    List<SurfaceProperty> buildSurfaces(ArrayNode surfaces) {
        if (!surfaces.isEmpty()) {
            List<SurfaceProperty> geometries = new ArrayList<>(surfaces.size());
            for (JsonNode surface : surfaces) {
                Polygon polygon = surface.isArray() ? createPolygon((ArrayNode) surface) : null;
                if (polygon != null) {
                    geometries.add(new SurfaceProperty(polygon));
                } else {
                    return null;
                }
            }

            return geometries;
        } else {
            return null;
        }
    }

    private Polygon createPolygon(ArrayNode rings) {
        JsonNode ring = rings.path(0);
        if (ring.isArray()) {
            LinearRing boundary = createLinearRing((ArrayNode) ring);
            if (boundary != null) {
                Polygon polygon = new Polygon(boundary);

                for (int i = 1; i < rings.size(); i++) {
                    ring = rings.get(i);
                    boundary = ring.isArray() ? createLinearRing((ArrayNode) ring) : null;
                    if (boundary != null) {
                        polygon.getInterior().add(new AbstractRingProperty(boundary));
                    } else {
                        return null;
                    }
                }

                return polygon;
            }
        }

        return null;
    }

    private LinearRing createLinearRing(ArrayNode ring) {
        List<Double> vertices = verticesBuilder.getVertices(ring, true);
        if (!vertices.isEmpty()) {
            DirectPositionList posList = new DirectPositionList(vertices);
            posList.setSrsDimension(3);
            return new LinearRing(posList);
        } else {
            return null;
        }
    }
}
