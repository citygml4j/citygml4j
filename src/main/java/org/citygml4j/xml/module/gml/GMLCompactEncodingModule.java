package org.citygml4j.xml.module.gml;

import org.xmlobjects.gml.util.GMLConstants;

public class GMLCompactEncodingModule extends GMLModule {
    public static final GMLCompactEncodingModule v3_3;

    static {
        v3_3 = new GMLCompactEncodingModule(
                GMLConstants.GML_3_3_CE_NAMESPACE,
                "gmlce",
                "http://schemas.opengis.net/gml/3.3/geometryCompact.xsd"
        );
    }

    private GMLCompactEncodingModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
