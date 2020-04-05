package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class VersioningModule extends CityGMLModule {
    public static final VersioningModule v3_0;

    private VersioningModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new VersioningModule(
                CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE,
                "ver",
                "http://schemas.opengis.net/citygml/versioning/3.0/versioning.xsd",
                CityGMLVersion.v3_0
        );
    }

    public static VersioningModule of(CityGMLVersion version) {
        return version == CityGMLVersion.v3_0 ? v3_0 : null;
    }
}
