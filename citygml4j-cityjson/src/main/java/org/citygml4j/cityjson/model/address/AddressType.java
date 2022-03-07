/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

public enum AddressType {
    ADMINISTRATIVE_AREA("AdministrativeArea"),
    COUNTRY("Country"),
    FREE_TEXT_ADDRESS("FreeTextAddress"),
    LOCALITY("Locality"),
    POSTAL_DELIVERY_POINT("PostalDeliveryPoint"),
    POST_CODE("PostCode"),
    POSTAL_CODE("PostalCode"),
    POST_OFFICE("PostOffice"),
    PREMISES("Premises"),
    RURAL_DELIVERY("RuralDelivery"),
    THOROUGHFARE("Thoroughfare");

    private final String typeName;

    AddressType(String typeName) {
        this.typeName = typeName;
    }

    public String toTypeName() {
        return typeName;
    }

    public static AddressType fromValue(String value) {
        for (AddressType v : AddressType.values()) {
            if (v.toTypeName().equals(value))
                return v;
        }

        return null;
    }

    public static AddressType fromPropertyName(String propertyName) {
        for (AddressType v : AddressType.values()) {
            if (propertyName.startsWith(v.toTypeName())) {
                return v;
            }
        }

        return FREE_TEXT_ADDRESS;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
