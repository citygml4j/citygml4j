package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

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
        switch (version) {
            case v3_0:
                return v3_0;
            case v2_0:
                return v2_0;
            default:
                return null;
        }
    }
}
