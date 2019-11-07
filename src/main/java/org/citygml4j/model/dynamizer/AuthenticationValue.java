package org.citygml4j.model.dynamizer;

public enum AuthenticationValue {
    NONE("none"),
    BASIC("basic"),
    O_AUTH_2("oAuth2"),
    API_KEY("apiKey"),
    ACCESS_TOKEN("accessToken");

    private final String value;

    AuthenticationValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static AuthenticationValue fromValue(String value) {
        for (AuthenticationValue v : AuthenticationValue.values()) {
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
