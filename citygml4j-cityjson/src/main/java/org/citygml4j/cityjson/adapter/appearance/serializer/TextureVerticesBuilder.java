/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.appearance.serializer;

import org.citygml4j.cityjson.model.geometry.TextureVertex;
import org.citygml4j.cityjson.util.ArrayBuffer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextureVerticesBuilder {
    private Map<String, Integer> indexes = new HashMap<>();
    private ArrayBuffer<TextureVertex> vertices = new ArrayBuffer<>();
    private int precision;

    TextureVerticesBuilder(int precision) {
        this.precision = precision;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        if (precision >= 0) {
            this.precision = precision;
        }
    }

    public List<Integer> addTextureVertices(List<Double> vertices) {
        List<Integer> indexes = new ArrayList<>(vertices.size() / 2);

        int size = vertices.size();
        for (int i = 0; i < size; i += 2) {
            if (i + 2 > size) {
                break;
            }

            double s = round(vertices.get(i));
            double t = round(vertices.get(i + 1));
            String key = Double.toString(s) + t;

            Integer index = this.indexes.get(key);
            if (index == null) {
                index = this.vertices.size();
                this.vertices.add(TextureVertex.of(s, t));
                this.indexes.put(key, index);
            }

            indexes.add(index);
        }

        return indexes;
    }

    public ArrayBuffer<TextureVertex> build() {
        indexes.clear();
        return vertices;
    }

    public void reset() {
        indexes = new HashMap<>();
        vertices = new ArrayBuffer<>();
    }

    public double round(double value) {
        return BigDecimal.valueOf(value)
                .setScale(precision, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
