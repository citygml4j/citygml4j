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

package org.citygml4j.cityjson.adapter.appearance.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextureVerticesBuilder {
    private final ArrayNode textureVertices;

    TextureVerticesBuilder(ArrayNode textureVertices) {
        this.textureVertices = Objects.requireNonNull(textureVertices, "The texture vertices array must not be null.");
    }

    public List<Double> getTextureVertices(ArrayNode indexes) {
        List<Double> vertices = new ArrayList<>(indexes.size() * 2);

        for (int index = 1; index < indexes.size(); index++) {
            JsonNode vertex = this.textureVertices.get(indexes.path(index).asInt(-1));
            if (vertex != null && vertex.isArray() && vertex.size() == 2) {
                vertices.add(vertex.get(0).asDouble(0));
                vertices.add(vertex.get(1).asDouble(0));
            }
        }

        if (!vertices.isEmpty()) {
            vertices.add(vertices.get(0));
            vertices.add(vertices.get(1));
        }

        return vertices;
    }
}
