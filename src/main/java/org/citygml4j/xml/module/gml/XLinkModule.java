package org.citygml4j.xml.module.gml;

import org.xmlobjects.gml.util.GMLConstants;

public class XLinkModule extends GMLModule {
    public static final XLinkModule INSTANCE;

    static {
        INSTANCE = new XLinkModule(
                GMLConstants.XLINK_NAMESPACE,
                "xlink",
                "https://www.w3.org/1999/xlink.xsd"
        );
    }

    private XLinkModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
