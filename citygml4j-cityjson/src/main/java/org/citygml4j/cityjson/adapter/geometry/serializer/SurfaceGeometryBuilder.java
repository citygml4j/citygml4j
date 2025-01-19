/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.xmlobjects.gml.model.basictypes.Sign;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.compact.AbstractSimplePolygon;
import org.xmlobjects.gml.model.geometry.primitives.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SurfaceGeometryBuilder extends GeometryBuilder {
    private final EnumSet<GeometryType> allowedTypes;
    private final VerticesBuilder verticesBuilder;
    private final SemanticsBuilder semanticsBuilder;
    private final MaterialBuilder materialBuilder;
    private final TextureBuilder textureBuilder;
    private final ArrayNode boundaries;
    private final boolean shouldBuild;

    private boolean reverse;
    private int index;

    SurfaceGeometryBuilder(EnumSet<GeometryType> allowedTypes, AppearanceSerializer appearanceSerializer, VerticesBuilder verticesBuilder, CityJSONSerializerHelper helper) {
        super(helper);
        this.allowedTypes = allowedTypes;
        this.verticesBuilder = verticesBuilder;
        semanticsBuilder = new SemanticsBuilder(helper);
        materialBuilder = new MaterialBuilder(appearanceSerializer, helper);
        textureBuilder = new TextureBuilder(appearanceSerializer, helper);
        boundaries = helper.createArray();
        shouldBuild = GeometryType.SURFACE_TYPES.stream().anyMatch(allowedTypes::contains);
    }

    @Override
    ObjectNode build(AbstractGeometry geometry, Number lod) {
        if (!boundaries.isEmpty()) {
            ObjectNode node = helper.createObject();
            node.put(Fields.TYPE, geometry instanceof AbstractSurface
                    && allowedTypes.contains(GeometryType.COMPOSITE_SURFACE) ?
                    GeometryType.COMPOSITE_SURFACE.toTypeName() :
                    GeometryType.MULTI_SURFACE.toTypeName());
            setLod(lod, node);
            node.set(Fields.BOUNDARIES, boundaries);

            ObjectNode semantics = semanticsBuilder.build(index);
            if (semantics != null) {
                node.set(Fields.SEMANTICS, semantics);
            }

            ObjectNode material = materialBuilder.build(index);
            if (material != null) {
                node.set(Fields.MATERIAL, material);
            }

            ObjectNode texture = textureBuilder.build(index);
            if (texture != null) {
                node.set(Fields.TEXTURE, texture);
            }

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
    public void visit(Polygon polygon) {
        List<List<Integer>> indexes = createVertices(polygon);
        if (indexes != null) {
            textureBuilder.addTextures(polygon, reverse, index);
            addSurface(polygon, indexes);
        }
    }

    @Override
    public void visit(AbstractSimplePolygon simplePolygon) {
        List<List<Integer>> indexes = createVertices(simplePolygon);
        if (indexes != null) {
            textureBuilder.addTextures(simplePolygon, reverse, index);
            addSurface(simplePolygon, indexes);
        }
    }

    @Override
    public void visit(PolygonPatch polygonPatch) {
        List<List<Integer>> indexes = createVertices(polygonPatch);
        if (indexes != null) {
            textureBuilder.addTextures(polygonPatch, reverse, index);
            addSurface(polygonPatch.getParent(AbstractGeometry.class), indexes);
        }
    }

    @Override
    public void visit(LinearRing linearRing) {
        List<Integer> indexes = createVertices(linearRing);
        if (indexes != null) {
            textureBuilder.addTextures(linearRing, reverse, index);
            addSurface(linearRing, List.of(indexes));
        }
    }

    @Override
    public void visit(OrientableSurface orientableSurface) {
        if (orientableSurface.getOrientation() == Sign.MINUS) {
            reverse = !reverse;
            super.visit(orientableSurface);
            reverse = !reverse;
        } else {
            super.visit(orientableSurface);
        }
    }

    @Override
    public void visit(MultiSurface multiSurface) {
        if (allowedTypes.contains(GeometryType.MULTI_SURFACE)) {
            super.visit(multiSurface);
        }
    }

    private void addSurface(AbstractGeometry geometry, List<List<Integer>> indexes) {
        ArrayNode surface = boundaries.addArray();
        for (List<Integer> element : indexes) {
            ArrayNode ring = surface.addArray();
            element.forEach(ring::add);
        }

        semanticsBuilder.addSemantics(geometry, index);
        materialBuilder.addMaterials(geometry, reverse, index);

        index++;
    }

    private List<Integer> createVertices(CoordinateListProvider provider) {
        if (shouldBuild) {
            List<Double> vertices = provider.toCoordinateList3D(reverse);

            int size = vertices.size();
            if (size > 5
                    && vertices.get(0).equals(vertices.get(size - 3))
                    && vertices.get(1).equals(vertices.get(size - 2))
                    && vertices.get(2).equals(vertices.get(size - 1))) {
                vertices = vertices.subList(0, vertices.size() - 3);
            }

            return verticesBuilder.addVertices(vertices);
        } else {
            return null;
        }
    }

    private List<List<Integer>> createVertices(Polygon polygon) {
        return createVertices(polygon.getExterior(), polygon.isSetInterior() ? polygon.getInterior() : null);
    }

    private List<List<Integer>> createVertices(PolygonPatch polygonPatch) {
        return createVertices(polygonPatch.getExterior(), polygonPatch.isSetInterior() ? polygonPatch.getInterior() : null);
    }

    private List<List<Integer>> createVertices(AbstractSimplePolygon simplePolygon) {
        List<Integer> indexes = createVertices(simplePolygon.getControlPoints());
        return indexes != null ? List.of(indexes) : null;
    }

    private List<List<Integer>> createVertices(AbstractRingProperty exterior, List<AbstractRingProperty> interior) {
        List<List<Integer>> indexes = null;
        if (exterior != null && exterior.getObject() != null) {
            List<Integer> element = createVertices(exterior.getObject());
            if (element != null) {
                indexes = new ArrayList<>();
                indexes.add(element);

                if (interior != null) {
                    for (AbstractRingProperty property : interior) {
                        if (property.getObject() != null) {
                            element = createVertices(property.getObject());
                            if (element != null) {
                                indexes.add(element);
                            }
                        }
                    }
                }
            }
        }

        return indexes;
    }
}
