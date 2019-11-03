package org.citygml4j.model.versioning;

public enum TransactionValue {
    PLANNED("planned"),
    REALIZED("realized"),
    HISTORICAL_SUCCESSION("historicalSuccession"),
    FORK("fork"),
    MERGE("merge");

    private final String value;

    TransactionValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static TransactionValue fromValue(String value) {
        for (TransactionValue v : TransactionValue.values()) {
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
