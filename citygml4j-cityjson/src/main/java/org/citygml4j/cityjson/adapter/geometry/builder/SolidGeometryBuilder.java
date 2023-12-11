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
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.util.BoundaryFilter;
import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolid;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.model.geometry.primitives.*;

import java.util.ArrayList;
import java.util.List;

public class SolidGeometryBuilder extends GeometryObjectBuilder implements SurfaceProvider {
    private final SurfaceGeometryBuilder surfaceGeometryBuilder;
    private final List<SurfaceProperty> surfaces = new ArrayList<>();

    SolidGeometryBuilder(AbstractFeature object, BoundaryFilter filter, VerticesBuilder verticesBuilder) {
        super(object, filter);
        this.surfaceGeometryBuilder = new SurfaceGeometryBuilder(object, filter, verticesBuilder);
    }

    @Override
    void build(JsonNode node, GeometryType type, int lod, GeometryObject geometryObject) {
        JsonNode boundaries = node.path(Fields.BOUNDARIES);
        if (boundaries.isArray()) {
            AbstractGeometry geometry = switch (type) {
                case SOLID -> createSolid((ArrayNode) boundaries);
                case COMPOSITE_SOLID -> createCompositeSolid((ArrayNode) boundaries);
                case MULTI_SOLID -> createMultiSolid((ArrayNode) boundaries);
                default -> null;
            };

            if (geometry != null) {
                geometryObject.setGeometry(geometry);
            } else {
                surfaces.clear();
            }
        }
    }

    @Override
    public List<SurfaceProperty> getSurfaces() {
        return surfaces;
    }

    private Solid createSolid(ArrayNode shells) {
        JsonNode shell = shells.path(0);
        if (shell.isArray()) {
            List<SurfaceProperty> surfaces = surfaceGeometryBuilder.buildSurfaces((ArrayNode) shell);
            if (surfaces != null) {
                Solid solid = new Solid(new Shell(surfaces));
                this.surfaces.addAll(surfaces);

                for (int i = 1; i < shells.size(); i++) {
                    shell = shells.get(i);
                    surfaces = shell.isArray() ? surfaceGeometryBuilder.buildSurfaces((ArrayNode) shell) : null;
                    if (surfaces != null) {
                        solid.getInterior().add(new ShellProperty(new Shell(surfaces)));
                        this.surfaces.addAll(surfaces);
                    } else {
                        return null;
                    }
                }

                return solid;
            }
        }

        return null;
    }

    private AbstractSolid createCompositeSolid(ArrayNode solids) {
        if (!solids.isEmpty()) {
            CompositeSolid compositeSolid = new CompositeSolid();
            for (JsonNode shells : solids) {
                Solid solid = shells.isArray() ? createSolid((ArrayNode) shells) : null;
                if (solid != null) {
                    compositeSolid.getSolidMembers().add(new SolidProperty(solid));
                } else {
                    return null;
                }
            }

            return compositeSolid.getSolidMembers().size() > 1 ?
                    compositeSolid :
                    compositeSolid.getSolidMembers().get(0).getObject();
        } else {
            return null;
        }
    }

    private AbstractGeometry createMultiSolid(ArrayNode solids) {
        if (!solids.isEmpty()) {
            MultiSolid multiSolid = new MultiSolid();
            for (JsonNode shells : solids) {
                Solid solid = shells.isArray() ? createSolid((ArrayNode) shells) : null;
                if (solid != null) {
                    multiSolid.getSolidMember().add(new SolidProperty(solid));
                } else {
                    return null;
                }
            }

            return multiSolid.getSolidMember().size() > 1 ?
                    multiSolid :
                    multiSolid.getSolidMember().get(0).getObject();
        } else {
            return null;
        }
    }
}
