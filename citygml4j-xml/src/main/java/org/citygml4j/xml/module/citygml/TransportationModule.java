/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.citygml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.util.CityGMLConstants;

public class TransportationModule extends CityGMLModule {
    public static final TransportationModule v3_0;
    public static final TransportationModule v2_0;
    public static final TransportationModule v1_0;

    private TransportationModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new TransportationModule(
                CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE,
                "tran",
                "http://schemas.opengis.net/citygml/transportation/3.0/transportation.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new TransportationModule(
                CityGMLConstants.CITYGML_2_0_TRANSPORTATION_NAMESPACE,
                "tran",
                "http://schemas.opengis.net/citygml/transportation/2.0/transportation.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new TransportationModule(
                CityGMLConstants.CITYGML_1_0_TRANSPORTATION_NAMESPACE,
                "tran",
                "http://schemas.opengis.net/citygml/transportation/1.0/transportation.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static TransportationModule of(CityGMLVersion version) {
        return switch (version) {
            case v2_0 -> v2_0;
            case v1_0 -> v1_0;
            default -> v3_0;
        };
    }
}
