package org.citygml4j.model.core;

public enum SpaceType {
    CLOSED("closed"),
    OPEN("open"),
    SEMI_OPEN("semiOpen");

    private final String value;

    SpaceType(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static SpaceType fromValue(String value) {
        for (SpaceType v : SpaceType.values()) {
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
