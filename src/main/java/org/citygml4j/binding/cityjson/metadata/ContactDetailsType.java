/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.binding.cityjson.metadata;

public class ContactDetailsType {
    private String contactName;
    private String phone;
    private String address;
    private String emailAddress;
    private ContactType contactType;
    private RoleType role;
    private String organization;
    private String website;

    public boolean isSetContactName() {
        return contactName != null;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void unsetContactName() {
        contactName = null;
    }

    public boolean isSetPhone() {
        return phone != null;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void unsetPhone() {
        phone = null;
    }

    public boolean isSetAddress() {
        return address != null;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void unsetAddress() {
        address = null;
    }

    public boolean isSetEmailAddress() {
        return emailAddress != null;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void unsetEmailAddress() {
        emailAddress = null;
    }

    public boolean isSetContactType() {
        return contactType != null;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public boolean isSetRole() {
        return role != null;
    }

    public RoleType getRole() {
        return role;
    }

    public boolean isSetOrganization() {
        return organization != null;
    }

    public String getOrganization() {
        return organization;
    }

    public boolean isSetWebsite() {
        return website != null;
    }

    public String getWebsite() {
        return website;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
        role = null;
        organization = null;
        website = null;
    }

    public void unsetContactType() {
        contactType = null;
        role = null;
        organization = null;
        website = null;
    }

    public void setIndividualContactType(RoleType role, String organization) {
        this.contactType = ContactType.INDIVIDUAL;
        this.role = role;
        this.organization = organization;
        website = null;
    }

    public void setOrganizationContactType(String website) {
        this.contactType = ContactType.ORGANIZATION;
        this.website = website;
        role = null;
        organization = null;
    }

}
