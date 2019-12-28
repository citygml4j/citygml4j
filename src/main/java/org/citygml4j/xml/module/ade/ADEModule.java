package org.citygml4j.xml.module.ade;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.xml.module.Module;

import java.net.URL;

public abstract class ADEModule extends Module {
    private final CityGMLVersion version;

    public ADEModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation);
        this.version = version;
    }

    public ADEModule(String namespaceURI, String namespacePrefix, CityGMLVersion version) {
        this(namespaceURI, namespacePrefix, null, version);
    }

    public final CityGMLVersion getCityGMLVersion() {
        return version;
    }
    
    public URL getSchemaResource() {
        return null;
    }
}
