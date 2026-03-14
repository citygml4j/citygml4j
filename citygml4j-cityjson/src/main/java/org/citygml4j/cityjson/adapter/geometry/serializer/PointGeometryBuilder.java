/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.compact.SimpleMultiPoint;
import org.xmlobjects.gml.model.geometry.primitives.Point;

import java.util.EnumSet;

public class PointGeometryBuilder extends GeometryBuilder {
    private final VerticesBuilder verticesBuilder;
    private final ArrayNode boundaries;
    private final boolean shouldBuild;

    PointGeometryBuilder(EnumSet<GeometryType> allowedTypes, VerticesBuilder verticesBuilder, CityJSONSerializerHelper helper) {
        super(helper);
        this.verticesBuilder = verticesBuilder;
        boundaries = helper.createArray();
        shouldBuild = allowedTypes.contains(GeometryType.MULTI_POINT);
    }

    @Override
    ObjectNode build(AbstractGeometry geometry, Number lod) {
        if (!boundaries.isEmpty()) {
            ObjectNode node = helper.createObject();
            node.put(Fields.TYPE, GeometryType.MULTI_POINT.toTypeName());
            setLod(lod, node);
            node.set(Fields.BOUNDARIES, boundaries);
            return node;
        } else {
            return null;
        }
    }

    @Override
    int size() {
        return boundaries.size();
    }

    @Override
    public void visit(Point point) {
        addPoint(point);
    }

    @Override
    public void visit(SimpleMultiPoint simpleMultiPoint) {
        if (simpleMultiPoint.getPosList() != null) {
            addPoint(simpleMultiPoint.getPosList());
        }
    }

    private void addPoint(CoordinateListProvider provider) {
        if (shouldBuild) {
            verticesBuilder.addVertices(provider.toCoordinateList3D()).forEach(boundaries::add);
        }
    }
}
