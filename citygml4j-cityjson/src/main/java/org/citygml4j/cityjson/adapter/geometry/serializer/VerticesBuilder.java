/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import org.citygml4j.cityjson.model.geometry.Transform;
import org.citygml4j.cityjson.model.geometry.Vertex;
import org.citygml4j.cityjson.util.ArrayBuffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticesBuilder {
    private Map<VertexKey, Integer> indexes = new HashMap<>();
    private ArrayBuffer<Vertex> vertices = new ArrayBuffer<>();
    private int precision;
    private double scaleFactor;
    private Vertex translation;

    private record VertexKey(long x, long y, long z) {
    }

    VerticesBuilder(int precision) {
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

    public Vertex getTranslation() {
        return translation;
    }

    public void setTranslation(Vertex translation) {
        this.translation = translation;
    }

    public List<Integer> addVertices(List<Double> vertices) {
        List<Integer> indexes = new ArrayList<>(vertices.size() / 3);

        int size = vertices.size();
        for (int i = 0; i < size; i += 3) {
            if (i + 3 > size) {
                break;
            }

            long lx = Math.round(vertices.get(i) * scaleFactor);
            long ly = Math.round(vertices.get(i + 1) * scaleFactor);
            long lz = Math.round(vertices.get(i + 2) * scaleFactor);
            VertexKey key = new VertexKey(lx, ly, lz);

            Integer index = this.indexes.get(key);
            if (index == null) {
                index = this.vertices.size();
                this.vertices.add(Vertex.of(lx / scaleFactor, ly / scaleFactor, lz / scaleFactor));
                this.indexes.put(key, index);
            }

            indexes.add(index);
        }

        return indexes;
    }

    public Transform transform() {
        if (translation == null) {
            translation = Vertex.of(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            // get translation vector as lower left corner
            for (Vertex vertex : vertices) {
                if (vertex.getX() < translation.getX()) translation.setX(vertex.getX());
                if (vertex.getY() < translation.getY()) translation.setY(vertex.getY());
                if (vertex.getZ() < translation.getZ()) translation.setZ(vertex.getZ());
            }
        }

        // set scale factor and offset
        long[] offset = new long[]{(long) (translation.getX() * scaleFactor),
                (long) (translation.getY() * scaleFactor),
                (long) (translation.getZ() * scaleFactor)};

        // apply transformation
        for (Vertex vertex : vertices) {
            vertex.setX((long) (vertex.getX() * scaleFactor) - offset[0]);
            vertex.setY((long) (vertex.getY() * scaleFactor) - offset[1]);
            vertex.setZ((long) (vertex.getZ() * scaleFactor) - offset[2]);
        }

        double scale = 1 / scaleFactor;

        Transform transform = new Transform();
        transform.setTranslate(translation);
        transform.setScale(Vertex.of(scale, scale, scale));

        return transform;
    }

    public ArrayBuffer<Vertex> build() {
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
