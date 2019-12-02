package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.module.AbstractModule;

public class BuildingModule extends AbstractModule implements CityGMLModule {
    public static final BuildingModule v3_0;
    public static final BuildingModule v2_0;
    public static final BuildingModule v1_0;

    static {
        v3_0 = new BuildingModule(
                CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE,
                "bldg",
                "http://schemas.opengis.net/citygml/building/3.0/building.xsd"
        );

        v2_0 = new BuildingModule(
                CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE,
                "bldg",
                "http://schemas.opengis.net/citygml/building/2.0/building.xsd"
        );

        v1_0 = new BuildingModule(
                CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE,
                "bldg",
                "http://schemas.opengis.net/citygml/building/1.0/building.xsd"
        );
    }

    public static BuildingModule of(CityGMLVersion version) {
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

    private BuildingModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
