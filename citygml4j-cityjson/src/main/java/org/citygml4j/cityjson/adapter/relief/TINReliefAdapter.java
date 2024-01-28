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

package org.citygml4j.cityjson.adapter.relief;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.geometry.builder.GeometryObject;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.appearance.*;
import org.citygml4j.core.model.core.AbstractAppearanceProperty;
import org.citygml4j.core.model.relief.TINRelief;
import org.citygml4j.core.model.relief.TinProperty;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.*;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class TINReliefAdapter extends AbstractReliefComponentAdapter<TINRelief> {
    private final EnumSet<GeometryType> allowedTypes = EnumSet.of(GeometryType.COMPOSITE_SURFACE);

    @Override
    public TINRelief createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new TINRelief();
    }

    @Override
    public String createType(TINRelief object, CityJSONVersion version) throws CityJSONSerializeException {
        return "TINRelief";
    }

    @Override
    public void buildObject(TINRelief object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (JsonNode geometry : node.path(Fields.GEOMETRY)) {
            GeometryType type = GeometryType.fromValue(geometry.path(Fields.TYPE).asText());
            if (type == GeometryType.COMPOSITE_SURFACE) {
                GeometryObject geometryObject = helper.getGeometry(object, geometry);
                if (geometryObject != null
                        && geometryObject.getGeometry() instanceof CompositeSurface compositeSurface) {
                    TriangulatedSurface triangulatedSurface = toTriangulatedSurface(compositeSurface);
                    if (triangulatedSurface != null) {
                        object.setLod(geometry.path(Fields.LOD).asInt(0));
                        object.setTin(new TinProperty(triangulatedSurface));
                        if (geometryObject.hasAppearances()) {
                            addAppearances(object, geometryObject.getAppearances(), "#" + triangulatedSurface.getId());
                        }
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void writeObject(TINRelief object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        super.writeObject(object, node, helper);

        if (object.getTin() != null) {
            helper.addGeometry(object.getTin(), object.getLod(), node, allowedTypes);
        }
    }

    private TriangulatedSurface toTriangulatedSurface(CompositeSurface compositeSurface) {
        TriangleArrayProperty triangles = new TriangleArrayProperty();

        Iterator<SurfaceProperty> iterator = compositeSurface.getSurfaceMembers().iterator();
        while (iterator.hasNext()) {
            SurfaceProperty property = iterator.next();
            if (property.getObject() instanceof Polygon polygon) {
                if (polygon.getExterior() != null
                        && polygon.getExterior().getObject() instanceof LinearRing linearRing) {
                    if (linearRing.getControlPoints() != null
                            && linearRing.getControlPoints().isSetPosList()
                            && linearRing.getControlPoints().getPosList().getValue().size() == 12) {
                        triangles.getObjects().add(new Triangle(polygon.getExterior().getObject()));
                    } else {
                        return null;
                    }
                }
            }

            iterator.remove();
        }

        if (triangles.isSetObjects()) {
            TriangulatedSurface triangulatedSurface = new TriangulatedSurface(triangles);
            triangulatedSurface.setId(compositeSurface.getId());
            return triangulatedSurface;
        } else {
            return null;
        }
    }

    private void addAppearances(TINRelief object, List<Appearance> appearances, String target) {
        for (Appearance appearance : appearances) {
            Iterator<AbstractSurfaceDataProperty> iterator = appearance.getSurfaceData().iterator();
            while (iterator.hasNext()) {
                AbstractSurfaceData surfaceData = iterator.next().getObject();

                if (surfaceData instanceof X3DMaterial material) {
                    if (material.getTargets().size() == 1
                            && material.getTargets().get(0).getHref().equals(target)) {
                        continue;
                    }
                } else if (surfaceData instanceof ParameterizedTexture texture) {
                    if (texture.getTextureParameterizations().size() == 1) {
                        TextureAssociation association = texture.getTextureParameterizations().get(0).getObject();
                        if (association != null
                                && association.getTarget() != null
                                && association.getTarget().getHref().equals(target)) {
                            continue;
                        }
                    }
                }

                iterator.remove();
            }

            if (appearance.isSetSurfaceData()) {
                object.getAppearances().add(new AbstractAppearanceProperty(appearance));
            }
        }
    }
}
