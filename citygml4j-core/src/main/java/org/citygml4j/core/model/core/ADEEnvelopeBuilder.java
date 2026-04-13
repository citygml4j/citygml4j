/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.ade.ADEObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AbstractArrayProperty;
import org.xmlobjects.gml.model.base.AbstractInlineOrByReferenceProperty;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class ADEEnvelopeBuilder {
    private static final ClassValue<List<Field>> FIELDS = new ClassValue<>() {
        @Override
        protected List<Field> computeValue(Class<?> type) {
            return findFields(type);
        }
    };

    static final ClassValue<Boolean> HAS_UPDATE_ENVELOPE = new ClassValue<>() {
        @Override
        protected Boolean computeValue(Class<?> type) {
            try {
                type.getDeclaredMethod("updateEnvelope", Envelope.class, EnvelopeOptions.class);
                return Boolean.TRUE;
            } catch (NoSuchMethodException e) {
                return Boolean.FALSE;
            }
        }
    };

    private ADEEnvelopeBuilder() {
    }

    static void updateEnvelope(GMLObject object, Envelope envelope, EnvelopeOptions options, Set<Object> visited) {
        Class<?> type = object.getClass();
        for (Field field : FIELDS.get(type)) {
            try {
                Object value = field.get(object);
                if (value != null) {
                    updateEnvelope(value, envelope, options, visited);
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to update envelope for " + type.getSimpleName() + ".", e);
            }
        }
    }

    static void updateEnvelope(Object object, Envelope envelope, EnvelopeOptions options, Set<Object> visited) {
        if (!visited.add(object))
            return;

        if (object instanceof AbstractGeometry geometry) {
            envelope.include(geometry.computeEnvelope());
        } else if (object instanceof org.xmlobjects.gml.model.feature.AbstractFeature feature) {
            envelope.include(feature.computeEnvelope(options));
        } else if (object instanceof AbstractArrayProperty<?> property) {
            if (property.isSetObjects()) {
                property.getObjects().forEach(v -> updateEnvelope(v, envelope, options, visited));
            }
        } else if (object instanceof AbstractInlineOrByReferenceProperty<?> property) {
            updateEnvelope(property.getObject(), envelope, options, visited);
        } else if (object instanceof AbstractInlineProperty<?> property) {
            updateEnvelope(property.getObject(), envelope, options, visited);
        } else if (object instanceof GMLObject gmlObject && object instanceof ADEObject) {
            updateEnvelope(gmlObject, envelope, options, visited);
        } else if (object instanceof Collection<?> collection) {
            collection.forEach(v -> updateEnvelope(v, envelope, options, visited));
        } else if (object instanceof Object[] array) {
            Arrays.stream(array).forEach(v -> updateEnvelope(v, envelope, options, visited));
        } else if (object instanceof Map<?, ?> map) {
            map.values().forEach(v -> updateEnvelope(v, envelope, options, visited));
        }
    }

    private static List<Field> findFields(Class<?> type) {
        Field[] declared = type.getDeclaredFields();
        List<Field> ownFields = new ArrayList<>(declared.length);

        for (Field field : declared) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || field.isSynthetic())
                continue;

            try {
                field.setAccessible(true);
                ownFields.add(field);
            } catch (Exception e) {
                throw new RuntimeException("Cannot access field '" + field.getName() + "'.", e);
            }
        }

        Class<?> superclass = type.getSuperclass();
        List<Field> parentFields = superclass != null
                && superclass != Object.class
                && ADEObject.class.isAssignableFrom(superclass) ?
                FIELDS.get(superclass) : List.of();

        if (ownFields.isEmpty())
            return parentFields;
        else if (parentFields.isEmpty())
            return List.copyOf(ownFields);
        else {
            List<Field> combined = new ArrayList<>(ownFields.size() + parentFields.size());
            combined.addAll(parentFields);
            combined.addAll(ownFields);
            return List.copyOf(combined);
        }
    }
}
