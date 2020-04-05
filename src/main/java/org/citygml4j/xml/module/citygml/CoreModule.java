package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class CoreModule extends CityGMLModule {
    public static final CoreModule v3_0;
    public static final CoreModule v2_0;
    public static final CoreModule v1_0;

    private CoreModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new CoreModule(
                CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE,
                "core",
                "http://schemas.opengis.net/citygml/3.0/cityGMLBase.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new CoreModule(
                CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE,
                "core",
                "http://schemas.opengis.net/citygml/2.0/cityGMLBase.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new CoreModule(
                CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE,
                "core",
                "http://schemas.opengis.net/citygml/1.0/cityGMLBase.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static CoreModule of(CityGMLVersion version) {
        switch (version) {
            case v2_0:
                return v2_0;
            case v1_0:
                return v1_0;
            default:
                return v3_0;
        }
    }
}
