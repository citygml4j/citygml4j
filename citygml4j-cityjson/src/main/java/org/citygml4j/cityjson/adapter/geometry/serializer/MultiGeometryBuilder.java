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

package org.citygml4j.cityjson.adapter.geometry.serializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.compact.AbstractSimplePolygon;
import org.xmlobjects.gml.model.geometry.compact.SimpleMultiPoint;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.model.geometry.primitives.*;

import java.util.EnumSet;

public class MultiGeometryBuilder extends GeometryBuilder {
    private final EnumSet<GeometryType> allowedTypes;
    private final AppearanceSerializer appearanceSerializer;
    private final VerticesBuilder verticesBuilder;

    private GeometryBuilder pointGeometryBuilder;
    private GeometryBuilder curveGeometryBuilder;
    private GeometryBuilder surfaceGeometryBuilder;
    private GeometryBuilder solidGeometryBuilder;

    MultiGeometryBuilder(EnumSet<GeometryType> allowedTypes, AppearanceSerializer appearanceSerializer, VerticesBuilder verticesBuilder, CityJSONSerializerHelper helper) {
        super(helper);
        this.allowedTypes = allowedTypes;
        this.appearanceSerializer = appearanceSerializer;
        this.verticesBuilder = verticesBuilder;
    }

    @Override
    ArrayNode build(AbstractGeometry geometry, Number lod) {
        ArrayNode node = helper.createArray();
        build(geometry, lod, node);
        return node;
    }

    void build(AbstractGeometry geometry, Number lod, ArrayNode node) {
        build(geometry, lod, pointGeometryBuilder, node);
        build(geometry, lod, curveGeometryBuilder, node);
        build(geometry, lod, surfaceGeometryBuilder, node);
        build(geometry, lod, solidGeometryBuilder, node);
    }

    private void build(AbstractGeometry geometry, Number lod, GeometryBuilder builder, ArrayNode node) {
        if (builder != null) {
            JsonNode geometryNode = builder.build(geometry, lod);
            if (geometryNode != null) {
                node.add(geometryNode);
            }
        }
    }

    @Override
    int size() {
        return (pointGeometryBuilder != null ? pointGeometryBuilder.size() : 0) +
                (curveGeometryBuilder != null ? curveGeometryBuilder.size() : 0) +
                (surfaceGeometryBuilder != null ? surfaceGeometryBuilder.size() : 0) +
                (solidGeometryBuilder != null ? solidGeometryBuilder.size() : 0);
    }

    @Override
    public void visit(Point point) {
        point.accept(getOrCreatePointGeometryBuilder());
    }

    @Override
    public void visit(SimpleMultiPoint simpleMultiPoint) {
        simpleMultiPoint.accept(getOrCreatePointGeometryBuilder());
    }

    @Override
    public void visit(Curve curve) {
        curve.accept(getOrCreateCurveGeometryBuilder());
    }

    @Override
    public void visit(LineString lineString) {
        lineString.accept(getOrCreateCurveGeometryBuilder());
    }

    @Override
    public void visit(OrientableCurve orientableCurve) {
        orientableCurve.accept(getOrCreateCurveGeometryBuilder());
    }

    @Override
    public void visit(Polygon polygon) {
        polygon.accept(getOrCreateSurfaceGeometryBuilder());
    }

    @Override
    public void visit(AbstractSimplePolygon simplePolygon) {
        simplePolygon.accept(getOrCreateSurfaceGeometryBuilder());
    }

    @Override
    public void visit(Surface surface) {
        surface.accept(getOrCreateSurfaceGeometryBuilder());
    }

    @Override
    public void visit(OrientableSurface orientableSurface) {
        orientableSurface.accept(getOrCreateSurfaceGeometryBuilder());
    }

    @Override
    public void visit(MultiSurface multiSurface) {
        multiSurface.accept(getOrCreateSurfaceGeometryBuilder());
    }

    @Override
    public void visit(Solid solid) {
        solid.accept(getOrCreateSolidGeometryBuilder());
    }

    @Override
    public void visit(CompositeSolid compositeSolid) {
        compositeSolid.accept(getOrCreateSolidGeometryBuilder());
    }

    private GeometryBuilder getOrCreatePointGeometryBuilder() {
        if (pointGeometryBuilder == null) {
            pointGeometryBuilder = new PointGeometryBuilder(allowedTypes, verticesBuilder, helper);
        }

        return pointGeometryBuilder;
    }

    private GeometryBuilder getOrCreateCurveGeometryBuilder() {
        if (curveGeometryBuilder == null) {
            curveGeometryBuilder = new CurveGeometryBuilder(allowedTypes, verticesBuilder, helper);
        }

        return curveGeometryBuilder;
    }

    private GeometryBuilder getOrCreateSurfaceGeometryBuilder() {
        if (surfaceGeometryBuilder == null) {
            surfaceGeometryBuilder = new SurfaceGeometryBuilder(allowedTypes, appearanceSerializer, verticesBuilder, helper);
        }

        return surfaceGeometryBuilder;
    }

    private GeometryBuilder getOrCreateSolidGeometryBuilder() {
        if (solidGeometryBuilder == null) {
            solidGeometryBuilder = new SolidGeometryBuilder(allowedTypes, appearanceSerializer, verticesBuilder, helper);
        }

        return solidGeometryBuilder;
    }
}
