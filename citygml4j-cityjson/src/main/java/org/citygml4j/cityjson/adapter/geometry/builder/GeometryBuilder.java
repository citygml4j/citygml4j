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
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.builder.AppearanceBuilder;
import org.citygml4j.cityjson.adapter.geometry.MultiSurfaceProvider;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.util.BoundaryFilter;
import org.citygml4j.cityjson.util.lod.DefaultLodMapper;
import org.citygml4j.cityjson.util.lod.LodMapper;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.AbstractSpace;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import java.util.*;

public class GeometryBuilder {
    private final CityJSONBuilderHelper helper;
    private final VerticesBuilder verticesBuilder;
    private final VerticesBuilder templatesVerticesBuilder;
    private final SpaceGeometryBuilder spaceGeometryBuilder;
    private final SemanticsBuilder semanticsBuilder;
    private final MaterialBuilder materialBuilder;
    private final TextureBuilder textureBuilder;
    private final TemplateInfo templateInfo;
    private final Map<AbstractSpace, Map<Integer, MultiSurfaceProvider>> providers = new IdentityHashMap<>();

    private LodMapper lodMapper = new DefaultLodMapper();
    private boolean transformTemplateGeometries;
    private boolean assignAppearancesToImplicitGeometries;

    public GeometryBuilder(ArrayNode vertices, ObjectNode templates, AppearanceBuilder appearanceBuilder, CityJSONBuilderHelper helper) {
        this.helper = helper;

        verticesBuilder = new VerticesBuilder(vertices);
        templatesVerticesBuilder = new VerticesBuilder(helper.getOrPutArray(Fields.VERTICES_TEMPLATES, templates));

        spaceGeometryBuilder = new SpaceGeometryBuilder(this, helper);
        semanticsBuilder = new SemanticsBuilder(helper);
        materialBuilder = new MaterialBuilder(appearanceBuilder, helper);
        textureBuilder = new TextureBuilder(appearanceBuilder, helper);

        templateInfo = new TemplateInfo(helper.getOrPutArray(Fields.TEMPLATES, templates));
    }

    public VerticesBuilder getVerticesBuilder() {
        return verticesBuilder;
    }

    public VerticesBuilder getTemplatesVerticesBuilder() {
        return templatesVerticesBuilder;
    }

    public boolean isTransformTemplateGeometries() {
        return transformTemplateGeometries;
    }

    public void setTransformTemplateGeometries(boolean transformTemplateGeometries) {
        this.transformTemplateGeometries = transformTemplateGeometries;
    }

    public boolean isAssignAppearancesToImplicitGeometries() {
        return assignAppearancesToImplicitGeometries;
    }

    public void setAssignAppearancesToImplicitGeometries(boolean assignAppearancesToImplicitGeometries) {
        this.assignAppearancesToImplicitGeometries = assignAppearancesToImplicitGeometries;
    }

    public LodMapper getLodMapper() {
        return lodMapper;
    }

    public void setLodMapper(LodMapper lodMapper) {
        this.lodMapper = Objects.requireNonNull(lodMapper, "The LoD mapper must not be null.");
    }

    public List<Appearance> getGlobalAppearances() {
        return templateInfo.getAppearances();
    }

    public boolean hasGlobalAppearances() {
        return templateInfo.hasAppearances();
    }

    public void setMultiSurfaceProviders(AbstractSpace space, Map<Integer, MultiSurfaceProvider> providers) {
        if (providers != null) {
            this.providers.put(space, providers);
        }
    }

    public GeometryObject getGeometry(AbstractFeature object, JsonNode geometry, int lod, BoundaryFilter filter) {
        GeometryObject geometryObject = GeometryObject.newInstance();
        getGeometry(object, geometryObject, geometry, lod, filter, verticesBuilder);
        return geometryObject.isSetGeometry() || geometryObject.isSetImplicitGeometry() ?
                geometryObject :
                null;
    }

    void getGeometry(AbstractFeature object, GeometryObject geometryObject, JsonNode geometry, int lod, BoundaryFilter filter, VerticesBuilder verticesBuilder) {
        if (geometry != null && geometry.isObject()) {
            GeometryType type = GeometryType.fromValue(geometry.path(Fields.TYPE).asText());

            GeometryObjectBuilder builder = null;
            if (GeometryType.SURFACE_TYPES.contains(type)) {
                builder = new SurfaceGeometryBuilder(object, filter, verticesBuilder);
            } else if (GeometryType.SOLID_TYPES.contains(type)) {
                builder = new SolidGeometryBuilder(object, filter, verticesBuilder);
            } else if (type == GeometryType.MULTI_LINE_STRING) {
                builder = new CurveGeometryBuilder(object, filter, verticesBuilder);
            } else if (type == GeometryType.MULTI_POINT) {
                builder = new PointGeometryBuilder(object, filter, verticesBuilder);
            } else if (type == GeometryType.TEMPLATE_GEOMETRY) {
                builder = new TemplateGeometryBuilder(object, filter, templateInfo, this, helper);
            }

            if (builder != null) {
                builder.build(geometry, type, lod, geometryObject);

                if (geometryObject.getGeometry() != null && builder instanceof SurfaceProvider) {
                    List<SurfaceProperty> surfaces = ((SurfaceProvider) builder).getSurfaces();
                    materialBuilder.build(geometry.path(Fields.MATERIAL), surfaces, geometryObject);
                    textureBuilder.build(geometry.path(Fields.TEXTURE), surfaces, geometryObject);
                    if (object instanceof AbstractSpace) {
                        AbstractSpace space = (AbstractSpace) object;
                        JsonNode semantics = geometry.path(Fields.SEMANTICS);
                        semanticsBuilder.build(space, semantics, filter, surfaces, lod, geometryObject);
                    }
                }
            }
        }
    }

    public Map<Integer, List<GeometryObject>> getGeometries(AbstractFeature object, JsonNode geometries, BoundaryFilter filter) {
        Map<Integer, List<GeometryObject>> geometryObjects = new HashMap<>();

        Map<Double, List<JsonNode>> geometriesByLod = groupGeometriesByLod(geometries);
        if (!geometriesByLod.isEmpty()) {
            lodMapper.buildMapping(geometriesByLod.keySet());

            int maxLod = Collections.max(geometriesByLod.keySet()).intValue() + 1;
            for (int lod = 0; lod < maxLod; lod++) {
                List<JsonNode> nodes = geometriesByLod.getOrDefault(lodMapper.getMappingFor(lod), Collections.emptyList());
                for (JsonNode geometry : nodes) {
                    GeometryObject geometryObject = getGeometry(object, geometry, lod, filter);
                    if (geometryObject != null) {
                        geometryObjects.computeIfAbsent(lod, v -> new ArrayList<>()).add(geometryObject);
                    }
                }
            }
        }

        return geometryObjects;
    }

    public void addGeometries(AbstractSpace space, JsonNode geometries, BoundaryFilter filter) {
        try {
            if (geometries != null && geometries.isArray()) {
                spaceGeometryBuilder.build(space, geometries, filter, providers.getOrDefault(space, Collections.emptyMap()));
            }
        } finally {
            providers.remove(space);
        }
    }

    public Map<Double, List<JsonNode>> groupGeometriesByLod(JsonNode geometries) {
        if (!geometries.isEmpty()) {
            Map<Double, List<JsonNode>> geometriesByLod = new HashMap<>();
            for (JsonNode geometry : geometries) {
                GeometryType type = GeometryType.fromValue(geometry.path(Fields.TYPE).asText());
                JsonNode lod = type != GeometryType.TEMPLATE_GEOMETRY ?
                        geometry.path(Fields.LOD) :
                        templateInfo.getTemplate(geometry.path(Fields.TEMPLATE).asInt(-1)).path(Fields.LOD);

                if (lod.isValueNode()) {
                    geometriesByLod.computeIfAbsent(lod.asDouble(), v -> new ArrayList<>()).add(geometry);
                }
            }

            return geometriesByLod;
        }

        return Collections.emptyMap();
    }
}