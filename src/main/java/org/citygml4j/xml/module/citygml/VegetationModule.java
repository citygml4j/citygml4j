package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class VegetationModule extends CityGMLModule {
    public static final VegetationModule v3_0;
    public static final VegetationModule v2_0;
    public static final VegetationModule v1_0;

    static {
        v3_0 = new VegetationModule(
                CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE,
                "veg",
                "http://schemas.opengis.net/citygml/vegetation/3.0/vegetation.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new VegetationModule(
                CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE,
                "veg",
                "http://schemas.opengis.net/citygml/vegetation/2.0/vegetation.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new VegetationModule(
                CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE,
                "veg",
                "http://schemas.opengis.net/citygml/vegetation/1.0/vegetation.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static VegetationModule of(CityGMLVersion version) {
        switch (version) {
            case v2_0:
                return v2_0;
            case v1_0:
                return v1_0;
            default:
                return v3_0;
        }
    }

    private VegetationModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }
}
