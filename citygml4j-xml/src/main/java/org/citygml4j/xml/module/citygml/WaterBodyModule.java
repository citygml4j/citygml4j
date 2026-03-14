/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.citygml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.util.CityGMLConstants;

public class WaterBodyModule extends CityGMLModule {
    public static final WaterBodyModule v3_0;
    public static final WaterBodyModule v2_0;
    public static final WaterBodyModule v1_0;

    private WaterBodyModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new WaterBodyModule(
                CityGMLConstants.CITYGML_3_0_WATERBODY_NAMESPACE,
                "wtr",
                "http://schemas.opengis.net/citygml/waterbody/3.0/waterBody.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new WaterBodyModule(
                CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE,
                "wtr",
                "http://schemas.opengis.net/citygml/waterbody/2.0/waterBody.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new WaterBodyModule(
                CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE,
                "wtr",
                "http://schemas.opengis.net/citygml/waterbody/1.0/waterBody.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static WaterBodyModule of(CityGMLVersion version) {
        return switch (version) {
            case v2_0 -> v2_0;
            case v1_0 -> v1_0;
            default -> v3_0;
        };
    }
}
