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

import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.visitor.ObjectWalker;
import org.citygml4j.visitor.Visitable;
import org.xmlobjects.gml.model.base.AbstractAssociation;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AbstractInlineOrByReferenceProperty;
import org.xmlobjects.gml.model.base.AbstractReference;

import java.util.*;

public class ReferenceResolver {
    private ResolveMode mode = ResolveMode.ALL_OBJECTS;

    private ReferenceResolver() {
    }

    public static ReferenceResolver newInstance() {
        return new ReferenceResolver();
    }

    public ResolveMode getResolveMode() {
        return mode;
    }

    public ReferenceResolver withResolveMode(ResolveMode mode) {
        this.mode = mode;
        return this;
    }

    public <T extends AbstractGML> T resolveReference(String reference, Visitable object, Class<T> type) {
        if (!mode.getType().isAssignableFrom(type)) {
            return null;
        }

        String id = getIdFromReference(reference);
        AbstractGML[] target = new AbstractGML[1];

        object.accept(new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (type.isInstance(object) && id.equals(object.getId())) {
                    target[0] = object;
                    setShouldWalk(false);
                } else
                    super.visit(object);
            }
        });

        return type.cast(target[0]);
    }

    public AbstractGML resolveReference(String reference, Visitable object) {
        return resolveReference(reference, object, mode.getType());
    }

    public void resolveReferences(Visitable object) {
        Map<String, List<AbstractAssociation<?>>> properties = new HashMap<>();

        object.accept(new ObjectWalker() {
            @Override
            public void visit(AbstractInlineOrByReferenceProperty<?> property) {
                collect(property, property.getHref());
                super.visit(property);
            }

            @Override
            public void visit(AbstractReference<?> reference) {
                collect(reference, reference.getHref());
            }

            private void collect(AbstractAssociation<?> association, String reference) {
                if (reference != null
                        && (mode == ResolveMode.ALL_OBJECTS
                        || mode.getType().isAssignableFrom(association.getTargetType())))
                    properties.computeIfAbsent(getIdFromReference(reference), v -> new ArrayList<>()).add(association);
            }
        });

        object.accept(new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (object.getId() != null
                        && (mode == ResolveMode.ALL_OBJECTS
                        || mode.getType().isInstance(object))) {
                    List<AbstractAssociation<?>> candidates = properties.get(object.getId());
                    if (candidates != null) {
                        for (AbstractAssociation<?> candidate : candidates) {
                            if (candidate.getTargetType().isInstance(object)) {
                                candidate.getLocalProperties().set(CityGMLConstants.REFERENCED_OBJECT, object);
                                object.getLocalProperties().set(CityGMLConstants.IS_REFERENCED, Boolean.TRUE);
                            }
                        }
                    }
                }

                super.visit(object);
            }
        });
    }

    public <T extends AbstractGML> Map<String, T> getObjectsById(Visitable object, Class<T> type) {
        if (!mode.getType().isAssignableFrom(type)) {
            return Collections.emptyMap();
        }

        Map<String, T> targets = new HashMap<>();

        object.accept(new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (object.getId() != null && type.isInstance(object)) {
                    targets.put(object.getId(), type.cast(object));
                }

                super.visit(object);
            }
        });

        return targets;
    }

    public Map<String, ? extends AbstractGML> getObjectsById(Visitable object) {
        return getObjectsById(object, mode.getType());
    }

    public String getIdFromReference(String reference) {
        int index = reference.lastIndexOf("#");
        return index != -1 ? reference.substring(index + 1) : reference;
    }
}
