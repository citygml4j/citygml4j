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

package org.citygml4j.model.gml.feature;

import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

import java.util.*;
import java.util.stream.Collectors;

public class SpatialRepresentation {
    private final static SpatialRepresentation EMPTY_REPRESENTATION = new SpatialRepresentation();
    private Map<Integer, List<AssociationByRepOrRef<? extends AbstractGML>>> representations = new HashMap<>();

    public static SpatialRepresentation emptyRepresentation() {
        return EMPTY_REPRESENTATION;
    }

    protected final void add(int lod, AssociationByRepOrRef<? extends AbstractGML> property) {
        if (property instanceof GeometryProperty<?> || property instanceof ImplicitRepresentationProperty)
            representations.computeIfAbsent(lod, k -> new ArrayList<>()).add(property);
    }

    public void addRepresentation(AssociationByRepOrRef<? extends AbstractGML> property) {
        add(-1, property);
    }

    public void addRepresentation(GeometryProperty<? extends AbstractGeometry> property) {
        add(-1, property);
    }

    public void addRepresentation(ImplicitRepresentationProperty property) {
        add(-1, property);
    }

    protected boolean isSetRepresentation(int lod) {
        return representations.containsKey(lod);
    }

    public boolean hasRepresentations() {
        return !representations.isEmpty();
    }

    protected List<AssociationByRepOrRef<? extends AbstractGML>> getRepresentation(int lod) {
        return representations.getOrDefault(lod, Collections.emptyList());
    }

    public List<AssociationByRepOrRef<? extends AbstractGML>> getRepresentations() {
        return representations.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    protected boolean isSetGeometry(int lod) {
        List<AssociationByRepOrRef<? extends AbstractGML>> representation = representations.get(lod);
        return representation != null && representation.stream().anyMatch(GeometryProperty.class::isInstance);
    }

    public boolean hasGeometries() {
        return representations.keySet().stream().anyMatch(this::isSetGeometry);
    }

    protected List<GeometryProperty<? extends AbstractGeometry>> getGeometry(int lod) {
        List<AssociationByRepOrRef<? extends AbstractGML>> representation = representations.get(lod);
        return representation != null ? representation.stream()
                .filter(GeometryProperty.class::isInstance)
                .map(p -> (GeometryProperty<? extends AbstractGeometry>) p)
                .collect(Collectors.toList())
                : Collections.emptyList();
    }

    public List<GeometryProperty<? extends AbstractGeometry>> getGeometries() {
        return representations.values().stream()
                .flatMap(Collection::stream)
                .filter(GeometryProperty.class::isInstance)
                .map(p -> (GeometryProperty<? extends AbstractGeometry>) p)
                .collect(Collectors.toList());
    }

    protected boolean isSetImplicitGeometry(int lod) {
        List<AssociationByRepOrRef<? extends AbstractGML>> representation = representations.get(lod);
        return representation != null && representation.stream().anyMatch(ImplicitRepresentationProperty.class::isInstance);
    }

    public boolean hasImplicitGeometries() {
        return representations.keySet().stream().anyMatch(this::isSetImplicitGeometry);
    }

    protected List<ImplicitRepresentationProperty> getImplicitGeometry(int lod) {
        List<AssociationByRepOrRef<? extends AbstractGML>> representation = representations.get(lod);
        return representation != null ? representation.stream()
                .filter(ImplicitRepresentationProperty.class::isInstance)
                .map(p -> (ImplicitRepresentationProperty) p)
                .collect(Collectors.toList())
                : Collections.emptyList();
    }

    public List<ImplicitRepresentationProperty> getImplicitGeometries() {
        return representations.values().stream()
                .flatMap(Collection::stream)
                .filter(ImplicitRepresentationProperty.class::isInstance)
                .map(p -> (ImplicitRepresentationProperty) p)
                .collect(Collectors.toList());
    }

    protected List<Integer> getLods() {
        return representations.keySet().stream().filter(lod -> lod >= 0).collect(Collectors.toList());
    }
}
