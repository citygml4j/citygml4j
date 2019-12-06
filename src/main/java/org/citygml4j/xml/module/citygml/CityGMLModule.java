package org.citygml4j.xml.module.citygml;

import org.citygml4j.xml.module.Module;

public abstract class CityGMLModule extends Module {

    public CityGMLModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
