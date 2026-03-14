/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.transportation;

public enum TrafficDirectionValue {
    FORWARDS("forwards"),
    BACKWARDS("backwards"),
    BOTH("both");

    private final String value;

    TrafficDirectionValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static TrafficDirectionValue fromValue(String value) {
        for (TrafficDirectionValue v : TrafficDirectionValue.values()) {
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
