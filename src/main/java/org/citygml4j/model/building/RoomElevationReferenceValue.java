package org.citygml4j.model.building;

public enum RoomElevationReferenceValue {
    TBD("tbd");

    private final String value;

    RoomElevationReferenceValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static RoomElevationReferenceValue fromValue(String value) {
        for (RoomElevationReferenceValue v : RoomElevationReferenceValue.values()) {
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
