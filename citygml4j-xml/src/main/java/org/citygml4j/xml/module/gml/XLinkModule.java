/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.gml;

import org.xmlobjects.gml.util.GMLConstants;

public class XLinkModule extends GMLModule {
    public static final XLinkModule v1_0;

    static {
        v1_0 = new XLinkModule(
                GMLConstants.XLINK_NAMESPACE,
                "xlink",
                GMLConstants.XLINK_SCHEMA_LOCATION
        );
    }

    private XLinkModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
