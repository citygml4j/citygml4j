/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.model.geometry;

import java.util.EnumSet;

public enum GeometryType {
    MULTI_POINT("MultiPoint"),
    MULTI_LINE_STRING("MultiLineString"),
    MULTI_SURFACE("MultiSurface"),
    COMPOSITE_SURFACE("CompositeSurface"),
    SOLID("Solid"),
    MULTI_SOLID("MultiSolid"),
    COMPOSITE_SOLID("CompositeSolid"),
    TEMPLATE_GEOMETRY("GeometryInstance");

    public static final EnumSet<GeometryType> ALL_TYPES = EnumSet.allOf(GeometryType.class);
    public static final EnumSet<GeometryType> SURFACE_TYPES = EnumSet.of(MULTI_SURFACE, COMPOSITE_SURFACE);
    public static final EnumSet<GeometryType> SOLID_TYPES = EnumSet.of(SOLID, COMPOSITE_SOLID, MULTI_SOLID);

    private final String typeName;

    GeometryType(String typeName) {
        this.typeName = typeName;
    }

    public String toTypeName() {
        return typeName;
    }

    public static GeometryType fromValue(String value) {
        for (GeometryType v : GeometryType.values()) {
            if (v.toTypeName().equals(value))
                return v;
        }

        return null;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
