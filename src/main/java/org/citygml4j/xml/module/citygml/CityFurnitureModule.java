package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class CityFurnitureModule extends CityGMLModule {
    public static final CityFurnitureModule v3_0;
    public static final CityFurnitureModule v2_0;
    public static final CityFurnitureModule v1_0;

    static {
        v3_0 = new CityFurnitureModule(
                CityGMLConstants.CITYGML_3_0_CITYFURNITURE_NAMESPACE,
                "frn",
                "http://schemas.opengis.net/citygml/cityfurniture/3.0/cityFurniture.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new CityFurnitureModule(
                CityGMLConstants.CITYGML_2_0_CITYFURNITURE_NAMESPACE,
                "frn",
                "http://schemas.opengis.net/citygml/cityfurniture/2.0/cityFurniture.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new CityFurnitureModule(
                CityGMLConstants.CITYGML_1_0_CITYFURNITURE_NAMESPACE,
                "frn",
                "http://schemas.opengis.net/citygml/cityfurniture/1.0/cityFurniture.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static CityFurnitureModule of(CityGMLVersion version) {
        switch (version) {
            case v2_0:
                return v2_0;
            case v1_0:
                return v1_0;
            default:
                return v3_0;
        }
    }

    private CityFurnitureModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }
}
