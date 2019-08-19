package org.citygml4j.model.construction;

public enum RelationToConstruction {
    INSIDE("inside"),
    OUTSIDE("outside"),
    BOTH_INSIDE_AND_OUTSIDE("bothInsideAndOutside");

    private final String value;

    RelationToConstruction(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static RelationToConstruction fromValue(String value) {
        for (RelationToConstruction v : RelationToConstruction.values()) {
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
