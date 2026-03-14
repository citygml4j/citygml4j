/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.metadata;

public enum ContactType {
    INDIVIDUAL("individual"),
    ORGANIZATION("organization");

    private final String value;

    ContactType(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static ContactType fromValue(String value) {
        for (ContactType v : ContactType.values()) {
            if (v.value.equals(value)) {
                return v;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
