package org.citygml4j.xml.module.gml;

import org.citygml4j.xml.module.Module;

public abstract class GMLModule extends Module {

    public GMLModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
