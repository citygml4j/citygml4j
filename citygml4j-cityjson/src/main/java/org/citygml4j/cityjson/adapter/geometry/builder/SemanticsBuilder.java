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
import org.xmlobjects.util.copy.CopyBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SemanticsBuilder {
    private final CityJSONBuilderHelper helper;
    private CopyBuilder copyBuilder;

    SemanticsBuilder(CityJSONBuilderHelper helper) {
        this.helper = helper;
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

        createBoundaries((ArrayNode) surfaces, boundaries, filter);
        assignGeometries(boundaries, (ArrayNode) values, geometries, lod);
        rebuildHierarchies((ArrayNode) surfaces, boundaries);
        cleanupBoundaries((ArrayNode) surfaces, filter, boundaries);

        if (!boundaries.isEmpty()) {
            geometryObject.setBoundaries(new ArrayList<>(boundaries.values()));
        }
    }

    private void createBoundaries(ArrayNode surfaces, Map<Integer, AbstractThematicSurface> boundaries, BoundaryFilter filter) {
        for (int i = 0; i < surfaces.size(); i++) {
            try {
                JsonNode surface = surfaces.get(i);
                String type = surface.path(Fields.TYPE).asText();

                AbstractThematicSurface boundary = helper.getObject(type, surface, AbstractThematicSurface.class);
                if (boundary == null
                        && helper.isMapUnsupportedTypesToGenerics()
                        && filter.isValidBoundary(GenericThematicSurface.class)) {
                    boundary = helper.getObjectUsingBuilder(surface, GenericThematicSurfaceAdapter.class);
                    addGenericTypeAttribute(type, boundary);
                }

                if (boundary != null) {
                    boundaries.put(i, boundary);
                }
            } catch (Exception e) {
                //
            }
        }
    }

    private void rebuildHierarchies(ArrayNode surfaces, Map<Integer, AbstractThematicSurface> boundaries) {
        for (int i = 0; i < surfaces.size(); i++) {
            JsonNode surface = surfaces.get(i);
            AbstractThematicSurface boundary = boundaries.get(i);

            if (boundary instanceof AbstractConstructionSurface) {
                for (JsonNode element : surface.path(Fields.CHILDREN)) {
                    int index = element.asInt(-1);
                    AbstractThematicSurface child = boundaries.get(index);
                    if (child instanceof AbstractFillingSurface) {
                        ((AbstractConstructionSurface) boundary)
                                .getFillingSurfaces()
                                .add(new AbstractFillingSurfaceProperty((AbstractFillingSurface) child));
                        boundaries.remove(index);
                    }
                }
            } else if (boundary instanceof AbstractFillingSurface) {
                AbstractThematicSurface parent = boundaries.get(surface.path(Fields.PARENT).asInt(-1));
                if (parent instanceof AbstractConstructionSurface) {
                    ((AbstractConstructionSurface) parent)
                            .getFillingSurfaces()
                            .add(new AbstractFillingSurfaceProperty((AbstractFillingSurface) boundary));
                    boundaries.remove(i);
                }
            }
        }
    }

    private void cleanupBoundaries(ArrayNode surfaces, BoundaryFilter filter, Map<Integer, AbstractThematicSurface> boundaries) {
        List<Map.Entry<Integer, AbstractThematicSurface>> entries = boundaries.entrySet().stream()
                .filter(e -> !filter.isValidBoundary(e.getValue()))
                .collect(Collectors.toList());

        if (!entries.isEmpty()) {
            if (helper.isMapUnsupportedTypesToGenerics()
                    && filter.isValidBoundary(GenericThematicSurface.class)) {
                CopyBuilder copyBuilder = getOrCreateCopyBuilder();
                for (Map.Entry<Integer, AbstractThematicSurface> entry : entries) {
                    GenericThematicSurface boundary = new GenericThematicSurface();
                    copyBuilder.shallowCopy(entry.getValue(), boundary, AbstractThematicSurface.class);

                    JsonNode surface = surfaces.get(entry.getKey());
                    addGenericTypeAttribute(surface.path(Fields.TYPE).asText(), boundary);
                    entry.setValue(boundary);
                }
            } else {
                entries.forEach(entry -> boundaries.remove(entry.getKey()));
            }
        }
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
        if (helper.getTargetCityGMLVersion() == CityGMLVersion.v3_0) {
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

    private void addGenericTypeAttribute(String type, AbstractThematicSurface boundary) {
        if (type.startsWith("+")) {
            type = type.substring(1);
        }

        StringAttribute stringAttribute = new StringAttribute(CityJSONConstants.GENERIC_TYPE_ATTRIBUTE, type);
        boundary.getGenericAttributes().add(new AbstractGenericAttributeProperty(stringAttribute));
    }

    private CopyBuilder getOrCreateCopyBuilder() {
        if (copyBuilder == null) {
            copyBuilder = new CopyBuilder();
        }

        return copyBuilder;
    }
}
