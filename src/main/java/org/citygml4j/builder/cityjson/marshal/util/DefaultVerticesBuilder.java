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
package org.citygml4j.builder.cityjson.marshal.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultVerticesBuilder implements VerticesBuilder {
    private final ReentrantLock lock = new ReentrantLock();
    private final Map<String, Integer> indexes = new ConcurrentHashMap<>();
    private final List<List<Double>> vertices = new ArrayList<>();

    private int significantDigits = 3;

    public DefaultVerticesBuilder withSignificantDigits(int significantDigits) {
        if (significantDigits > 0)
            this.significantDigits = significantDigits;

        return this;
    }

    public int getSignificantDigits() {
        return significantDigits;
    }

    @Override
    public List<Integer> addVertices(List<Double> vertices) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i += 3) {
            List<Double> vertex = vertices.subList(i, i + 3);

            vertex.set(0, round(vertex.get(0)).doubleValue());
            vertex.set(1, round(vertex.get(1)).doubleValue());
            vertex.set(2, round(vertex.get(2)).doubleValue());

            String key = vertex.get(0).toString() + vertex.get(1).toString() + vertex.get(2).toString();

            Integer index = indexes.get(key);
            if (index == null) {
                Integer tmp = null;

                lock.lock();
                try {
                    tmp = this.vertices.size();
                    this.vertices.add(vertex);
                } finally {
                    lock.unlock();
                }

                index = indexes.putIfAbsent(key, tmp);
                if (index == null)
                    index = tmp;
            }

            result.add(index);
        }

        return result;
    }

    @Override
    public List<List<Double>> build() {
        indexes.clear();
        return vertices;
    }

    @Override
    public void reset() {
        indexes.clear();
        vertices.clear();
    }

    private BigDecimal round(double value) {
        return BigDecimal.valueOf(value).setScale(significantDigits, RoundingMode.HALF_UP);
    }
}
