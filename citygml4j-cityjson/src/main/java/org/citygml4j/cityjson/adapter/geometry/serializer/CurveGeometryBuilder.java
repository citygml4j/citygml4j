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

package org.citygml4j.cityjson.adapter.geometry.serializer;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.xmlobjects.gml.model.basictypes.Sign;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.primitives.Curve;
import org.xmlobjects.gml.model.geometry.primitives.LineString;
import org.xmlobjects.gml.model.geometry.primitives.OrientableCurve;

import java.util.EnumSet;
import java.util.List;

public class CurveGeometryBuilder extends GeometryBuilder {
    private final VerticesBuilder verticesBuilder;
    private final ArrayNode boundaries;
    private final boolean shouldBuild;

    private boolean reverse;

    CurveGeometryBuilder(EnumSet<GeometryType> allowedTypes, VerticesBuilder verticesBuilder, CityJSONSerializerHelper helper) {
        super(helper);
        this.verticesBuilder = verticesBuilder;
        boundaries = helper.createArray();
        shouldBuild = allowedTypes.contains(GeometryType.MULTI_LINE_STRING);
    }

    @Override
    ObjectNode build(AbstractGeometry geometry, Number lod) {
        if (!boundaries.isEmpty()) {
            ObjectNode node = helper.createObject();
            node.put(Fields.TYPE, GeometryType.MULTI_LINE_STRING.toTypeName());
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
    public void visit(Curve curve) {
        addCurve(curve);
    }

    @Override
    public void visit(LineString lineString) {
        addCurve(lineString);
    }

    @Override
    public void visit(OrientableCurve orientableCurve) {
        if (orientableCurve.getOrientation() == Sign.MINUS) {
            reverse = !reverse;
            super.visit(orientableCurve);
            reverse = !reverse;
        } else {
            super.visit(orientableCurve);
        }
    }

    private void addCurve(CoordinateListProvider provider) {
        if (shouldBuild) {
            ArrayNode curve = boundaries.addArray();
            List<Integer> indexes = verticesBuilder.addVertices(provider.toCoordinateList3D(reverse));
            indexes.forEach(curve::add);
        }
    }
}
