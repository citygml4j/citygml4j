package org.citygml4j.model.core;

public enum RelativeToTerrain {
    ENTIRELY_ABOVE_TERRAIN("entirelyAboveTerrain"),
    SUBSTANTIALLY_ABOVE_TERRAIN("substantiallyAboveTerrain"),
    SUBSTANTIALLY_ABOVE_AND_BELOW_TERRAIN("substantiallyAboveAndBelowTerrain"),
    SUBSTANTIALLY_BELOW_TERRAIN("substantiallyBelowTerrain"),
    ENTIRELY_BELOW_TERRAIN("entirelyBelowTerrain");

    private final String value;

    RelativeToTerrain(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static RelativeToTerrain fromValue(String value) {
        for (RelativeToTerrain v : RelativeToTerrain.values()) {
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
