/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.citygml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.util.CityGMLConstants;

public class ReliefModule extends CityGMLModule {
    public static final ReliefModule v3_0;
    public static final ReliefModule v2_0;
    public static final ReliefModule v1_0;

    private ReliefModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new ReliefModule(
                CityGMLConstants.CITYGML_3_0_RELIEF_NAMESPACE,
                "dem",
                "http://schemas.opengis.net/citygml/relief/3.0/relief.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new ReliefModule(
                CityGMLConstants.CITYGML_2_0_RELIEF_NAMESPACE,
                "dem",
                "http://schemas.opengis.net/citygml/relief/2.0/relief.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new ReliefModule(
                CityGMLConstants.CITYGML_1_0_RELIEF_NAMESPACE,
                "dem",
                "http://schemas.opengis.net/citygml/relief/1.0/relief.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static ReliefModule of(CityGMLVersion version) {
        return switch (version) {
            case v2_0 -> v2_0;
            case v1_0 -> v1_0;
            default -> v3_0;
        };
    }
}
