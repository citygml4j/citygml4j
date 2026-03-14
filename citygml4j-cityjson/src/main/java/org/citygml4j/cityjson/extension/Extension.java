/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.extension;

import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.util.CityJSONPatterns;
import org.citygml4j.core.ade.ADE;

import java.net.URL;

public interface Extension extends ADE {
    String getSchemaLocation();

    CityJSONVersion getCityJSONVersion();

    default URL getSchemaResource() {
        return null;
    }

    static boolean isValidVersion(String version) {
        return CityJSONPatterns.EXTENSION_VERSION.matcher(version).matches();
    }
}
