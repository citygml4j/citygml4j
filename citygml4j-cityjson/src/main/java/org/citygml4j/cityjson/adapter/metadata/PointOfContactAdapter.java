/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.adapter.metadata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.metadata.ContactType;
import org.citygml4j.cityjson.model.metadata.PointOfContact;
import org.citygml4j.cityjson.model.metadata.Role;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;

public class PointOfContactAdapter implements JsonObjectBuilder<PointOfContact>, JsonObjectSerializer<PointOfContact> {

    @Override
    public PointOfContact createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new PointOfContact();
    }

    @Override
    public void buildObject(PointOfContact object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        JsonNode contactName = node.path("contactName");
        if (contactName.isTextual() && !contactName.asText().isEmpty()) {
            object.setContactName(contactName.asText());
        }

        JsonNode phone = node.path("phone");
        if (phone.isTextual()) {
            object.setPhone(phone.asText());
        }

        JsonNode address = node.path("address");
        if (address.isTextual()) {
            object.setAddress(address.asText());
        }

        JsonNode emailAddress = node.path("emailAddress");
        if (emailAddress.isTextual()) {
            object.setEmailAddress(emailAddress.asText());
        }

        JsonNode contactType = node.path("contactType");
        if (contactType.isTextual()) {
            object.setContactType(ContactType.fromValue(contactType.asText()));
        }

        JsonNode role = node.path("role");
        if (role.isTextual()) {
            object.setRole(Role.fromValue(role.asText()));
        }

        JsonNode organization = node.path("organization");
        if (organization.isTextual()) {
            object.setOrganization(organization.asText());
        }

        JsonNode website = node.path("website");
        if (website.isTextual()) {
            object.setWebsite(website.asText());
        }
    }

    @Override
    public void writeObject(PointOfContact object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        CityJSONVersion version = helper.getVersion();

        if (object.getContactName() != null) {
            node.put("contactName", object.getContactName());
        } else if (version != CityJSONVersion.v1_0) {
            node.put("contactName", "");
        }

        if (object.getPhone() != null) {
            node.put("phone", object.getPhone());
        }

        if (object.getAddress() != null) {
            node.put("address", object.getAddress());
        }

        if (object.getEmailAddress() != null) {
            node.put("emailAddress", object.getEmailAddress());
        } else if (version != CityJSONVersion.v1_0) {
            node.put("emailAddress", "");
        }

        if (object.getContactType() != null) {
            node.put("contactType", object.getContactType().toValue());

            if (version == CityJSONVersion.v1_0) {
                if (object.getContactType() == ContactType.INDIVIDUAL) {
                    if (object.getRole() != null) {
                        node.put("role", object.getRole().toValue());
                    }

                    if (object.getOrganization() != null) {
                        node.put("organization", object.getOrganization());
                    }
                } else {
                    if (object.getWebsite() != null) {
                        node.put("website", object.getWebsite());
                    }
                }
            }
        }

        if (version != CityJSONVersion.v1_0) {
            if (object.getRole() != null) {
                node.put("role", object.getRole().toValue());
            }

            if (object.getOrganization() != null) {
                node.put("organization", object.getOrganization());
            }

            if (object.getWebsite() != null) {
                node.put("website", object.getWebsite());
            }
        }
    }
}
