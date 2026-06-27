/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.xal;

import org.xmlobjects.xal.util.XALConstants;

public class XALCommonTypesModule extends XALModule {
    public static final XALCommonTypesModule v3_0;

    static {
        v3_0 = new XALCommonTypesModule(
                XALConstants.XAL_3_0_CT_NAMESPACE,
                "ct",
                "https://schemas.opengis.net/citygml/xAL/3.0/CommonTypes.xsd"
        );
    }

    private XALCommonTypesModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
