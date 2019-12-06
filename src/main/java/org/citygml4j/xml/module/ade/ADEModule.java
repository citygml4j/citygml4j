package org.citygml4j.xml.module.ade;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.xml.module.Module;

public abstract class ADEModule extends Module {
    private final CityGMLVersion version;

    public ADEModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation);
        this.version = version;
    }

    public final CityGMLVersion getCityGMLVersion() {
        return version;
    }
}
