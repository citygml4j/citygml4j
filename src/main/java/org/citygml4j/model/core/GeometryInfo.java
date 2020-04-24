/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.core;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GeometryInfo {
    private final Map<Integer, List<GeometryProperty<?>>> geometries = new HashMap<>();
    private final Map<Integer, List<ImplicitGeometryProperty>> implicitGeometries = new HashMap<>();

    public List<GeometryProperty<?>> getGeometries() {
        return geometries.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<GeometryProperty<?>> getGeometries(int lod) {
        return geometries.getOrDefault(lod, Collections.emptyList());
    }

    public List<GeometryProperty<?>> getNonLodGeometries() {
        return getGeometries(-1);
    }

    public void addGeometry(int lod, GeometryProperty<?> property) {
        if (lod >= 0 && property != null)
            geometries.computeIfAbsent(lod, v -> new ArrayList<>()).add(property);
    }

    public void addGeometry(GeometryProperty<?> property) {
        addGeometry(-1, property);
    }

    public boolean hasGeometries() {
        return !geometries.isEmpty();
    }

    public boolean hasGeometries(int lod) {
        return lod >= 0 && geometries.containsKey(lod);
    }

    public boolean hasNonLodGeometries() {
        return hasGeometries(-1);
    }

    public List<ImplicitGeometryProperty> getImplicitGeometries() {
        return implicitGeometries.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<ImplicitGeometryProperty> getImplicitGeometries(int lod) {
        return implicitGeometries.getOrDefault(lod, Collections.emptyList());
    }

    public List<ImplicitGeometryProperty> getNonLodImplicitGeometries() {
        return getImplicitGeometries(-1);
    }

    public void addImplicitGeometry(int lod, ImplicitGeometryProperty property) {
        if (lod >= 0 && property != null)
            implicitGeometries.computeIfAbsent(lod, v -> new ArrayList<>()).add(property);
    }

    public void addImplicitGeometry(ImplicitGeometryProperty property) {
        addImplicitGeometry(-1, property);
    }

    public boolean hasImplicitGeometries() {
        return !implicitGeometries.isEmpty();
    }

    public boolean hasImplicitGeometries(int lod) {
        return lod >= 0 && implicitGeometries.containsKey(lod);
    }

    public boolean hasNonLodImplicitGeometries() {
        return hasImplicitGeometries(-1);
    }
}
