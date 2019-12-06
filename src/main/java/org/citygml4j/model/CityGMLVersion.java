package org.citygml4j.model;

public enum CityGMLVersion {
    v3_0("3.0"),
    v2_0("2.0"),
    v1_0("1.0");

    private final String value;

    CityGMLVersion(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static CityGMLVersion fromValue(String value) {
        for (CityGMLVersion v : CityGMLVersion.values()) {
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
