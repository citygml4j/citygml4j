package org.citygml4j.model.appearance;

public enum WrapMode {
    NONE("none"),
    WRAP("wrap"),
    MIRROR("mirror"),
    CLAMP("clamp"),
    BORDER("border");

    private final String value;

    WrapMode(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static WrapMode fromValue(String value) {
        for (WrapMode v : WrapMode.values()) {
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
