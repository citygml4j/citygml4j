/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.citygml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.util.CityGMLConstants;

public class CityObjectGroupModule extends CityGMLModule {
    public static final CityObjectGroupModule v3_0;
    public static final CityObjectGroupModule v2_0;
    public static final CityObjectGroupModule v1_0;

    private CityObjectGroupModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new CityObjectGroupModule(
                CityGMLConstants.CITYGML_3_0_CITYOBJECTGROUP_NAMESPACE,
                "grp",
                "http://schemas.opengis.net/citygml/cityobjectgroup/3.0/cityObjectGroup.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new CityObjectGroupModule(
                CityGMLConstants.CITYGML_2_0_CITYOBJECTGROUP_NAMESPACE,
                "grp",
                "http://schemas.opengis.net/citygml/cityobjectgroup/2.0/cityObjectGroup.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new CityObjectGroupModule(
                CityGMLConstants.CITYGML_1_0_CITYOBJECTGROUP_NAMESPACE,
                "grp",
                "http://schemas.opengis.net/citygml/cityobjectgroup/1.0/cityObjectGroup.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static CityObjectGroupModule of(CityGMLVersion version) {
        return switch (version) {
            case v2_0 -> v2_0;
            case v1_0 -> v1_0;
            default -> v3_0;
        };
    }
}
