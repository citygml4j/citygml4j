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
import org.citygml4j.cityjson.adapter.appearance.builder.AppearanceBuilder;
import org.citygml4j.cityjson.adapter.geometry.MultiSurfaceProvider;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.util.BoundaryFilter;
import org.citygml4j.cityjson.util.lod.LodMapper;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.core.*;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.aggregates.*;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.Shell;
import org.xmlobjects.gml.model.geometry.primitives.Solid;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SpaceGeometryBuilder {
    private final GeometryBuilder geometryBuilder;
    private final VerticesBuilder verticesBuilder;
    private final AppearanceBuilder appearanceBuilder;
    private final CityJSONBuilderHelper helper;

    SpaceGeometryBuilder(GeometryBuilder geometryBuilder, CityJSONBuilderHelper helper) {
        this.geometryBuilder = geometryBuilder;
        this.helper = helper;
        verticesBuilder = geometryBuilder.getVerticesBuilder();
        appearanceBuilder = geometryBuilder.getAppearanceBuilder();
    }

    void build(AbstractSpace object, JsonNode node, BoundaryFilter filter, Map<Integer, MultiSurfaceProvider> providers) {
        LodMapper lodMapper = geometryBuilder.getLodMapper();
        GeometryObject geometryObject = GeometryObject.newInstance();

        Map<Double, List<JsonNode>> geometriesByLod = geometryBuilder.groupGeometriesByLod(node);
        lodMapper.buildMapping(geometriesByLod.keySet());

        for (int lod = 0; lod < 4; lod++) {
            List<JsonNode> geometries = geometriesByLod.getOrDefault(lodMapper.getMappingFor(lod), Collections.emptyList());
            for (JsonNode element : geometries) {
                geometryBuilder.getGeometry(object, geometryObject, element, lod, filter, appearanceBuilder, verticesBuilder);

                if (geometryObject.isSetGeometry()) {
                    addGeometry(object, geometryObject.getGeometry(), lod, providers);
                    if (geometryObject.hasBoundaries()) {
                        for (AbstractSpaceBoundary boundary : geometryObject.getBoundaries()) {
                            object.getBoundaries().add(new AbstractSpaceBoundaryProperty(boundary));
                        }
                    }
                } else if (geometryObject.isSetImplicitGeometry() && object instanceof AbstractOccupiedSpace space) {
                    addImplicitGeometry(space, geometryObject.getImplicitGeometry(), lod);
                }

                geometryObject.reset(true);
            }
        }

        if (geometryObject.hasAppearances()) {
            for (Appearance appearance : geometryObject.getAppearances()) {
                object.getAppearances().add(new AbstractAppearanceProperty(appearance));
            }
        }
    }

    private void addGeometry(AbstractSpace space, AbstractGeometry geometry, int lod, Map<Integer, MultiSurfaceProvider> providers) {
        // convert unsupported geometry types
        if (geometry instanceof CompositeSurface compositeSurface) {
            geometry = new MultiSurface(compositeSurface.getSurfaceMembers());
        } else if (geometry instanceof MultiSolid multiSolid) {
            space.setSolid(lod, new SolidProperty(new CompositeSolid(multiSolid.getSolidMember())));
        }

        // assign geometries
        if (geometry instanceof Solid solid) {
            space.setSolid(lod, new SolidProperty(solid));
        } else if (geometry instanceof MultiSurface multiSurface) {
            if (helper.getTargetCityGMLVersion() != CityGMLVersion.v3_0
                    || multiSurface.getSurfaceMember().stream().anyMatch(SurfaceProperty::isSetInlineObject)) {
                if (lod == 1) {
                    if (providers.containsKey(1)) {
                        providers.get(1).set(new MultiSurfaceProperty(multiSurface));
                    } else {
                        Solid solid = new Solid(new Shell(multiSurface.getSurfaceMember()));
                        space.setLod1Solid(new SolidProperty(solid));
                    }
                } else {
                    space.setMultiSurface(lod, new MultiSurfaceProperty((MultiSurface) geometry));
                }
            }
        } else if (geometry instanceof MultiCurve multiCurve) {
            space.setMultiCurve(lod, new MultiCurveProperty(multiCurve));
        } else if (lod == 0 && geometry instanceof MultiPoint multiPoint) {
            if (multiPoint.getPointMember().size() == 1) {
                space.setLod0Point(multiPoint.getPointMember().get(0));
            }
        }
    }

    private void addImplicitGeometry(AbstractOccupiedSpace space, ImplicitGeometry implicitGeometry, int lod) {
        space.setImplicitRepresentation(lod, new ImplicitGeometryProperty(implicitGeometry));
    }
}
