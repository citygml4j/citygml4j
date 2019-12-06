package org.citygml4j.xml.module.xal;

import org.citygml4j.xml.module.Module;

public abstract class XALModule extends Module {

    public XALModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
