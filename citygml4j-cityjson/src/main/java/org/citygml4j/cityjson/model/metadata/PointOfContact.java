/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.metadata;

public class PointOfContact {
    private String contactName;
    private String phone;
    private String address;
    private String emailAddress;
    private ContactType contactType;
    private Role role;
    private String organization;
    private String website;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        if (emailAddress == null || emailAddress.matches("^\\S+@\\S+\\.\\S+$")) {
            this.emailAddress = emailAddress;
        }
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        if (website == null || website.matches("^(https?)://.+")) {
            this.website = website;
        }
    }
}
