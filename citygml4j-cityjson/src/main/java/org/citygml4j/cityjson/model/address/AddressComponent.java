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

import java.util.Map;

public enum AddressComponent {
    ADMINISTRATIVE_AREA("AdministrativeArea", Map.of(
            CityJSONVersion.v1_0, "AdministrativeArea",
            CityJSONVersion.v2_0, "administrativeArea")),
    COUNTRY("Country", Map.of(
            CityJSONVersion.v1_0, "CountryName",
            CityJSONVersion.v2_0, "country")),
    FREE_TEXT_ADDRESS("FreeTextAddress", Map.of(
            CityJSONVersion.v1_0, "FreeTextAddress",
            CityJSONVersion.v2_0, "freeTextAddress")),
    LOCALITY("Locality", Map.of(
            CityJSONVersion.v1_0, "LocalityName",
            CityJSONVersion.v2_0, "locality")),
    POSTAL_DELIVERY_POINT("PostalDeliveryPoint", Map.of(
            CityJSONVersion.v1_0, "PostalDeliveryPoint",
            CityJSONVersion.v2_0, "postalDeliveryPoint")),
    POSTAL_CODE("PostalCode", Map.of(
            CityJSONVersion.v1_0, "PostalCode",
            CityJSONVersion.v2_0, "postalCode")),
    POST_OFFICE("PostOffice", Map.of(
            CityJSONVersion.v1_0, "PostOffice",
            CityJSONVersion.v2_0, "postOffice")),
    PREMISE_NAME("PremiseName", Map.of(
            CityJSONVersion.v1_0, "PremiseName",
            CityJSONVersion.v2_0, "premiseName")),
    PREMISE_NUMBER("PremiseNumber", Map.of(
            CityJSONVersion.v1_0, "PremiseNumber",
            CityJSONVersion.v2_0, "premiseNumber")),
    RURAL_DELIVERY("RuralDelivery", Map.of(
            CityJSONVersion.v1_0, "RuralDelivery",
            CityJSONVersion.v2_0, "ruralDelivery")),
    THOROUGHFARE_NAME("ThoroughfareName", Map.of(
            CityJSONVersion.v1_0, "ThoroughfareName",
            CityJSONVersion.v2_0, "thoroughfareName")),
    THOROUGHFARE_NUMBER("ThoroughfareNumber", Map.of(
            CityJSONVersion.v1_0, "ThoroughfareNumber",
            CityJSONVersion.v2_0, "thoroughfareNumber"));

    private final String propertyName;
    private final Map<CityJSONVersion, String> names;

    AddressComponent(String propertyName, Map<CityJSONVersion, String> names) {
        this.propertyName = propertyName;
        this.names = names;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyName(CityJSONVersion version) {
        return names.get(version == CityJSONVersion.v1_0 ?
                CityJSONVersion.v1_0 :
                CityJSONVersion.v2_0);
    }
}
