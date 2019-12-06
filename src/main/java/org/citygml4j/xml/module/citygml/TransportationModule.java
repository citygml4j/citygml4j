package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class TransportationModule extends CityGMLModule {
    public static final TransportationModule v3_0;
    public static final TransportationModule v2_0;
    public static final TransportationModule v1_0;

    static {
        v3_0 = new TransportationModule(
                CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE,
                "tran",
                "http://schemas.opengis.net/citygml/transportation/3.0/transportation.xsd"
        );

        v2_0 = new TransportationModule(
                CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE,
                "tran",
                "http://schemas.opengis.net/citygml/transportation/2.0/transportation.xsd"
        );

        v1_0 = new TransportationModule(
                CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE,
                "tran",
                "http://schemas.opengis.net/citygml/transportation/1.0/transportation.xsd"
        );
    }

    public static TransportationModule of(CityGMLVersion version) {
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

    private TransportationModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
