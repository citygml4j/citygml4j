package org.citygml4j.xml.module;

public abstract class Module {
    private final String namespaceURI;
    private final String namespacePrefix;
    private final String schemaLocation;

    public Module(String namespaceURI, String namespacePrefix, String schemaLocation) {
        this.namespaceURI = namespaceURI;
        this.namespacePrefix = namespacePrefix;
        this.schemaLocation = schemaLocation;
    }

    public final String getNamespaceURI() {
        return namespaceURI;
    }

    public final String getNamespacePrefix() {
        return namespacePrefix;
    }

    public final String getSchemaLocation() {
        return schemaLocation;
    }
}
