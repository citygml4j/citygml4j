package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.module.AbstractModule;

public class CityObjectGroupModule extends AbstractModule implements CityGMLModule {
    public static final CityObjectGroupModule v3_0;
    public static final CityObjectGroupModule v2_0;
    public static final CityObjectGroupModule v1_0;

    static {
        v3_0 = new CityObjectGroupModule(
                CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE,
                "grp",
                "http://schemas.opengis.net/citygml/cityobjectgroup/3.0/cityObjectGroup.xsd"
        );

        v2_0 = new CityObjectGroupModule(
                CityGMLConstants.CITYGML_2_0_CITYOBJECTGROUP_NAMESPACE,
                "grp",
                "http://schemas.opengis.net/citygml/cityobjectgroup/2.0/cityObjectGroup.xsd"
        );

        v1_0 = new CityObjectGroupModule(
                CityGMLConstants.CITYGML_1_0_CITYOBJECTGROUP_NAMESPACE,
                "grp",
                "http://schemas.opengis.net/citygml/cityobjectgroup/1.0/cityObjectGroup.xsd"
        );
    }

    public static CityObjectGroupModule of(CityGMLVersion version) {
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

    private CityObjectGroupModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
