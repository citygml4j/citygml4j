/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.model.core.AbstractAppearanceProperty;
import org.citygml4j.core.model.core.ImplicitGeometryProperty;
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
