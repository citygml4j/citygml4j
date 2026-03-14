/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
