/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
