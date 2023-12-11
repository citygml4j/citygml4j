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

package org.citygml4j.core.model.common;

import org.citygml4j.core.model.core.ImplicitGeometryProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

import java.util.*;
import java.util.stream.Collectors;

public class GeometryInfo {
    private final Map<Integer, List<GeometryProperty<?>>> geometries = new HashMap<>();
    private final Map<Integer, List<ImplicitGeometryProperty>> implicitGeometries = new HashMap<>();

    public Set<Integer> getLods() {
        Set<Integer> lods = getLods(geometries);
        lods.addAll(getLods(implicitGeometries));
        return lods;
    }

    public List<GeometryProperty<?>> getGeometries() {
        return geometries.values().stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public List<GeometryProperty<?>> getGeometries(int lod) {
        return lod > Integer.MIN_VALUE ?
                geometries.getOrDefault(lod, Collections.emptyList()) :
                Collections.emptyList();
    }

    public List<GeometryProperty<?>> getNonLodGeometries() {
        return geometries.getOrDefault(Integer.MIN_VALUE, Collections.emptyList());
    }

    public void addGeometry(int lod, GeometryProperty<?> property) {
        if (property != null)
            geometries.computeIfAbsent(lod, v -> new ArrayList<>()).add(property);
    }

    public void addGeometry(GeometryProperty<?> property) {
        addGeometry(Integer.MIN_VALUE, property);
    }

    public boolean hasGeometries() {
        return !geometries.isEmpty();
    }

    public boolean hasGeometries(int lod) {
        return lod > Integer.MIN_VALUE && geometries.containsKey(lod);
    }

    public boolean hasLodGeometries() {
        return geometries.keySet().stream().anyMatch(lod -> lod > Integer.MIN_VALUE);
    }

    public boolean hasNonLodGeometries() {
        return geometries.containsKey(Integer.MIN_VALUE);
    }

    public List<ImplicitGeometryProperty> getImplicitGeometries() {
        return implicitGeometries.values().stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public List<ImplicitGeometryProperty> getImplicitGeometries(int lod) {
        return lod > Integer.MIN_VALUE ?
                implicitGeometries.getOrDefault(lod, Collections.emptyList()) :
                Collections.emptyList();
    }

    public List<ImplicitGeometryProperty> getNonLodImplicitGeometries() {
        return implicitGeometries.getOrDefault(Integer.MIN_VALUE, Collections.emptyList());
    }

    public void addImplicitGeometry(int lod, ImplicitGeometryProperty property) {
        if (property != null)
            implicitGeometries.computeIfAbsent(lod, v -> new ArrayList<>()).add(property);
    }

    public void addImplicitGeometry(ImplicitGeometryProperty property) {
        addImplicitGeometry(Integer.MIN_VALUE, property);
    }

    public boolean hasImplicitGeometries() {
        return !implicitGeometries.isEmpty();
    }

    public boolean hasImplicitGeometries(int lod) {
        return lod > Integer.MIN_VALUE && implicitGeometries.containsKey(lod);
    }

    public boolean hasLodImplicitGeometries() {
        return implicitGeometries.keySet().stream().anyMatch(lod -> lod > Integer.MIN_VALUE);
    }

    public boolean hasNonLodImplicitGeometries() {
        return implicitGeometries.containsKey(Integer.MIN_VALUE);
    }

    private Set<Integer> getLods(Map<Integer, ?> geometries) {
        return geometries.keySet().stream()
                .filter(lod -> lod != Integer.MIN_VALUE)
                .collect(Collectors.toSet());
    }
}
