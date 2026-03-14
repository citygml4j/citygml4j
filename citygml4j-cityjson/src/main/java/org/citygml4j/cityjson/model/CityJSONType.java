/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model;

public enum CityJSONType {
    CITYJSON("CityJSON"),
    CITYJSON_FEATURE("CityJSONFeature");

    private final String typeName;

    CityJSONType(String typeName) {
        this.typeName = typeName;
    }

    public String toTypeName() {
        return typeName;
    }

    public static CityJSONType fromValue(String value) {
        for (CityJSONType v : CityJSONType.values()) {
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
