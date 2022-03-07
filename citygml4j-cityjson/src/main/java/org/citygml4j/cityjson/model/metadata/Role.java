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

package org.citygml4j.cityjson.model.metadata;

public enum Role {
    RESOURCE_PROVIDER("resourceProvider"),
    CUSTODIAN("custodian"),
    OWNER("owner"),
    USER("user"),
    DISTRIBUTOR("distributor"),
    ORIGINATOR("originator"),
    POINT_OF_CONTACT("pointOfContact"),
    PRINCIPAL_INVESTIGATOR("principalInvestigator"),
    PROCESSOR("processor"),
    PUBLISHER("publisher"),
    AUTHOR("author"),
    SPONSOR("sponsor"),
    CO_AUTHOR("co-author"),
    COLLABORATOR("collaborator"),
    EDITOR("editor"),
    MEDIATOR("mediator"),
    RIGHTS_HOLDER("rightsHolder"),
    CONTRIBUTOR("contributor"),
    FUNDER("funder"),
    STAKEHOLDER("stakeholder");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static Role fromValue(String value) {
        for (Role v : Role.values()) {
            if (v.value.equals(value)) {
                return v;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
