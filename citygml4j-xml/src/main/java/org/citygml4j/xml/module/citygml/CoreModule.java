/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.citygml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.util.CityGMLConstants;

public class CoreModule extends CityGMLModule {
    public static final CoreModule v3_0;
    public static final CoreModule v2_0;
    public static final CoreModule v1_0;

    private CoreModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new CoreModule(
                CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE,
                "core",
                "http://schemas.opengis.net/citygml/3.0/core.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new CoreModule(
                CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE,
                "core",
                "http://schemas.opengis.net/citygml/2.0/cityGMLBase.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new CoreModule(
                CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE,
                "core",
                "http://schemas.opengis.net/citygml/1.0/cityGMLBase.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static CoreModule of(CityGMLVersion version) {
        return switch (version) {
            case v2_0 -> v2_0;
            case v1_0 -> v1_0;
            default -> v3_0;
        };
    }
}
