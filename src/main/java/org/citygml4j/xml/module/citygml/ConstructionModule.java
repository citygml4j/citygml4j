package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class ConstructionModule extends CityGMLModule {
    public static final ConstructionModule v3_0;

    static {
        v3_0 = new ConstructionModule(
                CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE,
                "con",
                "http://schemas.opengis.net/citygml/construction/3.0/construction.xsd"
        );
    }

    public static ConstructionModule of(CityGMLVersion version) {
        return version == CityGMLVersion.v3_0 ? v3_0 : null;
    }

    private ConstructionModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
