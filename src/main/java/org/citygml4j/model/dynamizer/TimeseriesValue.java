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

package org.citygml4j.model.dynamizer;

import org.citygml4j.model.core.AbstractAppearanceProperty;
import org.citygml4j.model.core.ImplicitGeometryProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

public enum TimeseriesValue {
    INTEGER("int", Integer.class),
    DOUBLE("double", Double.class),
    STRING("string", String.class),
    GEOMETRY("geometry", GeometryProperty.class),
    URI("uri", String.class),
    BOOL("bool", Boolean.class),
    IMPLICIT_GEOMETRY("implicitGeometry", ImplicitGeometryProperty.class),
    APPEARANCE("appearance", AbstractAppearanceProperty.class);

    private final String value;
    private final Class<?> type;

    TimeseriesValue(String value, Class<?> type) {
        this.value = value;
        this.type = type;
    }

    public String toValue() {
        return value;
    }

    public Class<?> getType() {
        return type;
    }

    public static TimeseriesValue fromValue(String value) {
        for (TimeseriesValue v : TimeseriesValue.values()) {
            if (v.value.equals(value))
                return v;
        }

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
