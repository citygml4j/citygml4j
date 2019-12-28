package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class ReliefModule extends CityGMLModule {
    public static final ReliefModule v3_0;
    public static final ReliefModule v2_0;
    public static final ReliefModule v1_0;

    static {
        v3_0 = new ReliefModule(
                CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE,
                "dem",
                "http://schemas.opengis.net/citygml/relief/3.0/relief.xsd"
        );

        v2_0 = new ReliefModule(
                CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE,
                "dem",
                "http://schemas.opengis.net/citygml/relief/2.0/relief.xsd"
        );

        v1_0 = new ReliefModule(
                CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE,
                "dem",
                "http://schemas.opengis.net/citygml/relief/1.0/relief.xsd"
        );
    }

    public static ReliefModule of(CityGMLVersion version) {
        switch (version) {
            case v2_0:
                return v2_0;
            case v1_0:
                return v1_0;
            default:
                return v3_0;
        }
    }

    private ReliefModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
