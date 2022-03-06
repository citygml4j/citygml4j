/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.cityjson.model.geometry.Transform;
import org.citygml4j.cityjson.model.geometry.Vertex;
import org.citygml4j.cityjson.util.ArrayBuffer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticesBuilder {
    private Map<String, Integer> indexes = new HashMap<>();
    private ArrayBuffer<Vertex> vertices = new ArrayBuffer<>();
    private int precision;
    private Vertex translation;

    VerticesBuilder(int precision) {
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

            double x = round(vertices.get(i));
            double y = round(vertices.get(i + 1));
            double z = round(vertices.get(i + 2));
            String key = Double.toString(x) + y + z;

            Integer index = this.indexes.get(key);
            if (index == null) {
                index = this.vertices.size();
                this.vertices.add(Vertex.of(x, y, z));
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
        double scale = Math.pow(10, precision);
        int[] offset = new int[]{(int) (translation.getX() * scale),
                (int) (translation.getY() * scale),
                (int) (translation.getZ() * scale)};

        // apply transformation
        for (Vertex vertex : vertices) {
            vertex.setX((long) (vertex.getX() * scale) - offset[0]);
            vertex.setY((long) (vertex.getY() * scale) - offset[1]);
            vertex.setZ((long) (vertex.getZ() * scale) - offset[2]);
        }

        scale = 1 / scale;

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
        return BigDecimal.valueOf(value)
                .setScale(precision, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
