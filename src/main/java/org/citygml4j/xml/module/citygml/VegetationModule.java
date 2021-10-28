/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.xml.module.citygml;

import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.util.CityGMLConstants;

public class VegetationModule extends CityGMLModule {
    public static final VegetationModule v3_0;
    public static final VegetationModule v2_0;
    public static final VegetationModule v1_0;

    private VegetationModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new VegetationModule(
                CityGMLConstants.CITYGML_3_0_VEGETATION_NAMESPACE,
                "veg",
                "http://schemas.opengis.net/citygml/vegetation/3.0/vegetation.xsd",
                CityGMLVersion.v3_0
        );

        v2_0 = new VegetationModule(
                CityGMLConstants.CITYGML_2_0_VEGETATION_NAMESPACE,
                "veg",
                "http://schemas.opengis.net/citygml/vegetation/2.0/vegetation.xsd",
                CityGMLVersion.v2_0
        );

        v1_0 = new VegetationModule(
                CityGMLConstants.CITYGML_1_0_VEGETATION_NAMESPACE,
                "veg",
                "http://schemas.opengis.net/citygml/vegetation/1.0/vegetation.xsd",
                CityGMLVersion.v1_0
        );
    }

    public static VegetationModule of(CityGMLVersion version) {
        switch (version) {
            case v2_0:
                return v2_0;
            case v1_0:
                return v1_0;
            default:
                return v3_0;
        }
    }
}
