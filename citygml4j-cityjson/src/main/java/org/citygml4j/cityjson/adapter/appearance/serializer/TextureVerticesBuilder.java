/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.appearance.serializer;

import org.citygml4j.cityjson.model.geometry.TextureVertex;
import org.citygml4j.cityjson.util.ArrayBuffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextureVerticesBuilder {
    private Map<TextureVertexKey, Integer> indexes = new HashMap<>();
    private ArrayBuffer<TextureVertex> vertices = new ArrayBuffer<>();
    private int precision;
    private double scaleFactor;

    private record TextureVertexKey(long s, long t) {
    }

    TextureVerticesBuilder(int precision) {
        this.precision = precision;
        this.scaleFactor = Math.pow(10, precision);
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        if (precision >= 0) {
            this.precision = precision;
            this.scaleFactor = Math.pow(10, precision);
        }
    }

    public List<Integer> addTextureVertices(List<Double> vertices) {
        List<Integer> indexes = new ArrayList<>(vertices.size() / 2);

        int size = vertices.size();
        for (int i = 0; i < size; i += 2) {
            if (i + 2 > size) {
                break;
            }

            long ls = Math.round(vertices.get(i) * scaleFactor);
            long lt = Math.round(vertices.get(i + 1) * scaleFactor);
            TextureVertexKey key = new TextureVertexKey(ls, lt);

            Integer index = this.indexes.get(key);
            if (index == null) {
                index = this.vertices.size();
                this.vertices.add(TextureVertex.of(ls / scaleFactor, lt / scaleFactor));
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
        return Math.round(value * scaleFactor) / scaleFactor;
    }
}
