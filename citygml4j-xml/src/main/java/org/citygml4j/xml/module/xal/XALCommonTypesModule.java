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
                XALConstants.XAL_3_0_CT_SCHEMA_LOCATION
        );
    }

    private XALCommonTypesModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}
