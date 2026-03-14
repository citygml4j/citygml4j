/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.versioning;

public enum TransitionValue {
    INSERT("insert"),
    DELETE("delete"),
    REPLACE("replace");

    private final String value;

    TransitionValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static TransitionValue fromValue(String value) {
        for (TransitionValue v : TransitionValue.values()) {
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
