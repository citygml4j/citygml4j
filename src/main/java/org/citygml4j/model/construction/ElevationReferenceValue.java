package org.citygml4j.model.construction;

public enum ElevationReferenceValue {
    ABOVE_GROUND_ENVELOPE("aboveGroundEnvelope"),
    BOTTOM_OF_CONSTRUCTION("bottomOfConstruction"),
    ENTRANCE_POINT("entrancePoint"),
    GENERAL_EAVE("generalEave"),
    GENERAL_GROUND("generalGround"),
    GENERAL_ROOF("generalRoof"),
    GENERAL_ROOF_EDGE("generalRoofEdge"),
    HIGHEST_EAVE("highestEave"),
    HIGHEST_GROUND_POINT("highestGroundPoint"),
    HIGHEST_POINT("highestPoint"),
    HIGHEST_ROOF_EDGE("highestRoofEdge"),
    LOWEST_EAVE("lowestEave"),
    LOWEST__FLOR_ABOVE_GROUND("lowestFloorAboveGround"),
    LOWEST_GROUND_POINT("lowestGroundPoint"),
    LOWEST_ROOF_EDGE("lowestRoofEdge"),
    TOP_OF_CONSTRUCTION("topOfConstruction");

    private final String value;

    ElevationReferenceValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static ElevationReferenceValue fromValue(String value) {
        for (ElevationReferenceValue v : ElevationReferenceValue.values()) {
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
