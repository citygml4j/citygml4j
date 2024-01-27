/*
 * citygml-tools - Collection of tools for processing CityGML files
 * https://github.com/citygml4j/citygml-tools
 *
 * citygml-tools is part of the citygml4j project
 *
 * Copyright 2018-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.writer;

import org.citygml4j.core.model.appearance.Appearance;
import org.citygml4j.core.model.cityobjectgroup.CityObjectGroup;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.util.reference.Referees;
import org.citygml4j.core.visitor.ObjectWalker;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AbstractInlineOrByReferenceProperty;
import org.xmlobjects.gml.model.base.AbstractReference;
import org.xmlobjects.gml.model.base.ResolvableAssociation;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.visitor.Visitable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReferenceResolver {
    private final List<CityObjectGroup> groups = new ArrayList<>();
    private final List<AbstractGeometry> templates = new ArrayList<>();
    private final Map<String, List<ResolvableAssociation<?>>> globalProperties = new HashMap<>();

    ReferenceResolver() {
    }

    List<CityObjectGroup> getCityObjectGroups() {
        return groups;
    }

    void add(CityObjectGroup group) {
        groups.add(group);
        populateProperties(group, globalProperties);
    }

    List<AbstractGeometry> getTemplateGeometries() {
        return templates;
    }

    void add(AbstractGeometry geometry) {
        if (geometry.getId() != null) {
            templates.add(geometry);
        }
    }

    void add(Appearance appearance) {
        populateProperties(appearance, globalProperties);
    }

    void initialize() {
        templates.forEach(this::resolveReferences);
    }

    void resolveReferences(Visitable visitable) {
        List<AbstractGML> objects = new ArrayList<>();
        Map<String, List<ResolvableAssociation<?>>> properties = new HashMap<>();
        populate(visitable, objects, properties);

        objects.forEach(object -> {
            resolveReferences(object, properties);
            resolveReferences(object, globalProperties);
        });

        templates.forEach(template -> resolveReferences(template, properties));
    }

    private void resolveReferences(AbstractGML object, Map<String, List<ResolvableAssociation<?>>> properties) {
        List<ResolvableAssociation<?>> candidates = properties.get(object.getId());
        if (candidates != null) {
            for (ResolvableAssociation<?> candidate : candidates) {
                object.getLocalProperties()
                        .getOrSet(Referees.PROPERTY_NAME, Referees.class, Referees::new)
                        .add(candidate.getParent());

                if (properties != globalProperties) {
                    candidate.setReferencedObjectIfValid(object, false);
                }
            }
        }
    }

    private void populateProperties(AbstractFeature feature, Map<String, List<ResolvableAssociation<?>>> properties) {
        populate(feature, null, properties);
    }

    private void populate(Visitable visitable, List<AbstractGML> objects, Map<String, List<ResolvableAssociation<?>>> properties) {
        ObjectWalker walker = new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (objects != null && object.getId() != null) {
                    objects.add(object);
                }
            }

            @Override
            public void visit(AbstractInlineOrByReferenceProperty<?> property) {
                add(property, property.getHref());
                super.visit(property);
            }

            @Override
            public void visit(AbstractReference<?> reference) {
                add(reference, reference.getHref());
            }

            private void add(ResolvableAssociation<?> association, String reference) {
                if (reference != null && AbstractGML.class.isAssignableFrom(association.getTargetType())) {
                    int index = reference.lastIndexOf("#");
                    properties.computeIfAbsent(index != -1 ? reference.substring(index + 1) : reference,
                            v -> new ArrayList<>()).add(association);
                }
            }
        };

        walker.visit(visitable);
    }

    void clear() {
        groups.clear();
        templates.clear();
        globalProperties.clear();
    }
}
