/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.common.LevelOfDetail;
import org.citygml4j.core.util.CityGMLPatterns;
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
                    LevelOfDetail lod = field.isAnnotationPresent(LevelOfDetail.class) ?
                            field.getAnnotation(LevelOfDetail.class) :
                            null;

                    updateGeometryInfo(field.get(object), lod, field.getName(), geometryInfo);
                } catch (Throwable e) {
                    throw new RuntimeException("Failed to update geometry info for " + object + ".", e);
                }
            }
        } while ((type = type.getSuperclass()) != Object.class && ADEObject.class.isAssignableFrom(type));
    }

    static void updateGeometryInfo(Object object, LevelOfDetail lod, String name, GeometryInfo geometryInfo) {
        if (object instanceof GeometryProperty<?> property)
            geometryInfo.addGeometry(getLodFromProperty(lod, name), property);
        else if (object instanceof ImplicitGeometryProperty property)
            geometryInfo.addImplicitGeometry(getLodFromProperty(lod, name), property);
        else if (object instanceof Collection<?> collection)
            collection.forEach(v -> updateGeometryInfo(v, lod, name, geometryInfo));
        else if (object instanceof Object[] array)
            Arrays.stream(array).forEach(v -> updateGeometryInfo(v, lod, name, geometryInfo));
        else if (object instanceof Map<?, ?> map)
            map.values().forEach(v -> updateGeometryInfo(v, lod, name, geometryInfo));
    }

    static int getLodFromProperty(LevelOfDetail property, String fieldName) {
        if (property != null)
            return property.value();
        else {
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
}
