/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.util.reference;

import org.citygml4j.core.visitor.ObjectWalker;
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
    private boolean storeRefereesWithReferencedObject;

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

    public boolean isStoreRefereesWithReferencedObject() {
        return storeRefereesWithReferencedObject;
    }

    public DefaultReferenceResolver storeRefereesWithReferencedObject(boolean storeRefereesWithReferencedObject) {
        this.storeRefereesWithReferencedObject = storeRefereesWithReferencedObject;
        return this;
    }

    @Override
    public <T extends Child> T resolveReference(String reference, Class<T> type, Collection<? extends Visitable> scopes) {
        if (reference == null
                || scopes == null
                || !mode.getType().isAssignableFrom(type)) {
            return null;
        }

        String id = getIdFromReference(reference);
        AbstractGML[] target = new AbstractGML[1];

        ObjectWalker walker = new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (type.isInstance(object) && id.equals(object.getId())) {
                    target[0] = object;
                    setShouldWalk(false);
                } else {
                    super.visit(object);
                }
            }
        };

        for (Visitable scope : scopes) {
            walker.visit(scope);
        }

        return type.cast(target[0]);
    }

    @Override
    public <T extends Child> T resolveReference(String reference, Class<T> type, Visitable... scopes) {
        return scopes != null ? resolveReference(reference, type, Arrays.asList(scopes)) : null;
    }

    @Override
    public Child resolveReference(String reference, Collection<? extends Visitable> scopes) {
        return resolveReference(reference, mode.getType(), scopes);
    }

    @Override
    public Child resolveReference(String reference, Visitable... scopes) {
        return resolveReference(reference, mode.getType(), scopes);
    }

    @Override
    public void resolveReferences(Collection<? extends Visitable> scopes) {
        if (scopes == null) {
            return;
        }

        Map<String, List<ResolvableAssociation<?>>> properties = new HashMap<>();

        ObjectWalker walker = new ObjectWalker() {
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
        };

        for (Visitable scope : scopes) {
            walker.visit(scope);
        }

        walker = new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (object.getId() != null && mode.getType().isInstance(object)) {
                    List<ResolvableAssociation<?>> candidates = properties.get(object.getId());
                    if (candidates != null) {
                        for (ResolvableAssociation<?> candidate : candidates) {
                            candidate.setReferencedObjectIfValid(object, false);

                            if (storeRefereesWithReferencedObject) {
                                object.getLocalProperties()
                                        .getOrSet(Referees.PROPERTY_NAME, Referees.class, Referees::new)
                                        .add(candidate.getParent());
                            }
                        }
                    }
                }

                super.visit(object);
            }
        };

        for (Visitable scope : scopes) {
            walker.visit(scope);
        }
    }

    @Override
    public void resolveReferences(Visitable... scopes) {
        if (scopes != null) {
            resolveReferences(Arrays.asList(scopes));
        }
    }

    @Override
    public <T extends Child> Map<String, T> getObjectsById(Class<T> type, Collection<? extends Visitable> scopes) {
        if (scopes == null
                || !mode.getType().isAssignableFrom(type)) {
            return Collections.emptyMap();
        }

        Map<String, T> targets = new HashMap<>();

        ObjectWalker walker = new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (object.getId() != null && type.isInstance(object)) {
                    targets.put(object.getId(), type.cast(object));
                }

                super.visit(object);
            }
        };

        for (Visitable scope : scopes) {
            walker.visit(scope);
        }

        return targets;
    }

    @Override
    public <T extends Child> Map<String, T> getObjectsById(Class<T> type, Visitable... scopes) {
        return scopes != null ? getObjectsById(type, Arrays.asList(scopes)) : null;
    }

    @Override
    public Map<String, ? extends Child> getObjectsById(Collection<? extends Visitable> scopes) {
        return getObjectsById(mode.getType(), scopes);
    }

    @Override
    public Map<String, ? extends Child> getObjectsById(Visitable... scopes) {
        return getObjectsById(mode.getType(), scopes);
    }

    @Override
    public void removeResolvedReferences(Collection<? extends Visitable> scopes) {
        if (scopes == null) {
            return;
        }

        ObjectWalker walker = new ObjectWalker() {
            @Override
            public void visit(AbstractGML object) {
                if (storeRefereesWithReferencedObject && object.hasLocalProperties()) {
                    object.getLocalProperties().remove(Referees.PROPERTY_NAME);
                    if (object.getLocalProperties().isEmpty()) {
                        object.setLocalProperties(null);
                    }
                }

                super.visit(object);
            }

            @Override
            public void visit(AbstractInlineOrByReferenceProperty<?> property) {
                unsetReferencedObject(property);
                super.visit(property);
            }

            @Override
            public void visit(AbstractReference<?> reference) {
                unsetReferencedObject(reference);
            }

            private void unsetReferencedObject(ResolvableAssociation<?> association) {
                if (association.isSetReferencedObject()) {
                    association.setReferencedObject(null, false);
                }
            }
        };

        for (Visitable scope : scopes) {
            walker.visit(scope);
        }
    }

    @Override
    public void removeResolvedReferences(Visitable... scopes) {
        if (scopes != null) {
            removeResolvedReferences(Arrays.asList(scopes));
        }
    }

    public String getIdFromReference(String reference) {
        int index = reference.lastIndexOf("#");
        return index != -1 ? reference.substring(index + 1) : reference;
    }
}
