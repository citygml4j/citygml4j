package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class LandUseModule extends CityGMLModule {
    public static final LandUseModule v3_0;
    public static final LandUseModule v2_0;
    public static final LandUseModule v1_0;

    static {
        v3_0 = new LandUseModule(
                CityGMLConstants.CITYGML_3_0_LANDUSE_NAMESPACE,
                "luse",
                "http://schemas.opengis.net/citygml/landuse/3.0/landUse.xsd"
        );

        v2_0 = new LandUseModule(
                CityGMLConstants.CITYGML_2_0_LANDUSE_NAMESPACE,
                "luse",
                "http://schemas.opengis.net/citygml/landuse/2.0/landUse.xsd"
        );

        v1_0 = new LandUseModule(
                CityGMLConstants.CITYGML_1_0_LANDUSE_NAMESPACE,
                "luse",
                "http://schemas.opengis.net/citygml/landuse/1.0/landUse.xsd"
        );
    }

    public static LandUseModule of(CityGMLVersion version) {
        switch (version) {
            case v3_0:
                return v3_0;
            case v2_0:
                return v2_0;
            case v1_0:
                return v1_0;
            default:
                return null;
        }
    }

    private LandUseModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
