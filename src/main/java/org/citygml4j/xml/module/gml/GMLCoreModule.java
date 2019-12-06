package org.citygml4j.xml.module.gml;

import org.xmlobjects.gml.util.GMLConstants;

public class GMLCoreModule extends GMLModule {
    public static final GMLCoreModule v3_2;
    public static final GMLCoreModule v3_1;

    static {
        v3_2 = new GMLCoreModule(
                GMLConstants.GML_3_2_NAMESPACE,
                "gml",
                "http://schemas.opengis.net/gml/3.2.1/gml.xsd"
        );

        v3_1 = new GMLCoreModule(
                GMLConstants.GML_3_1_NAMESPACE,
                "gml",
                "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd"
        );
    }

    private GMLCoreModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
