package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class GenericsModule extends CityGMLModule {
    public static final GenericsModule v3_0;
    public static final GenericsModule v2_0;
    public static final GenericsModule v1_0;

    static {
        v3_0 = new GenericsModule(
                CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE,
                "gen",
                "http://schemas.opengis.net/citygml/generics/3.0/generics.xsd"
        );

        v2_0 = new GenericsModule(
                CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE,
                "gen",
                "http://schemas.opengis.net/citygml/generics/2.0/generics.xsd"
        );

        v1_0 = new GenericsModule(
                CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE,
                "gen",
                "http://schemas.opengis.net/citygml/generics/1.0/generics.xsd"
        );
    }

    public static GenericsModule of(CityGMLVersion version) {
        switch (version) {
            case v2_0:
                return v2_0;
            case v1_0:
                return v1_0;
            default:
                return v3_0;
        }
    }

    private GenericsModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
