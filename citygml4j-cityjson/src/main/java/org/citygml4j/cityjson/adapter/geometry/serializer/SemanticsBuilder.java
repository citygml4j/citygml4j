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
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class SemanticsBuilder {
    private final CityJSONSerializerHelper helper;
    private final Map<AbstractSpaceBoundary, Integer> boundaries = new IdentityHashMap<>();
    private final List<ObjectNode> surfaces = new ArrayList<>();
    private final ArrayNode values;

    SemanticsBuilder(CityJSONSerializerHelper helper) {
        this.helper = helper;
        values = helper.createArray();
    }

    void addSemantics(AbstractGeometry geometry, int index) {
        AbstractSpaceBoundary boundary = null;
        do {
            if (geometry.hasLocalProperties()) {
                boundary = geometry.getLocalProperties()
                        .get(CityJSONSerializerHelper.SEMANTIC_SURFACE, AbstractSpaceBoundary.class);
            }
        } while (boundary == null && (geometry = geometry.getParent(AbstractGeometry.class)) != null);

        if (boundary != null) {
            Integer value = boundaries.get(boundary);
            if (value == null) {
                ObjectNode surface = null;
                try {
                    surface = helper.getObject(boundary);
                } catch (Exception e) {
                    //
                }

                if (surface != null) {
                    value = surfaces.size();
                    surfaces.add(surface);
                } else {
                    value = -1;
                }

                boundaries.put(boundary, value);
            }

            if (value != -1) {
                appendNullValues(index);
                values.add(value);
            }
        }
    }

    ObjectNode build(int index) {
        if (!surfaces.isEmpty()) {
            // build hierarchy
            for (Map.Entry<AbstractSpaceBoundary, Integer> entry : boundaries.entrySet()) {
                if (entry.getValue() != -1) {
                    AbstractSpaceBoundary parent = entry.getKey();
                    while ((parent = parent.getParent(AbstractSpaceBoundary.class)) != null) {
                        Integer parentIndex = boundaries.get(parent);
                        if (parentIndex != null) {
                            surfaces.get(entry.getValue()).put(Fields.PARENT, parentIndex);
                            helper.getOrPutArray(Fields.CHILDREN, surfaces.get(parentIndex)).add(entry.getValue());
                            break;
                        }
                    }
                }
            }

            appendNullValues(index);

            ObjectNode semantics = helper.createObject();
            semantics.putArray(Fields.SURFACES).addAll(surfaces);
            semantics.set(Fields.VALUES, values);

            return semantics;
        } else {
            return null;
        }
    }

    private void appendNullValues(int index) {
        while (values.size() < index) {
            values.addNull();
        }
    }
}
