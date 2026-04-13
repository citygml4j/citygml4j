/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.common.LevelOfDetail;
import org.citygml4j.core.util.CityGMLPatterns;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.regex.Matcher;

public class ADEGeometryInfoBuilder {
    private static final ClassValue<List<FieldInfo>> FIELDS = new ClassValue<>() {
        @Override
        protected List<FieldInfo> computeValue(Class<?> type) {
            return findFields(type);
        }
    };

    static final ClassValue<Boolean> HAS_UPDATE_GEOMETRY_INFO = new ClassValue<>() {
        @Override
        protected Boolean computeValue(Class<?> type) {
            try {
                type.getDeclaredMethod("updateGeometryInfo", GeometryInfo.class);
                return Boolean.TRUE;
            } catch (NoSuchMethodException e) {
                return Boolean.FALSE;
            }
        }
    };


    private record FieldInfo(Field field, LevelOfDetail lod) {
    }

    private ADEGeometryInfoBuilder() {
    }

    static void updateGeometryInfo(GMLObject object, GeometryInfo geometryInfo) {
        Class<?> type = object.getClass();
        for (FieldInfo info : FIELDS.get(type)) {
            try {
                updateGeometryInfo(info.field().get(object), info.lod, info.field.getName(), geometryInfo);
            } catch (Exception e) {
                throw new RuntimeException("Failed to update geometry info for " + type.getSimpleName() + ".", e);
            }
        }
    }

    static void updateGeometryInfo(Object object, LevelOfDetail lod, String name, GeometryInfo geometryInfo) {
        if (object instanceof GeometryProperty<?> property) {
            geometryInfo.addGeometry(getLodFromProperty(lod, name), property);
        } else if (object instanceof ImplicitGeometryProperty property) {
            geometryInfo.addImplicitGeometry(getLodFromProperty(lod, name), property);
        } else if (object instanceof Collection<?> collection) {
            collection.forEach(v -> updateGeometryInfo(v, lod, name, geometryInfo));
        } else if (object instanceof Object[] array) {
            Arrays.stream(array).forEach(v -> updateGeometryInfo(v, lod, name, geometryInfo));
        } else if (object instanceof Map<?, ?> map) {
            map.values().forEach(v -> updateGeometryInfo(v, lod, name, geometryInfo));
        }
    }

    static int getLodFromProperty(LevelOfDetail lod, String fieldName) {
        if (lod != null) {
            return lod.value();
        } else {
            Matcher matcher = CityGMLPatterns.LOD_FROM_PROPERTY_NAME.matcher(fieldName);
            if (matcher.matches()) {
                try {
                    return Integer.parseInt(matcher.group(1));
                } catch (NumberFormatException e) {
                    //
                }
            }

            return Integer.MIN_VALUE;
        }
    }

    private static List<FieldInfo> findFields(Class<?> type) {
        Field[] declared = type.getDeclaredFields();
        List<FieldInfo> ownFields = new ArrayList<>(declared.length);

        for (Field field : declared) {
            int modifiers = field.getModifiers();
            if (Modifier.isStatic(modifiers) || field.isSynthetic())
                continue;

            try {
                field.setAccessible(true);
                ownFields.add(new FieldInfo(field, field.getAnnotation(LevelOfDetail.class)));
            } catch (Exception e) {
                throw new RuntimeException("Cannot access field '" + field.getName() + "'.", e);
            }
        }

        Class<?> superclass = type.getSuperclass();
        List<FieldInfo> parentFields = superclass != null
                && superclass != Object.class
                && ADEObject.class.isAssignableFrom(superclass) ?
                FIELDS.get(superclass) : List.of();

        if (ownFields.isEmpty())
            return parentFields;
        else if (parentFields.isEmpty())
            return List.copyOf(ownFields);
        else {
            List<FieldInfo> combined = new ArrayList<>(ownFields.size() + parentFields.size());
            combined.addAll(parentFields);
            combined.addAll(ownFields);
            return List.copyOf(combined);
        }
    }
}
