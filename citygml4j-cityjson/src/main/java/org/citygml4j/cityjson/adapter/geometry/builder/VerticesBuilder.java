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
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.model.geometry.Transform;
import org.citygml4j.cityjson.model.geometry.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VerticesBuilder {
    private final ArrayNode vertices;

    VerticesBuilder(ArrayNode vertices) {
        this.vertices = Objects.requireNonNull(vertices, "The vertices array must not be null.");
    }

    public List<Double> getVertices(ArrayNode indexes, boolean appendLastVertex) {
        List<Double> vertices = new ArrayList<>((appendLastVertex ? indexes.size() + 1 : indexes.size()) * 3);

        for (JsonNode index : indexes) {
            JsonNode vertex = this.vertices.get(index.asInt(-1));
            if (vertex != null && vertex.isArray() && vertex.size() == 3) {
                vertices.add(vertex.get(0).asDouble(0));
                vertices.add(vertex.get(1).asDouble(0));
                vertices.add(vertex.get(2).asDouble(0));
            }
        }

        if (appendLastVertex && !vertices.isEmpty()) {
            vertices.add(vertices.get(0));
            vertices.add(vertices.get(1));
            vertices.add(vertices.get(2));
        }

        return vertices;
    }

    public void applyTransformation(ObjectNode transformNode) {
        JsonNode scale = transformNode.path(Fields.SCALE);
        JsonNode translate = transformNode.path(Fields.TRANSLATE);
        if (!scale.isArray() || scale.size() < 3
                || !translate.isArray() || translate.size() < 3) {
            return;
        }

        Transform transform = new Transform();
        transform.setScale(Vertex.of(
                scale.get(0).asDouble(0),
                scale.get(1).asDouble(0),
                scale.get(2).asDouble(0)));

        transform.setTranslate(Vertex.of(
                translate.get(0).asDouble(1),
                translate.get(1).asDouble(1),
                translate.get(2).asDouble(1)));

        for (int i = 0; i < vertices.size(); i++) {
            JsonNode node = vertices.get(i);
            if (node != null && node.isArray() && node.size() == 3) {
                ArrayNode vertex = (ArrayNode) node;
                vertex.set(0, vertex.get(0).asDouble(0) * transform.getScale().getX() + transform.getTranslate().getX());
                vertex.set(1, vertex.get(1).asDouble(0) * transform.getScale().getY() + transform.getTranslate().getY());
                vertex.set(2, vertex.get(2).asDouble(0) * transform.getScale().getZ() + transform.getTranslate().getZ());
            }
        }
    }
}
