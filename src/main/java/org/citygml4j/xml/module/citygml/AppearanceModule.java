package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.module.AbstractModule;

public class AppearanceModule extends AbstractModule implements CityGMLModule {
    public static final AppearanceModule v3_0;
    public static final AppearanceModule v2_0;
    public static final AppearanceModule v1_0;

    static {
        v3_0 = new AppearanceModule(
                CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE,
                "app",
                "http://schemas.opengis.net/citygml/appearance/3.0/appearance.xsd"
        );

        v2_0 = new AppearanceModule(
                CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE,
                "app",
                "http://schemas.opengis.net/citygml/appearance/2.0/appearance.xsd"
        );

        v1_0 = new AppearanceModule(
                CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE,
                "app",
                "http://schemas.opengis.net/citygml/appearance/1.0/appearance.xsd"
        );
    }

    public static AppearanceModule of(CityGMLVersion version) {
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

    private AppearanceModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
