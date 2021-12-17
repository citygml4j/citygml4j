/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.util.reference;

import org.citygml4j.visitor.ObjectWalker;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AbstractInlineOrByReferenceProperty;
import org.xmlobjects.gml.model.base.AbstractReference;
import org.xmlobjects.gml.model.base.ResolvableAssociation;
import org.xmlobjects.gml.util.reference.ReferenceResolver;
import org.xmlobjects.gml.visitor.Visitable;
import org.xmlobjects.model.Child;

import java.util.*;

public class DefaultReferenceResolver implements ReferenceResolver {
    private ResolveMode mode = ResolveMode.ALL_OBJECTS;

    private DefaultReferenceResolver() {
    }

    public static DefaultReferenceResolver newInstance() {
        return new DefaultReferenceResolver();
    }

    public ResolveMode getResolveMode() {
        return mode;
    }

    public DefaultReferenceResolver withResolveMode(ResolveMode mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public <T extends Child> T resolveReference(String reference, Visitable scope, Class<T> type) {
        if (reference == null
                || scope == null
                || !mode.getType().isAssignableFrom(type)) {
            return null;
        }

        String id = getIdFromReference(reference);
        AbstractGML[] target = new AbstractGML[1];

        new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (type.isInstance(object) && id.equals(object.getId())) {
                    target[0] = object;
                    setShouldWalk(false);
                } else {
                    super.visit(object);
                }
            }
        }.visit(scope);

        return type.cast(target[0]);
    }

    @Override
    public Child resolveReference(String reference, Visitable scope) {
        return resolveReference(reference, scope, mode.getType());
    }

    @Override
    public void resolveReferences(Visitable scope) {
        if (scope == null) {
            return;
        }

        Map<String, List<ResolvableAssociation<?>>> properties = new HashMap<>();

        new ObjectWalker() {
            @Override
            public void visit(AbstractInlineOrByReferenceProperty<?> property) {
                collect(property, property.getHref());
                super.visit(property);
            }

            @Override
            public void visit(AbstractReference<?> reference) {
                collect(reference, reference.getHref());
            }

            private void collect(ResolvableAssociation<?> association, String reference) {
                if (reference != null && mode.getType().isAssignableFrom(association.getTargetType())) {
                    properties.computeIfAbsent(getIdFromReference(reference), v -> new ArrayList<>()).add(association);
                }
            }
        }.visit(scope);

        new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (object.getId() != null && mode.getType().isInstance(object)) {
                    List<ResolvableAssociation<?>> candidates = properties.get(object.getId());
                    if (candidates != null) {
                        for (ResolvableAssociation<?> candidate : candidates) {
                            candidate.setReferencedObjectIfValid(object, false);
                        }
                    }
                }

                super.visit(object);
            }
        }.visit(scope);
    }

    @Override
    public <T extends Child> Map<String, T> getObjectsById(Visitable scope, Class<T> type) {
        if (scope == null
                || !mode.getType().isAssignableFrom(type)) {
            return Collections.emptyMap();
        }

        Map<String, T> targets = new HashMap<>();

        new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (object.getId() != null && type.isInstance(object)) {
                    targets.put(object.getId(), type.cast(object));
                }

                super.visit(object);
            }
        }.visit(scope);

        return targets;
    }

    @Override
    public Map<String, ? extends Child> getObjectsById(Visitable scope) {
        return getObjectsById(scope, mode.getType());
    }

    public String getIdFromReference(String reference) {
        int index = reference.lastIndexOf("#");
        return index != -1 ? reference.substring(index + 1) : reference;
    }
}
