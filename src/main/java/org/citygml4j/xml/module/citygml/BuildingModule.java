package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class BuildingModule extends CityGMLModule {
    public static final BuildingModule v3_0;
    public static final BuildingModule v2_0;
    public static final BuildingModule v1_0;

    private BuildingModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new BuildingModule(
                CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE,
                "bldg",
                "http://schemas.opengis.net/citygml/building/3.0/building.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new BuildingModule(
                CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE,
                "bldg",
                "http://schemas.opengis.net/citygml/building/2.0/building.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new BuildingModule(
                CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE,
                "bldg",
                "http://schemas.opengis.net/citygml/building/1.0/building.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static BuildingModule of(CityGMLVersion version) {
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
