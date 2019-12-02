package org.citygml4j.xml.module;

public abstract class AbstractModule implements Module {
    private final String namespaceURI;
    private final String namespacePrefix;
    private final String schemaLocation;

    public AbstractModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        this.namespaceURI = namespaceURI;
        this.namespacePrefix = namespacePrefix;
        this.schemaLocation = schemaLocation;
    }

    @Override
    public String getNamespaceURI() {
        return namespaceURI;
    }

    @Override
    public String getNamespacePrefix() {
        return namespacePrefix;
    }

    @Override
    public String getSchemaLocation() {
        return schemaLocation;
    }
}
