package org.citygml4j.xml.module;

import java.util.Objects;

public abstract class Module {
    private final String namespaceURI;
    private final String namespacePrefix;
    private final String schemaLocation;

    public Module(String namespaceURI, String namespacePrefix, String schemaLocation) {
        this.namespaceURI = Objects.requireNonNull(namespaceURI, "The namespace URI must not be null.");
        this.namespacePrefix = Objects.requireNonNull(namespacePrefix, "The namespace prefix must not be null.");
        this.schemaLocation = schemaLocation;
    }

    public Module(String namespaceURI, String namespacePrefix) {
        this(namespaceURI, namespacePrefix, null);
    }

    public final String getNamespaceURI() {
        return namespaceURI;
    }

    public final String getNamespacePrefix() {
        return namespacePrefix;
    }

    public final boolean isSetSchemaLocation() {
        return schemaLocation != null && !schemaLocation.isEmpty();
    }

    public final String getSchemaLocation() {
        return schemaLocation;
    }
}
