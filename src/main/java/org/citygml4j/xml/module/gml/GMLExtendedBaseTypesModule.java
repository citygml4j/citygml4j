package org.citygml4j.xml.module.gml;

import org.xmlobjects.gml.util.GMLConstants;

public class GMLExtendedBaseTypesModule extends GMLModule {
    public static final GMLExtendedBaseTypesModule v3_3;

    static {
        v3_3 = new GMLExtendedBaseTypesModule(
                GMLConstants.GML_3_3_XBT_NAMESPACE,
                "gmlxbt",
                "http://schemas.opengis.net/gml/3.3/extdBaseTypes.xsd"
        );
    }

    private GMLExtendedBaseTypesModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
