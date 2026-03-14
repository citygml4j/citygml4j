/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.module.citygml;

import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.xml.module.Module;

public abstract class CityGMLModule extends Module {
    private final CityGMLVersion version;

    public CityGMLModule(String namespaceURI, String namespacePrefix, String schemaLocation, CityGMLVersion version) {
        super(namespaceURI, namespacePrefix, schemaLocation);
        this.version = version;
    }

    public CityGMLVersion getCityGMLVersion() {
        return version;
    }
}
