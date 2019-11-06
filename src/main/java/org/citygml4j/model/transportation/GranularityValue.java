package org.citygml4j.model.transportation;

public enum GranularityValue {
    LANE("lane"),
    WAY("way");

    private final String value;

    GranularityValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static GranularityValue fromValue(String value) {
        for (GranularityValue v : GranularityValue.values()) {
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
