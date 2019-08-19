package org.citygml4j.model.construction;

public enum HeightStatusValue {
    ESTIMATED("estimated"),
    MEASURED("measured");

    private final String value;

    HeightStatusValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static HeightStatusValue fromValue(String value) {
        for (HeightStatusValue v : HeightStatusValue.values()) {
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
