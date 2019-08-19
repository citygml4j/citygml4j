package org.citygml4j.model.construction;

public enum ConditionOfConstructionValue {
    DECLINED("declined"),
    DEMOLISHED("demolished"),
    FUNCTIONAL("functional"),
    PROJECTED("projected"),
    RUIN("ruin"),
    UNDER_CONSTRUCTION("underConstruction");

    private final String value;

    ConditionOfConstructionValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static ConditionOfConstructionValue fromValue(String value) {
        for (ConditionOfConstructionValue v : ConditionOfConstructionValue.values()) {
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
