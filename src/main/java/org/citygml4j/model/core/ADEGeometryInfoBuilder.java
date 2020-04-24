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

import org.citygml4j.model.ade.ADEObject;
import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.common.Property;
import org.citygml4j.util.CityGMLPatterns;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;

public class ADEGeometryInfoBuilder {

    private ADEGeometryInfoBuilder() {
    }

    static void updateGeometryInfo(GMLObject object, GeometryInfo geometryInfo) {
        Class<?> type = object.getClass();

        do {
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Property property = field.isAnnotationPresent(Property.class) ?
                            field.getAnnotation(Property.class) :
                            null;

                    updateGeometryInfo(field.get(object), property, field.getName(), geometryInfo);
                } catch (Throwable e) {
                    //
                }
            }
        } while ((type = type.getSuperclass()) != Object.class && ADEObject.class.isAssignableFrom(type));
    }

    static void updateGeometryInfo(Object object, Property property, String name, GeometryInfo geometryInfo) {
        if (object instanceof GeometryProperty<?>)
            geometryInfo.addGeometry(getLodFromProperty(property, name), (GeometryProperty<?>) object);
        else if (object instanceof ImplicitGeometryProperty)
            geometryInfo.addImplicitGeometry(getLodFromProperty(property, name), (ImplicitGeometryProperty) object);
        else if (object instanceof Collection<?>)
            ((Collection<?>) object).forEach(v -> updateGeometryInfo(v, property, name, geometryInfo));
        else if (object instanceof Object[])
            Arrays.stream(((Object[]) object)).forEach(v -> updateGeometryInfo(v, property, name, geometryInfo));
        else if (object instanceof Map<?, ?>)
            ((Map<?, ?>) object).values().forEach(v -> updateGeometryInfo(v, property, name, geometryInfo));
    }

    static int getLodFromProperty(Property property, String fieldName) {
        if (property != null && property.lod() != Integer.MIN_VALUE)
            return property.lod();
        else {
            String propertyName = property != null && !property.name().isEmpty() ? property.name() : fieldName;
            Matcher matcher = CityGMLPatterns.LOD_FROM_PROPERTY_NAME.matcher(propertyName);
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
}
