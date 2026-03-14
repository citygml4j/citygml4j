/*
 * citygml-tools - Collection of tools for processing CityGML files
 * https://github.com/citygml4j/citygml-tools
 *
 * citygml-tools is part of the citygml4j project
 *
 * Copyright 2018-2026 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.model.address;

import org.citygml4j.cityjson.model.CityJSONVersion;

import java.util.Objects;

public class AddressToken {
    private final String propertyName;
    private final String lowerPropertyName;
    private final AddressComponent component;

    private AddressToken(String propertyName, AddressComponent component) {
        this.propertyName = Objects.requireNonNull(propertyName, "The property name must not be null.");
        this.component = Objects.requireNonNull(component, "The address component must not be null.");
        lowerPropertyName = toLowerCamelCase(propertyName);
    }

    public static AddressToken of(String propertyName, AddressComponent component) {
        return new AddressToken(propertyName, component);
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyName(CityJSONVersion version) {
        return version == CityJSONVersion.v1_0 ? propertyName : lowerPropertyName;
    }

    public AddressComponent getComponent() {
        return component;
    }

    private String toLowerCamelCase(String value) {
        if (value == null
                || value.isEmpty()
                || Character.isLowerCase(value.charAt(0))
                || !Character.isAlphabetic(value.charAt(0))) {
            return value;
        }

        int i = 1;
        while (i < value.length() && !Character.isLowerCase(value.charAt(i))) {
            i++;
        }

        if (i == 1) {
            return Character.toLowerCase(value.charAt(0)) + value.substring(1);
        } else if (i == value.length()) {
            return value.toLowerCase();
        } else {
            String lower = value.substring(0, i - 1).toLowerCase();
            return lower + value.substring(i - 1);
        }
    }
}
