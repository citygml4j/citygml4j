package org.citygml4j.xml.module.gml;

import org.citygml4j.xml.module.AbstractModule;
import org.xmlobjects.gml.util.GMLConstants;

public class GMLBaseModule extends AbstractModule implements GMLModule {
    public static final GMLBaseModule v3_2;
    public static final GMLBaseModule v3_1;

    static {
        v3_2 = new GMLBaseModule(
                GMLConstants.GML_3_2_NAMESPACE,
                "gml",
                "http://schemas.opengis.net/gml/3.2.1/gml.xsd"
        );

        v3_1 = new GMLBaseModule(
                GMLConstants.GML_3_1_NAMESPACE,
                "gml",
                "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd"
        );
    }

    private GMLBaseModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
