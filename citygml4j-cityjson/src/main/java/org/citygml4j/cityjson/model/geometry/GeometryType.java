/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
