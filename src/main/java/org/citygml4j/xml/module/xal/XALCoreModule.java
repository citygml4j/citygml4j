/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.module.xal;

import org.xmlobjects.xal.util.XALConstants;

public class XALCoreModule extends XALModule {
    public static final XALCoreModule v3_0;
    public static final XALCoreModule v2_0;

    static {
        v3_0 = new XALCoreModule(
                XALConstants.XAL_3_0_NAMESPACE,
                "xAL",
                "http://docs.oasis-open.org/ciq/v3.0/cs02/xsd/default/xsd/xAL.xsd"
        );

        v2_0 = new XALCoreModule(
                XALConstants.XAL_2_0_NAMESPACE,
                "xAL",
                "http://schemas.opengis.net/citygml/xAL/xAL.xsd"
        );
    }

    private XALCoreModule(String namespaceURI, String namespacePrefix, String schemaLocation) {
        super(namespaceURI, namespacePrefix, schemaLocation);
    }
}