/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.citygml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.util.CityGMLConstants;

public class TunnelModule extends CityGMLModule {
    public static final TunnelModule v3_0;
    public static final TunnelModule v2_0;

    private TunnelModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new TunnelModule(
                CityGMLConstants.CITYGML_3_0_TUNNEL_NAMESPACE,
                "tun",
                "http://schemas.opengis.net/citygml/tunnel/3.0/tunnel.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new TunnelModule(
                CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE,
                "tun",
                "http://schemas.opengis.net/citygml/tunnel/2.0/tunnel.xsd",
                CityGMLVersion.v2_0
        );
    }

    public static TunnelModule of(CityGMLVersion version) {
        return switch (version) {
            case v3_0 -> v3_0;
            case v2_0 -> v2_0;
            default -> null;
        };
    }
}
