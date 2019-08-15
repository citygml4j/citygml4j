package org.citygml4j.model.core;

public enum RelativeToWater {
    ENTIRELY_ABOVE_WATER_SURFACE("entirelyAboveWaterSurface"),
    SUBSTANTIALLY_ABOVE_WATER_SURFACE("substantiallyAboveWaterSurface"),
    SUBSTANTIALLY_ABOVE_AND_BELOW_WATER_SURFACE("substantiallyAboveAndBelowWaterSurface"),
    SUBSTANTIALLY_BELOW_WATER_SURFACE("substantiallyBelowWaterSurface"),
    ENTIRELY_BELOW_WATER_SURFACE("entirelyBelowWaterSurface"),
    TEMPORARILY_ABOVE_AND_BELOW_WATER_SURFACE("temporarilyAboveAndBelowWaterSurface");

    private final String value;

    RelativeToWater(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static RelativeToWater fromValue(String value) {
        for (RelativeToWater v : RelativeToWater.values()) {
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
