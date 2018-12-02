package org.citygml4j.builder.cityjson.marshal.citygml.ade;

import java.util.Objects;

public class ExtensionAttribute {
    private final String name;
    private final Object value;

    public ExtensionAttribute(String name, Object value) {
        this.name = Objects.requireNonNull(name, "name must not be null.");
        this.value = Objects.requireNonNull(value, "value must not be null.");
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
