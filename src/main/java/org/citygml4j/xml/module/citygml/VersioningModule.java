package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.module.AbstractModule;

public class VersioningModule extends AbstractModule implements CityGMLModule {
    public static final VersioningModule v3_0;

    static {
        v3_0 = new VersioningModule(
                CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE,
                "ver",
                "http://schemas.opengis.net/citygml/versioning/3.0/versioning.xsd"
        );
    }

    public static VersioningModule of(CityGMLVersion version) {
        return version == CityGMLVersion.v3_0 ? v3_0 : null;
    }

    private VersioningModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
