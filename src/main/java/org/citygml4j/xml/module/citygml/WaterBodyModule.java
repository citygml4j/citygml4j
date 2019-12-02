package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.module.AbstractModule;

public class WaterBodyModule extends AbstractModule implements CityGMLModule {
    public static final WaterBodyModule v3_0;
    public static final WaterBodyModule v2_0;
    public static final WaterBodyModule v1_0;

    static {
        v3_0 = new WaterBodyModule(
                CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE,
                "wtr",
                "http://schemas.opengis.net/citygml/waterbody/3.0/waterBody.xsd"
        );

        v2_0 = new WaterBodyModule(
                CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE,
                "wtr",
                "http://schemas.opengis.net/citygml/waterbody/2.0/waterBody.xsd"
        );

        v1_0 = new WaterBodyModule(
                CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE,
                "wtr",
                "http://schemas.opengis.net/citygml/waterbody/1.0/waterBody.xsd"
        );
    }

    public static WaterBodyModule of(CityGMLVersion version) {
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

    private WaterBodyModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
