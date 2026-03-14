/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.gml;

import org.xmlobjects.gml.util.GMLConstants;

public class GMLCompactEncodingModule extends GMLModule {
    public static final GMLCompactEncodingModule v3_3;

    static {
        v3_3 = new GMLCompactEncodingModule(
                GMLConstants.GML_3_3_CE_NAMESPACE,
                "gmlce",
                GMLConstants.GML_3_3_CE_SCHEMA_LOCATION
        );
    }

    private GMLCompactEncodingModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
