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

public class DynamizerModule extends CityGMLModule {
    public static final DynamizerModule v3_0;

    private DynamizerModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation, version);
    }

    static {
        v3_0 = new DynamizerModule(
                CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE,
                "dyn",
                "http://schemas.opengis.net/citygml/dynamizer/3.0/dynamizer.xsd",
                CityGMLVersion.v3_0
        );
    }

    public static DynamizerModule of(CityGMLVersion version) {
        return version == CityGMLVersion.v3_0 ? v3_0 : null;
    }
}
