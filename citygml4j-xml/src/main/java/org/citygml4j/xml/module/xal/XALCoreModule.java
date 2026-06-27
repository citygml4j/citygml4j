/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.xal;

import org.xmlobjects.xal.util.XALConstants;

public class XALCoreModule extends XALModule {
    public static final XALCoreModule v3_0;
    public static final XALCoreModule v2_0;

    static {
        v3_0 = new XALCoreModule(
                XALConstants.XAL_3_0_NAMESPACE,
                "xAL",
                "https://schemas.opengis.net/citygml/xAL/3.0/xAL.xsd"
        );

        v2_0 = new XALCoreModule(
                XALConstants.XAL_2_0_NAMESPACE,
                "xAL",
                "https://schemas.opengis.net/citygml/xAL/xAL.xsd"
        );
    }

    private XALCoreModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
