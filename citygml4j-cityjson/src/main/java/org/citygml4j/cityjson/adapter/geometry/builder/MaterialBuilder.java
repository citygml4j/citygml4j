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

package org.citygml4j.cityjson.adapter.geometry.builder;

import com.fasterxml.jackson.databind.JsonNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.builder.AppearanceBuilder;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.core.model.appearance.GeometryReference;
import org.citygml4j.core.model.appearance.X3DMaterial;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.Shell;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.gml.visitor.GeometryWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaterialBuilder {
    private final CityJSONBuilderHelper helper;

    MaterialBuilder(CityJSONBuilderHelper helper) {
        this.helper = helper;
    }

    void build(JsonNode materials, List<SurfaceProperty> geometries, AppearanceBuilder appearanceBuilder, GeometryObject geometryObject) {
        for (Map.Entry<String, JsonNode> entry : materials.properties()) {
            int value = entry.getValue().path(Fields.VALUE).asInt(-1);
            if (value == -1) {
                List<Integer> flatValues = flatValues(entry.getValue(), geometries.size());
                for (int index = 0; index < flatValues.size() && index < geometries.size(); index++) {
                    int materialIndex = flatValues.get(index);
                    if (materialIndex != -1) {
                        AbstractSurface surface = geometries.get(index).getObject();
                        addMaterial(materialIndex, entry.getKey(), helper.getOrCreateId(surface),
                                appearanceBuilder, geometryObject);
                    }
                }
            } else {
                geometryObject.getGeometry().accept(new GeometryWalker() {
                    @Override
                    public void visit(MultiSurface multiSurface) {
                        addMaterial(value, entry.getKey(), helper.getOrCreateId(multiSurface),
                                appearanceBuilder, geometryObject);
                    }

                    @Override
                    public void visit(CompositeSurface compositeSurface) {
                        addMaterial(value, entry.getKey(), helper.getOrCreateId(compositeSurface),
                                appearanceBuilder, geometryObject);
                    }

                    @Override
                    public void visit(Shell shell) {
                        addMaterial(value, entry.getKey(), helper.getOrCreateId(shell),
                                appearanceBuilder, geometryObject);
                    }
                });
            }
        }
    }

    private void addMaterial(int index, String theme, String target, AppearanceBuilder appearanceBuilder, GeometryObject geometryObject) {
        X3DMaterial material = appearanceBuilder.getOrCreateMaterial(index, theme, geometryObject.getAppearanceInfo());
        if (material != null) {
            material.getTargets().add(new GeometryReference("#" + target));
        }
    }

    private List<Integer> flatValues(JsonNode material, int size) {
        List<Integer> flatValues = new ArrayList<>();
        flatValues(material.path(Fields.VALUES), flatValues);
        return flatValues;
    }

    private void flatValues(JsonNode values, List<Integer> flatValues) {
        for (JsonNode value : values) {
            if (value.isArray()) {
                flatValues(value, flatValues);
            } else {
                flatValues.add(value.asInt(-1));
            }
        }
    }
}
