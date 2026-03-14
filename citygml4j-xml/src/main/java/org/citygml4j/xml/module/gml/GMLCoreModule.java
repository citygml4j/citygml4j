/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.gml;

import org.xmlobjects.gml.util.GMLConstants;

public class GMLCoreModule extends GMLModule {
    public static final GMLCoreModule v3_2;
    public static final GMLCoreModule v3_1;

    static {
        v3_2 = new GMLCoreModule(
                GMLConstants.GML_3_2_NAMESPACE,
                "gml",
                GMLConstants.GML_3_2_SCHEMA_LOCATION
        );

        v3_1 = new GMLCoreModule(
                GMLConstants.GML_3_1_NAMESPACE,
                "gml",
                GMLConstants.GML_3_1_SCHEMA_LOCATION
        );
    }

    private GMLCoreModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
