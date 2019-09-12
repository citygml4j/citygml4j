package org.citygml4j.model.appearance;

public enum TextureType {
    SPECIFIC("specific"),
    TYPICAL("typical"),
    UNKNOWN("unknown");

    private final String value;

    TextureType(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static TextureType fromValue(String value) {
        for (TextureType v : TextureType.values()) {
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
