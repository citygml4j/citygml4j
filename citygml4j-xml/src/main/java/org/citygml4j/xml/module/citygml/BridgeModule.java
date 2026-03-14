/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.citygml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.util.CityGMLConstants;

public class BridgeModule extends CityGMLModule {
    public static final BridgeModule v3_0;
    public static final BridgeModule v2_0;

    private BridgeModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new BridgeModule(
                CityGMLConstants.CITYGML_3_0_BRIDGE_NAMESPACE,
                "brid",
                "http://schemas.opengis.net/citygml/bridge/3.0/bridge.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new BridgeModule(
                CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE,
                "brid",
                "http://schemas.opengis.net/citygml/bridge/2.0/bridge.xsd",
                CityGMLVersion.v2_0
        );
    }

    public static BridgeModule of(CityGMLVersion version) {
        return switch (version) {
            case v3_0 -> v3_0;
            case v2_0 -> v2_0;
            default -> null;
        };
    }
}
