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
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.generics.GenericThematicSurfaceAdapter;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.util.BoundaryFilter;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.construction.*;
import org.citygml4j.core.model.core.AbstractGenericAttributeProperty;
import org.citygml4j.core.model.core.AbstractSpace;
import org.citygml4j.core.model.core.AbstractThematicSurface;
import org.citygml4j.core.model.generics.GenericThematicSurface;
import org.citygml4j.core.model.generics.StringAttribute;
import org.citygml4j.core.model.transportation.HoleSurface;
import org.citygml4j.core.model.transportation.Marking;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SemanticsBuilder {
    private final CityJSONBuilderHelper helper;
    private final CityGMLVersion version;

    SemanticsBuilder(CityJSONBuilderHelper helper) {
        this.helper = helper;
        version = helper.getTargetCityGMLVersion();
    }

    void build(AbstractSpace object, JsonNode node, BoundaryFilter filter, List<SurfaceProperty> geometries, int lod, GeometryObject geometryObject) {
        JsonNode values = node.path(Fields.VALUES);
        JsonNode surfaces = node.path(Fields.SURFACES);
        if (!values.isArray() || !surfaces.isArray()) {
            return;
        }

        if (filter == null) {
            filter = object::isValidBoundary;
        }

        Map<Integer, AbstractThematicSurface> boundaries = new HashMap<>();
        createBoundaries((ArrayNode) surfaces, filter, boundaries);
        assignGeometries(boundaries, (ArrayNode) values, geometries, lod);

        boundaries.values().removeIf(boundary -> boundary.getParent() != null);
        if (!boundaries.isEmpty()) {
            geometryObject.setBoundaries(new ArrayList<>(boundaries.values()));
        }
    }

    private void createBoundaries(ArrayNode surfaces, BoundaryFilter filter, Map<Integer, AbstractThematicSurface> boundaries) {
        for (int i = 0; i < surfaces.size(); i++) {
            JsonNode surface = surfaces.get(i);
            AbstractThematicSurface boundary = getOrCreateBoundary(boundaries, i, surface, filter);

            if (filter.isValidBoundary(boundary)) {
                for (JsonNode element : surface.path(Fields.CHILDREN)) {
                    int index = element.asInt(-1);
                    AbstractThematicSurface child = getOrCreateBoundary(boundaries, index, surfaces.path(index), filter);
                    if (boundary instanceof AbstractConstructionSurface && child instanceof AbstractFillingSurface) {
                        ((AbstractConstructionSurface) boundary)
                                .getFillingSurfaces()
                                .add(new AbstractFillingSurfaceProperty((AbstractFillingSurface) child));
                    }
                }
            }
        }

        boundaries.values().removeIf(boundary -> !filter.isValidBoundary(boundary) && boundary.getParent() == null);
    }

    private AbstractThematicSurface getOrCreateBoundary(Map<Integer, AbstractThematicSurface> boundaries, int value, JsonNode surface, BoundaryFilter filter) {
        AbstractThematicSurface boundary = boundaries.get(value);
        if (boundary == null) {
            try {
                String type = surface.path(Fields.TYPE).asText();
                boundary = helper.getObject(type, surface, AbstractThematicSurface.class);

                if (helper.isMapUnsupportedTypesToGenerics()
                        && helper.getTargetCityGMLVersion() == CityGMLVersion.v3_0
                        && (boundary == null || !filter.isValidBoundary(boundary))) {
                    boundary = helper.getObjectUsingBuilder(surface, GenericThematicSurfaceAdapter.class);
                    if (type.startsWith("+")) {
                        type = type.substring(1);
                    }

                    StringAttribute stringAttribute = new StringAttribute(CityJSONConstants.GENERIC_TYPE_ATTRIBUTE, type);
                    boundary.getGenericAttributes().add(new AbstractGenericAttributeProperty(stringAttribute));
                }

                boundaries.put(value, boundary);
            } catch (Exception e) {
                //
            }
        }

        return boundary;
    }

    private void assignGeometries(Map<Integer, AbstractThematicSurface> boundaries, ArrayNode values, List<SurfaceProperty> geometries, int lod) {
        List<Integer> flatValues = flatValues(values);
        for (int index = 0; index < flatValues.size() && index < geometries.size(); index++) {
            int value = flatValues.get(index);

            AbstractThematicSurface boundary = boundaries.get(value);
            if (boundary != null && isAvailableForLod(boundary, lod)) {
                MultiSurface multiSurface = getOrCreateMultiSurface(boundary, lod);
                if (multiSurface != null) {
                    SurfaceProperty property = geometries.get(index);
                    multiSurface.getSurfaceMember().add(new SurfaceProperty(property.getObject()));
                    property.setHref("#" + helper.getOrCreateId(property.getObject()));
                    property.setInlineObject(null);
                }
            }
        }

        boundaries.values().removeIf(boundary -> boundary.getMultiSurface(lod) == null);
    }

    private MultiSurface getOrCreateMultiSurface(AbstractThematicSurface boundary, int lod) {
        MultiSurfaceProperty property = boundary.getMultiSurface(lod);
        if (property == null) {
            property = new MultiSurfaceProperty(new MultiSurface());
            if (!boundary.setMultiSurface(lod, property)) {
                return null;
            }
        }

        return property.getObject();
    }

    private boolean isAvailableForLod(AbstractThematicSurface boundary, int lod) {
        if (version == CityGMLVersion.v3_0) {
            return lod >= 0 && lod < 4;
        } else {
            if (boundary instanceof DoorSurface
                    || boundary instanceof WindowSurface
                    || boundary instanceof InteriorWallSurface
                    || boundary instanceof CeilingSurface
                    || boundary instanceof FloorSurface) {
                return lod == 3;
            } else if (boundary instanceof Marking
                    || boundary instanceof HoleSurface
                    || boundary instanceof GenericThematicSurface) {
                return false;
            }

            return lod >= 2 && lod < 4;
        }
    }

    private List<Integer> flatValues(ArrayNode values) {
        List<Integer> flatValues = new ArrayList<>();
        flatValues(values, flatValues);
        return flatValues;
    }

    private void flatValues(ArrayNode values, List<Integer> flatValues) {
        for (JsonNode value : values) {
            if (value.isArray()) {
                flatValues((ArrayNode) value, flatValues);
            } else {
                flatValues.add(value.asInt(-1));
            }
        }
    }
}
