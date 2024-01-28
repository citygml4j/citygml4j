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

package org.citygml4j.cityjson.adapter.geometry.serializer;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceInfo;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.core.model.appearance.X3DMaterial;
import org.citygml4j.core.util.reference.Referees;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

import java.util.HashMap;
import java.util.Map;

public class MaterialBuilder {
    private final AppearanceSerializer appearanceSerializer;
    private final CityJSONSerializerHelper helper;
    private final Map<String, ObjectNode> materials = new HashMap<>();

    MaterialBuilder(AppearanceSerializer appearanceSerializer, CityJSONSerializerHelper helper) {
        this.appearanceSerializer = appearanceSerializer;
        this.helper = helper;
    }

    void addMaterials(AbstractGeometry geometry, boolean reverse, int index) {
        Map<String, AppearanceInfo> materialInfos = null;
        do {
            if (geometry.hasLocalProperties()) {
                Referees referees = geometry.getLocalProperties().get(Referees.PROPERTY_NAME, Referees.class);
                if (referees != null) {
                    for (X3DMaterial material : referees.get(X3DMaterial.class)) {
                        if (material.getIsFront() != reverse) {
                            AppearanceInfo materialInfo = appearanceSerializer.getOrCreateMaterial(material);
                            if (materialInfo != null) {
                                if (materialInfos == null) {
                                    materialInfos = new HashMap<>();
                                }

                                materialInfos.putIfAbsent(materialInfo.getTheme(), materialInfo);
                            }
                        }
                    }
                }
            }
        } while ((geometry = geometry.getParent(AbstractGeometry.class)) != null);

        if (materialInfos != null) {
            for (AppearanceInfo materialInfo : materialInfos.values()) {
                ObjectNode material = materials.get(materialInfo.getTheme());
                if (material == null) {
                    material = helper.createObject();
                    material.putArray(Fields.VALUES);
                    materials.put(materialInfo.getTheme(), material);
                }

                ArrayNode values = (ArrayNode) material.get(Fields.VALUES);
                appendNullValues(values, index);
                values.add(materialInfo.getIndex());
            }
        }
    }

    ObjectNode build(int index) {
        if (!materials.isEmpty()) {
            ObjectNode material = helper.createObject();
            for (Map.Entry<String, ObjectNode> entry : materials.entrySet()) {
                ObjectNode node = entry.getValue();

                ArrayNode values = (ArrayNode) node.get(Fields.VALUES);
                if (values.size() < index) {
                    appendNullValues(values, index);
                } else if (collapseValues(values)) {
                    node.remove(Fields.VALUES);
                    node.set(Fields.VALUE, values.get(0));
                }

                material.set(entry.getKey(), node);
            }

            return material;
        } else {
            return null;
        }
    }

    private void appendNullValues(ArrayNode values, int index) {
        while (values.size() < index) {
            values.addNull();
        }
    }

    private boolean collapseValues(ArrayNode values) {
        int value = values.get(0).asInt(-1);
        if (value != -1) {
            for (int i = 1; i < values.size(); i++) {
                if (values.get(i).asInt(-1) != value) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}
