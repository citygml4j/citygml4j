/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.gml;

import org.xmlobjects.gml.util.GMLConstants;

public class GMLExtendedBaseTypesModule extends GMLModule {
    public static final GMLExtendedBaseTypesModule v3_3;

    static {
        v3_3 = new GMLExtendedBaseTypesModule(
                GMLConstants.GML_3_3_XBT_NAMESPACE,
                "gmlxbt",
                GMLConstants.GML_3_3_XBT_SCHEMA_LOCATION
        );
    }

    private GMLExtendedBaseTypesModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
