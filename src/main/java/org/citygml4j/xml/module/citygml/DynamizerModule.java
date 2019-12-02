package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.module.AbstractModule;

public class DynamizerModule extends AbstractModule implements CityGMLModule {
    public static final DynamizerModule v3_0;

    static {
        v3_0 = new DynamizerModule(
                CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE,
                "dyn",
                "http://schemas.opengis.net/citygml/dynamizer/3.0/dynamizer.xsd"
        );
    }

    public static DynamizerModule of(CityGMLVersion version) {
        return version == CityGMLVersion.v3_0 ? v3_0 : null;
    }

    private DynamizerModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
