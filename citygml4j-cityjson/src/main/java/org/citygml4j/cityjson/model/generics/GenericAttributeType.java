/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.generics;

public enum GenericAttributeType {
    STRING_ATTRIBUTE("StringAttribute"),
    INT_ATTRIBUTE("IntAttribute"),
    DOUBLE_ATTRIBUTE("DoubleAttribute"),
    DATE_ATTRIBUTE("DateAttribute"),
    URI_ATTRIBUTE("UriAttribute"),
    CODE_ATTRIBUTE("CodeAttribute"),
    MEASURE_ATTRIBUTE("MeasureAttribute"),
    GENERIC_ATTRIBUTE_SET("GenericAttributeSet");

    private final String typeName;

    GenericAttributeType(String typeName) {
        this.typeName = typeName;
    }

    public String toTypeName() {
        return typeName;
    }

    public static GenericAttributeType fromValue(String value) {
        for (GenericAttributeType v : GenericAttributeType.values()) {
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
