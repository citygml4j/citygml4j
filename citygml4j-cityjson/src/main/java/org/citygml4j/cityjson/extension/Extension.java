/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
