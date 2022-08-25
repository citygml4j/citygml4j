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

package org.citygml4j.cityjson.adapter.geometry.serializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;
import org.xmlobjects.gml.model.geometry.primitives.Solid;

import java.util.*;

public class SolidGeometryBuilder extends GeometryBuilder {
    private final EnumSet<GeometryType> allowedTypes;
    private final SurfaceGeometryBuilder builder;
    private final List<Integer> shells = new ArrayList<>();
    private final List<Integer> solids = new ArrayList<>();
    private final boolean shouldBuild;

    private boolean isComposite;
    private int disconnectedSolids;

    SolidGeometryBuilder(EnumSet<GeometryType> allowedTypes, AppearanceSerializer appearanceSerializer, VerticesBuilder verticesBuilder, CityJSONSerializerHelper helper) {
        super(helper);
        this.allowedTypes = allowedTypes;
        builder = new SurfaceGeometryBuilder(allowedTypes, appearanceSerializer, verticesBuilder, helper);
        shouldBuild = GeometryType.SOLID_TYPES.stream().anyMatch(allowedTypes::contains);
    }

    @Override
    ObjectNode build(AbstractGeometry geometry, Number lod) {
        ObjectNode node = builder.build(geometry, lod);
        if (node != null) {
            GeometryType type;
            if (size() == 1 && allowedTypes.contains(GeometryType.SOLID)) {
                type = GeometryType.SOLID;
            } else if (disconnectedSolids == 1 && allowedTypes.contains(GeometryType.COMPOSITE_SOLID)) {
                type = GeometryType.COMPOSITE_SOLID;
            } else {
                type = GeometryType.MULTI_SOLID;
            }

            node.put(Fields.TYPE, type.toTypeName());

            sliceSolid(node, shells);
            if (solids.size() > 1) {
                sliceSolid(node, solids);
            }
        }

        return node;
    }

    @Override
    int size() {
        return solids.size();
    }

    @Override
    public void visit(Solid solid) {
        if (shouldBuild && (solids.size() == 0
                || (disconnectedSolids == 0 && allowedTypes.contains(GeometryType.COMPOSITE_SOLID))
                || allowedTypes.contains(GeometryType.MULTI_SOLID))) {
            if (solid.getExterior() != null && solid.getExterior().getObject() != null) {
                solid.getExterior().getObject().accept(builder);
                shells.add(builder.size());

                if (solid.isSetInterior()) {
                    for (ShellProperty property : solid.getInterior()) {
                        if (property.getObject() != null) {
                            property.getObject().accept(builder);
                            shells.add(builder.size());
                        }
                    }
                }

                solids.add(shells.size());
                if (!isComposite) {
                    disconnectedSolids++;
                }
            }
        }
    }

    @Override
    public void visit(CompositeSolid compositeSolid) {
        if (!isComposite) {
            isComposite = true;
            super.visit(compositeSolid);
            isComposite = false;
            disconnectedSolids++;
        } else {
            super.visit(compositeSolid);
        }
    }

    private void sliceSolid(ObjectNode node, List<Integer> limits) {
        ArrayNode boundaries = (ArrayNode) node.get(Fields.BOUNDARIES);
        if (boundaries != null) {
            node.set(Fields.BOUNDARIES, slice(boundaries, limits));
        }

        ObjectNode semantics = (ObjectNode) node.get(Fields.SEMANTICS);
        if (semantics != null) {
            semantics.set(Fields.VALUES, slice(helper.getOrPutArray(Fields.VALUES, semantics), limits));
        }

        sliceAppearance((ObjectNode) node.get(Fields.MATERIAL), limits);
        sliceAppearance((ObjectNode) node.get(Fields.TEXTURE), limits);
    }

    private void sliceAppearance(ObjectNode appearance, List<Integer> limits) {
        if (appearance != null) {
            Iterator<Map.Entry<String, JsonNode>> iterator = appearance.fields();
            while (iterator.hasNext()) {
                Map.Entry<String, JsonNode> entry = iterator.next();
                if (entry.getValue().isObject()) {
                    ObjectNode material = (ObjectNode) entry.getValue();
                    material.set(Fields.VALUES, slice(helper.getOrPutArray(Fields.VALUES, material), limits));
                }
            }
        }
    }

    private ArrayNode slice(ArrayNode array, List<Integer> limits) {
        ArrayNode result = helper.createArray();
        int index = 0;

        for (int limit : limits) {
            ArrayNode slice = result.addArray();
            for (; index < limit; index++) {
                slice.add(array.get(index));
            }
        }

        return result;
    }
}
